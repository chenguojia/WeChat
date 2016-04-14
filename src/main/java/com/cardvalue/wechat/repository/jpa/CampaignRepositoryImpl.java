package com.cardvalue.wechat.repository.jpa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.commons.math.util.MathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.BetDTO;
import com.cardvalue.wechat.dto.CampaignDTO;
import com.cardvalue.wechat.dto.CampaignLogResponseDTO;
import com.cardvalue.wechat.dto.CampaignReportDTO;
import com.cardvalue.wechat.dto.DrawRequestDTO;
import com.cardvalue.wechat.dto.DrawResponseDTO;
import com.cardvalue.wechat.dto.MatchDTO;
import com.cardvalue.wechat.dto.TeamDTO;
import com.cardvalue.wechat.model.Campaign;
import com.cardvalue.wechat.model.CampaignAction;
import com.cardvalue.wechat.model.CampaignAward;
import com.cardvalue.wechat.model.PointCampaignAward;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.UserCampaign;
import com.cardvalue.wechat.model.UserPointSummary;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.CampaignRepository;
import com.cardvalue.wechat.repository.UserPointSummaryRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.service.UserPointService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Utility;

@Repository
@Transactional(readOnly=true)
public class CampaignRepositoryImpl implements CampaignRepository {

	private final static Logger logger = LoggerFactory.getLogger(CampaignRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserRepository userRepo;
	
	@Resource
	private UserService userService;
	
	@Resource
	private UserPointSummaryRepository upsRepo;
	
	@Resource
	private UserPointService upsService;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public CampaignDTO findLatestCampaign(int userId, int campaignId){
		WeUser user = userRepo.findOne(userId);
		TypedQuery<Campaign> q = em.createNamedQuery("findCampaign", Campaign.class)
				.setParameter("id", campaignId);
		Campaign campaign = null;
		campaign = q.getSingleResult();
		
		TypedQuery<UserCampaign> findUserCampaignQuery = em.createNamedQuery("findUserCampaign", UserCampaign.class)
				.setParameter("user", user)
				.setParameter("campaign", campaign);
		
		//是否有过参与
		UserCampaign uc = null;
		try{
			uc = findUserCampaignQuery.getSingleResult();
		}catch(NoResultException ex){
			logger.info("need to create user campaign");
		}
		
		if(uc == null){
			//没有参与
			uc = new UserCampaign();
			//生成六位随机领奖码，保证领奖码的唯一性
			String awardCode = RandomStringUtils.randomAlphanumeric(6);
			TypedQuery<UserCampaign> findUserCampaignByAwardCodeQuery = em.createNamedQuery("findUserCampaignByAwardCode", UserCampaign.class)
				.setParameter("awardCode", awardCode);
			try{
				UserCampaign repeatUC = findUserCampaignByAwardCodeQuery.getSingleResult();
				while(repeatUC != null){
					awardCode = RandomStringUtils.randomAlphanumeric(6);
					findUserCampaignByAwardCodeQuery.setParameter("awardCode", awardCode);
					repeatUC = findUserCampaignByAwardCodeQuery.getSingleResult();
				}
			}catch(NoResultException e){}	
			uc.setAwardCode(awardCode);
			uc.setUser(user);
			uc.setCampaign(campaign);
			uc.setAwardGave(false);
			uc.setExtraDrawCount(0);
			uc.setUsedExtraDrawCount(0);
			em.persist(uc);
		}
		
		//获得领奖码
		String awardCode = uc.getAwardCode();
		
		CampaignDTO dto = new CampaignDTO(); 
		dto.setAwardCode(awardCode);
		
		int availableDrawCount = getAvailableDrawCount(user, uc, false);
		dto.setCampaignId(campaignId);
		dto.setDrawCount(availableDrawCount);
		dto.setBeginDate(campaign.getBeginDate());
		dto.setEndDate(campaign.getEndDate());
		//得奖信息
		Query getAwardMessageQuery = em.createNamedQuery("getAwardMessage")
			.setParameter("campaignId", campaign.getId()).setMaxResults(20);
		List<Object[]> messages = (List<Object[]>)getAwardMessageQuery.getResultList();
		for(Object[] message : messages){
			String name = (String)message[1];
			String overlayString = StringUtils.overlay(name, "经理", 1, name.length());
			String awardMsg =  message[0] + " " + overlayString + " " + message[2] + "元";
			dto.addAwardMessage(awardMsg);
		}
		return dto;
	}
	
	@Transactional(propagation=Propagation.NESTED)
	public int getAvailableDrawCount(WeUser user, UserCampaign uc, boolean isDraw){
		int allowType = uc.getCampaign().getAllowUserType();
		int availableDrawCount = 0;
		Date now = new Date();
		Campaign campaign = uc.getCampaign();
		if((allowType == 0 || allowType == user.getType()) && (now.after(campaign.getBeginDate()) && now.before(campaign.getEndDate()))){
			//获得抽奖次数
			Query getAwardCountByUserQuery = em.createNamedQuery("getAwardCountByUser")
					.setParameter("userId", user.getId())
					.setParameter("campaignId", campaign.getId());
			int awardCount = ((BigInteger)getAwardCountByUserQuery.getSingleResult()).intValue();
			availableDrawCount = (awardCount == 0) ? 1 : 0; 
		}
		return availableDrawCount;
	}
	
	@Override
	@Transactional
	public DrawResponseDTO draw(DrawRequestDTO request) {
		WeUser user = em.find(WeUser.class, request.getUserId());
		Campaign campaign = em.find(Campaign.class, request.getCampaignId());
		TypedQuery<UserCampaign> findUserCampaignQuery = em.createNamedQuery("findUserCampaign", UserCampaign.class)
				.setParameter("user", user)
				.setParameter("campaign", campaign);
		UserCampaign uc = findUserCampaignQuery.getSingleResult();
		int availableDrawCount = getAvailableDrawCount(user, uc, true);
		DrawResponseDTO response = new DrawResponseDTO();
		response.setResult(0);
		Date currentDate = new Date();
		if(currentDate.before(campaign.getBeginDate()) || currentDate.after(campaign.getEndDate())){
			response.setResult(-2);
		}else if(availableDrawCount > 0){
			//减去抽奖次数
			response.setRemainDrawCount(availableDrawCount - 1);
			//初始化抽奖日志信息
			CampaignAction action = new CampaignAction();
			action.setUser(user);
			action.setCreateDate(new Date());
			action.setCampaign(campaign);
			response.setResult(0);
			Sales s = userService.findSalesByUserId(user.getId());
			CampaignAward award = pointAward(user, s.getBranchCode());
			if(award == null){
				TypedQuery<CampaignAward> listAwardQuery = em.createQuery("SELECT a FROM CampaignAward a WHERE a.campaign=:campaign and type=:type", CampaignAward.class);
				listAwardQuery.setParameter("campaign", campaign);
				listAwardQuery.setParameter("type", "first");
				CampaignAward firstAward = listAwardQuery.getSingleResult();
					firstAward.setAmount(1 + RandomUtils.nextFloat()*2);
				award = firstAward;
			}
			double amount = award.getAmount();
			amount = MathUtils.round(amount, 2);
			response.setResult(1);
			response.setResultMessage(Utility.formatDouble(amount));
			action.setAwardId(award.getId());
			action.setAwardMemo(String.valueOf(amount));
			action.setAmount(amount);
			upsService.addBalance(user.getId(), amount, "砸金蛋");
			//存入抽奖日志
			em.persist(action);
		}else{
			response.setResult(-1);
		}
		//扣除额外抽奖次数
		return response;
	}
	
	private CampaignAward pointAward(WeUser user, String branchCode){
		java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		TypedQuery<PointCampaignAward> findPointCampaignAwardQuery = 
				em.createNamedQuery("findPointCampaignAward",PointCampaignAward.class).setParameter("date", today);
		List<PointCampaignAward> pointAwardList = findPointCampaignAwardQuery.getResultList();
		for(PointCampaignAward pAward : pointAwardList){
			//判断抽奖人是否有资格
			if((pAward.getBranchCode() == null && pAward.getUser() == null) 
					|| (pAward.getUser() != null && pAward.getUser().getId() == user.getId())
					|| (pAward.getBranchCode() != null && pAward.getBranchCode().equals(branchCode))){
				//判断该奖是否可抽
				Query getAwardCountInDateQuery  = em.createNamedQuery("getAwardCountInDate")
						.setParameter("awardId", pAward.getAward().getId()).setParameter("date", new Date());
				int usedCount = ((BigInteger)getAwardCountInDateQuery.getSingleResult()).intValue();
				if(usedCount < pAward.getAward().getTotalCount()){
					Query getAwardCountByDateAndUserQuery  = em.createNamedQuery("getAwardCountByDateAndUser")
							.setParameter("awardId", pAward.getAward().getId())
							.setParameter("date", new Date())
							.setParameter("userId", user.getId());
					int count = ((BigInteger)getAwardCountByDateAndUserQuery.getSingleResult()).intValue();
					//判断此人是否已经中过奖
					if(count == 0){
						//指定到人
						if(pAward.getUser() != null && pAward.getUser().getId() == user.getId()){
							return pAward.getAward();
						}else{
							Query drawTimesQuery = em.createNamedQuery("getDrawTimesInBranch").setParameter("branchCode", branchCode);
							int drawTimes = ((BigInteger)drawTimesQuery.getSingleResult()).intValue();
							if(drawTimes+1 == pAward.getTimes()){
								return pAward.getAward();
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	@Transactional
	@Override
	public void accumulation(int campaignId){
		Campaign campaign = em.find(Campaign.class, campaignId);
		//列出所有的奖项
		TypedQuery<CampaignAward> listAwardQuery = em.createQuery("SELECT a FROM CampaignAward a WHERE a.campaign=:campaign", CampaignAward.class);
		listAwardQuery.setParameter("campaign", campaign);
		List<CampaignAward> awards = listAwardQuery.getResultList();
		CampaignAward floatAward = null;
		//2014-4-17 把随机奖总金额从250元调整为450元
		double floatAmount = 0;
		Date today = new Date();
		for(CampaignAward award : awards){
			//单个奖项当日可用总金额
			double dailyAwardAmount = 0.0;
			//如果是浮动奖池
			if(award.getType().equals("float")){
				floatAward = award;
				dailyAwardAmount = award.getAmount();
			}else if(award.getType().equals("fixed") || award.getType().equals("point")){
				dailyAwardAmount = award.getAmount() * award.getTotalCount();
			}else{
				continue;
			}
			Query getAwardAmountInDateQuery = em.createNamedQuery("getAwardAmountInDate")
					.setParameter("awardId", award.getId())
					.setParameter("date", today);
			//单个奖项当日已抽取金额
			double drawedAmount = (Double)getAwardAmountInDateQuery.getSingleResult();
			//单个奖项当日结余金额
			double awardBalance = dailyAwardAmount - drawedAmount;
			//滚入下一日浮动奖池中
			floatAmount += awardBalance;
		}
		//2014-4-28把随机总金额调整为1150元，把随机红包数量调整为3878人次.
		Date tempDate = DateUtils.addHours(today, 1);
		Date triggerDate = null;
		try {
			triggerDate = DateUtils.parseDate("2014-04-28", new String[]{"yyyy-MM-dd"});
		} catch (ParseException e) {
			logger.error("Parse date string error", e);
		}
		if(floatAward != null){
			if(tempDate.after(triggerDate)){
				floatAmount += 1150;
				floatAward.setTotalCount(3878);
			}else{
				floatAmount += 450;
			}
			floatAward.setAmount(floatAmount);
			em.persist(floatAward);
		}
	}
	
	@Override
	public CampaignLogResponseDTO campaignLog(int campaignId, int userId){
		Campaign campaign = em.find(Campaign.class, campaignId);
		WeUser user = em.find(WeUser.class, userId);
		CampaignLogResponseDTO dto = new CampaignLogResponseDTO();
		//累计红包金额
		Query getTotalAmountQuery = em.createNamedQuery("getTotalAmount")
				.setParameter("userId", userId)
				.setParameter("campaignId", campaignId);
		double totalAmount = (Double)getTotalAmountQuery.getSingleResult();
		dto.setTotalAmount(MathUtils.round(totalAmount, 2) + "元");
		//砸金蛋记录
		TypedQuery<CampaignAction> getAwardLogsQuery = em.createNamedQuery("getAwardLogs", CampaignAction.class)
				.setParameter("user", user)
				.setParameter("campaign", campaign)
				.setMaxResults(5);
		List<CampaignAction> actionList = getAwardLogsQuery.getResultList();
		for(CampaignAction action : actionList){
			Date createDate = action.getCreateDate();
			String dateString = Utility.formatShortDateInChinese(createDate);
			dto.addAward(dateString, String.valueOf(action.getAmount()));
		}
		//领奖码
		TypedQuery<UserCampaign> findUserCampaignQuery = em.createNamedQuery("findUserCampaign", UserCampaign.class)
				.setParameter("user", user)
				.setParameter("campaign", campaign);
		UserCampaign uc = findUserCampaignQuery.getSingleResult();
		dto.setAwardCode(uc.getAwardCode());
		dto.setAwardGave(uc.isAwardGave());
		
		//领奖微信
		Sales s = userService.findSalesByUserId(userId);
		String branchCode = s.getBranchCode();
		Query findBranchWechatNumberQuery = em.createNamedQuery("findBranchWechatNumber").setParameter("branchCode", branchCode);
		String wechatNumber = null;
		try{
			wechatNumber = (String)findBranchWechatNumberQuery.getSingleResult();
		}catch(NoResultException e){
			//ignore the no result exception
		}
		dto.setWechatNumber(wechatNumber);
		
		//结束时间
		long duration = campaign.getEndDate().getTime() - System.currentTimeMillis();
		dto.setTimeTillEnd(DurationFormatUtils.formatDuration(duration, Utility.DURATION_FORMAT_IN_CHINESE, false));
		return dto;
	}

	@Override
	public List<Campaign> findActiveCampaigns() {
		TypedQuery<Campaign> listCampaignQuery = em.createQuery("SELECT c FROM Campaign c WHERE c.beginDate<=:date and c.endDate>=:date", Campaign.class);
		List<Campaign> campaigns = listCampaignQuery.setParameter("date", new Date()).getResultList();
		return campaigns;
	}
	
	@Override
	@Transactional
	public int shareTimeline(int userId, int campaignId){
		Campaign campaign = em.find(Campaign.class, campaignId);
		WeUser user = em.find(WeUser.class, userId);
		TypedQuery<UserCampaign> findUserCampaignQuery = em.createNamedQuery("findUserCampaign", UserCampaign.class)
				.setParameter("user", user)
				.setParameter("campaign", campaign);
		
		UserCampaign uc = findUserCampaignQuery.getSingleResult();
		//用户未分享
		if(!uc.isHasShared() && user.getType() == Constants.USER_TYPE_UMS_SALES){
			uc.setExtraDrawCount(uc.getExtraDrawCount()+1);
			uc.setHasShared(true);
			em.persist(uc);
		}
		int availDrawCount = getAvailableDrawCount(user, uc, false);
		return availDrawCount;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CampaignReportDTO> report(Date beginDate, Date endDate, int campaignId){
		List<CampaignReportDTO> dtoList = new ArrayList<CampaignReportDTO>();
		Query reportQuery = em.createNamedQuery("dailyReport");
		reportQuery.setParameter("campaignId", campaignId);
		reportQuery.setParameter("beginDate", beginDate);
		reportQuery.setParameter("endDate", endDate);
		List<Object[]> resultList = (List<Object[]> )reportQuery.getResultList();
		for(Object[] objs : resultList){
			CampaignReportDTO dto = new CampaignReportDTO();
			dto.setBranch((String)objs[0]);
			dto.setRegion((String)objs[1]);
			dto.setName((String)objs[2]);
			dto.setDrawCount(((BigInteger)objs[3]).intValue());
			dto.setAmount((Double)objs[4]);
			dto.setLoginCount(((BigInteger)objs[5]).intValue());
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public void addExtraDrawCount() {
		Query addExtraDrawCountQuery = em.createNamedQuery("addExtraDrawCount");
		int updateCount = addExtraDrawCountQuery.executeUpdate();
		logger.info(updateCount + " users have been granted with a extra draw count");
	}

	private final static String MATCH_CAN_BET_QUERY = "SELECT COUNT(*) FROM `campaign_worldcup_match` WHERE id=:matchId AND bet_start_time<NOW() AND bet_end_time>NOW()";
	private final static String INSERT_MATCH_BET_QUERY = "INSERT INTO campaign_worldcup_bet_match (user_id,match_id,bet,stake,bet_time) VALUES (:userId,:matchId,:bet,:stake,NOW())";
	private final static String TEAM_ELIMINATED_QUERY = "SELECT COUNT(*) FROM campaign_worldcup_team WHERE id=:teamId AND eliminated=TRUE";
	private final static String QUANLIFIED_TEAM_COUNT_QUERY = "SELECT COUNT(*) FROM campaign_worldcup_team WHERE eliminated=FALSE";
	private final static String INSERT_CHAMPION_BET_QUERY = "INSERT INTO campaign_worldcup_bet_champion (user_id,team_id,stake,bet_time,odds) VALUES (:userId,:teamId,:stake,NOW(),:odds)";
	
	private final static String UPDATE_MATCH_RESULT_QUERY = "UPDATE campaign_worldcup_match SET result=:result, memo=:memo WHERE id=:matchId";
	private final static String ELIMINATE_TEAM_QUERY_PART_1 = "UPDATE campaign_worldcup_team cwt  LEFT JOIN campaign_worldcup_match cwm  ON cwt.id = cwm.team";
	private final static String ELIMINATE_TEAM_QUERY_PART_2 = "_id SET cwt.eliminated=TRUE WHERE cwm.id=:matchId";
	private final static String UPDATE_MATCH_BET_QUERY = "UPDATE campaign_worldcup_bet_match SET result=(CASE WHEN bet=:result THEN 1 ELSE 2 END) WHERE match_id=:matchId"; 
	private final static String UPDATE_MATCH_POINT_QUERY = "UPDATE user_point_summary ups LEFT JOIN campaign_worldcup_bet_match cwbm ON ups.`user_id`=cwbm.`user_id` SET ups.total_point=cwbm.stake + ups.total_point, ups.available_point=cwbm.stake*2 + ups.available_point WHERE cwbm.match_id=:matchId AND cwbm.result=1";
	private final static String UPDATE_CHAMPION_BET_FAILED_QUERY = "UPDATE campaign_worldcup_bet_champion cwbc LEFT JOIN campaign_worldcup_match cwm ON (CASE WHEN cwm.result = 1 THEN cwm.team2_id ELSE cwm.team1_id END)=cwbc.team_id SET cwbc.result=2 WHERE cwm.id=:matchId";
	private final static String UPDATE_CHAMPION_BET_SUCCESS_QUERY = "UPDATE campaign_worldcup_bet_champion cwbc LEFT JOIN campaign_worldcup_match cwm ON (CASE WHEN cwm.result = 1 THEN cwm.team1_id ELSE cwm.team2_id END)=cwbc.team_id SET cwbc.result=1 WHERE cwm.id=:matchId";
	private final static String UPDATE_CHAMPION_POINT_QUERY = "UPDATE user_point_summary ups  LEFT JOIN campaign_worldcup_bet_champion cwbc ON ups.user_id=cwbc.user_id  LEFT JOIN campaign_worldcup_team cwt ON cwbc.team_id=cwt.id SET ups.total_point=cwbc.stake*(cwbc.odds-1) + ups.total_point, ups.available_point=cwbc.stake*cwbc.odds + ups.available_point WHERE cwt.eliminated=FALSE";
	
	private final static String MATCH_QUERY= "SELECT m.id, t1.name AS team1Name , t2.name AS team2Name, t1.flag1 AS team1Flag, t2.flag1 AS team2Flag, DATE_FORMAT(m.match_time, '%m/%e %H:%i') AS matchTime, m.location FROM campaign_worldcup_match m LEFT JOIN campaign_worldcup_team t1 ON m.team1_id=t1.id LEFT JOIN campaign_worldcup_team t2 ON m.team2_id=t2.id WHERE m.bet_start_time < NOW() AND m.bet_end_time > NOW()";
	private final static String TEAM_QUERY= "SELECT id, NAME, flag2 AS flag FROM campaign_worldcup_team WHERE eliminated=FALSE";
	private final static String BET_MATCH_QUERY= "SELECT UUID() as id, '猜胜负' AS TYPE,  CONCAT(t1.name,' VS ',t2.name) AS matchLabel, CONCAT((CASE WHEN b.bet=1 THEN t1.name ELSE t2.name END),'',CAST(b.stake AS char),'分') AS betLabel, (CASE WHEN b.result=1 THEN CONCAT('赢得',FORMAT(b.stake*2,0),'分') WHEN b.result=2 THEN '未中奖' ELSE '未开奖' END) AS resultLabel, b.bet_time AS betTime FROM campaign_worldcup_bet_match b LEFT JOIN campaign_worldcup_match m ON b.match_id=m.id LEFT JOIN campaign_worldcup_team t1 ON m.team1_id=t1.id LEFT JOIN campaign_worldcup_team t2 ON m.team2_id=t2.id WHERE b.user_id=:userId";
	private final static String BET_TEAM_COUNT_QUERY= "SELECT count(*) FROM campaign_worldcup_bet_champion WHERE user_id=:userId";
	private final static String BET_TEAM_QUERY= "SELECT UUID() as id, '猜冠军' AS TYPE , '' AS matchLabel, t.name AS betLabel, (CASE WHEN b.result=1 THEN CONCAT('赢得', FORMAT(stake*odds,0), '分') WHEN b.result=2 THEN '未中奖' ELSE '未开奖' END) AS resultLabel, b.bet_time AS betTime FROM campaign_worldcup_bet_champion b LEFT JOIN campaign_worldcup_team t ON b.team_id=t.id WHERE b.user_id=:userId";
	private final static String UNCOMPLETE_MATCH_QUERY = "SELECT m.id, t1.name AS team1Name, t2.name AS team2Name, t1.flag1 AS team1Flag, t2.flag1 AS team2Flag, DATE_FORMAT(m.match_time, '%m/%e %H:%i') AS matchTime, m.location FROM campaign_worldcup_match m LEFT JOIN campaign_worldcup_team t1 ON m.team1_id=t1.id LEFT JOIN campaign_worldcup_team t2 ON m.team2_id=t2.id WHERE result=0 ORDER BY match_time";
	private final static String FIND_MATCH_QUERY = "SELECT m.id, t1.name AS team1Name, t2.name AS team2Name ,t1.flag1 AS team1Flag, t2.flag1 AS team2Flag, DATE_FORMAT(m.match_time, '%m/%e %H:%i') AS matchTime, m.location FROM campaign_worldcup_match m LEFT JOIN campaign_worldcup_team t1 ON m.team1_id=t1.id LEFT JOIN campaign_worldcup_team t2 ON m.team2_id=t2.id WHERE m.id=:matchId";
	
	@Override
	@Transactional
	public int betMatch(int userId, int matchId, int bet, int stake) {
		int returnCode = 1;
		//判断当前比赛是否能投注
		Query query = em.createNativeQuery(MATCH_CAN_BET_QUERY);
		query.setParameter("matchId", matchId);
		int result = ((BigInteger)query.getSingleResult()).intValue();
		if(result == 1){
			UserPointSummary ups = upsRepo.findByUserId(userId);
			if(ups.getAvailablePoint() >= stake){
				query = em.createNativeQuery(INSERT_MATCH_BET_QUERY);
				query.setParameter("userId", userId);
				query.setParameter("matchId", matchId);
				query.setParameter("bet", bet);
				query.setParameter("stake", stake);
				returnCode = query.executeUpdate();
				ups.setAvailablePoint(ups.getAvailablePoint() - stake);
				em.persist(ups);
			}else{
				//积分不够
				returnCode = 3;
			}
		}else{
			//不在下注时间内
			returnCode = 2;
		}
		return returnCode;
	}

	@Override
	@Transactional
	public int betChampion(int userId, int teamId, int stake) {
		int returnCode = 1;
		//判断投注球队是否已经被淘汰
		Query query = em.createNativeQuery(TEAM_ELIMINATED_QUERY);
		query.setParameter("teamId", "teamId");
		int result = ((BigInteger)query.getSingleResult()).intValue();
		if(result == 0){
			query = em.createNativeQuery(QUANLIFIED_TEAM_COUNT_QUERY);
			int count = ((BigInteger)query.getSingleResult()).intValue();
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			//猜冠军截止日是2014/7/13 23:59:59
			cal.set(2014, 6, 13, 23, 59, 59);
			if(cal.getTime().after(now)){
				UserPointSummary ups = upsRepo.findByUserId(userId);
				if(ups.getAvailablePoint() >= stake){
					query = em.createNativeQuery(BET_TEAM_COUNT_QUERY);
					query.setParameter("userId", userId);
					int betTeamCount = ((BigInteger)query.getSingleResult()).intValue();
					if(betTeamCount < 3){
						query = em.createNativeQuery(INSERT_CHAMPION_BET_QUERY);
						query.setParameter("userId", userId);
						query.setParameter("teamId", teamId);
						query.setParameter("stake", stake);
						query.setParameter("odds", getOdds(2));
						returnCode = query.executeUpdate();
						ups.setAvailablePoint(ups.getAvailablePoint() - stake);
						em.persist(ups);
					}else{
						//竞猜超过三次
						returnCode = 5;
					}
				}else{
					//积分不够
					returnCode = 3;
				}
			}else{
				//截止时间到
				returnCode = 4;
			}
		}else{
			//球队已经被淘汰
			returnCode = 2;
		}
		return returnCode;
	}

	@Override
	@Transactional
	public void matchResult(int matchId, int result, String memo) {
		//更新比赛结果
		Query query = em.createNativeQuery(UPDATE_MATCH_RESULT_QUERY);
		query.setParameter("matchId", matchId);
		query.setParameter("result", result);
		query.setParameter("memo", memo);
		query.executeUpdate();
		//比赛输球队置淘汰标志
		query = em.createNativeQuery(ELIMINATE_TEAM_QUERY_PART_1 + (result == 1 ? 2 : 1) + ELIMINATE_TEAM_QUERY_PART_2);
		query.setParameter("matchId", matchId);
		query.executeUpdate();
		//更新竞猜的结果
		query = em.createNativeQuery(UPDATE_MATCH_BET_QUERY);
		query.setParameter("matchId", matchId);
		query.setParameter("result", result);
		query.executeUpdate();
		//正确的竞猜加分
		query = em.createNativeQuery(UPDATE_MATCH_POINT_QUERY);
		query.setParameter("matchId", matchId);
		query.executeUpdate();
		//更新竞猜冠军记录，如果投注的球队已经被淘汰，被置结果标志为失败
		query = em.createNativeQuery(UPDATE_CHAMPION_BET_FAILED_QUERY);
		query.setParameter("matchId", matchId);
		query.executeUpdate();
		//查询剩余未淘汰球队
		query = em.createNativeQuery(QUANLIFIED_TEAM_COUNT_QUERY);
		int count = ((BigInteger)query.getSingleResult()).intValue();
		if(count == 1){
			query = em.createNativeQuery(UPDATE_CHAMPION_BET_SUCCESS_QUERY);
			query.setParameter("matchId", matchId);
			query.executeUpdate();
			query = em.createNativeQuery(UPDATE_CHAMPION_POINT_QUERY);
			query.executeUpdate();
		}
	}

	@Override
	public List<MatchDTO> listMatch() {
		Query query = em.createNativeQuery(MATCH_QUERY, MatchDTO.class);
		return query.getResultList();
	}
	
	@Override
	public List<MatchDTO> listUnCompleteMatch() {
		Query query = em.createNativeQuery(UNCOMPLETE_MATCH_QUERY, MatchDTO.class);
		return query.getResultList();
	}
	
	@Override
	public MatchDTO findMatchById(int matchId) {
		Query query = em.createNativeQuery(FIND_MATCH_QUERY, MatchDTO.class);
		query.setParameter("matchId", matchId);
		return (MatchDTO)query.getSingleResult();
	}

	@Override
	public List<TeamDTO> listQuanlifiedTeams() {
		Query query = em.createNativeQuery(TEAM_QUERY, TeamDTO.class);
		return query.getResultList();
	}

	@Override
	public List<BetDTO> listBet(int userId) {
		List<BetDTO> bets = new ArrayList<BetDTO>();
		Query teamQuery = em.createNativeQuery(BET_TEAM_QUERY, BetDTO.class);
		teamQuery.setParameter("userId", userId);
		bets.addAll(teamQuery.getResultList());
		Query matchQuery = em.createNativeQuery(BET_MATCH_QUERY, BetDTO.class);
		matchQuery.setParameter("userId", userId);
		bets.addAll(matchQuery.getResultList());
		Collections.sort(bets);
		return bets;
	}
	
	@Override
	@Transactional
	public int shareCampaign(int campaignId, int userId){
		int returnCode = 0;
		WeUser user = userRepo.findOne(userId);
		TypedQuery<Campaign> q = em.createNamedQuery("findCampaign", Campaign.class)
				.setParameter("id", campaignId);
		Campaign campaign = null;
		campaign = q.getSingleResult();
		
		TypedQuery<UserCampaign> findUserCampaignQuery = em.createNamedQuery("findUserCampaign", UserCampaign.class)
				.setParameter("user", user)
				.setParameter("campaign", campaign);
		UserCampaign uc = null;
		try{
			uc = findUserCampaignQuery.getSingleResult();
		}catch(NoResultException ex){
			logger.info("need to create user campaign");
		}
		boolean addPoint = false;
		if(uc == null){
			uc = new UserCampaign();
			uc.setUser(user);
			uc.setCampaign(campaign);
			addPoint = true;
		}else if(!uc.isHasShared()){
			addPoint = true;
		}
		
		if(addPoint){
			uc.setHasShared(true);
			UserPointSummary ups = upsRepo.findByUserId(userId);
			ups.setAvailablePoint(ups.getAvailablePoint() + campaign.getSharePoints());
			ups.setTotalPoint(ups.getTotalPoint() + campaign.getSharePoints());
			em.persist(uc);
			em.persist(ups);
			returnCode = 1;
		}
		return returnCode;
	}
	
	static Calendar cal1 = Calendar.getInstance();
	static Calendar cal2 = Calendar.getInstance();
	static Calendar cal3 = Calendar.getInstance();
	
	static{
		cal1.set(2014, 6, 2, 7, 0, 0);
		cal2.set(2014, 6, 6, 7, 0, 0);
		cal3.set(2014, 6, 10, 7, 0, 0);
	}
	
	@Override
	public int getOdds(int betType){
		int odds = 2;
		if(betType == 2){
			Calendar now = Calendar.getInstance();
			if(now.before(cal1)){
				odds = 16;
			}else if(now.before(cal2)){
				odds = 8;
			}else if(now.before(cal3)){
				odds = 4;
			}
		}
		return odds;
	}
	
	//------大转盘
	//大转盘活动ID
	public final static int CAMPAIGN_ROTARY_ID = 10;
	
	private UserCampaign getRotaryUserCampaign(int userId){
		logger.info("Getting rotary campaign for user:" + userId);
		WeUser user = userRepo.findOne(userId);

		//获取大转盘活动对象
		TypedQuery<Campaign> q = em.createNamedQuery("findCampaign", Campaign.class)
				.setParameter("id", CAMPAIGN_ROTARY_ID);
		Campaign campaign = null;
		campaign = q.getSingleResult();

		//获取当前登录用户关联的大转盘活动对象
		TypedQuery<UserCampaign> findUserCampaignQuery = em.createNamedQuery("findUserCampaign", UserCampaign.class)
				.setParameter("user", user)
				.setParameter("campaign", campaign);
		
		//是否有过参与
		UserCampaign uc = null;
		try{
			uc = findUserCampaignQuery.getSingleResult();
		}catch(NoResultException ex){
			logger.info("need to create user campaign");
		}
		if(uc == null){
			//表示第一次进入大转盘活动界面，创建用户关联大转盘活动对象.
			uc = new UserCampaign();
			uc.setUser(user);
			uc.setCampaign(campaign);
			uc.setAwardGave(false);
			uc.setExtraDrawCount(0);
			uc.setUsedExtraDrawCount(0);
			em.persist(uc);
			logger.info("user campaign record created, user:" + userId + ",campaign:" + CAMPAIGN_ROTARY_ID);
		}
		return uc;
	}
	
	//抽奖次数
	@Override
	public int getRotaryCount(int userId){
		logger.info("Getting rotary count for user:" + userId);
		UserCampaign uc = getRotaryUserCampaign(userId);
		int drawCount = uc.getExtraDrawCount() - uc.getUsedExtraDrawCount();
		logger.info("The rotary count for user:" + userId + " is " + drawCount);
		return drawCount;
	}
	 
	//增加抽奖次数
	@Override
	public int modifyRotaryCount(int userId, int mCount){
		logger.info("modify rotary count for user:" + userId + ", modify count:" + mCount);
		UserCampaign uc = getRotaryUserCampaign(userId);
		int extraDrawCount = uc.getExtraDrawCount();
		uc.setExtraDrawCount(extraDrawCount + mCount);
		em.persist(uc);
		logger.info("The new rotary count for user:" + userId + " is " + uc.getExtraDrawCount());
		return uc.getExtraDrawCount();
	}
	
	@Override
	public DrawResponseDTO drawRotary(DrawRequestDTO request){
		logger.info("start draw ratory...");
		WeUser user = em.find(WeUser.class, request.getUserId());
		Campaign campaign = em.find(Campaign.class, request.getCampaignId());
		int availableDrawCount = getRotaryCount(request.getUserId());
		DrawResponseDTO response = new DrawResponseDTO();
		response.setResult(0);
		Date currentDate = new Date();
		if(currentDate.before(campaign.getBeginDate()) || currentDate.after(campaign.getEndDate())){
			response.setResult(-2);
		}else if(availableDrawCount > 0){
			//减去抽奖次数
			response.setRemainDrawCount(availableDrawCount - 1);
			//初始化抽奖日志信息
			CampaignAction action = new CampaignAction();
			action.setUser(user);
			action.setCreateDate(currentDate);
			action.setCampaign(campaign);
			response.setResult(0);
			Sales s = userService.findSalesByUserId(user.getId());
			//根据抽奖逻辑，直接指定奖项(1-2等奖)，给当前抽奖人
			//CampaignAward award = pointRotaryAward(user, s.getBranchCode());
			//判断抽奖逻辑中设定的奖项是否为null，，如果的奖项是为nul则没配置，进行表示设定的奖项抽完，进行随机抽取（3-5等奖、加上特等奖）.
				//表示为null,随机抽取可以抽的奖项给抽奖人
			List<Integer> list = getAvailableAwardListForSandPay();//获取可用的所有奖项
			int awardId = list.get(RandomUtils.nextInt(list.size()));
			CampaignAward award = em.find(CampaignAward.class, awardId);//抽中奖项
			response.setResult(award.getLevel());//奖项等级
			double amount = award.getAmount();//奖项金额
			if(award.getLevel() == 1){
				//表示抽中的是参与奖，奖励金额3~10元不等,数据库配的特等奖为最小3元
				amount = award.getAmount() + RandomUtils.nextInt(31);//金额3~10不等,随机加
			}
			response.setResultMessage(Utility.formatDouble(amount));//相应值
			//记录抽奖日志
			action.setAwardId(award.getId());//抽中的奖项
			action.setAwardMemo(String.valueOf(amount));//抽中的金额备注
			action.setAmount(amount);//抽中的金额
			upsService.addBalance(user.getId(), amount, "大转盘红包");//给用户的钱包余额中增加钱
			updateAwardAvailCount(10, award.getId(), currentDate);//将此奖项规定时间内允许抽取的次数减1
			//存入抽奖日志
			em.persist(action);
			//将该用户的已经抽取的次数加1
			UserCampaign uc = getRotaryUserCampaign(user.getId());
			uc.setUsedExtraDrawCount(uc.getUsedExtraDrawCount() + 1);
			em.persist(uc);//保存
			//给前端返回，当前用户剩余的抽奖次数
			response.setRemainDrawCount(uc.getExtraDrawCount()-uc.getUsedExtraDrawCount());
		}else{
			response.setResult(-1);
		}
		//扣除额外抽奖次数
		logger.info("finish draw ratory, response:" + response.getResult() + ", message:" + response.getResultMessage());
		return response;
	}
	
	/**
	 * 中奖逻辑设置：（每4周） 
	 * 1）一等奖：第18个抽的客经中一等奖，第三、第四周各出1个一等奖；
	 * 2）二等奖：第一、三、四周各出1个二等奖；第二周出2个二等奖； 
	 * 3）三~五等奖中奖数平均分配到每周；
	 */
	
	private final static String ROTARY_FIND_POINT_AWARD = "SELECT a FROM PointCampaignAward a WHERE a.pointDate<=:date AND a.pointEndDate>=:date";//获取制定的奖项
	private final static String ROTARY_GET_AWARD_COUNT_IN_DATE = "SELECT COUNT(*) FROM campaign_action ca WHERE ca.award_id=:awardId AND DATE(create_date)>=DATE(:pointBeginDate) AND DATE(create_date)<=DATE(:pointEndDate)";//获取指定奖项已经抽取的次数
	private final static String ROTARY_GET_AWARD_COUNT_BY_DATE_AND_USER = "SELECT COUNT(*) FROM campaign_action ca WHERE ca.award_id=:awardId AND DATE(create_date)>=DATE(:pointBeginDate) AND DATE(create_date)<=DATE(:pointEndDate) AND ca.user_id=:userId";//当前人中奖的次数
	private final static String ROTARY_GET_DRAW_COUNT = "SELECT count(*) FROM campaign_action WHERE campaign_id=:campaignId AND DATE(create_date)>=DATE(:pointBeginDate) AND DATE(create_date)<=DATE(:pointEndDate)";
	private final static String ROTARY_GET_AWARD_LIST = "SELECT award_id, avail_count FROM campaign_award_setting WHERE campaign_id=:campaignId AND start_date<=DATE(:date) AND end_date>=DATE(:date)";//查询规定日期，奖项允许抽取的次数
	private final static String ROTARY_UPDATE_AWARD_AVAIL_COUNT = "UPDATE campaign_award_setting SET avail_count=avail_count-1 WHERE campaign_id=:campaignId AND award_id=:awardId AND start_date<=DATE(:date) AND end_date>=DATE(:date)";
	private final static String ROTARY_GET_AWARD = "SELECT id FROM campaign_award WHERE campaign_id=:campaignId AND level=:level";//获取大转盘活动所有的奖项
	private final static String ROTARY_GET_USED_AWARD_COUNT = "SELECT SUM(total_count-avail_count) used_count FROM campaign_award_setting WHERE campaign_id=:campaignId GROUP BY campaign_id";
	
	private CampaignAward pointRotaryAward(WeUser user, String branchCode){
		logger.info("check the point award for user:" + user.getId()+", branch code:" + branchCode);
		java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		//获取指定奖项
		TypedQuery<PointCampaignAward> findPointCampaignAwardQuery = em.createQuery(ROTARY_FIND_POINT_AWARD, PointCampaignAward.class).setParameter("date", today);
		List<PointCampaignAward> pointAwardList = findPointCampaignAwardQuery.getResultList();
		for(PointCampaignAward pAward : pointAwardList){
			//判断抽奖人是否有资格
			if((pAward.getBranchCode() == null && pAward.getUser() == null) 
					|| (pAward.getUser() != null && pAward.getUser().getId() == user.getId())
					|| (pAward.getBranchCode() != null && pAward.getBranchCode().equals(branchCode))){
				//判断该奖是否可抽
				Query getAwardCountInDateQuery  = em.createNativeQuery(ROTARY_GET_AWARD_COUNT_IN_DATE)
						.setParameter("awardId", pAward.getAward().getId())
						.setParameter("pointBeginDate", pAward.getPointDate())
						.setParameter("pointEndDate", pAward.getPointEndDate());

				//获取当前循环的奖项已经抽取的次数
				int usedCount = ((BigInteger)getAwardCountInDateQuery.getSingleResult()).intValue();
				//判断已经抽取的次数，是否小于该奖项总共允许抽取的次数
				if(usedCount < pAward.getAward().getTotalCount()){
					//表示此奖还没有抽完，还有剩余次数,继续查询此人有无中过此奖
					Query getAwardCountByDateAndUserQuery  = em.createNativeQuery(ROTARY_GET_AWARD_COUNT_BY_DATE_AND_USER)
							.setParameter("awardId", pAward.getAward().getId())
							.setParameter("pointBeginDate", pAward.getPointDate())
							.setParameter("pointEndDate", pAward.getPointEndDate())
							.setParameter("userId", user.getId());
					int count = ((BigInteger)getAwardCountByDateAndUserQuery.getSingleResult()).intValue();//查询当前登录人中过此奖的次数
					//判断此人是否已经中过奖
					if(count == 0){
						//表示没有中过此奖，判断该奖项数据库指定中奖的人是否和当前登录人一致
						if(pAward.getUser() != null && pAward.getUser().getId() == user.getId()){
							//表示与设定的中奖人是一致，让当前人中奖
							logger.info("user matched, return point award:" + pAward.getAward().getId() + ", user:" + user.getId());
							return pAward.getAward();
						}else if(pAward.getUser() == null && pAward.getTimes() < 1 && (pAward.getBranchCode() != null && pAward.getBranchCode().equals(branchCode))){
							//如果没有设定中奖人、没有设定抽奖次数、只设置了中间地区，正好当前登录人又是该地区的，则中奖
							logger.info("user matched, return point award:" + pAward.getAward().getId() + ", user:" + user.getId());
							return pAward.getAward();
						}else{
							//表示该奖项没有制定到具体谁中奖,继续获取中奖的总共数量
							Query drawTimesQuery = em.createNativeQuery(ROTARY_GET_DRAW_COUNT)
									.setParameter("campaignId", pAward.getAward().getCampaign().getId())
									.setParameter("pointBeginDate", pAward.getPointDate())
									.setParameter("pointEndDate", pAward.getPointEndDate());
							int drawTimes = ((BigInteger)drawTimesQuery.getSingleResult()).intValue();//获取大转盘参与人抽奖的总次数
							//判断制定的奖项抽取次数和实际次数是否吻合
							if(drawTimes+1 == pAward.getTimes()){
								//表示吻合，即中奖
								logger.info("times matched, return point award:" + pAward.getAward().getId() + ", times:" + pAward.getTimes());
								return pAward.getAward();
							}
						}
					}
				}
			}
		}
		return null;
	}

	private List<Integer> getAvailableAwardListForSandPay(){
		logger.info("getting available award list or sandpay...");
		//查询已经抽取的固定奖项数量
		Query getUsedAwardCountQuery = em.createNativeQuery(ROTARY_GET_USED_AWARD_COUNT)
				.setParameter("campaignId", 10);
		int usedCount = ((BigDecimal)getUsedAwardCountQuery.getSingleResult()).intValue();
		//奖池最大300
		int lotteryPoolSize = 300 - usedCount;
		Query getAwardCountByDateAndUserQuery  = em.createNativeQuery(ROTARY_GET_AWARD_LIST)
				.setParameter("campaignId", 10)
				.setParameter("date", new Date());
		//查询并加入固定奖项
		List<Object[]> settingList = getAwardCountByDateAndUserQuery.getResultList();//查询规定日期，奖项允许抽取的次数
		List<Integer> awardList = new ArrayList<Integer>(lotteryPoolSize); //创建一个指定大小的集合
		for(Object[] setting : settingList){
			int awardId = (Integer)setting[0];
			int availCount = (Integer)setting[1];
			for(int i =0;i < availCount;i++){
				awardList.add(awardId);
			}
		}
		//奖池的空余部分补入随机奖项
		Query getAwardQuery = em.createNativeQuery(ROTARY_GET_AWARD)
				.setParameter("campaignId", 10)
				.setParameter("level", 1);//获取随机奖
		int awardId = (Integer)getAwardQuery.getSingleResult();
		for(int i = awardList.size();i<lotteryPoolSize;i++){
			awardList.add(awardId);
		}
		return awardList;
	}
	
	private int updateAwardAvailCount(int campaignId, int awardId, Date date){
		logger.info("updateing award avail count, campaignId:" + campaignId + ", awardId:" + awardId + ", date:" + date);
		Query updateAwardAvailCountQuery = em.createNativeQuery(ROTARY_UPDATE_AWARD_AVAIL_COUNT);
		updateAwardAvailCountQuery.setParameter("campaignId", campaignId)
			.setParameter("awardId", awardId)
			.setParameter("date", date);
		return updateAwardAvailCountQuery.executeUpdate();
	}

	public Campaign findById(int id) {
		return em.find(Campaign.class,id);
	}
}
