package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.Campaign;
import com.cardvalue.wechat.model.UserCampaign;
import com.cardvalue.wechat.model.UserCoupon;
import com.cardvalue.wechat.model.WeUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository(value = "userCampaignRepository")
public interface UserCampaignRepository extends CrudRepository<UserCampaign, Long>{

	public List<UserCampaign> findByCampaignAndUser(Campaign campaign, WeUser user);
	
}
