package com.cardvalue.wechat.repository.jpa;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.DistrictInfoDTO;
import com.cardvalue.wechat.dto.KeyMerchantDTO;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.KeyMerchantRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.PageableResult;

@Repository
public class KeyMerchantRepositoryImpl implements KeyMerchantRepository{

	private final static String KEY_MERCHANT_LIST_1 = "SELECT mc.id, mc.mid, mc.province, mc.prefecture, mc.county, mc.subdistrict, mc.area, IFNULL(m.active_status_label,'未开发') AS status_label, mc.address, mc.merchant_name, mc.processor_id"
			+ " FROM (SELECT * FROM merchant_credit WHERE credit_line_in_90_days>0 ";
	private final static String KEY_MERCHANT_LIST_2 = ") AS mc LEFT JOIN merchant m ON mc.mid=m.mid ";
	private final static String KEY_MERCHANT_LIST_3 = " ORDER BY m.active_status,mc.id";
	
	private final static String KEY_MERCHANT_COUNT_1 = "SELECT COUNT(*) FROM (SELECT MID, subdistrict, processor_id, merchant_name FROM merchant_credit WHERE credit_line_in_90_days>0 ";
	private final static String KEY_MERCHANT_COUNT_2 = ") AS mc ";
	
	private final static String KEY_MERCHANT_WHERE_1 = " WHERE 1=1";
	private final static String KEY_MERCHANT_WHERE_2 = " AND (mc.mid LIKE :term OR mc.merchant_name LIKE :term OR mc.subdistrict LIKE :term)";
	private final static String KEY_MERCHANT_WHERE_3 = " AND processor_id=:processorId";
	
	private final static String KEY_MERCHANT_REL_LIST_1 = "SELECT rel.id, rel.mid, rel.province, rel.prefecture, rel.county, rel.subdistrict, rel.area, IFNULL(m.active_status_label,'未开发') AS status_label, rel.address, rel.merchant_name "
				+ "FROM key_merchant_user_rel rel "
				+ "LEFT JOIN merchant m ON rel.mid=m.mid "
				+ "WHERE rel.user_id=:userId";
	private final static String KEY_MERCHANT_REL_LIST_2 = " ORDER BY m.active_status,rel.id";
	private final static String KEY_MERCHANT_REL_COUNT = "SELECT count(*) FROM key_merchant_user_rel rel WHERE rel.user_id=:userId";
	private final static String KEY_MERCHANT_REL_WHERE = " AND (rel.mid LIKE :term OR rel.merchant_name LIKE :term OR rel.subdistrict LIKE :term)";
	
