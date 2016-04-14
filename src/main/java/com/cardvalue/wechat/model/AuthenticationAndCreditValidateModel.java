package com.cardvalue.wechat.model;

import com.cardvalue.wechat.util.Result;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationAndCreditValidateModel {
	
	private String validateResult;//验证结果,1成功 0失败
	
	private ModelAndView mv;//验证成功mv有值，否则为null
	
	private Result<?> result;//验证成功result有值，否则为null

	public String getValidateResult() {
		return validateResult;
	}

	public void setValidateResult(String validateResult) {
		this.validateResult = validateResult;
	}

	public ModelAndView getMv() {
		return mv;
	}

	public void setMv(ModelAndView mv) {
		this.mv = mv;
	}

	public Result<?> getResult() {
		return result;
	}

	public void setResult(Result<?> result) {
		this.result = result;
	}
	
	
	
	
}
