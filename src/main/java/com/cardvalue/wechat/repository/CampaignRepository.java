package com.cardvalue.wechat.repository;

import java.util.Date;
import java.util.List;

import com.cardvalue.wechat.dto.BetDTO;
import com.cardvalue.wechat.dto.CampaignDTO;
import com.cardvalue.wechat.dto.CampaignLogResponseDTO;
import com.cardvalue.wechat.dto.CampaignReportDTO;
import com.cardvalue.wechat.dto.DrawRequestDTO;
import com.cardvalue.wechat.dto.DrawResponseDTO;
import com.cardvalue.wechat.dto.MatchDTO;
import com.cardvalue.wechat.dto.TeamDTO;
import com.cardvalue.wechat.model.Campaign;

public interface CampaignRepository{

	public CampaignDTO findLatestCampaign(int userId, int campaignId);
	
	public DrawResponseDTO draw(DrawRequestDTO request);

	public CampaignLogResponseDTO campaignLog(int campaignId, int userId);
	
	public List<Campaign> findActiveCampaigns();

	public void accumulation(int campaignId);

	public int shareTimeline(int userId, int campaignId);

	List<CampaignReportDTO> report(Date beginDate, Date endDate, int campaignId);
	
	public void addExtraDrawCount();
	
	public List<MatchDTO> listMatch();
	
	public List<TeamDTO> listQuanlifiedTeams();
	
	public List<BetDTO> listBet(int userId);
	
	public int betMatch(int userId, int matchId, int bet, int stake);
	
	public int betChampion(int userId, int teamId, int stake);
	
	public void matchResult(int matchId, int result, String memo);

	public List<MatchDTO> listUnCompleteMatch();

	public MatchDTO findMatchById(int matchId);

	int shareCampaign(int campaignId, int userId);

	int getOdds(int betType);

	int getRotaryCount(int userId);

	int modifyRotaryCount(int userId, int mCount);

	DrawResponseDTO drawRotary(DrawRequestDTO request);

	public Campaign findById(int id);

}