	private final static Logger logger = LoggerFactory.getLogger(KeyMerchantRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager em;	

	@Resource
	private UserRepository userRepo;
	
	@Override
	public PageableResult<?> findByUserId(int userId, String term, String processorId, int pageNum, int pageSize) {
		logger.debug("start findByMerchantNameAndUserId");
		boolean hasTerm = StringUtils.isNotBlank(term);
		WeUser user = userRepo.findOne(userId);
		DistrictInfoDTO dto = getUserDistrictInfo(userId);
		String province = dto.getProvince();
		String prefecture = dto.getPrefecture();
		String county = dto.getCounty();
		String subdistrict = dto.getSubdistrict();
		String area = dto.getArea();
		StringBuilder sb = new StringBuilder(); 
		String countSql = null;
		String listSql = null;
		Map<String, Object> params = new HashMap<String, Object>();
		
		//判断选择的商户类型
		if(StringUtils.isNotBlank(processorId)){
			if(!processorId.equals("331"))
				sb.append("AND processor_id = " + processorId);
		}
		
		if(StringUtils.isNotBlank(province)){
			//已配置了省市区白名单
			sb.append(" AND province IN (").append(province).append(")");
			if(StringUtils.isNotBlank(prefecture)){
				sb.append(" AND prefecture IN (").append(prefecture).append(")");
				if(StringUtils.isNotBlank(county)){
					sb.append(" AND county IN (").append(county).append(")");
					if(StringUtils.isNotBlank(subdistrict)){
						sb.append(" AND subdistrict IN (").append(subdistrict).append(")");
					}
				}
			}
			if(StringUtils.isNotBlank(area)){
				sb.append(" AND area IN (").append(area).append(")");
			}
			if(!StringUtils.equals(user.getProcessorId(), Constants.PROCESSOR_ID_CV)){
				sb.append(KEY_MERCHANT_WHERE_3);
				params.put("processorId", user.getProcessorId());
			}
			countSql = KEY_MERCHANT_COUNT_1 + sb.toString() + KEY_MERCHANT_COUNT_2 + KEY_MERCHANT_WHERE_1;
			listSql = KEY_MERCHANT_LIST_1 + sb.toString() + KEY_MERCHANT_LIST_2 + KEY_MERCHANT_WHERE_1;
			if(hasTerm){
				countSql += KEY_MERCHANT_WHERE_2;
				listSql += KEY_MERCHANT_WHERE_2;
				params.put("term", "%" + term + "%");
			}
			listSql += KEY_MERCHANT_LIST_3;
		}else{
			//如果没有配置省市区，尝试查找商户直接分配表
			//todo
			countSql = KEY_MERCHANT_REL_COUNT;
			listSql = KEY_MERCHANT_REL_LIST_1;
			if(hasTerm){
				params.put("term", "%" + term + "%");
			}
			listSql += KEY_MERCHANT_REL_LIST_2;
			params.put("userId", userId);
		}
		Query countQuery = em.createNativeQuery(countSql);
		Query listQuery = em.createNativeQuery(listSql, KeyMerchantDTO.class);
		Iterator<Map.Entry<String, Object>> entryIter = params.entrySet().iterator();
		while(entryIter.hasNext()){
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>)entryIter.next();
			countQuery.setParameter(entry.getKey(), entry.getValue());
			listQuery.setParameter(entry.getKey(), entry.getValue());
		}
		PageableResult result = new PageableResult();
		int numRows = ((BigInteger)countQuery.getSingleResult()).intValue();
		result.setNumRows(numRows);
		
		result.setPageCount((int)Math.ceil((double)numRows/pageSize));
		logger.debug("number of rows:" + numRows + ", page count:" + result.getPageCount());
		
		listQuery.setFirstResult(pageSize*(pageNum-1));
		listQuery.setMaxResults(pageSize);
		List<KeyMerchantDTO> keyMerchants = listQuery.getResultList();
		
		result.setPageNumber(pageNum);
		result.setPageSize(pageSize);
		result.setPayload(keyMerchants);
		logger.debug("page number:" + pageNum + ", page size:" + pageSize);
		return result;
	}

	private final static String COUNT_BY_MID_SQL = "SELECT count(*) FROM merchant_credit mc WHERE mc.mid=:mid and credit_line_in_90_days>0 ";
	
	@Override
	public int countByMid(String mid) {
		logger.debug("start countByMid");
		Query query = em.createNativeQuery(COUNT_BY_MID_SQL);
		query.setParameter("mid", mid);
		int count = ((BigInteger)query.getSingleResult()).intValue();
		return count;
	}

	@Override
	@Transactional
	public void updateKeyMerchantUserRel(String username, String mid, String subNo, String province){
		String[] names = StringUtils.split(username, ',');
		for(int i = 0;i < names.length;i++){
			String name = names[i];
			Query q = em.createNativeQuery("SELECT u.id FROM USER u LEFT JOIN sales s ON u.id=s.user_id LEFT JOIN master_branch mb ON s.branch_code=mb.code WHERE s.name=:name AND mb.label LIKE :branch AND u.enabled=TRUE AND u.type=1");
			q.setParameter("name", name);
			q.setParameter("branch", "%" + province + "%");
			List<Integer> ids = q.getResultList();
			if(ids != null && ids.size() > 0){
				int userId = ids.get(0);
				Query q1 = em.createNativeQuery("select count(*) from key_merchant_user_rel where mid=:mid and sub_no=:subNo and user_id=:userId");
				q1.setParameter("mid", mid);
				q1.setParameter("subNo", subNo);
				q1.setParameter("userId", userId);
				int count = ((BigInteger)q1.getSingleResult()).intValue();
				if(count == 0){
					Query q2 = em.createNativeQuery("insert into key_merchant_user_rel values(NULL, :mid, :subNo, :userId)");
					q2.setParameter("mid", mid);
					q2.setParameter("subNo", subNo);
					q2.setParameter("userId", userId);
					q2.executeUpdate();
				}
			}
		}
	}

