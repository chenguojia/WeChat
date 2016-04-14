package com.cardvalue.wechat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.cardvalue.wechat.model.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cardvalue.wechat.annotation.Token;
import com.cardvalue.wechat.dto.CampaignDTO;
import com.cardvalue.wechat.dto.CampaignLogResponseDTO;
import com.cardvalue.wechat.dto.DrawRequestDTO;
import com.cardvalue.wechat.dto.DrawResponseDTO;
import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.UserPointSummary;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.CampaignRepository;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.UserPointSummaryRepository;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.CampaignService;
import com.cardvalue.wechat.service.UserService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Result;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/campaign")
public class CampaignController {
	
	private static final Logger logger = LoggerFactory.getLogger(CampaignController.class);
	
	@Resource
	private WeChatService weChatService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private CampaignRepository campaignRepo;
	
	@Resource
	private CampaignService campaignService;
	
	@Resource
	private ParamRepository paramRepo;
	
	@Resource
	private UtilRepository utilRepo;
	
	@Resource
	private UserPointSummaryRepository upsRepo; 
	
	@RequestMapping(value = "/egg", method = RequestMethod.GET)
	@Token(save=true)
	public ModelAndView eggIndex(HttpSession session) {
		logger.info("User entering ");
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		ModelAndView mv = new ModelAndView();
		//判断是否是注册客户经理
		if(user != null && user.isEnabled()){
			int userId = user.getId();
			CampaignDTO dto = campaignRepo.findLatestCampaign(userId, 3);
			Sales s = userService.findSalesByUserId(userId);
			dto.setName(s.getName());
			dto.setUserId(userId);
			mv.addObject("dto", dto);
		}else{
			mv.setViewName("campaign/invalid-user");
		}
		return mv;
	}
	
	@RequestMapping(value = "/draw", method = RequestMethod.GET)
	@Token(remove=true,save=true)
	public @ResponseBody DrawResponseDTO draw(DrawRequestDTO request, HttpSession session){
		DrawResponseDTO response = campaignRepo.draw(request);
		response.setToken((String)session.getAttribute(Constants.SESSION_KEY_TOKEN));
		return response;
	}
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public ModelAndView summary(@RequestParam int campaignId, @RequestParam int userId){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("campaign/award-log");
		CampaignLogResponseDTO response = campaignRepo.campaignLog(campaignId, userId);
		mv.addObject("dto", response);
		return mv;
	}
	
	@RequestMapping(value = "/share", method = RequestMethod.GET)
	public ModelAndView share(@RequestParam int campaignId, @RequestParam int userId, @RequestParam String amount){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("campaign/award-share");
		Sales sales = userService.findSalesByUserId(userId);
		String branchLabel = utilRepo.getBranchLabelByCode(sales.getBranchCode());
		mv.addObject("name", branchLabel + " " + sales.getName());
		mv.addObject("amount", amount);
		return mv;
	}
	
	@RequestMapping(value = "/shareTimeline", method = RequestMethod.GET)
	public @ResponseBody int shareTimeline(@RequestParam int campaignId, @RequestParam int userId){
		int availCount = campaignRepo.shareTimeline(userId, campaignId);
		return availCount;
	}
	
	@RequestMapping(value = "/rule", method = RequestMethod.GET)
	public String rule(){
		return "campaign/rule";
	}
	
