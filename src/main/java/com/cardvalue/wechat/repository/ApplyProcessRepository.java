package com.cardvalue.wechat.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cardvalue.wechat.model.ApplyProcess;

public interface ApplyProcessRepository extends CrudRepository<ApplyProcess, Integer>,ApplyProcessRepositoryCustom{
	public List<ApplyProcess> findByProcessType(int processType);
}
