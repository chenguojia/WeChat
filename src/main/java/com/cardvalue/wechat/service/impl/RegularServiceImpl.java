package com.cardvalue.wechat.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cardvalue.wechat.dto.ActiveRateDTO;
import com.cardvalue.wechat.dto.LabelValueTO;
import com.cardvalue.wechat.dto.LoginSalesInBranchTO;
import com.cardvalue.wechat.dto.SalesLoginTO;
import com.cardvalue.wechat.dto.SalesPointSummaryDTO;
import com.cardvalue.wechat.dto.SalesUnLoginTO;
import com.cardvalue.wechat.model.AddKeyMerchantDetailDTO;
import com.cardvalue.wechat.model.AddKeyMerchantSummaryDTO;
import com.cardvalue.wechat.model.Merchant;
import com.cardvalue.wechat.repository.KeyMerchantRepository;
import com.cardvalue.wechat.repository.MerchantRepository;
import com.cardvalue.wechat.repository.ReferrerLinkRepository;
import com.cardvalue.wechat.repository.SalesRepository;
import com.cardvalue.wechat.service.MerchantService;
import com.cardvalue.wechat.service.RegularService;
import com.cardvalue.wechat.service.WeChatService;
import com.cardvalue.wechat.util.ColumnConfig;
import com.cardvalue.wechat.util.ExcelHelper;
import com.cardvalue.wechat.util.Utility;

@Service
public class RegularServiceImpl implements RegularService {

	private final static Logger logger = LoggerFactory.getLogger(RegularServiceImpl.class);

	@Resource
	private SalesRepository salesRepo;

	@Resource
	private MerchantRepository merchantRepo;

	@Resource
	private ReferrerLinkRepository referrerLinkRepo;

	@Resource
	private MerchantService merchantService;

	@Resource
	private JavaMailSender mailSender;

	@Resource
	private KeyMerchantRepository keyMerchantRepo;

	@Resource
	private List<ColumnConfig> loggedSheetConfig;

	@Resource
	private List<ColumnConfig> unLoggedSheetConfig;

	@Resource
	private List<ColumnConfig> groupInDateSheetConfig;

	@Resource
	private List<ColumnConfig> groupInBranchSheetConfig;

	@Resource
	private List<ColumnConfig> activeRateSheetConfig;

	@Resource
	private List<ColumnConfig> pointSummarySheetConfig;

	@Resource
	private List<ColumnConfig> unactivatedMerchantSheetConfig;

	@Resource
	private List<ColumnConfig> addKeyMerchantSummarySheetConfig;

	@Resource
	private List<ColumnConfig> addKeyMerchantDetailSheetConfig;

	@Resource
	private WeChatService weChatService;

	@Value("${mail.from.email}")
	private String mailSenderEmail;

	@Value("${mail.from.personal}")
	private String mailSenderPersonal;

	@Value("${mail.to.email}")
	private String mailToEmail;

	@Value("${mail.keymerchant.to}")
	private String keyMerchantTo;

	@Value("${mail.text}")
	private String mailText;

