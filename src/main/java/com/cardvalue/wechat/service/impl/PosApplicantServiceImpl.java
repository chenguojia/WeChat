package com.cardvalue.wechat.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.model.PosApplicant;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.repository.PosApplicantRepository;
import com.cardvalue.wechat.repository.SalesRepository;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.PosApplicantService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

@Service
public class PosApplicantServiceImpl implements PosApplicantService{

	@Resource
	private PosApplicantRepository posApplicantRepo;
	
	@Resource
	private SalesRepository salesRepo;
	
	@Resource
	private UtilRepository utilRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<PosApplicant> findByUserId(int userId) {
		return posApplicantRepo.findByUserId(userId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PosApplicant> findByPrefecture(String prefecture) {
		return posApplicantRepo.findByPrefecture(prefecture);
	}

	@Override
	@Transactional
	public Result<?> claim(int userId, int applicantId) {
		Result<?> result = new Result<Object>();
		result.setCode(Constants.RESULT_CODE_FAILED);
		PosApplicant app = posApplicantRepo.findOne(applicantId);
		if(app != null){
			if(app.getStatus() == 1){
				app.setUserId(userId);
				app.setStatus(2);
				app.setClaimDate(new Date());
				posApplicantRepo.save(app);
				result.setCode(Constants.RESULT_CODE_SUCCESS);
				result.setMessage("已经成功领取");
			}else{
				result.setMessage("待装POS商户已被领取");
			}
		}else{
			result.setMessage("待装POS商户不存在");
		}
		return result;
	}

	@Override
	public PosApplicant findOne(int id) {
		return posApplicantRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public int countByPrefecture(int userId) {
		Sales s = salesRepo.findByUserId(userId);
		String regionCode = s.getRegionCode();
		String region = utilRepo.getRegionLabelByCode(regionCode);
		int count = this.findByPrefecture(region).size();
		return count;
	}

}
