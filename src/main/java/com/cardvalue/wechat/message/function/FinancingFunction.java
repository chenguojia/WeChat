package com.cardvalue.wechat.message.function;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.annotations.Synchronize;
import org.springframework.stereotype.Component;

import com.cardvalue.wechat.dto.ApplyProcessContext;
import com.cardvalue.wechat.model.ApplyProcess;
import com.cardvalue.wechat.model.ApplyProcessInputArgumentModel;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.ApplyProcessRepository;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Utility;

@Component("FinancingFunction")
public class FinancingFunction {

	@Resource
	UserService userService;
	
	@Resource
	ApplyProcessRepository applyProcessRepository;
	
	//用户申请流程唯一标示上下文map
	public static Map<String, ApplyProcessContext> applyProcessContextMap = new HashMap<String, ApplyProcessContext>();
	
	public String quickFinancing(String openId, String content){
		WeUser user = userService.findByOpenId(openId);
		String infoStr = null;
		if(user != null){
			ApplyProcess applyProcess = applyProcessRepository.findByProcessTypeAndStepNum(1, 1);
			if(applyProcess != null) {
				//设置用户与服务器交互时间
				applyProcess.setLastOptStepDate(new Date());
				//表示申请速融流程开始，给常量赋值
				this.applyProcessContextMap.put(openId, new ApplyProcessContext(applyProcess,new ApplyProcessInputArgumentModel()));
				//服务器返回提示信息给用户手机端
				return applyProcess.getResponText();
			}
		}else{
			infoStr = "对不起，您还不是注册用户或你的账户未绑定";
		}
		return infoStr;
	}
}
