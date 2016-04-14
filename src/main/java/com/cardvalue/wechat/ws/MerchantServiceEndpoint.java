package com.cardvalue.wechat.ws;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cardvalue.wechat.repository.SalesRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;
import com.cardvalue.wechat.ws.bo.UpdateMerchantActiveStatusRequest;

@Component
@WebService(serviceName="MerchantService")
public class MerchantServiceEndpoint  {

	private final static Logger logger = LoggerFactory.getLogger(MerchantServiceEndpoint.class);
	
	@Resource
	private UserRepository userRepo;

	@Resource
	private SalesRepository salesRepo;
	
	@Resource
	private MerchantService merchantService;
	
	@WebMethod(operationName="updateMerchantActiveStatus")
	public Result<?> updateMerchantActiveStatus(UpdateMerchantActiveStatusRequest request) throws ParseException {
		logger.info("start update merchant active status [mid:" + request.getMid() + "][status:" + request.getStatus() + "][date:" + request.getUpdateDate() + "]");
		Result<Object> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		int status = 3;
		String statusLabel = "未验证通过";
		if(request.getStatus().equals("验证成功")){
			status = 2;
			statusLabel = "营销成功";
		}
		Date updateDate = DateUtils.parseDate(request.getUpdateDate(), new String[]{"yyyy-MM-dd HH:mm:ss"});
		int flag = merchantService.setActivateStatus(request.getMid(), status, statusLabel, request.getMemo(), updateDate, request.getVerifier());
		result.setMessage(String.valueOf(flag));
		if(flag == 1){
			result.setCode(Constants.RESULT_CODE_SUCCESS);
		}
		return result;
	}
	
}
