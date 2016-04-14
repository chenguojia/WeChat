package com.cardvalue.wechat.web;

import com.cardvalue.wechat.dto.*;
import com.cardvalue.wechat.service.*;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.RestfulResult;
import com.cardvalue.wechat.util.Utility;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Mr tao on 2015/5/25.
 */
@Controller
@RequestMapping(value = "/new/m")
public class NewMerchantUserController {

    private static final Logger logger = LoggerFactory.getLogger(NewMerchantUserController.class);

    @Resource
    private SmsService smsService;

    @Value("${ws.crm.restful.merchant.url}")
    private String wsCrmRestfulMerchantUrl;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    @Value("${ws.jxl.url}")
    private String wsJxlUrl;

    @Resource
    private NewMerchantService newMerchantService;

    @Resource
    private MerchantService merchantService;

    /**
     * 新版商户微信菜单入口
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ModelAndView enter(@RequestParam String code, HttpSession session, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("newm/bind");
        NewMerchantUserModel newMerchantUserModel = newMerchantService.enter(code, session, request);
        if (newMerchantUserModel != null) {
            if (StringUtils.isNotBlank(newMerchantUserModel.getAgreeToLicense()) && newMerchantUserModel.getAgreeToLicense().equals("1")) { //绑定后，判断有误确定授权条款
                return home(session);//表示已经同意过授权，直接进入首页
            } else {
                return showAccredit(); //表示还未同意授权，进入授权显示界面
            }
        }
        return mv;
    }

    /**
     * TAB - 我的账户 - TAB
     *
     * @return
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView account(HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/account");
        ApplicationModel applicationModel = null;
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
        }
        //将当申请记录保存，是否正在计算授信字段存在于申请记录中
        mv.addObject("applicationModel", applicationModel);
        return mv;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////TAB - 更多 - TAB///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * TAB - 更多 - TAB
     *
     * @return
     */
    @RequestMapping(value = "/more", method = RequestMethod.GET)
    public ModelAndView more() {
        ModelAndView mv = new ModelAndView("newm/more/more");
        return mv;
    }

