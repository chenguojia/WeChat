package com.cardvalue.wechat.service;

import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.ws.bo.SynMerchantRequest;
import com.cardvalue.wechat.ws.bo.SynMerchantUserRequest;
import org.springframework.dao.DataAccessException;

import com.cardvalue.wechat.dto.UserRegisterDTO;
import com.cardvalue.wechat.model.Merchant;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.util.Result;

public interface UserService {

	public WeUser findByUsername(String username) throws DataAccessException;
	
	public WeUser findByOpenId(String openId) throws DataAccessException;
	
	public WeUser bind(String username, String openId) throws DataAccessException;
	
	public void afterLogin(WeUser user, HttpSession session) throws DataAccessException;
	
	public Sales findSalesByUserId(int userId);
	
	public Merchant findMerchantByUserId(int userId);
	
	/**
	 * 注册创建用户
	 * @param dto
	 * @return
	 */
	public Result<?> createUser(UserRegisterDTO dto,HttpSession session) throws Exception;

	/**
	 * 同步网站用户认证到微信端
	 * @param synUserObj 同步用户对象
	 * @return
	 */
	public Result<?> synMerchantUser(SynMerchantUserRequest synUserObj);

	/**
	 * 网站端同步商户信息到微信端
	 * @param synMerchantObj
	 * @return
	 */
	public Result<?> synMerchant(SynMerchantRequest synMerchantObj);
	
}
