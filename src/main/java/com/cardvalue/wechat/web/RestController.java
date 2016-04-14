package com.cardvalue.wechat.web;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cardvalue.wechat.dto.CouponInfo;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.CouponService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private UtilityService utilService;

	@Resource
	private UtilRepository utilRepository;

	@ResponseBody
	@RequestMapping(value = "/rest/coupon/info/{number}", method = RequestMethod.GET, produces = "application/javascript;charset=UTF-8")
	public String getCouponInfo(@PathVariable String number, @RequestParam(required=false) String callback) throws IOException {
		logger.info("getting coupon info with number:" + number);
		CouponInfo couponInfo = couponService.getCouponInfo(number);
		Result<CouponInfo> result = new Result<CouponInfo>();
		if(couponInfo != null){
			result.setCode(Constants.RESULT_CODE_SUCCESS);
			result.setPayload(couponInfo);
		}else{
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("Coupon number[" + number + "] not found.");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(new JSONPObject(callback,result)));
		return objectMapper.writeValueAsString(new JSONPObject(callback,result));
	}
	
	@RequestMapping(value = "/rest/coupon/use/{number}", method = RequestMethod.GET, produces = "application/javascript;charset=UTF-8")
	@ResponseBody
	public String useCoupon(@PathVariable String number, @RequestParam(required=false) String callback) throws IOException{
		logger.info("using coupon with number:" + number);
		int flag = couponService.useCoupon(number);
		Result<?> result = new Result<Object>();
		if(flag == 1){
			result.setCode(Constants.RESULT_CODE_SUCCESS);
		}else{
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage(String.valueOf(flag));
		}
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(new JSONPObject(callback,result));
	}
	
	@RequestMapping(value = "/rest/mcc/check/{mcc}", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> checkMcc(@PathVariable String mcc){
		logger.info("check the mcc :" + mcc);
		Result<String> result = new Result<String>();
		Object[] categoryAndFlag = utilRepository.getCategoryAndFlagByMcc(mcc);
		if(categoryAndFlag != null){
			result.setCode(Constants.RESULT_CODE_SUCCESS);
			result.setMessage(categoryAndFlag[0] + "," + categoryAndFlag[1]);
			System.out.println(categoryAndFlag[0] + "," + categoryAndFlag[1]);
		}else{
			result.setCode(Constants.RESULT_CODE_FAILED);
		}
		return result;
	}
			
}
