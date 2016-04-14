package com.cardvalue.wechat.service.impl;

import com.cardvalue.cas.service.impl.MerchantServiceImplPortBindingStub;
import com.cardvalue.wechat.dto.*;
import com.cardvalue.wechat.model.ActionLog;
import com.cardvalue.wechat.model.UploadFileChildModel;
import com.cardvalue.wechat.model.UploadFileMainModel;
import com.cardvalue.wechat.repository.ActionLogRepository;
import com.cardvalue.wechat.service.NewMerchantService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.HttpUtils;
import com.cardvalue.wechat.util.RestfulResult;
import com.cardvalue.wechat.util.Utility;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Service(value = "newMerchantService")
public class NewMerchantServiceImpl implements NewMerchantService {

    private final static Logger logger = LoggerFactory.getLogger(NewMerchantServiceImpl.class);

    @Resource
    private MerchantServiceImplPortBindingStub merchantServiceImplPortBindingStub; // 获取商户流水验证问题接口

    @Resource
    private UtilityService utilityService;

    @Resource
    private ActionLogRepository actionLogRepository;

    @Value("${ws.crm.restful.merchant.url}")
    private String wsCrmRestfulMerchantUrl;

    @Value("${ws.jxl.url}")
    private String wsJxlUrl;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    @Resource
    private WeChatService weChatService;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 用户绑定接口
     *
     * @param code    微信编码
     * @param session
     * @param request
     * @return
     */
    public NewMerchantUserModel enter(String code, HttpSession session, HttpServletRequest request) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("code", code);

