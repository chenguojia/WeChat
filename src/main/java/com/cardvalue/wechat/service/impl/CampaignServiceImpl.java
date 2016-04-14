package com.cardvalue.wechat.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cardvalue.wechat.dto.CampaignReportDTO;
import com.cardvalue.wechat.dto.DrawRequestDTO;
import com.cardvalue.wechat.dto.DrawResponseDTO;
import com.cardvalue.wechat.repository.CampaignRepository;
import com.cardvalue.wechat.service.CampaignService;
import com.cardvalue.wechat.util.ColumnConfig;
import com.cardvalue.wechat.util.ExcelHelper;
import com.cardvalue.wechat.util.Utility;

@Service
public class CampaignServiceImpl implements CampaignService {

	private final static Logger logger = LoggerFactory.getLogger(CampaignServiceImpl.class);

	@Resource
	private CampaignRepository campaignRepo;

	@Resource
	private JavaMailSender mailSender;

	@Resource
	private List<ColumnConfig> campaignReportSheetConfig;

	@Value("${mail.from.email}")
	private String mailSenderEmail;

	@Value("${mail.from.personal}")
	private String mailSenderPersonal;

	@Value("${mail.campaign.to.email}")
	private String mailToEmail;

	@Value("${mail.text}")
	private String mailText;

	@Override
	//@Scheduled(cron = "0 59 23 * * *")
	//@Scheduled(initialDelay=10000, fixedRate=500000)
	@Transactional
	public void dailyBatch() {
		logger.info("Start Campaign Daily Batch Job...");
		logger.info("Complete Campaign Daily Batch Job.");
	}

	@Override
	//@Scheduled(cron = "0 0 0,9 * * *")
	//@Scheduled(initialDelay=20000, fixedRate=500000)
	@Transactional(readOnly = true)
	public void dailyMorningReport() {
		logger.info("Start Campaign Daily Morning Report...");
		logger.info("Complete Campaign Daily Batch Job.");
	}

	@Override
	//@Scheduled(cron = "0 0 17 * * *")
	//@Scheduled(initialDelay=30000, fixedRate=500000)
	@Transactional(readOnly = true)
	public void dailyEveningReport() {
		logger.info("Start Campaign Daily Batch Job...");
		logger.info("Complete Campaign Daily Batch Job.");
	}

	private void generateReport(List<CampaignReportDTO> dtoList) {
		HSSFWorkbook workbook = ExcelHelper.createWorkbook();
		try {
			HSSFSheet loggedWorksheet = ExcelHelper.createSheet(workbook, "活动统计");
			ExcelHelper.build(loggedWorksheet, 0, 0, campaignReportSheetConfig, dtoList);
			File file = File.createTempFile("daily-report", "xls");
			OutputStream os = new FileOutputStream(file);
			workbook.write(os);
			os.flush();
			os.close();
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailSenderEmail, mailSenderPersonal);
			helper.setTo(StringUtils.split(mailToEmail, ","));
			helper.addAttachment(MimeUtility.encodeText("微信平台活动统计报告.xls"), file);
			helper.setSubject("微信平台活动统计报告(" + Utility.formatLongDate(new Date()) + ")");
			helper.setText(mailText);
			mailSender.send(message);
		} catch (Exception e) {
			logger.error("Error occurs when generate campaign report:", e);
		}
	}

	@Override
	@Transactional
	public void addExtraDrawCount() {
		/*logger.info("Start adding extra draw count...");
		campaignRepo.addExtraDrawCount();
		logger.info("Complete adding extra draw count.");*/
	}
	
	@Override
	@Transactional(readOnly=true)
	public int getRotaryCount(int userId){
		return campaignRepo.getRotaryCount(userId);
	}

	@Override
	@Transactional
	public int modifyRotaryCount(int userId, int mCount){
		return campaignRepo.modifyRotaryCount(userId, mCount);
	}

	@Override
	@Transactional
	public DrawResponseDTO drawRotary(DrawRequestDTO request){
		return campaignRepo.drawRotary(request);
	}
	
}