	@Scheduled(cron = "0 0 9 * * *")
	// @Scheduled(initialDelay=10000, fixedRate=500000000)
	@Override
	public void dailyReport() {
		logger.debug("daily report begin...");
		List<SalesLoginTO> loggedSales = salesRepo.findLoggedSales();
		List<SalesUnLoginTO> notLoggedSales = salesRepo.findNotLoggedSales();
		List<LoginSalesInBranchTO> loggedSalesInBranch = salesRepo.findLoggedSalesInBranch();
		List<LabelValueTO> loggedSalesInDate = salesRepo.findLoggedSalesInLoginDate();

		HSSFWorkbook workbook = ExcelHelper.createWorkbook();
		try {
			HSSFSheet loggedWorksheet = ExcelHelper.createSheet(workbook, "已登录客户经理列表");
			ExcelHelper.build(loggedWorksheet, 0, 0, loggedSheetConfig, loggedSales);

			HSSFSheet unLoggedWorksheet = ExcelHelper.createSheet(workbook, "未登录客户经理列表");
			ExcelHelper.build(unLoggedWorksheet, 0, 0, unLoggedSheetConfig, notLoggedSales);

			HSSFSheet loggedSalesInBranchSheet = ExcelHelper.createSheet(workbook, "按分支机构统计");
			ExcelHelper.build(loggedSalesInBranchSheet, 0, 0, groupInBranchSheetConfig, loggedSalesInBranch);

			HSSFSheet loggedSalesInDateSheet = ExcelHelper.createSheet(workbook, "按登录日期统计");
			ExcelHelper.build(loggedSalesInDateSheet, 0, 0, groupInDateSheetConfig, loggedSalesInDate);

			File file = File.createTempFile("daily-report", "xls");
			OutputStream os = new FileOutputStream(file);
			workbook.write(os);
			os.flush();
			os.close();
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailSenderEmail, mailSenderPersonal);
			helper.setTo(StringUtils.split(mailToEmail, ","));
			helper.addAttachment(MimeUtility.encodeText("微信平台每日统计报告.xls"), file);
			helper.setSubject("微信平台每日统计报告(" + Utility.formatLongDate(new Date()) + ")");
			helper.setText(mailText);
			mailSender.send(message);
		} catch (Exception e) {
			logger.error("generate daily report failed", e);
		}
		logger.debug("daily report finish");
	}

	@Override
	@Scheduled(cron = "0 10 09 1 * ?")
	// @Scheduled(initialDelay=10000, fixedRate=500000000)
	public void monthlyReport() {
		logger.debug("monthly report begin...");
		List<ActiveRateDTO> activeRates = salesRepo.findActiveRate();
		HSSFWorkbook workbook = ExcelHelper.createWorkbook();
		try {
			HSSFSheet activeRateSheet = ExcelHelper.createSheet(workbook, "活跃度统计");
			ExcelHelper.build(activeRateSheet, 0, 0, activeRateSheetConfig, activeRates);
			File file = File.createTempFile("monthly-report", "xls");
			OutputStream os = new FileOutputStream(file);
			workbook.write(os);
			os.flush();
			os.close();
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailSenderEmail, mailSenderPersonal);
			helper.setTo(StringUtils.split(mailToEmail, ","));
			helper.addAttachment(MimeUtility.encodeText("微信平台月度统计报告.xls"), file);
			helper.setSubject("微信平台月度统计报告(" + Utility.formatLongDate(new Date()) + ")");
			helper.setText(mailText);
			mailSender.send(message);
		} catch (Exception e) {
			logger.error("generate monthly report failed", e);
		}
		logger.debug("monthly report finish");
	}

	@Scheduled(cron = "0 5 9 * * *")
	@Override
	public void pointSummaryReport() {
		logger.debug("point summary report begin...");
		List<SalesPointSummaryDTO> salesPointSummaries = salesRepo.getSalesPointSummary();

		HSSFWorkbook workbook = ExcelHelper.createWorkbook();
		try {
			HSSFSheet loggedWorksheet = ExcelHelper.createSheet(workbook, "积分统计");
			ExcelHelper.build(loggedWorksheet, 0, 0, pointSummarySheetConfig, salesPointSummaries);

			File file = File.createTempFile("point-summary-report", "xls");
			OutputStream os = new FileOutputStream(file);
			workbook.write(os);
			os.flush();
			os.close();
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailSenderEmail, mailSenderPersonal);
			helper.setTo(StringUtils.split(mailToEmail, ","));
			helper.addAttachment(MimeUtility.encodeText("微信平台客户经理积分统计报告.xls"), file);
			helper.setSubject("微信平台客户经理积分统计报告(" + Utility.formatLongDate(new Date()) + ")");
			helper.setText(mailText);
			mailSender.send(message);
		} catch (Exception e) {
			logger.error("generate point summary report failed", e);
		}
		logger.debug("point summary report finish");
	}

	// @Scheduled(cron="0 0 9 * * *")
	// @Scheduled(initialDelay=10000, fixedRate=900000000)
	@Override
	public void unactivatedMerchantReport() {
		logger.debug("unactivated merchant report begin...");
		Calendar cal = Calendar.getInstance();
		// cal.add(Calendar.DATE, -1);
		String dateStr = Utility.formatShortDate(cal.getTime());
		List<Merchant> unactivatedMerchants = merchantRepo.getUnactivatedMerchants(dateStr);

		HSSFWorkbook workbook = ExcelHelper.createWorkbook();
		try {
			HSSFSheet loggedWorksheet = ExcelHelper.createSheet(workbook, "待激活商户");
			ExcelHelper.build(loggedWorksheet, 0, 0, unactivatedMerchantSheetConfig, unactivatedMerchants);
			File file = File.createTempFile("unactivated-merchant", "xls");
			OutputStream os = new FileOutputStream(file);
			workbook.write(os);
			os.flush();
			os.close();
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailSenderEmail, mailSenderPersonal);
			helper.setTo(StringUtils.split(mailToEmail, ","));
			helper.addAttachment(MimeUtility.encodeText("待激活商户列表.xls"), file);
			helper.setSubject("待激活商户列表(" + Utility.formatLongDate(new Date()) + ")");
			helper.setText(mailText);
			mailSender.send(message);
		} catch (Exception e) {
			logger.error("unactivated merchant report failed", e);
		}
		logger.debug("unactivated merchant report finish");
	}

	@Scheduled(cron = "0 5 19 * * *")
	// @Scheduled(initialDelay=10000, fixedRate=900000000)
	@Override
	public void addKeyMerchantReport() {
		logger.debug("add key merchant report begin...");
		List<AddKeyMerchantSummaryDTO> summaryDTOs = merchantRepo.listAddKeyMerchantSummary();
		List<AddKeyMerchantDetailDTO> detailDTOs = merchantRepo.listAddKeyMerchantDetail();
		HSSFWorkbook workbook = ExcelHelper.createWorkbook();
		try {
			HSSFSheet summarySheet = ExcelHelper.createSheet(workbook, "总表");
			ExcelHelper.build(summarySheet, 0, 0, addKeyMerchantSummarySheetConfig, summaryDTOs);
			HSSFSheet loggedWorksheet = ExcelHelper.createSheet(workbook, "明细");
			ExcelHelper.build(loggedWorksheet, 0, 0, addKeyMerchantDetailSheetConfig, detailDTOs);
			File file = File.createTempFile("unactivated-merchant", "xls");
			OutputStream os = new FileOutputStream(file);
			workbook.write(os);
			os.flush();
			os.close();
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailSenderEmail, mailSenderPersonal);
			helper.setTo(StringUtils.split(keyMerchantTo, ","));
			helper.addAttachment(MimeUtility.encodeText("营销季活动每日数据列表.xls"), file);
			helper.setSubject("营销季活动每日数据列表(" + Utility.formatLongDate(new Date()) + ")");
			helper.setText(mailText);
			mailSender.send(message);
		} catch (Exception e) {
			logger.error("unactivated merchant report failed", e);
		}
		logger.debug("add key merchant report finish");
	}

	@Override
	@Scheduled(cron = "0 0 0/1 * * *")
	public void clearExpiredReferrerLinks() {
		logger.info("start clear expired referrer link...");
		int count = referrerLinkRepo.removeExpiredLinks();
		logger.info(count + " exprired links removed");
	}

}
