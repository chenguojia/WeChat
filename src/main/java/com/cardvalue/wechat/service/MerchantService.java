package com.cardvalue.wechat.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.dto.*;
import com.cardvalue.wechat.model.*;
import com.cardvalue.wechat.util.Result;
import org.springframework.transaction.annotation.Transactional;

public interface MerchantService {

	public MerchantCredit findMerchantByNumber(String number, String processorId);
	
	public CreditInfo calculate(CalculateInfo info);
	
	public boolean allowAccess(MerchantCredit credit, Sales sales);
	
	public int setActivateStatus(String mid, int status, String statusLabel, String memo, Date updateDate, String verifier);
	
	public Result<?> create(MerchantRegisterDTO dto, Sales s);
	
	/**
	 * 认证新增商户
	 * @param dto
	 * @param s
	 * @return
	 */
	public Result<?> createMerchant(MerchantRegisterDTO dto, Sales s,WeUser user,HttpSession session);
	
	public void authorize(int mid);
	
	public Result<?> remoteAdd(RemoteAddMerchantDTO dto, Sales s);
	
	public Result<?> validMerchant(String openId, long linkId);

	public int sendReferrerLinkNotice(ReferrerLink link);

	boolean hasCreditLine(List<MerchantCredit> credits);
	
	/**
	 * 查询对账单明细
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @param baoliId 商户的保利id
	 * @param pageNum 当前页码
	 * @param pageSize 每页数量
	 * @return
	 */
	public ExchangerResultModel bankStatementList(String beginDate,String endDate,String baoliId,int pageNum, int pageSize);
	
	/**
	 * 通过商户id获取保利编号集合
	 * @param mid
	 * @return
	 */
	public List queryBaolisIdByMid(String mid);

	/**
	 * 获取授信详情公共方法
	 * @param dto 调用接口需要用到的dto
	 * @param user 调用接口需要用到的user
	 * @param entryType 入口类型：1表示是在后台认证的时候调用  2表示直接在用户管理界面里点击进入查询授信额度
	 * @returnentryType
	 */
	public Result<?> getCreditInfo(MerchantRegisterDTO dto,WeUser user,String entryType);

	/**
	 * 修改商户信息，（用于网站第一次同步用户到微信，微信端进入认证界面补全信息）
	 * @param dto
	 * @param user
	 * @param session
	 * @return
	 */
	@Transactional
	public Merchant mergeMerchant(MerchantRegisterDTO dto,WeUser user,HttpSession session);

	/**
	 * 获取速融记录
	 * @param user
	 * @param type 1获取所有类型融资记录 2只获取“速融”类型融资记录
	 * @return
	 */
	public List queryInstantCreditByMerchantAppid(WeUser user,String type);

	/**
	 * 通过保理id获取单个速融记录
	 * @param user
	 * @return
	 */
	public InstantCreditModel getInstantCreditModelByCashadvId(WeUser user,String cashadvId);

	/**
	 * 判断是否有未完成的融资申请
	 * @param user
	 * @return
	 */
	public Result<?> isFinishFinancing(WeUser user);

	/**
	 * 关闭融资申请
	 * @param user
	 * @return
	 */
	public Result<?> closeFinancing(WeUser user,String cashadvId);
}
