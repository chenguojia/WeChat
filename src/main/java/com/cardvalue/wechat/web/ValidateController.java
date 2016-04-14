package com.cardvalue.wechat.web;

import com.cardvalue.wechat.repository.MerchantRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.util.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/v")
public class ValidateController {

	private static final Logger logger = LoggerFactory.getLogger(ValidateController.class);

	@Resource
	private UserRepository userRepository;

	@Resource
	private MerchantRepository merchantRepository;

	@Value("${ws.crm.restful.url}")
	private String wsCrmRestfulUrl;

	/**
	 * 注册,校验手机是否重复
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/validMobile",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String validMobile(String param){
		if(userRepository.findByUsername(param) != null) return  "0";
		else return "1";

	}

	/**
	 * 注册,校验推荐人手机是否合法
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/validReferrerMobile",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String validReferrerMobile(String param){
		//判断推荐人手机号码是否不为空
		if(StringUtils.isNotBlank(param)){
			//检查推荐人手机号码是否存在
			if (userRepository.findByUsername(param) == null
					&& merchantRepository.findByContactMobile(param) == null) {
				//表示推荐人手机号码不正确，给提醒
				return "0";
			}else{
				//表示输入的推荐人手机号码系统能找到
				return "1";
			}
		}else{
			return "1";
		}
	}

	/**
	 * 注册,校验推荐人手机是否合法
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/validReferrerMobileWithCrm",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String validReferrerMobileWithCrm(String param){
		//判断推荐人手机号码是否不为空
		if(StringUtils.isNotBlank(param)){

			//step1、检查推荐人手机号码是否在CRM数据库存在
			try {
				//调用接口
				String url = wsCrmRestfulUrl + "/members";//接口url
				Map<String, String> map = new HashMap<String, String>();
				map.put("where", "{\"mobilePhone\":\""+ param +"\"}");
				String responseBody = HttpUtils.executeHttpRequest(url, map, HttpGet.METHOD_NAME);
				//解析JSON转对象
				if(responseBody.indexOf("failed") != -1){
					return "0"; //推荐人不存在，验证不通过
				} else {
					return "1"; //推荐人在CRM中存在，验证通过
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("call crm interface fail for query referrer ! error info : " + e.getMessage());
				return "0"; //接口调用出错，推荐人不存在，验证不通过
			}
		}else{
			return "1";//允许手机号为空，所以当期输入空时还是算通过
		}
	}

}