    /**
     * TAB - 更多 - 案例分享
     *
     * @return
     */
    @RequestMapping(value = "/more/caseShare", method = RequestMethod.GET)
    public ModelAndView caseShare(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/caseShare");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 常见问题
     *
     * @return
     */
    @RequestMapping(value = "/more/question", method = RequestMethod.GET)
    public ModelAndView question(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/question");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 公司简介
     *
     * @return
     */
    @RequestMapping(value = "/more/aboutUs", method = RequestMethod.GET)
    public ModelAndView aboutUs(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/aboutUs");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 资质荣誉
     *
     * @return
     */
    @RequestMapping(value = "/more/honor", method = RequestMethod.GET)
    public ModelAndView honor(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/honor");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 新闻中心
     *
     * @return
     */
    @RequestMapping(value = "/more/news", method = RequestMethod.GET)
    public ModelAndView news(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/news");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 新闻中心
     *
     * @return
     */
    @RequestMapping(value = "/more/newsDetails", method = RequestMethod.GET)
    public ModelAndView newsDetails(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/newsDetails");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 联系方式
     *
     * @return
     */
    @RequestMapping(value = "/more/contactUs", method = RequestMethod.GET)
    public ModelAndView contactUs(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/contactUs");
        mv.addObject("isApp", isApp);
        return mv;
    }

    /**
     * TAB - 更多 - 意见反馈
     *
     * @return
     */
    @RequestMapping(value = "/more/comments", method = RequestMethod.GET)
    public ModelAndView comments(@RequestParam(defaultValue = "0") String isApp) {
        ModelAndView mv = new ModelAndView("newm/more/comments");
        mv.addObject("isApp", isApp);
        return mv;
    }


    /////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////TAB - 更多 - TAB///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 条款  - 注册
     *
     * @return
     */
    @RequestMapping(value = "/clause/register", method = RequestMethod.GET)
    public ModelAndView registerClause() {
        ModelAndView mv = new ModelAndView("newm/clause/register");
        return mv;
    }

    /**
     * 条款  - 注册
     *
     * @return
     */
    @RequestMapping(value = "/clause/privacy", method = RequestMethod.GET)
    public ModelAndView privacyClause() {
        ModelAndView mv = new ModelAndView("newm/clause/privacy");
        return mv;
    }

    /**
     * 条款  - 注册后同意
     *
     * @return
     */
    @RequestMapping(value = "/clause/registerFinish", method = RequestMethod.GET)
    public ModelAndView registerFinish() {
        ModelAndView mv = new ModelAndView("newm/clause/registerFinish");
        return mv;
    }

    /**
     * 条款  - 创建申请
     *
     * @return
     */
    @RequestMapping(value = "/clause/createApply", method = RequestMethod.GET)
    public ModelAndView createApply() {
        ModelAndView mv = new ModelAndView("newm/clause/createApply");
        return mv;
    }

    /**
     * 条款  - 放款待确认
     *
     * @return
     */
    @RequestMapping(value = "/clause/affirmLoansClause", method = RequestMethod.GET)
    public ModelAndView affirmLoans() {
        ModelAndView mv = new ModelAndView("newm/clause/affirmLoansClause");
        return mv;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////用户相关操作///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 绑定账号获取验证码
     *
     * @param session
     * @return 1表示生成验证 0表示失败
     */
    @RequestMapping(value = "/getCheckCode", method = {RequestMethod.GET})
    @ResponseBody
    public String getCheckCode(String mobile, HttpSession session) {
        //生产环境则发送短信
//        if (wsLocalIp.equals("192.168.0.209")) {
            String checCode = Utility.createRandom(true, 4);//生成验证码
            int flag = smsService.sendSms(mobile, "您好，验证码为:" + checCode + "，2分钟内有效，请勿泄露。");
            if (flag > 0) {
                //短信发送成功，SESSION储存
                session.setAttribute("checkCode", checCode);
                session.setAttribute("checkCodeMobile", mobile);
                session.setAttribute("checkCodeSetDate", new Date());
                return "1";
            }
//        }
        return "0";
    }

    /**
     * 绑定账号获取验证码 - ios | android
     *
     */
    @RequestMapping(value = "/getCheckCode/query", method = {RequestMethod.GET})
    @ResponseBody
    public RestfulResult queryGetCheckCode(String mobile) {
        RestfulResult result = new RestfulResult("-1", "获取验证码出错!", null);
        String checCode = Utility.createRandom(true, 4);//生成验证码
        int flag = smsService.sendSms(mobile, "您好，验证码为:" + checCode + "，2分钟内有效，请勿泄露。");
        if (flag > 0) {
            //短信发送成功，map返回
            Map map = new HashMap();
            map.put("checkCode", checCode);
            map.put("checkCodeMobile", mobile);
            map.put("checkCodeSetDate",  new Date());
            result.setResultData(map);
            result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
            result.setResultMsg("短息发送成功!");
        }
        return result;
    }

    /**
     * 新用户绑定显示界面 - 只给后台验证未登录失败时跳转，前端页面不允许访问
     *
     * @return
     */
    @RequestMapping(value = "/bind/show", method = RequestMethod.GET)
    public ModelAndView showBind() {
        ModelAndView mv = new ModelAndView("newm/bind");
        return mv;
    }

    /**
     * 新用户绑定
     *
     * @return
     */
    @RequestMapping(value = "/bind", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult bind(BindDTO dto, HttpSession session, HttpServletRequest request) {
        return newMerchantService.bind(dto, session, request);
    }

    /**
     * 用户登录 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/login/show", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        ModelAndView mv = new ModelAndView("newm/login");
        return mv;
    }

    /**
     * 用户登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult login(LoginDTO dto, HttpSession session, HttpServletRequest request) {
        return newMerchantService.login(dto, session, request);
    }

    /**
     * 忘记密码 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/forgetPassword/show", method = RequestMethod.GET)
    public ModelAndView showForgetPassword() {
        ModelAndView mv = new ModelAndView("newm/forgetPassword");
        return mv;
    }

    /**
     * 忘记密码
     *
     * @return
     */
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult forgetPassword(ForgetPasswordDTO dto, HttpSession session) {
        return newMerchantService.forgetPassword(dto, session);
    }

    /**
     * 修改密码 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/updatePassword/show", method = RequestMethod.GET)
    public ModelAndView showUpdatePassword() {
        ModelAndView mv = new ModelAndView("newm/updatePassword");
        return mv;
    }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult updatePassword(UpdatePasswordDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            dto.setMerchantId(newMerchantUserModel.getObjectId());
            result = newMerchantService.updatePassword(dto);
        }
        return result;
    }

    /**
     * 我的账户
     *
     * @return
     */
    @RequestMapping(value = "/userInfo/show", method = RequestMethod.GET)
    public ModelAndView showUserInfo() {
        ModelAndView mv = new ModelAndView("newm/userInfo");
        return mv;
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult logout(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            result = newMerchantService.logout(session);
        }
        return result;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////商户相关操作///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 授权 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/accredit/show", method = RequestMethod.GET)
    public ModelAndView showAccredit() {
        ModelAndView mv = new ModelAndView("newm/accredit");
        return mv;
    }

    /**
     * 授权条款
     *
     * @return
     */
    @RequestMapping(value = "/accredit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult accredit(HttpSession session, HttpServletRequest request) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            //插入条款 - 同意类型
            // 以后，CRM自动修改AGREELICENCE为1
            result = newMerchantService.accredit(Constants.CLAUSE_TYPE_ACCREDIT, newMerchantUserModel.getObjectId(), null, newMerchantUserModel.getMobilePhone(), Utility.getRemoteIp(request),
                    session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                    null, newMerchantUserModel.getLongitude() + "," + newMerchantUserModel.getLatitude(), request.getHeader("user-agent"));
        }
        return result;
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/home");
        ApplicationModel applicationModel = null;
        CreditsTaskModel creditsTaskModel = null;
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                session.setAttribute(Constants.SESSION_KEY_NEW_MERCHANT_APPLICATION, applicationModel);//设置最新一条申请session
                RestfulResult result = newMerchantService.getCredits(applicationModel.getCreditId());
                if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                    creditsTaskModel = (CreditsTaskModel) result.getResultData();
                    //重新刷新申请里面的isCouputer字段是否为0
                    applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
                }
            }
        }
        //提现申请是否显示红点
        if (newMerchantService.queryApplications(newMerchantUserModel.getObjectId()).size() < 1 ||
                (newMerchantService.queryApplications(newMerchantUserModel.getObjectId()).size() >= 1 &&
                        StringUtils.isNotBlank(newMerchantUserModel.getIsRenewable()) && newMerchantUserModel.getIsRenewable().equals("1"))) {
            mv.addObject("isCash", "1");
        }
        //正式代码
        mv.addObject("applicationModel", applicationModel);
        mv.addObject("creditsTaskModel", creditsTaskModel);
        mv.addObject("newMerchantUserModel", newMerchantUserModel);
        return mv;
    }

    /**
     * 授信 - 倒计时
     *
     * @return
     */
    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult credit(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "正在计算额度!!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = null;
            if (session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT_APPLICATION) == null) {
                applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            } else {
                applicationModel = (ApplicationModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT_APPLICATION);
            }
            if (applicationModel != null) {
                //获取授信情况
                result = newMerchantService.getCredits(applicationModel.getCreditId());
                //如果剩余时间为0则计算成功
                if (!(result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS) && ((CreditsTaskModel) result.getResultData()).getWaitSeconds().equals("0"))) {
                    result = new RestfulResult("-1", "正在计算额度!!", null);
                }
            }
        }
        return result;
    }

    /**
     * 我的额度
     *
     * @return
     */
    @RequestMapping(value = "/myLimit", method = RequestMethod.GET)
    public ModelAndView myLimit(HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/myLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                mv.addObject("applicationModel", applicationModel);
                mv.addObject("newMerchantUserModel", newMerchantUserModel);
            }
        }
        return mv;
    }

