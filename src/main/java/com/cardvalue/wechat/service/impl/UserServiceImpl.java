package com.cardvalue.wechat.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import cn.cvbaoli.www.AddServiceBindingStub;
import cn.cvbaoli.www.ArrResponse;
import cn.cvbaoli.www.SoapRequestAuths;
import cn.cvbaoli.www.SoapSyncUserRequestMain;
import com.cardvalue.wechat.ws.bo.SynMerchantRequest;
import com.cardvalue.wechat.ws.bo.SynMerchantUserRequest;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.UserRegisterDTO;
import com.cardvalue.wechat.model.Merchant;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.UserInfo;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.MerchantRepository;
import com.cardvalue.wechat.repository.SalesRepository;
import com.cardvalue.wechat.repository.UserInfoRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.AdminService;
import com.cardvalue.wechat.service.LogService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

@Service("userService")
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UserInfoRepository userInfoRepository;
	
	@Resource
	private UtilRepository utilRepository;
	
	@Resource
	private UtilityService utilityService;
	
	@Resource
	private SalesRepository salesRepository;
	
	@Resource
	private MerchantRepository merchantRepository;
	
	@Resource
	private LogService logService;
	
	@Resource
	private AdminService adminService;
	
	@Resource
	private WeChatService weService;

	@Resource
	private AddServiceBindingStub addServiceBindingStub;

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public WeUser findByUsername(String username) throws DataAccessException {
		return userRepository.findByUsername(username);
	}
	
	@Override
	@Transactional(readOnly = true)
	public WeUser findByOpenId(String openId) throws DataAccessException {
		return userRepository.findByOpenId(openId);
	}

	@Override
	@Transactional
	public WeUser bind(String username, String openId) throws DataAccessException {
		WeUser user = userRepository.findByUsername(username);
		if(user.getType() != Constants.USER_TYPE_TESTING){
			if(!StringUtils.equals(user.getOpenId(), openId)){
				logger.info("bind user to new openid:" + openId);
				user.setOpenId(openId);
				user = userRepository.save(user);
				adminService.weGroupMove(user.getId());
			}
		}
		return user;
	}

	@Override
	@Transactional
	public void afterLogin(WeUser user, HttpSession session) throws DataAccessException {
		MDC.put("user", user.getUsername());
		//将用户与用户详情存入SESSION
		session.setAttribute(Constants.SESSION_KEY_USER, user);
		session.setAttribute(Constants.SESSION_KEY_USER_INFO,userInfoRepository.findByUserId(user.getId()));
		
		//根据用户类型判断是商户还是销售经理，分别将不同对象存入SEESION
		if(user.getType() != Constants.USER_TYPE_MERCHANT){
			Sales sales = salesRepository.findByUserId(user.getId());
			session.setAttribute(Constants.SESSION_KEY_SALES, sales);
		}else{
			//通过当前登录人id查找对应商户
			Merchant merchant = merchantRepository.findByUser(user);
			//如果查询到了则表示用户认证过，存入session
			session.setAttribute(Constants.SESSION_KEY_MERCHANT, merchant);
		}
		
		user.setLastLogin(new Date());
		user.setToken("");
		userRepository.save(user);
		logService.insertActionLog(Constants.ACTION_LOG_IN, user.getId(), user.getOpenId(), "User Type:" + user.getType());
	}

	@Override
	public Sales findSalesByUserId(int userId) {
		return salesRepository.findByUserId(userId);
	}
	
	@Override
	public Merchant findMerchantByUserId(int userId) {
		WeUser user = userRepository.findOne(userId);
		return merchantRepository.findByUser(user);
	}
	
	/**
	 * 注册创建用户
	 * @param dto
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Override
	@Transactional
	public Result<?> createUser(UserRegisterDTO dto,HttpSession session) throws Exception{
		Result<?> result = new Result<Object>();
		
		//判断用户名是否唯一
		if(userRepository.findByUsername(dto.getMobile()) == null){
			/**创建user对象*/
			WeUser user = userRepository.createUser(Constants.USER_TYPE_MERCHANT, dto.getMobile(), dto.getPassword(), dto.getReferrerId(), Constants.USER_SOURCE_SUBSCRIBE, dto.getOpenId(), true, Constants.PROCESSOR_ID_NA);
			logger.info("成功创建user对象，id为："+ user.getId());

			try {
				//复制属性
				UserInfo tempUserInfo = new UserInfo();
				PropertyUtils.copyProperties(tempUserInfo, dto);
				//设置省份和城市的中文汉字
				if(tempUserInfo.getProvinceId() != null && tempUserInfo.getProvinceId() > 0){
                    tempUserInfo.setProvinceName(utilRepository.getProvincesOrRegionsById(tempUserInfo.getProvinceId()).getName());
                }
				if(tempUserInfo.getRegionId() != null && tempUserInfo.getRegionId() > 0){
                    tempUserInfo.setRegionName(utilRepository.getProvincesOrRegionsById(tempUserInfo.getRegionId()).getName());
                }
				//关联用户user的id
				tempUserInfo.setUserId(user.getId());
				tempUserInfo.setCreateDate(new Date());
				/**创建userInfo对象*/
				UserInfo userInfo = userInfoRepository.save(tempUserInfo);
				logger.info("成功创建userInfo对象，id为："+ userInfo.getId());
				//推送微信消息
				//weService.pushMessage(dto.getOpenId(), "亲，您已经成功完成注册！");

				//调用网站接口将新创建的用户同步到网站
				if(session != null){
                    SoapRequestAuths soapRequestAuths = new SoapRequestAuths("", "");
                    SoapSyncUserRequestMain soapSyncUserRequestMain = new SoapSyncUserRequestMain(userInfo.getMobile(), user.getPassword(), userInfo.getName(), userInfo.getMobile(), userInfo.getEmail(), userInfo.getProvinceId() == null ? null :userInfo.getProvinceId().toString(), userInfo.getRegionId() == null ? null : userInfo.getRegionId().toString(), "1");
                    ArrResponse arrResponse = addServiceBindingStub.syncUser(soapRequestAuths, soapSyncUserRequestMain);
                    if(!arrResponse.getStatus().equals("1")){
                        //表示失败，打印日志信息
                        ObjectMapper mapper = new ObjectMapper();
                        logService.insertActionLog(Constants.ACTION_SYN_USER, user.getId(), null, "微信端用户注册成功同步到网站用户失败，失败详情如下：1、网站service第1个参数对象'auths'转json为:"+ mapper.writeValueAsString(soapRequestAuths) + " 2、网站service第2个参数对象转'json'为:"+ mapper.writeValueAsString(soapSyncUserRequestMain));
                    }
                }
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setMessage("亲，您已经成功完成注册！");
			} catch (Exception e) {
				logger.error("",e);
			}
		}else{
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("当前手机号已被注册，请输入其他手机号");
		}
		
		return result;
	}

	/**
	 * 同步网站用户认证到微信端
	 * @param synUserObj 同步用户对象
	 * @return
	 */
	@Override
	@Transactional
	public Result<?> synMerchantUser(SynMerchantUserRequest synUserObj){
		//接口返回结果
		Result<?> result = new Result<Object>();

		try {
			//判断同步的对象是否存在
			if(userRepository.findByUsername(synUserObj.getMobile()) == null){
				/**step1.创建用户对象*/
				WeUser user = new WeUser();
				user.setUsername(synUserObj.getMobile());
				user.setPassword(synUserObj.getPassword());
				user.setType(Constants.USER_TYPE_MERCHANT);
				user.setEnabled(true);
				user.setReferrerId(0);
				user.setSource(Constants.USER_SOURCE_SUBSCRIBE);
				user.setProcessorId(Constants.PROCESSOR_ID_NA);
				em.persist(user);

				/**step2.创建用户信息对象*/
				UserInfo userInfo = new UserInfo();
				userInfo.setName(synUserObj.getName());
				userInfo.setMobile(synUserObj.getMobile());
				userInfo.setEmail(synUserObj.getEmail());
				userInfo.setProvinceId(synUserObj.getProvinceId());
				userInfo.setRegionId(synUserObj.getRegionId());
				if(synUserObj.getProvinceId() != null) userInfo.setProvinceName(utilRepository.getProvincesOrRegionsById(synUserObj.getProvinceId()).getName());
				if(synUserObj.getRegionId() != null) userInfo.setRegionName(utilRepository.getProvincesOrRegionsById(synUserObj.getRegionId()).getName());
				userInfo.setUserId(user.getId());
				em.persist(userInfo);

				/**step3.同步用户后将用户认证成功*/
				Merchant merchant = new Merchant();
				merchant.setUser(user);
				merchant.setContactMobile(synUserObj.getMobile());
				merchant.setContactPosition(Integer.valueOf(synUserObj.getContactPosition()));//身份
				merchant.setCreateDate(new Date());
				merchant.setAuthorizationFlag(true);//默认同意条款
				merchant.setActiveStatus(2);//用户自主注册，直接验证通过
				merchant.setActiveStatusLabel("验证通过");
				em.persist(merchant);

			}else{
				/**修改用户对象*/
				WeUser user = userRepository.findByUsername(synUserObj.getMobile());
				if(StringUtils.isNotBlank(synUserObj.getMobile())) user.setUsername(synUserObj.getMobile());
				if(StringUtils.isNotBlank(synUserObj.getPassword())) user.setPassword(synUserObj.getPassword());
				em.merge(user);

				/**修改用户信息对象*/
				UserInfo userInfo = userInfoRepository.findByUserId(user.getId());
				if(StringUtils.isNotBlank(synUserObj.getName()))  userInfo.setName(synUserObj.getName());
				if(StringUtils.isNotBlank(synUserObj.getMobile()))  userInfo.setMobile(synUserObj.getMobile());
				if(StringUtils.isNotBlank(synUserObj.getEmail()))  userInfo.setEmail(synUserObj.getEmail());
				if(synUserObj.getProvinceId() != null)  userInfo.setProvinceId(synUserObj.getProvinceId());
				if(synUserObj.getRegionId() !=null)  userInfo.setRegionId(synUserObj.getRegionId());
				if(synUserObj.getProvinceId() != null) userInfo.setProvinceName(utilRepository.getProvincesOrRegionsById(synUserObj.getProvinceId()).getName());
				if(synUserObj.getRegionId() != null) userInfo.setRegionName(utilRepository.getProvincesOrRegionsById(synUserObj.getRegionId()).getName());
				userInfo.setUserId(user.getId());
				em.merge(userInfo);
			}
			//设置省份和城市的中文汉字
			/*if(tempUserInfo.getProvinceId() > 0){
				tempUserInfo.setProvinceName(utilRepository.getProvincesOrRegionsById(tempUserInfo.getProvinceId()).getName());
			}
			if(tempUserInfo.getRegionId() > 0){
				tempUserInfo.setRegionName(utilRepository.getProvincesOrRegionsById(tempUserInfo.getRegionId()).getName());
			}*/

			/**返回结果*/
			result.setCode(Constants.RESULT_CODE_SUCCESS);
			result.setMessage("网站端用户同步到微信端成功！");

			/**日志*/
			logger.info("网站端用户同步到微信端成功！");

		} catch (Exception e) {

			/**返回结果*/
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("网站端用户同步到微信端失败！");

			/**日志*/
			logger.info("网站端用户同步到微信端出错！错误信息如下：",e);
		}

		return result;
	}

	/**
	 * 网站端同步商户信息到微信端
	 * @param synMerchantObj
	 * @return
	 */
	@Override
	@Transactional
	public Result<?> synMerchant(SynMerchantRequest synMerchantObj){
		//接口返回结果
		Result<?> result = new Result<Object>();
		WeUser user = userRepository.findByUsername(synMerchantObj.getUserName());

		try {
			/**step1.创建商户对象*/
			Merchant merchant = new Merchant();
			merchant.setUser(user);
			merchant.setName(synMerchantObj.getMerchantName());
			merchant.setContactName(synMerchantObj.getContactName());
			merchant.setContactMobile(synMerchantObj.getContactMobile());
			merchant.setContactPosition(synMerchantObj.getContactPosition());
			merchant.setCreateDate(new Date());
			merchant.setAddress(synMerchantObj.getAddress());
			merchant.setAuthorizationFlag(true);//默认同意条款
			merchant.setActiveStatus(2);//用户自主注册，直接验证通过
			merchant.setActiveStatusLabel("验证通过");
			//特殊处理MID，用户可以输入多个商编
			String[] mids = synMerchantObj.getMid().split(",");
			if(mids.length == 1){
				merchant.setMid(synMerchantObj.getMid().substring(0,15));
			}else{
				merchant.setMid(mids[0].substring(0,15));
				//拼接其他mid
				String otherMid = "";
				for(int i = 1 ; i <mids.length ; i ++){
					otherMid += mids[i]+",";
				}
				merchant.setOtherMid(otherMid);
			}
			//判断同步的对象是否存在
			if(merchantRepository.findByUser(user) == null){
				em.persist(merchant);//保存
			}else{
				merchant.setId(merchantRepository.findByUser(user).getId());
				em.merge(merchant);//修改
			}

			/**step2.修改用户对象*/
			if(synMerchantObj.getProcessorId() != null){
				user.setProcessorId(synMerchantObj.getProcessorId());//如果网站端有传入PROCESSORID则修改
				em.merge(user);
			}

			/**返回结果*/
			result.setCode(Constants.RESULT_CODE_SUCCESS);
			result.setMessage("网站端同步商户信息到微信端成功！");

			/**日志*/
			logger.info("网站端同步商户信息到微信端成功！");

		} catch (Exception e) {

			/**返回结果*/
			result.setCode(Constants.RESULT_CODE_FAILED);
			result.setMessage("网站端同步商户信息到微信端失败！");

			/**日志*/
			logger.info("网站端同步商户信息到微信端出错！错误信息如下：",e);
		}

		return result;
	}
	
}