        NewMerchantUserModel newMerchantUserModel = null;
        //默认如果OPENID为空或未绑定,则跳转到绑定界面
        String openId = weChatService.getOpenIdByAccessToken(code);
//        openId = "o3KVtuBD_UjmWXbQGpSIdohfCB43";//测试代码
        //openId = "o3KVtuBD_UjmWXbQGpSIdohfCB53";//测试代码
        if (StringUtils.isBlank(openId)) {
            openId = code; //测试代码
        }
        if (openId != null) {
            session.setAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID, openId);
            try {
                //判断此微信的OPENID是否已经绑定过
                String url = wsCrmRestfulMerchantUrl + "/wechatUsers/" + openId;
                String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
                if (responseBody.indexOf("error") == -1) {
                    //表示已经绑定过
                    Map<String, String> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, String>>() {
                    });
                    //调用接口储存登录的信息
                    newMerchantUserModel = this.getMerchantUserById(map.get("merchantId"));
                    //判断绑定的用户是否存在
                    if (newMerchantUserModel != null) {
                        //保存绑定或者登录成功的用户信息
                        session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel);
                        //设置特殊的用户名和密码
                        authenticateUserAndSetSession(Constants.SESSION_KEY_NEW_MERCHANT, Constants.SESSION_KEY_NEW_MERCHANT, request);
                    }
                } else {
                    //未绑定返回绑定界面
                    logger.info("调用查询用户是否绑定接口 - CRM返回错误：", responseBody);
                }
            } catch (Exception e) {
                String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
            }
        }
        return newMerchantUserModel;
    }

    /**
     * SPRING-SECURITY框架登录
     *
     * @param username 用户名
     * @param password 密码
     * @param request  请求
     */
    private void authenticateUserAndSetSession(String username, String password, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

    /**
     * 获取验证问题交易流水
     *
     * @param creditId 获取验证问题流水的授信id
     * @return
     */
    public List getVerifyQuestion(String creditId, String mid) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("creditId", creditId);

        List<VerifyQuestionModel> questions = new ArrayList<VerifyQuestionModel>(); //问题集合
        List<TransactionsModel> list = new ArrayList<TransactionsModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId + "/transactions";
            Map parameter = new HashMap();
            parameter.put("where", "{\"mid\":\"" + mid + "\"}");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //获取交易流水
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, List<TransactionsModel>>>() {
                });
                if (map.get("results") != null) {
                    list = (List<TransactionsModel>) map.get("results");
                }

                //直接将流水增加到问题列表
                for (int i = 0; i < list.size(); i++) {
                    TransactionsModel transactionsModel = list.get(i);
                    questions.add(new VerifyQuestionModel(i + 1, "在" + transactionsModel.getTranDateTime() + "的刷卡消费金额是？", transactionsModel.getTranAmt()));
                }
            } else {
                String errorMsg = "调用crm接口:获取验证问题交易流水失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return questions;
    }

    /**
     * 验证商户流水问题
     *
     * @param questions       系统随机创建的问题集合
     * @param questionIds     用户回答的问题ids
     * @param questionAnswers 用户回答问题答案
     * @return
     */
    public RestfulResult verifyQuestionAnswer(List<VerifyQuestionModel> questions, String questionIds, String questionAnswers) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        try {
            if (StringUtils.isNotBlank(questionIds) && StringUtils.isNotBlank(questionAnswers)) {
                String[] ids = questionIds.split(",");
                String[] answers = questionAnswers.split(",");
                if (ids.length == answers.length && questions.size() == ids.length && questions.size() == answers.length) {
                    List answerErrorQuestionIds = new ArrayList();//回答错误的题目
                    for (int i = 0; i < ids.length; i++) {
                        if (Double.parseDouble(questions.get(i).getQuestionRightAnswers()) != Double.parseDouble(answers[i]))
                            answerErrorQuestionIds.add(questions.get(i).getId());
                    }
                    if (answerErrorQuestionIds.size() < 1) {
                        //表示答对所有题目
                        result.setResultCode("1");
                        result.setResultMsg("验证通过!");
                    } else {
                        //表示有错误题目
                        result.setResultCode("2");//返回特殊状态码2
                        result.setResultMsg("部分问题回答错误!");
                        result.setResultData(answerErrorQuestionIds);
                    }
                } else {
                    result.setResultMsg("回答的问题与答案数量不一致!");
                }
            } else {
                result.setResultMsg("问题或答案不能为空!");
            }
        } catch (Exception e) {
            logger.error("验证商户流水问题出错:", e.getMessage());
        }

        return result;
    }

    /**
     * 修改授信系统验证问题次数
     *
     * @param creditId  授信id
     * @param mid       验证问题的mid
     * @param parameter 调用验证问题接口需要的参数
     * @return
     */
    public RestfulResult updateCreditCheckQuestions(String creditId, String mid, Map parameter) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("creditId", creditId);
        callMethodParams.put("mid", mid);
        callMethodParams.put("parameter", parameter);

        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        try {
            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId + "/mids/" + mid;
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, Constants.HTTP_METHOD_PUT, mapper.writeValueAsString(parameter));//修改使用put方式
            if (responseBody.indexOf("error") == -1) {
                //返回验证剩余次数和验证状态
                CreditVerifyQuestionModel creditVerifyQuestionModel = new ObjectMapper().readValue(responseBody, new TypeReference<CreditVerifyQuestionModel>() {
                });
                //返回结果
                result.setResultCode("1");
                result.setResultMsg("修改成功!");
                result.setResultData(creditVerifyQuestionModel);
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:修改授信系统验证问题次数失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }


    /**
     * 微信绑定新商户
     *
     * @param dto     前台传入参数
     * @param session
     * @param request 请求
     * @return
     */
    public RestfulResult bind(BindDTO dto, HttpSession session, HttpServletRequest request) {
        //记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        callMethodParams.put("openId", session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID));
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        String checkCodeResult = utilityService.validateCheckCode(session, dto.getMobile(), dto.getCheckCode());
//        if (!wsLocalIp.equals("192.168.0.209")) checkCodeResult = null;//正式环境发短信
        if (checkCodeResult == null) {
            //验证码成功,判断是否存在OPENID
            if (session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null) {
                result.setResultMsg("本系统只允许使用在微信内使用!");
                return result;
            }
            Map parameter = new HashMap();//构建参数
            parameter.put("openId", session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID));
            parameter.put("mobilePhone", dto.getMobile());
            parameter.put("mobilePhoneVerified", "1");
            parameter.put("password", dto.getPassword());
            result = this.bindOrForgetPassword(parameter, result, callMethodParams, session, request);
        } else {
            result.setResultMsg(checkCodeResult);
        }
        return result;
    }

    /**
     * 忘记密码
     *
     * @param dto     前台传入参数
     * @param session
     * @return
     */
    public RestfulResult forgetPassword(ForgetPasswordDTO dto, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        Map parameter = new HashMap();
        parameter.put("mobilePhone", dto.getMobile());
        parameter.put("mobilePhoneVerified", "1");
        parameter.put("password", dto.getPassword());
        if (session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) != null) {
            result = this.bindOrForgetPassword(parameter, result, callMethodParams, session, null); //登录
        } else {
            result.setResultMsg("本系统只允许使用在微信内使用!");
            return result;
        }
        return result;
    }

    /**
     * 绑定或忘记密码公用方法
     *
     * @param parameter        接口调用需传入参数
     * @param result           返回结果
     * @param callMethodParams 出错参数记录
     * @param session
     * @param request          请求
     */
    private RestfulResult bindOrForgetPassword(Map parameter, RestfulResult result, Map callMethodParams, HttpSession session, HttpServletRequest request) {
        // 调用绑定接口
        try {
            String url = wsCrmRestfulMerchantUrl + "/merchantsByMobilePhone";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            if (responseBody.indexOf("error") == -1) {
                //绑定成功,储存绑定商户信息
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                NewMerchantUserModel newMerchantUserModel = this.getMerchantUserById(map.get("objectId"));
                if (newMerchantUserModel != null) {
                    if (request != null) {
                        //表示是绑定时调用，继续创建授权
                        if (this.accredit(Constants.CLAUSE_TYPE_REGISTER, newMerchantUserModel.getObjectId(), null, newMerchantUserModel.getMobilePhone(), Utility.getRemoteIp(request),
                                session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                                null, newMerchantUserModel.getLongitude() + "," + newMerchantUserModel.getLatitude(), request.getHeader("user-agent")).getResultCode().
                                equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                            //保存绑定或者登录成功的用户信息
                            session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel);
                            //设置特殊的用户名和密码
                            authenticateUserAndSetSession(Constants.SESSION_KEY_NEW_MERCHANT, Constants.SESSION_KEY_NEW_MERCHANT, request);
                            result.setResultCode("1");
                            result.setResultMsg("成功!");
                            //判断是否已经同意过条款
                            if (StringUtils.isNotBlank(newMerchantUserModel.getAgreeToLicense()) && newMerchantUserModel.getAgreeToLicense().equals("1")) {
                                result.setResultData("1");
                            }
                        } else {
                            result.setResultMsg("授权失败!");
                        }
                    } else {
                        //表示是忘记密码调用，直接返回成功
                        result.setResultCode("1");
                        result.setResultMsg("成功!");
                    }
                } else {
                    result.setResultMsg("绑定用户成功，获取用户信息失败!");
                }
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:绑定或忘记密码公用方法失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }


    /**
     * 登录
     *
     * @param dto     前台传入参数
     * @param session
     * @param request 请求
     * @return
     */
    public RestfulResult login(LoginDTO dto, HttpSession session, HttpServletRequest request) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        Map parameter = new HashMap();//构建参数
        parameter.put("mobilePhone", dto.getMobile());
        parameter.put("password", dto.getPassword());
        //判断有无OPENID
        if (session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) != null) {
            parameter.put("openId", session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString());
        } else {
            result.setResultMsg("本系统只允许使用在微信内使用!");
            return result;
        }
        //调用接口
        try {
            String url = wsCrmRestfulMerchantUrl + "/login";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //登录成功
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                NewMerchantUserModel newMerchantUserModel = this.getMerchantUserById(map.get("objectId"));
                if (newMerchantUserModel != null) {
                    //保存绑定或者登录成功的用户信息
                    session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, newMerchantUserModel);
                    //设置特殊的用户名和密码
                    authenticateUserAndSetSession(Constants.SESSION_KEY_NEW_MERCHANT, Constants.SESSION_KEY_NEW_MERCHANT, request);
                    //返回成功
                    result.setResultCode("1");
                    result.setResultMsg("成功!");
                } else {
                    result.setResultMsg("获取用户失败!");
                }
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:登录失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }


    /**
     * 登出
     *
     * @param session
     * @return
     */
    public RestfulResult logout(HttpSession session) {
        String openId = session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString();
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("openId", openId);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        Map parameter = new HashMap();//构建参数
        try {
            String url = wsCrmRestfulMerchantUrl + "/wechatUsers/" + openId + "/logout";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
            if (responseBody.indexOf("error") == -1) {
                //session移除登录用户对象
                session.removeAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
                //返回成功结果集
                result.setResultCode("1");
                result.setResultMsg("成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:登出失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }

    /**
     * 修改密码
     *
     * @param dto 前台传入参数
     * @return
     */
    public RestfulResult updatePassword(UpdatePasswordDTO dto) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        //定义返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        try {
            Map parameter = new HashMap();
            parameter.put("oldPassword", dto.getOldPassword());
            parameter.put("newPassword", dto.getNewPassword());

            String url = wsCrmRestfulMerchantUrl + "/merchants/" + dto.getMerchantId() + "/updatePassword";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, Constants.HTTP_METHOD_PUT, mapper.writeValueAsString(parameter));//修改使用put方式
            if (responseBody.indexOf("error") == -1) {
                //修改成功
                result.setResultCode("1");
                result.setResultMsg("成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:修改密码失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_UPDATE_PASSWORD, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }

    /**
     * 获取商户对应的用户
     *
     * @param merchantUserId 用户id
     * @return
     */
    public NewMerchantUserModel getMerchantUserById(String merchantUserId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantUserId", merchantUserId);
        NewMerchantUserModel newMerchantUserModel = null;
        try {
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantUserId;
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //返回成功,处理业务逻辑
                newMerchantUserModel = new ObjectMapper().readValue(responseBody, new TypeReference<NewMerchantUserModel>() {
                });
            } else {
                String errorMsg = "调用crm接口:获取商户对应的用户失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return newMerchantUserModel;
    }


    /**
     * 创建授权
     *
     * @param type          授权类型 1：同意注册条款；2：同意授权条款；3：同意申请条款；4：同意确认条款
     * @param merchantId    商户对应的用户ID，类型为1、2时必填
     * @param applicationId 商户对应的申请ID，类型为3、4时必填
     * @param mobilePhone   用户手机号
     * @param ip            用户IP
     * @param openId        微信ID
     * @param deviceNumber  手机序列号
     * @param gps           当前GPS
     * @param agent         浏览器对应的agent
     * @return
     */
    public RestfulResult accredit(String type, String merchantId, String applicationId, String mobilePhone,
                                  String ip, String openId, String deviceNumber, String gps, String agent) {
        //构建返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        Map<String, Object> callMethodParams = null;
        try {
            Map parameter = new HashMap(); //构建参数
            parameter.put("type", type);
            parameter.put("merchantId", merchantId);
            parameter.put("applicationId", applicationId);
            parameter.put("mobilePhone", mobilePhone);
            parameter.put("openId", openId);
            parameter.put("time", Utility.formatBasicDate(new Date()));
            parameter.put("ip", ip);
            parameter.put("deviceNumber", deviceNumber);
            parameter.put("gps", gps);
            parameter.put("agent", agent);
            callMethodParams = parameter; //记录日志 - 记录当前请求参数
            String url = wsCrmRestfulMerchantUrl + "/authorizations";//调用接口
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            if (responseBody.indexOf("error") == -1) {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultData(map.get("objectId"));//返回授权新建的id
                result.setResultCode("1");
                result.setResultMsg("成功!");
            } else {
                //打印错误信息到前台
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:创建授权失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }

        return result;
    }

    /**
     * 获取申请记录
     * 此申请不代表是APPID而是APPLICATIONID
     *
     * @param applicationId
     * @return
     */
    public ApplicationModel getApplicationById(String applicationId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("applicationId", applicationId);
        ApplicationModel applicationModel = null;
        if (StringUtils.isBlank(applicationId)) return applicationModel;
        try {
            String url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId;
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //返回成功,处理业务逻辑
                applicationModel = new ObjectMapper().readValue(responseBody, new TypeReference<ApplicationModel>() {
                });
            } else {
                String errorMsg = "调用crm接口:获取申请记录失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return applicationModel;
    }

    /**
     * 提交POS额度 - 创建商编
     *
     * @param dto     前台传入参数
     * @param session
     * @return
     */
    public RestfulResult posLimit(PosLimitDTO dto, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        if (StringUtils.isBlank(dto.getCreditId())) return result;
        try {
            String url = wsCrmRestfulMerchantUrl + "/credits/" + dto.getCreditId() + "/mids";
            Map parameter = new HashMap();
            parameter.put("mid", dto.getMids());
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            if (responseBody.indexOf("error") == -1) {
                result.setResultCode("1");//成功
                AddMidModel addMidModel = mapper.readValue(responseBody, new TypeReference<AddMidModel>() {
                });
                result.setResultData(addMidModel);//将添加商编以后的状态返回前台,状态只可能为2个：Q生成验证问题中、U问题已经生成完毕
                result.setResultMsg("调用成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用提交POS额度创建商编 失败!"; //返回错误信息接口
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 提交基础额度
     * 1、修改user保存基础额度信息
     * 2、创建授信 调用http://192.168.0.208:81/rest/1.2/api.php/credits
     *
     * @param dto
     * @return
     */
    public RestfulResult basicLimit(BasicLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);

        /** step1.修改个人的基础资料 */
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parameter = objectMapper.convertValue(dto, Map.class); // 对象转MAP
        RestfulResult result = this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);

        if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
            /** step2.调用接口创建授信 */
            ObjectMapper mapper = new ObjectMapper();
            try {
                String errorMsg = "";
                String url = wsCrmRestfulMerchantUrl + "/credits";
                parameter = new HashMap();
                parameter.put("applicationId", newMerchantUserModel.getApplicationId());
                String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
                if (responseBody.indexOf("error") == -1) {
                    //重新更新SESSION中的用户信息，重新获取isComputingAmount字段
                    //session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, this.getMerchantUserById(newMerchantUserModel.getObjectId()));
                    //成功
                    result.setResultCode("1");
                    result.setResultMsg("调用成功!");
                } else {
                    Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                    });
                    result.setResultMsg(map.get("error"));
                    errorMsg = "调用创建授信 失败!"; //返回错误信息接口
                }
                if (StringUtils.isNotBlank(errorMsg)) {
                    utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                            this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
                }
            } catch (Exception e) {
                String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
            }
        }
        return result;
    }

    /**
     * 查询所有申请记录通过商户用户id
     *
     * @param merchantId
     * @return
     */
    public List queryApplications(String merchantId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);

        List<ApplicationModel> applicationModel = new ArrayList<ApplicationModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/applications";
            Map parameter = new HashMap();
            parameter.put("where", "{\"merchantId\":\"" + merchantId + "\",\"isEnabled\":1}");//
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    applicationModel = (List<ApplicationModel>) map.get("results");
                }
            } else {
                String errorMsg = "调用crm接口:获取商户对应的用户失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return applicationModel;
    }


    /**
     * 创建申请
     * 1.若当前申请未激活，则自动激活申请，将申请的创建时间更新为当前时间，并将线索的状态改为12（额度已核算）
     * 2.若当前申请已激活，则自动创建一条新线索，状态为76（收到授权书，待核算额度），处理机构为330（未选择处理机构），
     * 线索来源为66（手机申请），线上客户经理为15712（指定的线上客户经理ID），法人手机号码为merchants.mobilePhone，
     * 并进行续签关联（renewAppId为当前申请表中的app_id），将app表中的信息更新到leads表中，并在CRM编辑线索页面可显示；同时创建一条新申请。
     *
     * @param merchantId
     * @param session
     * @return
     */
    public RestfulResult createApplication(String merchantId, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);//定义返回
        Map parameter = new HashMap();//构建参数
        parameter.put("merchantId", merchantId);
        try {
            String url = wsCrmRestfulMerchantUrl + "/applications";
            ObjectMapper mapper = new ObjectMapper();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
            if (responseBody.indexOf("error") == -1) {
                //更新SESSION中的用户申请
                session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, this.getMerchantUserById(merchantId));
                //返回成功
                result.setResultCode("1");
                result.setResultMsg("成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:创建申请!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_BIND, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }


    /**
     * 查询确认书待确认显示字段信息
     *
     * @param applicationId
     * @return
     */
    public List queryConfirmlists(String applicationId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("applicationId", applicationId);
        List<ConfirmlistModel> confirmlistModels = new ArrayList<ConfirmlistModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId + "/confirmlists";
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //返回成功,处理业务逻辑
                confirmlistModels = new ObjectMapper().readValue(responseBody, new TypeReference<List<ConfirmlistModel>>() {
                });
            } else {
                String errorMsg = "调用crm接口:查询确认书待确认显示字段信息失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return confirmlistModels;
    }

    /**
     * 查询文件列表或者补件列表
     *
     * @param merchantId 用户id
     * @param isPending  是否补件列表
     * @return
     */
    public List queryUploadFileMain(String merchantId, boolean isPending) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        callMethodParams.put("isPending", isPending);

        List<UploadFileMainModel> uploadFileMainModels = new ArrayList<UploadFileMainModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantId + "/checklists";
            Map parameter = new HashMap();
            if (isPending == false)
                parameter.put("where", "{\"aggregation\":\"layerSecond\"}");//正常清单列表
            else
                parameter.put("where", "{\"aggregation\":\"layerSecond\",\"status\":\"Pending\"}");//补件
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    uploadFileMainModels = (List<UploadFileMainModel>) map.get("results");
                }
            } else {
                String errorMsg = "调用crm接口:查询文件列表或者补件列表失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return uploadFileMainModels;
    }

    /**
     * 查询父分组下所有子分组
     *
     * @param merchantId
     * @param groupName
     * @return
     */
    public List queryUploadFileChildModel(String merchantId, String groupName) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantId);
        callMethodParams.put("groupName", groupName);
        List<UploadFileChildModel> uploadFileChildModels = new ArrayList<UploadFileChildModel>();
        try {
            //调用接口
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantId + "/filelists";
            Map parameter = new HashMap();
            parameter.put("where", "{\"layerSecond\":\"" + groupName + "\"}");//补件
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    uploadFileChildModels = (List<UploadFileChildModel>) map.get("results");
                }
            } else {
                String errorMsg = "调用crm接口:查询父分组下所有子分组失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return uploadFileChildModels;
    }

    /**
     * 修改用户信息
     *
     * @param merchantUserId
     * @param parameter
     * @return
     */
    public RestfulResult updateMerchantUser(String merchantUserId, Map parameter, HttpSession session) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("merchantId", merchantUserId);
        callMethodParams.put("parameter", parameter);
        //定义返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String errorMsg = "";
            String url = wsCrmRestfulMerchantUrl + "/merchants/" + merchantUserId;
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, Constants.HTTP_METHOD_PUT, mapper.writeValueAsString(parameter));//修改使用put方式
            if (responseBody.indexOf("error") == -1) {
                //重新更新SESSION中的用户申请
                session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT, this.getMerchantUserById(merchantUserId));
                //返回成功
                result.setResultCode("1");
                result.setResultMsg("修改成功!");
            } else {
                //打印错误信息到前台
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                errorMsg = "调用修改用户信息 失败!"; //返回错误信息接口
            }
            if (StringUtils.isNotBlank(errorMsg)) {
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 修改用户的经度维度
     *
     * @param openId
     * @param parameter
     * @return
     */
    public RestfulResult updateMerchantUserlatitudeAndLongitude(String openId, Map parameter) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("openId", openId);
        callMethodParams.put("parameter", parameter);
        //定义返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String errorMsg = "";
            String url = wsCrmRestfulMerchantUrl + "/wechatUsers/" + openId + "/lonlat";
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
            if (responseBody.indexOf("error") == -1) {
                //返回成功
                result.setResultCode("1");
                result.setResultMsg("修改成功!");
            } else {
                //打印错误信息到前台
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                errorMsg = "调用修改用户的经度维度 失败!"; //返回错误信息接口
            }
            if (StringUtils.isNotBlank(errorMsg)) {
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 修改申请信息
     *
     * @param applicationId
     * @param parameter
     * @return
     */
    public RestfulResult updateApplication(String applicationId, Map parameter) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("applicationId", applicationId);
        callMethodParams.put("parameter", parameter);
        //定义返回
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String errorMsg = "";
            String url = wsCrmRestfulMerchantUrl + "/applications/" + applicationId;
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, Constants.HTTP_METHOD_PUT, mapper.writeValueAsString(parameter));//修改使用put方式
            if (responseBody.indexOf("error") == -1) {
                result.setResultCode("1");//成功
                result.setResultMsg("修改成功!");
            } else {
                //打印错误信息到前台
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {
                });
                result.setResultMsg(map.get("error"));
                errorMsg = "调用crm接口修改申请信息 失败!"; //返回错误信息接口
            }
            if (StringUtils.isNotBlank(errorMsg)) {
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 获取店铺|申请APP下的所有保理记录
     *
     * @param appId
     * @return
     */
    public List getCashdvancesAppById(String appId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("appId", appId);
        List<CashadvancesModel> shopModels = new ArrayList<CashadvancesModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/cashadvances";
            Map parameter = new HashMap();
            parameter.put("where", "{\"appId\":" + appId + "}");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                //返回成功,处理业务逻辑
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                });
                if (map.get("results") != null) {
                    shopModels = (List<CashadvancesModel>) map.get("results");
                }
            } else {
                String errorMsg = "调用crm接口:获取店铺|申请APP下的所有保理记录失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return shopModels;
    }


    /**
     * 提交补件申请
     *
     * @param baoliId
     * @return
     */
    public RestfulResult addFile(String baoliId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("baoliId", baoliId);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String url = wsCrmRestfulMerchantUrl + "/apps";
            Map parameter = new HashMap();
            parameter.put("status", "已补件");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));
            if (responseBody.indexOf("error") == -1) {
                result.setResultCode("1"); //返回成功标志
                result.setResultMsg("提交成功!");
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口提交补件申请失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT_ADD_FILE, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 基础额度中查询所有省份
     *
     * @return
     */
    public List queryProvinces() {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        List<ProvinceModel> list = new ArrayList<ProvinceModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/provincelist";
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<ProvinceModel>>() {
                });
            } else {
                //记录错误信息到数据库
                String errorMsg = "调用crm接口:基础额度中查询所有省份失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }

    /**
     * 基础额度中根据省份查询所有市
     *
     * @return
     */
    public List queryCitys(String provinceId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("provinceId", provinceId);
        List<CityModel> list = new ArrayList<CityModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/proid/" + provinceId;
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<CityModel>>() {
                });
            } else {
                String errorMsg = "调用crm接口:基础额度中根据省份查询所有市失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));

        }
        return list;
    }

    /**
     * 基础额度中查询所有一级行业
     *
     * @return
     */
    public List queryIndustrys() {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        List<IndustryModel> list = new ArrayList<IndustryModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/industrylists";
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<IndustryModel>>() {
                });
            } else {
                String errorMsg = "调用crm接口:基础额度中查询所有一级行业失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }

    /**
     * 基础额度中根据以及行业id查询所有对应子行业
     *
     * @param industryId 大类id
     * @param merchantId 当前申请id
     * @return
     */
    public List queryIndustryDetails(String industryId, String merchantId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("industryId", industryId);
        List<IndustryDetailModel> list = new ArrayList<IndustryDetailModel>();
        try {
            String url = wsCrmRestfulMerchantUrl + "/industrylists/";
            Map parameter = new HashMap();
            parameter.put("where", "{\"industryPId\":\"" + industryId + "\",\"merchantId\":\"" + merchantId + "\"}");
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                list = new ObjectMapper().readValue(responseBody, new TypeReference<List<IndustryDetailModel>>() {
                });
            } else {
                String errorMsg = "调用crm接口:基础额度中根据以及行业id查询所有对应子行业失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }


    /**
     * 获取授信情况是否正在计算（获取授信系统正在执行的授信任务）
     *
     * @return
     */
    public RestfulResult getCredits(String creditId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("creditId", creditId);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        ObjectMapper mapper = new ObjectMapper();
        try {
            //调用接口获取授信记录
            if (StringUtils.isBlank(creditId)) return result;
            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId;
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                CreditsTaskModel creditsTaskModel = new ObjectMapper().readValue(responseBody, new TypeReference<CreditsTaskModel>() {
                });
                result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
                result.setResultMsg("成功");
                result.setResultData(creditsTaskModel);
            } else {
                Map<String, String> map = mapper.readValue(responseBody, new TypeReference<Map<String, String>>() {//打印错误信息到前台
                });
                result.setResultMsg(map.get("error"));
                String errorMsg = "调用crm接口:获取授信失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }

    /**
     * 获取POS额度中的POS商编
     *
     * @param creditId 授信id
     * @return
     */
    public List queryPosCreditsMids(String creditId) {
        //记录日志 - 记录当前请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("creditId", creditId);
        List<PosMidModel> list = new ArrayList<PosMidModel>();
        try {
            if (StringUtils.isBlank(creditId)) return list;
            String url = wsCrmRestfulMerchantUrl + "/credits/" + creditId + "/mids";
            Map parameter = new HashMap();
            String responseBody = HttpUtils.executeCrmHttpRequest(url, parameter, HttpGet.METHOD_NAME, null);
            if (responseBody.indexOf("error") == -1) {
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, List<PosMidModel>>>() {
                });
                if (map.get("results") != null) {
                    list = (List<PosMidModel>) map.get("results");
                }
            } else {
                String errorMsg = "调用crm接口:获取POS额度中的POS商编失败!";
                utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                        this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, responseBody)));
            }
        } catch (Exception e) {
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return list;
    }

    /**
     * 查询POS额度中的POS商编验证失败的记录
     *
     * @param list
     * @return
     */
    public PosMidModel queryCheckFailMid(List<PosMidModel> list) {
        PosMidModel returnObj = null;
        for (PosMidModel posMidModel : list) {
            if (posMidModel.getStatus().equals("F")) {
                returnObj = posMidModel;
                break;
            }
        }
        return returnObj;
    }

    /**
     * 查询POS额度中的POS商编还有待生成验证问题的记录或者正在授信的记录
     *
     * @param list
     * @return
     */
    public PosMidModel queryProcessingMid(List<PosMidModel> list) {
        PosMidModel returnObj = null;
        for (PosMidModel posMidModel : list) {
            if (posMidModel.getStatus().equals("C")) {
                returnObj = posMidModel;
                break;
            }  //else if (posMidModel.getStatus().equals("Q")) {
//                returnObj = posMidModel;
//                break;
//            }
        }
        return returnObj;
    }

    /**
     * 查询POS额度中的POS商编还有待生成验证问题的记录
     *
     * @param list
     * @return
     */
    public PosMidModel queryMakingQuestionsMid(List<PosMidModel> list) {
        PosMidModel returnObj = null;
        for (PosMidModel posMidModel : list) {
            if (posMidModel.getStatus().equals("Q")) {
                returnObj = posMidModel;
                break;
            }
        }
        return returnObj;
    }

    /**
     * 提交聚信立
     *
     * @param dto
     * @param newMerchantUserModel
     * @param session
     * @return
     */
    public RestfulResult juxinliLimit(JuxinliLimitDTO dto, NewMerchantUserModel newMerchantUserModel, HttpSession session) {
        //记录日志 - 记录当前请求参数
        final Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("dto", dto);
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        final ObjectMapper mapper = new ObjectMapper();
        try {
            if (StringUtils.isBlank(dto.getCheckCode())) {
                /**表示是第一次进入界面没有验证码提交**/
                //调用聚信立第一个接口
                String url = wsJxlUrl + "/getverifycode";
                Map parameter = new HashMap();
                parameter.put("name", dto.getOwnerName());
                parameter.put("id_card_num",dto.getOwnerSSN());
                parameter.put("account", newMerchantUserModel.getMobilePhone());
                parameter.put("password", dto.getServicePassword());
                String responseBody = HttpUtils.executeCrmHttpRequest(url, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(parameter));//修改使用put方式
                Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String,Object>>() {
                });
                Boolean flag = Boolean.parseBoolean(map.get("success").toString());//处理结果
                Map data = (Map) map.get("data");//返回数据结果
                if (flag) {
                    if (data.get("process_code").equals("10002")) {
                        //表示需要输入验证码，还是返回成功标示
                        result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
                        result.setResultMsg("手机运行商需要输入验证码!");
                        result.setResultData(data);//返回手机验证标示
                    } else if (data.get("process_code").equals("10008")) {
                        //表示不需要验证码直接采集数据成功,此时开始调用CRM接口保存数据
                        parameter = new HashMap();
                        parameter.put("ownerSSN", dto.getOwnerSSN());
                        parameter.put("ownerName", dto.getOwnerName());
                        parameter.put("isJxlValid", "1");//聚信立状态
                        result = this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);
                    } else {
                        //表示失败，打印失败信息
                        result.setResultMsg(data.get("content").toString());
                        result.setResultData(data);//保存返回结果集
                    }
                } else {
                    //表示失败，打印失败信息
                    result.setResultMsg(data.get("content").toString());
                    result.setResultData(data);//保存返回结果集
                }
            } else {
                /**表示第二次输入了验证码以后提交**/
                String url = wsJxlUrl + "/submit";
                Map parameter = new HashMap();
                parameter.put("account", newMerchantUserModel.getMobilePhone());
                parameter.put("password", dto.getServicePassword());
                parameter.put("token", dto.getToken());
                parameter.put("captcha", dto.getCheckCode());
                parameter.put("website", dto.getWebsite());
                final Map tempParameter = parameter;
                //开启新线程去采集
                new Thread() {
                    @Override
                    public void run() {
                        String tempResponseBody = "";
                        try {
                            String myUrl = wsJxlUrl + "/submit";
                            final String responseBody = HttpUtils.executeCrmHttpRequest(myUrl, null, HttpPost.METHOD_NAME, mapper.writeValueAsString(tempParameter));//修改使用put方式
                            tempResponseBody = responseBody;
                            Map<String, Object> map = new ObjectMapper().readValue(responseBody, new TypeReference<Map<String, Object>>() {
                            });
                        } catch (Exception e) {
                            String errorMsg = "调用聚信立接口:提交手机号、手机密码、验证码 到聚信立系统，进行数据整合失败!";
                            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, tempResponseBody)));
                        }
                    }
                }.start();
                //调用CRM保存数据
                parameter = new HashMap();
                parameter.put("ownerSSN", dto.getOwnerSSN());
                parameter.put("ownerName", dto.getOwnerName());
                parameter.put("isJxlValid", "1");//聚信立状态
                result = this.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errorMsg = "服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !";
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_NEW_MERCHANT, new Date(),
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, errorMsg, Utility.getExceptionInfo(e))));
        }
        return result;
    }
}
