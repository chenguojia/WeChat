package com.cardvalue.wechat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.axis2.databinding.types.soapencoding.Array;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cardvalue.wechat.dto.WeButton;
import com.cardvalue.wechat.dto.WeGroup;
import com.cardvalue.wechat.dto.WeGroupCreateResponse;
import com.cardvalue.wechat.dto.WeMenu;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.model.WechatMenu;
import com.cardvalue.wechat.repository.CampaignRepository;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.repository.WechatMenuRepository;
import com.cardvalue.wechat.service.AdminService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.service.WechatMenuService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

@Service("wechatMenuService")
public class WechatMenuServiceImpl implements WechatMenuService{

	private final static Logger logger = LoggerFactory.getLogger(WechatMenuServiceImpl.class);

	@Resource
	private WechatMenuRepository wechatMenuRepository;
	
	@Value("${wechat.base.url}")
	private String baseURL;
	
	@Value("${wechat.app.name}")
	private String appName;
	
	@Value("${wechat.appid}")
	private String weAppId;
	
	@Override
	public WeMenu loadMenus() {
		
		/**服务器地址**/
		String appURL = baseURL + appName;
		
		/**主菜单**/
		WeMenu menu = new WeMenu();
		
		//获取3个根节点
		List<WechatMenu> rootMenus = wechatMenuRepository.findByParentId(null);
		
		for (WechatMenu rootMenu : rootMenus) {
			
			WeButton rootButton = new WeButton();
			rootButton.setName(rootMenu.getName());
			
			//获取子菜单集合
			List<WechatMenu> childrenMenus = wechatMenuRepository.findByParentId(rootMenu.getId());
			
			for (WechatMenu childrenMenu : childrenMenus) {
				WeButton childrenBtn = new WeButton();
				childrenBtn.setName(childrenMenu.getName());
				childrenBtn.setType(childrenMenu.getType());
				//如果是类型为view，则设置URL
				if(childrenMenu.getType().equals(Constants.WE_MENU_BUTTON_TYPE_VIEW)){
					//如果菜单为用户入口则特殊处理URL
					if(childrenMenu.getName().equals("用户入口")){
						childrenBtn.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?"
								+ "redirect_uri=http%3A%2F%2F220.248.19.21%2F" + appName 
								+ "%2Fhome%2Fenter&response_type=code&scope=snsapi_base&appid=" + weAppId);
					}else{
						//普通菜单则设置默认的URL
						if(childrenMenu.getUrl().indexOf("https") == -1)
							childrenBtn.setUrl(appURL + childrenMenu.getUrl());
						else 
							childrenBtn.setUrl(childrenMenu.getUrl());	
					}
				}
				//如果类型是事件，则设置key	
				if(childrenMenu.getType().equals(Constants.WE_MENU_BUTTON_TYPE_CLICK))
					childrenBtn.setKey(childrenMenu.getKey());
				//将子节点加入根节点中
				rootButton.getSubButtons().add(childrenBtn);
			}
			
			/**主菜单按钮加入主菜单中**/
			menu.getButtons().add(rootButton);
		}
		
		return menu;
	}
	
	
}
