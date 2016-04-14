package com.cardvalue.wechat.web;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cardvalue.wechat.dto.MessageVerificationDTO;
import com.cardvalue.wechat.dto.WeButton;
import com.cardvalue.wechat.dto.WeChatMessage;
import com.cardvalue.wechat.dto.WeMenu;
import com.cardvalue.wechat.message.MessageHandler;
import com.cardvalue.wechat.message.MessageHandlers;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.XMLConverter;

@Controller
@RequestMapping({"/we"})
public class WeController {
    private static final Logger logger = LoggerFactory.getLogger(WeController.class);
    @Value("${wechat.verification.token}")
    private String token;
    @Value("${wechat.appid}")
    private String weAppId;
    @Value("${wechat.base.url}")
    private String baseURL;
    @Value("${wechat.app.name}")
    private String appName;
    @Resource
    private MessageHandlers messageHandlers;
    @Resource
    private XMLConverter xmlConverter;
    @Resource
    private WeChatService weChatService;
    @Resource
    private UserRepository userRepo;

    @ResponseBody
    @RequestMapping(value = {"/io"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String verify(MessageVerificationDTO dto) {
        logger.info("start verification : {}", dto);
        boolean flag = false;

        String[] strs = {dto.getTimestamp(), dto.getNonce(), this.token};
        Arrays.sort(strs);

        String tempSignature = DigestUtils.sha1Hex(StringUtils.join(strs, null));
        logger.info("calculated signature : {}", tempSignature);

        flag = StringUtils.equals(tempSignature, dto.getSignature());
        logger.info("verify flag : {}", Boolean.valueOf(flag));
        if (flag) {
            return dto.getEchostr();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = {"/io"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String io(@RequestBody String xml) {
        String response = null;
        logger.info("receiving message : {}", xml);
        try {
            WeChatMessage message = (WeChatMessage) this.xmlConverter.convertFromXMLToObject(xml);
            MessageHandler handler = this.messageHandlers.getMessageHandler(message);
            response = handler.handle(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = {"/menu/create"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public void createMenu() {
        String appURL = this.baseURL + this.appName;
        WeMenu menu = new WeMenu();
        WeButton button1 = new WeButton();
//        button1.setName("融资入口");
//        button1.setType("view");
//        button1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fhome%2Fenter%3FredirectUrl%3D&response_type=code&scope=snsapi_base&appid=" + this.weAppId);

        button1.setName("融资入口");
        button1.setType("view");
        button1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fnew%2Fm%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);

        WeButton button2 = new WeButton();
        button2.setName("最新活动");
        button2.setType("view");
        button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fhome%2Fenter%3FredirectUrl%3D%2Fpublic%2FnewestCampaign&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
        //button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fpublic%2FnewestCampaign&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
        //button2.setType("click");
        //button2.setKey("new_activities");
        //button2.setUrl("http://220.248.19.21/" + this.appName + "/resources/html/advertisement.html");

        WeButton button3 = new WeButton();
        button3.setName("服务");
        WeButton button3_1 = new WeButton();
        button3_1.setName("商业保理");
        button3_1.setType("view");
        button3_1.setUrl(appURL + "/merchant/page/factoring-introduce");
        button3.getSubButtons().add(button3_1);

        WeButton button3_2 = new WeButton();
        button3_2.setName("常见问题");
        button3_2.setType("view");
        button3_2.setUrl(appURL + "/merchant/page/question");
        button3.getSubButtons().add(button3_2);

        WeButton button3_3 = new WeButton();
        button3_3.setName("案例分享");
        button3_3.setType("view");
        button3_3.setUrl(appURL + "/merchant/page/cases");
        button3.getSubButtons().add(button3_3);

        WeButton button3_4 = new WeButton();
        button3_4.setName("关于我们");
        button3_4.setType("view");
        button3_4.setUrl(appURL + "/merchant/page/about-us");
        button3.getSubButtons().add(button3_4);

    /*WeButton button3_5 = new WeButton();
    button3_5.setName("用户入口");
    button3_5.setType("view");
    button3_5.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
    button3.getSubButtons().add(button3_5);*/

        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        this.weChatService.createMenu(menu);
    /*String appURL = this.baseURL + this.appName;
    WeMenu menu = new WeMenu();
    WeButton button1 = new WeButton();
    button1.setName("商户");
    WeButton button1_1 = new WeButton();
    button1_1.setName("计算额度");
    button1_1.setType("view");
    button1_1.setUrl(appURL + "/merchant/calculator");
    button1.getSubButtons().add(button1_1);
    WeButton button1_2 = new WeButton();
    button1_2.setName("融资申请");
    button1_2.setType("view");
    button1_2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fhome%2Fenter%3FredirectUrl%3D%2Fm%2FnewApply&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
    

    button1.getSubButtons().add(button1_2);
    
    WeButton button2 = new WeButton();
    button2.setName("积分活动");
    button2.setType("view");
    button2.setUrl("http://220.248.19.21/" + this.appName + "/resources/html/advertisement.html");
    
    WeButton button3 = new WeButton();
    button3.setName("服务");
    WeButton button3_1 = new WeButton();
    button3_1.setName("商业保理");
    button3_1.setType("view");
    button3_1.setUrl(appURL + "/merchant/page/factoring-introduce");
    button3.getSubButtons().add(button3_1);
    
    WeButton button3_2 = new WeButton();
    button3_2.setName("常见问题");
    button3_2.setType("view");
    button3_2.setUrl(appURL + "/merchant/page/question");
    button3.getSubButtons().add(button3_2);
    
    WeButton button3_3 = new WeButton();
    button3_3.setName("案例分享");
    button3_3.setType("view");
    button3_3.setUrl(appURL + "/merchant/page/cases");
    button3.getSubButtons().add(button3_3);
    
    WeButton button3_4 = new WeButton();
    button3_4.setName("关于我们");
    button3_4.setType("view");
    button3_4.setUrl(appURL + "/merchant/page/about-us");
    button3.getSubButtons().add(button3_4);
    
    WeButton button3_5 = new WeButton();
    button3_5.setName("用户入口");
    button3_5.setType("view");
    button3_5.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=http%3A%2F%2F220.248.19.21%2F" + this.appName + "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + this.weAppId);
    

    button3.getSubButtons().add(button3_5);
    
    menu.getButtons().add(button1);
    menu.getButtons().add(button2);
    menu.getButtons().add(button3);
    
    this.weChatService.createMenu(menu);*/
    }

    @RequestMapping(value = {"/user/{userId}"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    public String sendCustomMessage(@PathVariable int userId, @RequestBody String message) {
        WeUser user = (WeUser) this.userRepo.findOne(Integer.valueOf(userId));
        if ((user != null) && (StringUtils.isNotEmpty(user.getOpenId()))) {
            this.weChatService.pushMessage(user.getOpenId(), message);
            return "successful";
        }
        return "failed";
    }
}