    /**
     * POS额度 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/posLimit/show", method = RequestMethod.GET)
    public ModelAndView showPosLimit(HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/posLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                List list = newMerchantService.queryPosCreditsMids(applicationModel.getCreditId());
                mv.addObject("posCreditsMids", list); //查询已经添加过的商编
                mv.addObject("checkFailMid", newMerchantService.queryCheckFailMid(list));//获取验证失的POS记录
                mv.addObject("processingMid", newMerchantService.queryProcessingMid(list));//获取正在授信的POS记录
                mv.addObject("makingQuestionsMid", newMerchantService.queryMakingQuestionsMid(list));//获取待生成验证问题的记录
            }
        }
        return mv;
    }

    /**
     * 局部刷新获取商编
     *
     * @return
     */
    @RequestMapping(value = "/posLimit/query", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryPosLimit(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "正在计算额度!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                List list = newMerchantService.queryPosCreditsMids(applicationModel.getCreditId());
                String isHaveMakingQuestionsMid = newMerchantService.queryMakingQuestionsMid(list) == null ? "0" : "1";//是否有正在生成问题的记录,1有，0没有
                Map map = new HashMap();
                map.put("isHaveMakingQuestionsMid",isHaveMakingQuestionsMid);
                map.put("posCreditsMids",list);
                result.setResultData(map);
                result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
            }
        }
        return result;
    }

    /**
     * POS额度
     * 1、创建商编.   http://192.168.0.208:81/rest/1.2/api.php/credits/4481/mids
     * 2、查询商编   http://192.168.0.208:81/rest/1.2/api.php/credits/4881/mids
     * 3、点击验证获取交易流水生成问题  http://192.168.0.208:81/rest/1.2/api.php/credits/4881/transactions
     * 4、开始验证回答问题(更新商编):http://192.168.0.208:81/rest/1.2/api.php/credits/4883/mids/998556666612345 ，获取验证问题如果没有流水提示给用户稍后再试，用户过一会点击以后如果获取到了就直接返回首页，
     * 5、第四步调用以后CRM会监听授信返回，如果返回验证成功，CRM会自动修改将isConputer置为0已经计算成功，此时微信首页直接显示授信的额度.
     *
     * @return
     */
    @RequestMapping(value = "/posLimit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult posLimit(PosLimitDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "正在计算额度!!", null);
        //查询授信id
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                dto.setCreditId(applicationModel.getCreditId());
                result = newMerchantService.posLimit(dto, session);
            }
        }
        return result;
    }

    /**
     * 基础额度 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/basicLimit/show", method = RequestMethod.GET)
    public ModelAndView showBasicLimit(HttpSession session) {
        //判断是否允许重算额度.
        ModelAndView mv = new ModelAndView("newm/basicLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        mv.addObject("newMerchantUserModel", newMerchantUserModel);
        mv.addObject("industryPIds", newMerchantService.queryIndustrys());//查询所有一级行业
        mv.addObject("provinceIds", newMerchantService.queryProvinces());//查询所有省份
        return mv;
    }

    /**
     * 基础额度-通过省份查询城市
     *
     * @return
     */
    @RequestMapping(value = "/queryCitys", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryCitys(String provinceId) {
        return new RestfulResult("1", "查询城市成功", newMerchantService.queryCitys(provinceId));
    }

    /**
     * 基础额度-根据以及行业id查询所有对应子行业
     *
     * @return
     */
    @RequestMapping(value = "/queryIndustryDetails", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryIndustryDetails(String industryId,HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "查询行业分类出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            return new RestfulResult("1", "查询子行业成功", newMerchantService.queryIndustryDetails(industryId,newMerchantUserModel.getObjectId()));
        }
        return result;
    }

    /**
     * 基础额度
     *
     * @return
     */
    @RequestMapping(value = "/basicLimit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult basicLimit(BasicLimitDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            return newMerchantService.basicLimit(dto, newMerchantUserModel, session);
        }
        return result;
    }


    /**
     * 聚信立额度 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/juxinliLimit/show", method = RequestMethod.GET)
    public ModelAndView showJuxinliLimit(HttpSession session) {
        //判断是否允许重算额度.
        ModelAndView mv = new ModelAndView("newm/juxinliLimit");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        mv.addObject("newMerchantUserModel",newMerchantUserModel);
        mv.addObject("wsJxlUrl",wsJxlUrl);
        return mv;
    }

    /**
     * 聚信立额度
     * 将手机号码、姓名、身份证保存到CRM
     *
     * @return
     */
    @RequestMapping(value = "/juxinliLimit", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult juxinliLimit(JuxinliLimitDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            return newMerchantService.juxinliLimit(dto, newMerchantUserModel, session);
        }
        return result;
    }

    /**
     * 修改用户基本资料
     *
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult updateUser(UpdateUserDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> parameter = objectMapper.convertValue(dto, Map.class); // 对象转MAP
            return newMerchantService.updateMerchantUser(newMerchantUserModel.getObjectId(), parameter, session);
        }
        return result;
    }


    /**
     * 上传材料主页面 - 显示
     *
     * @return
     */
    @RequestMapping(value = "/uploadFile/show", method = RequestMethod.GET)
    public ModelAndView showUploadFile(HttpSession session, @RequestParam(defaultValue = "1") String selectedTabIndex) {
        ModelAndView mv = new ModelAndView("newm/uploadFile");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                mv.addObject("applicationModel", applicationModel);
            }
            //表示验证通过，直接进入上传资料界面
            mv.addObject("selectedTabIndex", selectedTabIndex);//选中tab
            mv.addObject("newMerchantUserModel", newMerchantUserModel);
            mv.addObject("uploadFileMainModels", newMerchantService.queryUploadFileMain(newMerchantUserModel.getObjectId(), false)); //正式代码
        }
        return mv;
    }

    /**
     * 上传材料
     * 5，提交申请；6：提交补件；7：确认申请；8：拒绝申请；
     *
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult uploadFile(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                Map<String, Object> parameter = new HashMap<String, Object>();
                parameter.put("type", "5");
                result = newMerchantService.updateApplication(applicationModel.getObjectId(), parameter);
            }
        }
        return result;
    }

    /**
     * 上传材料详细界面
     *
     * @param groupName  父分组名称
     * @param sourceType 返回页面类型
     * @param session
     * @return
     */
    @RequestMapping(value = "/uploadFileDetail/show", method = RequestMethod.GET)
    public ModelAndView uploadFileDetail(String groupName, @RequestParam(defaultValue = "1") String sourceType, HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/uploadFileDetail");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            mv.addObject("newMerchantUserModel", newMerchantUserModel);
            mv.addObject("uploadFileChildModels", newMerchantService.queryUploadFileChildModel(newMerchantUserModel.getObjectId(), Utility.transcoding(groupName))); //查询所有子分组
        }
        mv.addObject("wsCrmRestfulMerchantUrl", wsCrmRestfulMerchantUrl);
        mv.addObject("sourceType", sourceType);
        mv.addObject("groupName", Utility.transcoding(groupName));
        return mv;
    }

    /**
     * 补件父界面 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/addFile/show", method = RequestMethod.GET)
    public ModelAndView showAddFile(@RequestParam(defaultValue = "1") String sourceType, HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/addFile");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            mv.addObject("uploadFileMainModels", newMerchantService.queryUploadFileMain(newMerchantUserModel.getObjectId(), true));//补件列表
        }
        mv.addObject("sourceType", sourceType);
        return mv;
    }

    /**
     * 补件子界面 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/addFileDetail/show", method = RequestMethod.GET)
    public ModelAndView showAddFileDetail(String baoliId) {
        ModelAndView mv = new ModelAndView("newm/addFile");
        mv.addObject("baoliId", baoliId);
        return mv;
    }

    /**
     * 补件
     * 5，提交申请；6：提交补件；7：确认申请；8：拒绝申请；
     *
     * @return
     */
    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult addFile(HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                Map<String, Object> parameter = new HashMap<String, Object>();
                parameter.put("type", "6");
                result = newMerchantService.updateApplication(applicationModel.getObjectId(), parameter);
            }
        }
        return result;
    }


    /**
     * 还款明细 - 初次进入界面
     *
     * @return
     */
    @RequestMapping(value = "/refundDetail", method = RequestMethod.GET)
    public ModelAndView refundDetail(@RequestParam(defaultValue = "1") String pageNumber, @RequestParam String baoliId, @RequestParam(defaultValue = "1") String sourceType) {
        ModelAndView mv = new ModelAndView("newm/refundDetail");
        try {
            //设置返回模型对象
            ExchangerResultModel exchangerResultModel = merchantService.bankStatementList("1999-01-01", "2090-01-01", baoliId, Integer.valueOf(pageNumber), 20);
            mv.addObject("exchangerResultModel", exchangerResultModel);
            mv.addObject("pageCount", String.valueOf((int) Math.ceil((double) exchangerResultModel.getTotal() / Integer.valueOf(20))));
            mv.addObject("pageNumber", pageNumber);
            mv.addObject("baoliId", baoliId);
            mv.addObject("sourceType", sourceType);
        } catch (Exception e) {
            logger.error("获取对账单记录出错:", e.getMessage());
        }
        return mv;
    }

    /**
     * 还款明细 - ajax加载
     *
     * @return
     */
    @RequestMapping(value = "/loadRefundDetail", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult loadRefundDetail(@RequestParam(defaultValue = "1") String pageNumber, @RequestParam String baoliId) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        try {
            //设置返回模型对象
            ExchangerResultModel exchangerResultModel = merchantService.bankStatementList("1999-01-01", "2090-01-01", baoliId, Integer.valueOf(pageNumber), 20);
            Map resultMap = new HashMap();
            resultMap.put("exchangerResultModel", exchangerResultModel);
            resultMap.put("pageNumber", pageNumber);

            //返回结果集
            result.setResultCode("1");
            result.setResultMsg("成功获取到对账信息!");
            result.setResultData(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取对账单记录出错:", e);
        }
        return result;
    }

    /**
     * 商户所有申请状态列表 申请|线索
     *
     * @return
     */
    @RequestMapping(value = "/applyStatus/show", method = RequestMethod.GET)
    public ModelAndView showApplyStatus(HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/applyStatus");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) { //查询已存在的基础信息
            mv.addObject("applications", newMerchantService.queryApplications(newMerchantUserModel.getObjectId()));
        }
        return mv;
    }

    /**
     * 创建新申请
     * 首贷
     * 1.改更新申请 ，线索状态为 "12:额度已核算"
     * 2.开始添加授权记录
     * 续贷
     * 1.创建申请 - 创建新申请  {"leadStatus":"76","appId":4345}
     * 2.开始添加授权
     *
     * @return
     */
    @RequestMapping(value = "/applyStatus", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult applyStatus(HttpSession session, HttpServletRequest request) {
        RestfulResult result = new RestfulResult("-1", "本系统只允许使用在微信内使用!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            //判断本次申请是否结束，如果还未结束则不让创新申请,当前保理状态不等于关闭，表示未结束 【获取申请】
            if (newMerchantService.queryApplications(newMerchantUserModel.getObjectId()).size() < 1 ||
                    (newMerchantService.queryApplications(newMerchantUserModel.getObjectId()).size() >= 1 &&
                            StringUtils.isNotBlank(newMerchantUserModel.getIsRenewable()) && newMerchantUserModel.getIsRenewable().equals("1"))) {
                //表示首次贷款或续贷贷款调用同一方法
                result = newMerchantService.createApplication(newMerchantUserModel.getObjectId(), session);
                if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                    //插入条款 - 申请类型
                    result = newMerchantService.accredit(Constants.CLAUSE_TYPE_APPLY, newMerchantUserModel.getObjectId(), null, newMerchantUserModel.getMobilePhone(), Utility.getRemoteIp(request),
                            session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                            null, newMerchantUserModel.getLongitude() + "," + newMerchantUserModel.getLatitude(), request.getHeader("user-agent"));
                    //如果是续贷，要提醒前端授信额度已经过期，需要重新授信，跳转到授信界面
                    if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                       if ((newMerchantService.queryApplications(newMerchantUserModel.getObjectId()).size() >= 1 &&
                               StringUtils.isNotBlank(newMerchantUserModel.getIsRenewable()) && newMerchantUserModel.getIsRenewable().equals("1"))) {
                           result.setResultData("1");//表示续贷
                       }
                    }
                }
            } else if (newMerchantService.queryApplications(newMerchantUserModel.getObjectId()).size() >= 1 &&
                    StringUtils.isNotBlank(newMerchantUserModel.getIsRenewable()) && newMerchantUserModel.getIsRenewable().equals("0")) {
                result.setResultData("1");//表示系统没有出错只是给出的提示
                result.setResultMsg("您还有未结束的申请记录，暂不允许创建新申请!");//表示还有未结束的申请记录
            } else {
                result.setResultMsg("系统繁忙，创建申请失败!!");
            }
        }
        return result;
    }

    /**
     * 申请书待确认 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/affirmLoans/show", method = RequestMethod.GET)
    public ModelAndView showAffirmLoans(HttpSession session) {
        ModelAndView mv = new ModelAndView("newm/affirmLoans");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            mv.addObject("confirmlists", newMerchantService.queryConfirmlists(newMerchantUserModel.getApplicationId()));//调用查询确认文件清单接口   //正式代码
        }
        return mv;
    }

    /**
     * 申请书待确认 - 确认|放弃
     * 同意  1.更改申请type为:7  2.添加确认授权条款
     * 拒绝  1.更改申请type为:8 拒绝原因:canceldescother
     * 状态  5，提交申请；6：提交补件；7：确认申请；8：拒绝申请；
     *
     * @return
     */
    @RequestMapping(value = "/affirmLoans", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult affirmLoans(String isOk, String reson, HttpSession session, HttpServletRequest request) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            Map<String, Object> parameter = new HashMap<String, Object>();
            if (applicationModel != null) {//如果申请不为空
                if (StringUtils.isNotBlank(isOk) && isOk.equals("1")) {
                    //表示同意
                    parameter.put("type", "7");
                    result = newMerchantService.updateApplication(applicationModel.getObjectId(), parameter);
                    //表示修改状态成功
                    if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                        //插入条款 - 确认类型
                        result = newMerchantService.accredit(Constants.CLAUSE_TYPE_AFFIRM, newMerchantUserModel.getObjectId(), null, newMerchantUserModel.getMobilePhone(), Utility.getRemoteIp(request),
                                session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID) == null ? "" : session.getAttribute(Constants.SESSION_KEY_WECHAT_OPEN_ID).toString(),
                                null, newMerchantUserModel.getLongitude() + "," + newMerchantUserModel.getLatitude(), request.getHeader("user-agent"));
                    }
                } else if (StringUtils.isNotBlank(isOk) && isOk.equals("0") && StringUtils.isNotBlank(reson)) {
                    //表示拒绝
                    parameter.put("type", "8");
                    parameter.put("canceldescOther", reson);
                    result = newMerchantService.updateApplication(applicationModel.getObjectId(), parameter);
                }
            }

        }
        return result;
    }

    /**
     * 商户身份验证 - 显示界面
     *
     * @return
     */
    @RequestMapping(value = "/verify/show", method = RequestMethod.GET)
    public ModelAndView showVerify(HttpSession session, String mid) {
        ModelAndView mv = new ModelAndView("newm/verify");
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                //获取验证问题并生成验证问题
                List questions = newMerchantService.getVerifyQuestion(applicationModel.getCreditId(), mid); //正式代码
                mv.addObject("questions", questions);
                session.setAttribute("questions", questions);//将问题保存到session
            }
        }
        mv.addObject("mid", mid);
        return mv;
    }

    /**
     * 随机生成验证问题公共方法 - ios | android
     *
     * @return
     */
    @RequestMapping(value = "/verify/query", method = RequestMethod.GET)
    @ResponseBody
    public List queryVerify(String creditId,String mid) {
        List questions = newMerchantService.getVerifyQuestion(creditId, mid);
        return questions;
    }

    /**
     * 商户身份验证
     *
     * @return
     */
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ResponseBody
    public RestfulResult verify(VerifyDTO dto, HttpSession session) {
        RestfulResult result = new RestfulResult("-1", "系统出错!", null);
        Map parameter = new HashMap();
        NewMerchantUserModel newMerchantUserModel = (NewMerchantUserModel) session.getAttribute(Constants.SESSION_KEY_NEW_MERCHANT);
        if (newMerchantUserModel != null) {
            ApplicationModel applicationModel = newMerchantService.getApplicationById(newMerchantUserModel.getApplicationId());
            if (applicationModel != null) {
                if (session.getAttribute("questions") != null) {
                    List questions = (List) session.getAttribute("questions");//获取系统构建的问题列表
                    //开始验证问题对错
                    result = newMerchantService.verifyQuestionAnswer(questions, dto.getQuestionIds(), dto.getQuestionAnswers());
                    //将对错情况告知授信系统，调用授信接口修改验证次数
                    if (result.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) parameter.put("isPass", "Y");
                    else parameter.put("isPass ", "N");
                    RestfulResult resultTemp = newMerchantService.updateCreditCheckQuestions(applicationModel.getCreditId(), dto.getMid(), parameter);
                    if (resultTemp.getResultCode().equals(Constants.RESTFUL_RESULT_SUCCESS)) {
                        CreditVerifyQuestionModel creditVerifyQuestionModel = (CreditVerifyQuestionModel) resultTemp.getResultData();
                        if (Integer.parseInt(creditVerifyQuestionModel.getLeftTryTimes()) < 1) {
                            //表示都验证失败了
                            result.setResultCode("3");
                            result.setResultMsg("对不起！您三次验证均不通过，该商编额度暂不能激活。请提供如下材料之一作为辅证，激活您的商编额度：\n" +
                                    "1、POS机装机单\n" +
                                    "2、收单机构提供的对账系统截屏（需包含商户注册名称、商户编号和装机地址信息）!");
                        }
                    }
                }
            }
        }
        return result;
    }
}