	@RequestMapping(value = "/showEdm", method = RequestMethod.GET)
	public ModelAndView showEdm(@RequestParam(required=false) String code){
		ModelAndView mv = new ModelAndView();
		String openId = weChatService.getOpenIdByAccessToken(code);
		mv.setViewName("campaign/edm");
		mv.addObject("campaignId", 1);
		if(openId != null){
			WeUser user = userService.findByOpenId(openId);		
			if(user != null && user.isEnabled()){
				mv.addObject("userId", user.getId());
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/worldcup", method = RequestMethod.GET)
	@Token(save=true)
	public ModelAndView worldCup(HttpSession session){
		ModelAndView mv = new ModelAndView();
		WeUser user = (WeUser)session.getAttribute("login_user");
		if(user == null){
			mv.addObject("message", "感谢您的支持, 请通过用户入口登录后再参与竞猜世界杯活动");
			mv.addObject("returnFlag", false);
			mv.setViewName("message");
		}else{
			UserPointSummary ups = upsRepo.findByUserId(user.getId());
			mv.addObject("matchs", campaignRepo.listMatch());
			mv.addObject("teams", campaignRepo.listQuanlifiedTeams());
			mv.addObject("availablePoints", ups.getAvailablePoint());
			mv.addObject("userId", user.getId());
			mv.setViewName("campaign/worldcup");
		}
		return mv;
	}
	
	@RequestMapping(value = "/worldcup-bet-list", method = RequestMethod.GET)
	public ModelAndView betWorldCup(HttpSession session){
		ModelAndView mv = new ModelAndView();
		WeUser user = (WeUser)session.getAttribute("login_user");
		mv.addObject("bets", campaignRepo.listBet(user.getId()));
		mv.setViewName("campaign/worldcup-bet");
		return mv;
	}
	
	@RequestMapping(value = "/worldcup-bet-match", method = RequestMethod.GET)
	@ResponseBody
	@Token(save=true, remove=true)
	public Result<String> betMatch(@RequestParam int matchId, @RequestParam int bet, @RequestParam int stake, HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		Result<String> result = new Result<String>();
		if(user != null){
			int code = campaignRepo.betMatch(user.getId(), matchId, bet, stake);
			if(code == 1){
				UserPointSummary ups = upsRepo.findByUserId(user.getId());
				result.setMessage(String.valueOf(ups.getAvailablePoint()));
			}
			result.setPayload((String)session.getAttribute(Constants.SESSION_KEY_TOKEN));
			result.setCode(String.valueOf(code));
		}else{
			result.setCode("-1");
		}
		return result;
	}
	
	@RequestMapping(value = "/worldcup-bet-team", method = RequestMethod.GET)
	@ResponseBody
	@Token(save=true, remove=true)
	public Result<String> betTeam(int teamId, int stake, HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		Result<String> result = new Result<String>();
		if(user != null){
			int code = campaignRepo.betChampion(user.getId(), teamId, stake);
			if(code == 1){
				UserPointSummary ups = upsRepo.findByUserId(user.getId());
				result.setMessage(String.valueOf(ups.getAvailablePoint()));
				result.setPayload((String)session.getAttribute(Constants.SESSION_KEY_TOKEN));
			}
			result.setCode(String.valueOf(code));
		}else{
			result.setCode("-1");
		}
		return result;
	}
	
	@RequestMapping(value = "/showMatchList", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showMatchList(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("matchs", campaignRepo.listUnCompleteMatch());
		mv.setViewName("campaign/match-list");
		return mv;
	}
	
	@RequestMapping(value = "/showMatch", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showMatch(@RequestParam int matchId){
		ModelAndView mv = new ModelAndView();
		mv.addObject("match", campaignRepo.findMatchById(matchId));
		mv.setViewName("campaign/match");
		return mv;
	}
	
	@RequestMapping(value = "/updateMatchResult", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateMatchResult(@RequestParam int matchId, @RequestParam int result, @RequestParam String memo){
		campaignRepo.matchResult(matchId, result, memo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("matchs", campaignRepo.listUnCompleteMatch());
		mv.setViewName("campaign/match-list");
		return mv;
	}
	
	@RequestMapping(value = "/shareCampaign", method = RequestMethod.GET)
	@ResponseBody
	public int shareCampaign(@RequestParam int campaignId, @RequestParam int userId){
		return campaignRepo.shareCampaign(campaignId, userId);
	}
	
	@RequestMapping(value = "/getOdds", method = RequestMethod.GET)
	@ResponseBody
	public int getOdds(@RequestParam int betType){
		return campaignRepo.getOdds(betType);
	}

	/**
	 * 大转盘活动
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/rotary", method = RequestMethod.GET)
	public ModelAndView rotary(HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		ModelAndView mv = new ModelAndView();
		int drawCount = campaignService.getRotaryCount(user.getId());
		Campaign campaign = campaignRepo.findById(10);
		mv.addObject("campaign", campaign);
		mv.addObject("drawCount", drawCount);
		mv.setViewName("campaign/rotary");
		return mv;
	}
	
	@RequestMapping(value = "/drawRotary", method = RequestMethod.GET)
	@ResponseBody
	public DrawResponseDTO drawRotary(HttpSession session){
		WeUser user = (WeUser)session.getAttribute(Constants.SESSION_KEY_USER);
		DrawRequestDTO request = new DrawRequestDTO();
		request.setUserId(user.getId());
		request.setCampaignId(10);
		DrawResponseDTO response = campaignService.drawRotary(request);
		return response;
	}

	/**
	 * 积分活动
	 * @return
	 */
	@RequestMapping(value = "/showIntegra", method = RequestMethod.GET)
	public ModelAndView showIntegra(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("campaign/integra");
		return mv;
	}
}
