package com.cardvalue.wechat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cardvalue.wechat.model.ApplyProcess;
import com.cardvalue.wechat.model.WechatMenu;

public interface WechatMenuRepository extends CrudRepository<WechatMenu, Integer>{
	public List<WechatMenu> findByParentId(Integer parentId);
}
