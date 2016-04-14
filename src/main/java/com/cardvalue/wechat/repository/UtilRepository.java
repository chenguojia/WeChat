package com.cardvalue.wechat.repository;

import java.util.List;

import com.cardvalue.wechat.dto.LabelValueTO;
import com.cardvalue.wechat.model.CvRegionConf;

public interface UtilRepository {

	public String getBranchLabelByCode(String code);
	
	public String getRegionLabelByCode(String code);

	public List<String> getStartupImages(int userId);

	public List<LabelValueTO> getAllBranches();

	public List<LabelValueTO> getRegionsByBranch(String branchCode);

	public String getBranchCodeByRegionCode(String regionCode, String salesBranchCode);

	public String getProvinceCodeByRegionCode(String regionCode);

	public void resetSequenceNumber();
	
	/**
	 * 查询所有省份或者城市
	 * @param type 1省  2市
	 * @param pid 上一节点id
	 * @return
	 */
	public List<CvRegionConf> queryProvincesOrRegions(Integer type,Integer pid);
	
	/**
	 * 通过省份或者城市id获取对象
	 * @param id
	 * @return
	 */
	public CvRegionConf getProvincesOrRegionsById(Integer id);

	CvRegionConf getProvincesOrRegionsByName(String name);

	String getCategoryByMcc(String mcc);

	public Object[] getCategoryAndFlagByMcc(String mcc);

	/**
	 * 根据银联分支机构来查询系统中标准的省市
	 * @param name
	 * @return
	 */
	public CvRegionConf getProvincesOrRegionsByMatching(String name);


}
