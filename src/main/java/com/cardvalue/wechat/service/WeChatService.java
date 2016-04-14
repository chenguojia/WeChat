package com.cardvalue.wechat.service;

import com.cardvalue.wechat.dto.WeMenu;
import com.cardvalue.wechat.util.Result;


public interface WeChatService {

	public void pushMessage(String openId, String content);
	
	public String getOpenIdByAccessToken(String code);
	
	public String getAccessToken();
	
	public void createMenu(WeMenu menu);

	Result<?> listGroups();

	Result<?> createGroup(String name);

	Result<?> moveUserToGroup(String openId, int groupId);
	
	Result<?> updateGroup(int groupId, String groupName);

	/**
	 * 推送自定义模板消息
	 * @param openId 接受者
	 * @param templateName 模板中文名称
	 * @param values 模板中参数
	 */
	public void pushTemplateMessage(String openId, String templateName,Object ... values);
	
}
