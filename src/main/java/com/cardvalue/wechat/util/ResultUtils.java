package com.cardvalue.wechat.util;


public class ResultUtils {

	public static boolean isSuccess(Result<?> r){
		return isCodeEquals(r, Constants.RESULT_CODE_SUCCESS);
	}
	
	public static boolean isFaild(Result<?> r){
		return isCodeEquals(r, Constants.RESULT_CODE_FAILED);
	}
	
	public static boolean isCodeEquals(Result<?> r, String code){
		if(r != null && r.getCode().equals(code)){
			return true;
		}else{
			return false;
		}
	}
	
}
