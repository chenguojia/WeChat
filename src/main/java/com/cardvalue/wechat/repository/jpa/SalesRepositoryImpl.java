package com.cardvalue.wechat.repository.jpa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.ActiveRateDTO;
import com.cardvalue.wechat.dto.LabelValueTO;
import com.cardvalue.wechat.dto.LoginSalesInBranchTO;
import com.cardvalue.wechat.dto.SalesInfo;
import com.cardvalue.wechat.dto.SalesLoginTO;
import com.cardvalue.wechat.dto.SalesPointSummaryDTO;
import com.cardvalue.wechat.dto.SalesUnLoginTO;
import com.cardvalue.wechat.dto.SaveSalesDTO;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.SalesRepositoryCustom;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;

public class SalesRepositoryImpl implements SalesRepositoryCustom{

	private final static Logger logger = LoggerFactory.getLogger(SalesRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private JavaMailSender mailSender;
	
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private UtilityService utilityService;
	
	@Value( "${mail.from.email}" )
	private String mailSenderEmail;
	
	@Value( "${mail.from.personal}" )
	private String mailSenderPersonal;
	
	@Value( "${mail.add.sales.to.email}" )
	private String mailToEmail;
	
	public final static String STATIC_QUERY_SQL = "select mb.label as branch, count(*) as total," 
			+ " count(case when u.last_login is not null then 1 else null end) as logged_count,"
			+ " count(case when u.last_login is null then 1 else null end) as unlogged_count,"
			+ " count(case when u.last_login is not null then 1 else null end)/count(*) as logged_percentage"
			+ " from sales s left join user u on (s.user_id=u.id)"
			+ " left join master_branch mb on (s.branch_code=mb.code)"
			+ " where u.type=1 and u.enabled=true group by s.branch_code"; 
	
	public final static String SALES_POINT_SUMMARY_SQL = "SELECT u.id, mb.`label` as branch, mr.`label` as region, s.`name`, "
			+ "p.name as level, ups.`total_point`, ups.`available_point`,"
			+ "SUM(CASE WHEN al.action=1 THEN 1 ELSE 0 END) AS login_count,"
			+ "SUM(CASE WHEN al.action=4 THEN 1 ELSE 0 END) AS search_count,"
			+ "SUM(CASE WHEN al.action=9 THEN 1 ELSE 0 END) AS leads_count,"
			+ "SUM(CASE WHEN al.action=10 THEN 1 ELSE 0 END) AS merchant_count, "
			+ "COUNT(DISTINCT DATE(create_date)) AS login_date_count "
			+ "FROM user_point_summary ups "
			+ "LEFT JOIN action_log al ON ups.`user_id`=al.`user_id` " 
			+ "LEFT JOIN sales s ON s.`user_id`=ups.`user_id` "
			+ "LEFT JOIN master_branch mb ON s.`branch_code`=mb.`code` "
			+ "LEFT JOIN master_region mr ON s.`region_code`=mr.`code` "
			+ "LEFT JOIN USER u ON u.`id`=s.`user_id` "
			+ "LEFT JOIN parameter p ON ups.`level`=p.`value` "
			+ "WHERE al.`create_date` > '2014-6-2' AND u.`type`=1 AND p.enum='user_point_level' "
			+ "GROUP BY ups.`user_id`";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SalesLoginTO> findLoggedSales() {
		Query query = em.createNativeQuery("select u.id as userId,  s.name as name, s.mobile, date(u.last_login) as loginDate, time(u.last_login) as logintime,"
				+ " branch_code as branchCode, region_code as regionCode, mb.label as branch, mr.label as region, u.username, u.password,"
				+ " SUM(CASE WHEN (al.create_date > SUBDATE(CURDATE(),1) and create_date < CURDATE()) THEN 1 ELSE 0 END) as dayLoginCount,"
				+ " (SELECT COUNT(*) FROM action_log t WHERE t.action = 9 AND t.user_id = u.id AND t.create_date > SUBDATE(CURDATE(),1) AND t.create_date < CURDATE())  AS submitLeadsCount "
				+ " from sales s"
				+ " left join user u on (s.user_id=u.id)"
				+ " left join master_branch mb on (s.branch_code=mb.code)"
				+ " left join master_region mr on (s.region_code=mr.code)"
				+ " left join action_log al on (al.user_id=u.id)"
				+ " where u.type=1 and u.enabled=true and u.last_login is not null and al.action=1 "
				+ " group by al.user_id"
				+ " order by u.last_login");
		List<Object[]> resultList = query.getResultList();
		List<SalesLoginTO> toList = new ArrayList<SalesLoginTO>(resultList.size());
		for(Object[] objs : resultList){
			SalesLoginTO to = new SalesLoginTO();
			to.map(objs);
			toList.add(to);
		}
		return toList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalesUnLoginTO> findNotLoggedSales() {
		Query query = em.createNativeQuery("select u.id as userId,  s.name as name, s.mobile, date(u.last_login) as loginDate, time(u.last_login) as logintime,"
				+ " branch_code as branchCode, region_code as regionCode, mb.label as branch, mr.label as region, u.username, u.password"				
				+ " from sales s left join user u on (s.user_id=u.id)"
				+ " left join master_branch mb on (s.branch_code=mb.code)"
				+ " left join master_region mr on (s.region_code=mr.code)"
				+ " where u.type=1 and u.enabled=true and u.last_login is null order by s.branch_code, s.region_code");
		List<Object[]> resultList = query.getResultList();
		List<SalesUnLoginTO> toList = new ArrayList<SalesUnLoginTO>(resultList.size());
		for(Object[] objs : resultList){
			SalesUnLoginTO to = new SalesUnLoginTO();
			to.map(objs);
			toList.add(to);
		}
		return toList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginSalesInBranchTO> findLoggedSalesInBranch() {
		Query query = em.createNativeQuery(STATIC_QUERY_SQL);
		List<Object[]> resultList = query.getResultList();
		List<LoginSalesInBranchTO> toList = new ArrayList<LoginSalesInBranchTO>(resultList.size());
		for(Object[] objs : resultList){
			LoginSalesInBranchTO to = new LoginSalesInBranchTO();
			to.map(objs);
			toList.add(to);
		}
		return toList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabelValueTO> findLoggedSalesInLoginDate() {
		Query query = em.createNativeQuery("select date(u.last_login) as label, count(*) as value"
				+ " from sales s left join user u on (s.user_id=u.id) where u.type=1 and u.enabled=true and u.last_login is not null group by date(u.last_login)");
		List<Object[]> resultList = query.getResultList();
		List<LabelValueTO> toList = new ArrayList<LabelValueTO>(resultList.size());
		for(Object[] objs : resultList){
			LabelValueTO to = new LabelValueTO();
			to.map(objs);
			toList.add(to);
		}
		return toList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActiveRateDTO> findActiveRate() {
		Query query = em.createNativeQuery("select mb.label, "
				+ " sum(case when al.action<2 then 1 when al.action<6 then 2 else 4 end) as active_rate,"
				+ " sum(case when month(al.create_date) <> month(curdate())-1 or year(al.create_date) <> year(curdate()) then 0 when al.action<2 then 1 when al.action<6 then 2 else 4 end) as month_active_rate,"  
				+ " (select count(*) from sales where branch_code=s.branch_code) as user_count"
				+ " from action_log al"
				+ " left join user u on u.id=al.user_id"
				+ " left join sales s on s.user_id=u.id"
				+ " left join master_branch mb on mb.code=s.branch_code"
				+ " where u.type=1 and u.enabled=true"
				+ " group by s.branch_code;");
		List<Object[]> resultList = query.getResultList();
		List<ActiveRateDTO> toList = new ArrayList<ActiveRateDTO>(resultList.size());
		for(Object[] objs : resultList){
			ActiveRateDTO to = new ActiveRateDTO();
			to.map(objs);
			toList.add(to);
		}
		return toList;
	}
	
	@Override
	@Transactional
	public Sales saveSales(SaveSalesDTO dto){
		//判断用户是否已经存在(手机号)
		Query findSalesByMobileQuery = em.createNamedQuery("findSalesByMobile")
				.setParameter("mobile",dto.getMobile());
		BigInteger salesCount = (BigInteger)findSalesByMobileQuery.getSingleResult();
		Sales newSales = null;
		if(salesCount.intValue() == 0){
			
			//根据processId设置userType
			if(dto.getProcessorId().equals("301")){
				//银联
				dto.setUserType(String.valueOf(Constants.USER_TYPE_UMS_SALES));
			}else if(dto.getProcessorId().equals("331")){
				//卡得万利
				dto.setUserType(String.valueOf(Constants.USER_TYPE_STAFF));
			}else if(dto.getProcessorId().equals("332")){
				//通联
				dto.setUserType(String.valueOf(Constants.USER_TYPE_ALLINPAY_SALES));
			}else if(dto.getProcessorId().equals("329")){
				//银盛
				dto.setUserType(String.valueOf(Constants.USER_TYPE_YS_SALES));
			}
			
			WeUser user = userRepo.createUser(Integer.parseInt(dto.getUserType()), dto.getUsername(), dto.getPassword(), 0, 
					Constants.USER_SOURCE_SYSTEM_CREATED, null, true, dto.getProcessorId());
			int userId = user.getId();
			newSales = new Sales();
			newSales.setUserId(userId);
			newSales.setName(dto.getName());
			newSales.setMobile(dto.getMobile());
			newSales.setEmail(dto.getEmail());
			newSales.setBranchCode(StringUtils.defaultIfBlank(dto.getBranchCode(), Constants.CODE_ALL));
			newSales.setRegionCode(StringUtils.defaultIfBlank(dto.getRegionCode(), Constants.CODE_ALL));
			em.persist(newSales);
		}
		return newSales;
	}
	
	@Override
	@Transactional
	public Sales saveSales(SaveSalesDTO dto, Sales referrer){
		Sales sales = saveSales(dto);
		if(sales != null){
			WeUser user = userRepo.findOne(sales.getUserId());
			user.setReferrerId(referrer.getUserId());
			user.setSource(Constants.USER_SOURCE_USER_ADD);
			em.persist(user);
			//获取当前processor类型的名称
			Parameter parameter = utilityService.getParamByValueAndGroup(Constants.PARAM_GROUP_PROCESSOR_ID, dto.getProcessorId());
			
			String nickName = "";
			
			if(dto.getProcessorId().equals("331")){
				//表示卡得万利员工
				nickName = "卡得万利员工";
			}else{
				//表示是其他用户类型
				nickName =  parameter.getName() + "客户经理";
			}
			
			try{
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setFrom(mailSenderEmail, mailSenderPersonal);
				helper.setTo(StringUtils.split(mailToEmail, ","));
				helper.setSubject("新增客户经理通知");
				helper.setText(referrer.getName() + "添加了新"+ nickName + sales.getName() + ",用户名和密码分别是" + user.getUsername() + "," + user.getPassword());
				mailSender.send(message);
			}catch(Exception e){
				logger.error("Error occurs during sending notification email:",e);
			} 
		}
		return sales;
	}

	@Override
	public SalesInfo getSalesInfo(int salesId) {
		String getSalesInfoSql = "SELECT s.id, u.username, u.password, s.name, mb.label as branch, mr.label as region, s.mobile, s.email FROM sales s"
				+ " LEFT JOIN USER u ON s.user_id=u.id"
				+ " LEFT JOIN master_branch mb ON s.branch_code=mb.code"
				+ " LEFT JOIN master_region mr ON s.region_code=mr.code"
				+ " WHERE s.id=:salesId";
		Query query = em.createNativeQuery(getSalesInfoSql, SalesInfo.class);
		query.setParameter("salesId", salesId);
		SalesInfo salesInfo = null;
		try{
			salesInfo = (SalesInfo)query.getSingleResult();
		}catch(Exception e){
			logger.error("Error",e);
		}
		return salesInfo;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SalesPointSummaryDTO> getSalesPointSummary(){
		Query query = em.createNativeQuery(SALES_POINT_SUMMARY_SQL, SalesPointSummaryDTO.class);
		List<SalesPointSummaryDTO> dtoList = query.getResultList();
		return dtoList;
	}

}
