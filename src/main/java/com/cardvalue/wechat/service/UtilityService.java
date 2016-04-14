package com.cardvalue.wechat.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.model.CvRegionConf;
import com.cardvalue.wechat.model.Parameter;

public interface UtilityService {

	public String generateSequenceNumber(int type);
	
	public Parameter getParamByValueAndGroup(String group, String value);
	
	public List<Parameter> getParamsByGroup(String group);

	public void resetSequenceNumber();

	long storeMerchantReferrer(int referrerId, String mid);

	boolean validReferrerLink(long linkId);
	
	/**
	 * 判断用户是客户经理还是商户
	 * @param userId 用户id
	 * @return 1表示客户经理 0表示商户
	 */
	public String getUserType(Integer userId);
	
	/**
	 * 校验用户输入的手机和验证码是否和服务器一致
	 * @param session 
	 * @param inputMobile 用户输入的手机号码
	 * @param inputCheckCode 用户输入的验证码
	 * @return
	 */
	public String validateCheckCode(HttpSession session,String inputMobile,String inputCheckCode);
	
	/**
	 * 查询所有省份或者城市
	 * @param type 1省  2市
	 * @param pid 上一节点id
	 * @return
	 */
	public List<CvRegionConf> queryProvincesOrRegions(Integer type,Integer pid);
	
	/**
	 * 通过省份或者城市id获取对象
	 * @param id
	 * @return
	 */
	public CvRegionConf getProvincesOrRegionsById(Integer id); 
	
	public CvRegionConf getProvincesOrRegionsByName(String name);

	String getCategoryByMcc(String mcc);

	/**
	 * 外部调用微信接口出错通知邮件
	 * @param businessObj 需要在邮件中现实详情的对象
	 */
	public void sendMailForException(Object businessObj);

}
