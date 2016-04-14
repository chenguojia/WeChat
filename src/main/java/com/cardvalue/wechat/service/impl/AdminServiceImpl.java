package com.cardvalue.wechat.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cardvalue.wechat.dto.WeGroup;
import com.cardvalue.wechat.dto.WeGroupCreateResponse;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.AdminService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

@Service
public class AdminServiceImpl implements AdminService{

	private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private WeChatService weService;
	
	@Resource
	private ParamRepository paramRepo;
	
	@Override
	public String batchWeGroupMove() {
		int groupNumber = 0;
		int groupUserNumber = 0;
		Result<?> result = weService.listGroups();
		if(StringUtils.equals(result.getCode(), Constants.RESULT_CODE_SUCCESS)){
			List<WeGroup> groups = (List<WeGroup>)result.getPayload();
			List<Parameter> params = paramRepo.findByGroup(Constants.PARAM_GROUP_USER_TYPE);
			for(Parameter param : params){
				String userTypeName = param.getName();
				WeGroup group = findGroup(userTypeName, groups);
				if(group == null){
					Result createGroupResult = weService.createGroup(userTypeName);
					if(createGroupResult != null && StringUtils.equals(createGroupResult.getCode(),Constants.RESULT_CODE_SUCCESS)){
						WeGroupCreateResponse createGroupResponse = (WeGroupCreateResponse)createGroupResult.getPayload();
						WeGroup newGroup = createGroupResponse.getGroup();
						groups.add(newGroup);
						logger.info("Create group:" + userTypeName + " successful, return group id:" + newGroup.getId());
					}else{
						logger.info("Create group:" + userTypeName + " failed");
					}
				}
			}
			groupNumber = groups.size();
			Iterator<WeUser> iter = userRepo.findAll().iterator();
			while(iter.hasNext()){
				WeUser user = iter.next();
				String openId = user.getOpenId();
				if(StringUtils.isNoneBlank(openId)){
					int type = user.getType();
					Parameter typeParam = paramRepo.findByGroupAndValue(Constants.PARAM_GROUP_USER_TYPE, String.valueOf(type));
					if(typeParam != null){
						String typeName = typeParam.getName();
						WeGroup group = findGroup(typeName, groups);
						if(group != null){
							Result moveGroupResponse = weService.moveUserToGroup(openId, group.getId());
							if(moveGroupResponse != null && StringUtils.equals(moveGroupResponse.getCode(), Constants.RESULT_CODE_SUCCESS)){
								groupUserNumber++;
								logger.info("Move user:" + user.getId() + " to group:" + group.getId() + " successful");
							}else{
								logger.info("Move user:" + user.getId() + " to group:" + group.getId() + " failed");
							}
						}
					}
				}
			}
		}
		return "当前共有" + groupNumber + "个分组, 共有" + groupUserNumber + "名用户被分配到组内";
	}

	@Override
	public void weGroupMove(int userId) {
		WeUser user = userRepo.findOne(userId);
		Result<?> result = weService.listGroups();
		if(StringUtils.equals(result.getCode(), Constants.RESULT_CODE_SUCCESS)){
			List<WeGroup> groups = (List<WeGroup>)result.getPayload();
			int type = user.getType();
			Parameter typeParam = paramRepo.findByGroupAndValue(Constants.PARAM_GROUP_USER_TYPE, String.valueOf(type));
			WeGroup group = findGroup(typeParam.getName(), groups);
			if(group != null){
				Result<?> moveGroupResponse = weService.moveUserToGroup(user.getOpenId(), group.getId());
				if(moveGroupResponse != null && StringUtils.equals(moveGroupResponse.getCode(), Constants.RESULT_CODE_SUCCESS)){
					logger.info("Move user:" + user.getId() + " to group:" + group.getId() + " successful");
				}else{
					logger.info("Move user:" + user.getId() + " to group:" + group.getId() + " failed");
				}
			}
		}else{
			logger.warn("list we group failed");
		}
	}
	
	@Override
	public Result<?> weGroupUpdate(String fromGroupName, String toGroupName) {
		Result<?> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		Result<?> listGroupResult = weService.listGroups();
		if(StringUtils.equals(listGroupResult.getCode(), Constants.RESULT_CODE_SUCCESS)){
			List<WeGroup> groups = (List<WeGroup>)listGroupResult.getPayload();
			WeGroup group = findGroup(fromGroupName, groups);
			if(group != null){
				result = weService.updateGroup(group.getId(), toGroupName);
			}else{
				logger.warn("group:" + fromGroupName + " not found");
				result.setMessage("group:" + fromGroupName + " not found");
			}
		}else{
			logger.warn("list we group failed");
			result.setMessage("list we group failed");
		}
		return result;
	}
	
	private WeGroup findGroup(String name, List<WeGroup> groups){
		/**
		 * 需求：现微后台将'运营专员'、'内部员工'移动到'银商客户经理'中
		 * 实现：判断当前登录人类型，是否是'运营专员'或'内部员工'，如果是则已将其移动到'银商客户经理'分组中
		 */
		if (name.equals("运营专员") || name.equals("内部员工")) {
			for (WeGroup group : groups) {
				if(StringUtils.equals("银商客户经理", group.getName())){
					return group;
				}
			}
		} else {
			for(WeGroup group : groups){
				if(StringUtils.equals(name, group.getName())){
					return group;
				}
			}
		}
		return null;
	} 
}
