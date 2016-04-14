package com.cardvalue.wechat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cardvalue.wechat.model.ActionLog;

import java.util.List;

@Repository
public interface ActionLogRepository extends CrudRepository<ActionLog, Long>{
    public List<ActionLog> findByActionAndOpenId(int action,String openId);
}
