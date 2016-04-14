package com.cardvalue.wechat.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.model.CvRegionConf;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.ReferrerLink;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.ReferrerLinkRepository;
import com.cardvalue.wechat.repository.SequenceRepository;
import com.cardvalue.wechat.repository.UserRepository;
import com.cardvalue.wechat.repository.UtilRepository;
import com.cardvalue.wechat.service.UtilityService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Utility;

@Service
public class UtilityServiceImpl implements UtilityService {

	private final static Logger logger = LoggerFactory.getLogger(UtilityServiceImpl.class);

	@Resource
	private SequenceRepository sequenceRepository;

	@Resource
	private ParamRepository paramRepository;

	@Resource
	private UtilRepository utilRepo;

	@Resource
	private UserRepository userRepository;

	@Resource
	private ReferrerLinkRepository referrerLinkRepo;

	@Resource
	private JavaMailSender mailSender;

	@Value("${mail.from.email}")
	private String mailSenderEmail;

	@Value("${mail.from.personal}")
	private String mailSenderPersonal;

	@Value("${mail.to.maintainer}")
	private String mailToMaintainer;

	@Value("${ws.local.ip}")
	private String wsLocalIp;

	DateFormat df = new SimpleDateFormat("yyMMdd");

	@Override
	public String generateSequenceNumber(int type) {
		//目前微信端只能提交线索
		String seqName = Constants.SEQUENCE_NAME_LEADS_;
		int seqNumber = sequenceRepository.getSequenceNumber(seqName);
		//左补齐0到五位
		String paddedSeqNumber = StringUtils.leftPad(String.valueOf(seqNumber), 5, '0');
		String dateString = df.format(new Date());
		StringBuilder sb = new StringBuilder();
		sb.append(type).append(dateString).append(paddedSeqNumber);
		return sb.toString();
	}

	@Override
	public Parameter getParamByValueAndGroup(String group, String value) {
		Parameter parameter = paramRepository.findByGroupAndValue(group, value);
		return parameter;
	}

	@Override
	public List<Parameter> getParamsByGroup(String group){
		return paramRepository.findByGroup(group);
	}

	@Scheduled(cron="0 0 0 * * *")
	@Transactional
	@Override
	public void resetSequenceNumber(){
		logger.info("reset sequence number start...");
		utilRepo.resetSequenceNumber();
		logger.info("reset sequence number completed.");
	}

	@Override
	public long storeMerchantReferrer(int referrerId, String mid){
		ReferrerLink link = referrerLinkRepo.create(referrerId, mid);
		return link.getId();
	}

	@Override
	public boolean validReferrerLink(long linkId){
		boolean valid = false;
		ReferrerLink link = referrerLinkRepo.findById(linkId);
		if(link != null && link.isValid()){
			Date now = new Date();
			Date oneHourAgo = DateUtils.addHours(now, -1);
			if(oneHourAgo.compareTo(link.getCreateDate()) < 0){
				valid = true;
			}
		}
		return valid;
	}

	/**
	 * 判断用户是客户经理还是商户
	 * @param userId 用户id
	 * @return 1表示客户经理 0表示商户
	 */
	public String getUserType(Integer userId){
		String userType = "1";
		WeUser user = userRepository.findById(userId);
		if(user != null){
			switch(user.getType()){
				case 0:
				case 1:
				case 2:
				case 6:
				case 7:
				case 8:
					userType = "1";
					break;
				case 4:
					userType = "0";
					break;
				default:
					userType = "1";
			}
		}
		return userType;
	}


	/**
	 * 校验用户输入的手机和验证码是否和服务器一致
	 * @param session
	 * @param inputMobile 用户输入的手机号码
	 * @param inputCheckCode 用户输入的验证码
	 * @return
	 */
	public String validateCheckCode(HttpSession session,String inputMobile,String inputCheckCode){

		String msg = null;

		if(session.getAttribute("checkCode") != null){
			//获取短信验证码
			String checkCode = (String)session.getAttribute("checkCode");
			String checkCodeMobile = (String)session.getAttribute("checkCodeMobile");
			Date checkCodeSetDate = (Date)session.getAttribute("checkCodeSetDate");

			//判断验证码是否过期
			if(Utility.getDateDiff(new Date(), checkCodeSetDate, "m") <= 2){
				//判断发送短信的手机和输入的手机是否一致
				if(checkCodeMobile.equals(inputMobile)){
					//判断验证码是否输入的一致
					if(checkCode.equals(inputCheckCode)){
						//表示验证通过
						msg =null;
					}else{
						//表示验证码输入的不是短信提示的
						msg = "您输入的验证码有误，请重新输入。";
					}
				}else{
					//表示验证码输入的不是短信提示的
					msg = "您输入的手机与接受验证码的手机号码不一致，请重新输入。";
				}
			}else{
				//表示验证码过期了
				msg = "您输入的校验码已超时，请点击确认重新获取校验码。";
				//清空验证码信息
				session.removeAttribute("checkCode");
				session.removeAttribute("checkCodeMobile");
				session.removeAttribute("checkCodeSetDate");
			}
		}else{
			//表示验证码输入的不是短信提示的
			msg = "您当前没有获取验证码，请点击确认重新获取校验码。";
		}

		return msg;
	}

	@Override
	public List<CvRegionConf> queryProvincesOrRegions(Integer type, Integer pid) {
		return utilRepo.queryProvincesOrRegions(type, pid);
	}

	@Override
	public CvRegionConf getProvincesOrRegionsById(Integer id) {
		return utilRepo.getProvincesOrRegionsById(id);
	}

	@Override
	public CvRegionConf getProvincesOrRegionsByName(String name) {
		return utilRepo.getProvincesOrRegionsByName(name);
	}

	@Override
	public String getCategoryByMcc(String mcc){
		return utilRepo.getCategoryByMcc(mcc);
	}

    /**
     * 外部调用微信接口出错通知邮件
     *
     * @param businessObj 需要在邮件中现实详情的对象
     */
    public void sendMailForException(Object businessObj) {
        if (businessObj != null) {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setFrom(mailSenderEmail, mailSenderPersonal);
                helper.setTo(StringUtils.split(mailToMaintainer, ","));
                String envirName = "测试环境";
                if (wsLocalIp.equals("192.168.0.209")) envirName = "正式环境";
                String subject = "[" + envirName + "] 外部调用微信接口出错通知邮件(" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ")";
                String text = "错误详情为：" + new ObjectMapper().writeValueAsString(businessObj);
                logger.info(subject + "\n" + text);//打印日志
                helper.setSubject(subject);
                helper.setText(text);
                mailSender.send(message);//测试环境先不发邮件
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("发送错误通知邮件出错 : ", e);
            }
        }
    }
}