	private final static String LIST_BY_MID_SQL = "SELECT mc.id, mc.mid, mc.province, mc.prefecture, mc.county, mc.subdistrict, mc.area, IFNULL(m.active_status_label,'未开发') AS status_label, mc.address, mc.merchant_name, mc.processor_id "
			+ "FROM merchant_credit mc LEFT JOIN merchant m ON mc.mid=m.mid "
			+ "WHERE mc.mid=:mid and credit_line_in_90_days>0 ";
	
	@Override
	public List<KeyMerchantDTO> findByMid(String mid) {
		Query q = em.createNativeQuery(LIST_BY_MID_SQL, KeyMerchantDTO.class);
		q.setParameter("mid", mid);
		return q.getResultList();
	}

	private final static String FIND_BY_PROVINCE_SQL = "SELECT mc.mid, mc.sub_code, mc.province, mc.prefecture, mc.county, mc.subdistrict, mc.area, mc.merchant_name, mc.address, NULL as status_label "
			+ "FROM merchant_credit mc " 
			+ "WHERE mc.province=:province AND mc.credit_line_in_90_days>0"; 
	
	@Override
	public List<KeyMerchantDTO> findByProvince(String province) {
		Query q = em.createNativeQuery(FIND_BY_PROVINCE_SQL, KeyMerchantDTO.class);
		q.setParameter("province", province);
		return q.getResultList();
	}

	private final static String FIND_BY_PROVINCE_AND_PREFECTURE_SQL = "SELECT mc.mid, mc.sub_code, mc.province, mc.prefecture, mc.county, mc.subdistrict, mc.area, mc.merchant_name, mc.address, NULL as status_label "
			+ "FROM merchant_credit mc " 
			+ "WHERE mc.province=:province AND mc.prefecture=:prefecture AND mc.credit_line_in_90_days>0"; 
	
	@Override
	public List<KeyMerchantDTO> findByProvinceAndPrefecture(String province, String prefecture) {
		Query q = em.createNativeQuery(FIND_BY_PROVINCE_SQL, KeyMerchantDTO.class);
		q.setParameter("province", province);
		q.setParameter("prefecture", prefecture);
		return q.getResultList();
	}
	
	private final static String DISTRICT_INFO_SQL = "SELECT id, province, prefecture, county, subdistrict, area FROM user_district WHERE user_id=:userId GROUP BY province,prefecture,county,subdistrict";
	
	private DistrictInfoDTO getUserDistrictInfo(int userId){
		Query q = em.createNativeQuery(DISTRICT_INFO_SQL, DistrictInfoDTO.class);
		q.setParameter("userId", userId);
		List<DistrictInfoDTO> infoList = q.getResultList();
		Set<String> provinceSet = new HashSet<String>();
		Set<String> prefectureSet = new HashSet<String>();
		Set<String> countySet = new HashSet<String>();
		Set<String> subdistrictSet = new HashSet<String>();
		Set<String> areaSet = new HashSet<String>();
		for(DistrictInfoDTO dto : infoList){
			if(StringUtils.isNotBlank(dto.getProvince())){
				provinceSet.add("'" + dto.getProvince() + "'");
			}
			if(StringUtils.isNotBlank(dto.getPrefecture())){
				prefectureSet.add("'" + dto.getPrefecture() + "'");
			}
			if(StringUtils.isNotBlank(dto.getCounty())){
				countySet.add("'" + dto.getCounty() + "'");
			}
			if(StringUtils.isNotBlank(dto.getSubdistrict())){
				subdistrictSet.add("'" + dto.getSubdistrict() + "'");
			}
			if(StringUtils.isNotBlank(dto.getArea())){
				areaSet.add("'" + dto.getArea() + "'");
			}
		}
		DistrictInfoDTO dto = new DistrictInfoDTO();
		dto.setProvince(StringUtils.join(provinceSet, ","));
		dto.setPrefecture(StringUtils.join(prefectureSet, ","));
		dto.setCounty(StringUtils.join(countySet, ","));
		dto.setSubdistrict(StringUtils.join(subdistrictSet, ","));
		dto.setArea(StringUtils.join(areaSet, ","));
		return dto;
	}
}
