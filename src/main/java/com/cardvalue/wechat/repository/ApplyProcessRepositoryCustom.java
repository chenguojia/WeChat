package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.ApplyProcess;


public interface ApplyProcessRepositoryCustom {
	public ApplyProcess findByProcessTypeAndStepNum(int processType, int stepNum);
}
