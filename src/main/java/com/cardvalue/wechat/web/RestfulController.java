package com.cardvalue.wechat.web;

import com.cardvalue.wechat.dto.CouponInfo;
import com.cardvalue.wechat.model.ActionLog;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.ActionLogRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.CouponService;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.SmsService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.RestfulResult;
import com.cardvalue.wechat.util.Result;
import com.cardvalue.wechat.util.Utility;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * restful interface
 * Created by Mr tao on 2015/5/19.
 */
@Controller
@RequestMapping(value = "/restful")
public class RestfulController {

    private static final Logger logger = LoggerFactory.getLogger(MerchantUserController.class);

    @Resource
    private ActionLogRepository actionLogRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private CouponService couponService;

    @Resource
    private UtilityService utilityService;

    @Resource
    private SmsService smsService;

    @Value("${ws.local.ip}")
    private String wsLocalIp;

    /**
     * 查询推荐商户的可用优惠券
     *
     * @param request  请求
     * @param username 转介商户的用户名，传入多个时用 ',' 分隔
     * @return
     */
    @RequestMapping(value = "/queryCouponByUserNames", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryCouponByUserNames(HttpServletRequest request, String username) {

        //返回接口
        RestfulResult result = new RestfulResult(Constants.RESTFUL_RESULT_FAILED, null, null);

        //当前接口请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("username", username);

        try {
            if (!Utility.isInner(Utility.getRemoteIp(request))) {
                result.setResultMsg("请求ip : " + Utility.getRemoteIp(request) + " 不合法!");//验证客户端来源
            } else {
                if (StringUtils.isNotBlank(username)) {
                    String[] usernames = username.split(",");
                    boolean isExistRefer = false; // 推荐人存在标志
                    List<CouponInfo> coupons = null;
                    for (String currUsername : usernames) {
                        WeUser user = userRepository.findByUsername(currUsername);
                        if (user != null) {
                            isExistRefer = true;//表示存在
                            coupons = couponService.listCouponInfoByUserId(user.getId());
                            break;
                        }
                    }
                    // 推荐人是否存在
                    if (isExistRefer) {
                        result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
                        result.setResultData(coupons);
                    } else {
                        result.setResultMsg("系统无法查询到您传入的推荐人: " + username + " !");
                    }
                } else {
                    result.setResultMsg("推荐人用户名不允许为空!");
                }
            }
        } catch (Exception e) {
            result.setResultMsg("服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !"); //返回错误信息接口
            result.setResultData(e.getMessage());
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_RESTFUL, new Date(), //记录错误信息到数据库
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, result.getResultMsg(), Utility.getExceptionInfo(e))));
        }

        logger.error(result.getResultMsg());
        return result;
    }

    /**
     * 查询推荐商户是否存在
     *
     * @param request  请求
     * @param username 转介商户的用户名
     * @return
     */
    @RequestMapping(value = "/queryRerrerByUserName", method = RequestMethod.GET)
    @ResponseBody
    public RestfulResult queryRerrerByUserName(HttpServletRequest request, String username, String refferName) {

        //返回接口
        RestfulResult result = new RestfulResult(Constants.RESTFUL_RESULT_FAILED, null, null);

        //当前接口请求参数
        Map<String, Object> callMethodParams = new HashMap<String, Object>();
        callMethodParams.put("username", username);

        try {
            if (!Utility.isInner(Utility.getRemoteIp(request))) {
                result.setResultMsg("请求 ip:" + Utility.getRemoteIp(request) + "不合法!");//验证客户端来源
            } else {
                if (StringUtils.isNotBlank(username)) {
                    WeUser user = userRepository.findByUsername(username);
                    if (user != null) {
                        result.setResultCode(Constants.RESTFUL_RESULT_SUCCESS);
                        result.setResultData(user);
                    } else {
                        result.setResultMsg("系统无法查询到您传入的推荐人: " + username + " !");
                        //生产环境则发送短信
                        if (wsLocalIp.equals("192.168.0.209")) {
                            //发送短信通知推荐人关注微信服务号并进行注册
                            smsService.sendSms(username, "尊敬的卡得万利商户，您好！您转介推荐的商户：" + refferName + " 的融资手续正在办理中，请立即在微信中搜索“CVBAOLI”或“卡得万利”关注并进行新用户注册，以免影响您的现金券赠送！如在被推荐商户成功放款后还未完成上述操作，您的优惠券将作废处理！");
                        }
                    }
                } else {
                    result.setResultMsg("推荐人用户名不允许为空!");
                }
            }
        } catch (Exception e) {
            result.setResultMsg("服务器出错: 调用 " + this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + " 失败 !"); //返回错误信息接口
            result.setResultData(e.getMessage());
            utilityService.sendMailForException(actionLogRepository.save(new ActionLog(Constants.ACTION_RESTFUL, new Date(), //记录错误信息到数据库
                    this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName(), callMethodParams, result.getResultMsg(), Utility.getExceptionInfo(e))));
        }

        logger.error(result.getResultMsg());
        return result;
    }

}
