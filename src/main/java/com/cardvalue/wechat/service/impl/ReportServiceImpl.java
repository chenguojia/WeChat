package com.cardvalue.wechat.service.impl;

import com.cardvalue.wechat.service.ReportService;
import com.cardvalue.wechat.util.Constants;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(value = "reportService")
public class ReportServiceImpl implements ReportService {
	
	private final static Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);
	
	private String outputPath = null;//报表文件导出存放路径，spring注入得到
	
	private DataSource dataSource = null;//数据源

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取报表文件的宽度
	 *
	 * @param filePath	 模板文件绝对路径
	 */
	@Override
	public String getPageWidth(String filePath){
		String pageWidth = "700";
		try {
			String reportTemplatetSuffix = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());//模板文件后缀名
			JasperReport jasperReport = null;
			/**step1.判断模板文件类型*/
			if (reportTemplatetSuffix.equals("jrxml")) {
				//表示读取模板文件类型为JRXML还未编译的设计模板文件
				jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(new FileInputStream(new File(filePath))));
			} else {
				//表示读取模板文件类型为JASPER编译后的模板文件
				jasperReport = (JasperReport) JRLoader.loadObject(filePath);
			}
			pageWidth = String.valueOf(jasperReport.getPageWidth());
		} catch (Exception e){
			logger.error("报表文件获取宽度:",e);
		}
		return pageWidth;
	}
	
	/**
	 * 获取报表文件中的参数集合
	 * 
	 * @param filePath	 模板文件绝对路径
	 * @param type	    1返回所有参数 2返回系统参数3 返回用户自定义参数
	 */
	@Override
	public JRParameter [] getJRParameters(String filePath,String type){
		try {
			String reportTemplatetSuffix = filePath.substring(filePath.lastIndexOf(".")+1,filePath.length());//模板文件后缀名
			JasperReport jasperReport = null;
			/**step1.判断模板文件类型*/
			if(reportTemplatetSuffix.equals("jrxml")){
				//表示读取模板文件类型为JRXML还未编译的设计模板文件
				jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(new FileInputStream(new File(filePath))));
			}else {
				//表示读取模板文件类型为JASPER编译后的模板文件
				jasperReport = (JasperReport) JRLoader.loadObject(filePath);
			}
			//System.out.println("是否忽略分页:" + jasperReport.isIgnorePagination());

			System.out.println(jasperReport.getPageWidth());

			//获取模板的所有参数
			JRParameter [] parameters = jasperReport.getParameters();
			//返回系统参数
			JRParameter [] newParameters  = null;
			
			//判断用户需要获取的类型
			if(type.equals("1")){
				return parameters;
			}else if(type.equals("2")){
				newParameters = new JRParameter[19];
				for(int i = 0 ;i <= 18 ; i++){newParameters[i] = parameters[i];}
				return newParameters;
			}else{
				//返回用户自定义参数,因为系统参数默认有19个,大于19表示有自定义参数
				if(parameters.length > 19){
					newParameters = new JRParameter[parameters.length - 19];
					for(int i = 0 ;i <= newParameters.length - 1 ; i++){
						newParameters[i] = parameters[19+i];
					}
					return newParameters;
				}else{
					return null;//表示模板文件中没有自定义参数
				}
			}
		} catch (Exception e) {
			logger.error("报表导出出错:",e);
			return null;
		}
	}
	
	
	/**
	 * 生成报表jasperPrint打印对象
	 * 
	 * @param reportTemplatePath	 模板文件路径名称带后缀名(JRXML/JASPER)
	 * @param reportTemplateParams	 模板文件中定义的parameters参数map
	 * @param reportTemplateType	 模板填充方式  1.JDBC数据源 / 2.BEAN数据源
	 * @param dataSourceLst			 数据源,模板类型为BEAN数据源时传后台转换出来的LIST泛型对象
	 */
	@Override
	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	public JasperPrint createJasperPrint(String reportTemplatePath,Map reportTemplateParams,String reportTemplateType,List dataSourceLst){
		try {
			/**step1.初始化变量*/
			String filePath = reportTemplatePath;//获取模板文件绝对路径
			JRDataSource datesource = null;//数据源对象
			JasperReport jasperReport = null;//模板文件对象
			String reportTemplatetSuffix = reportTemplatePath.substring(reportTemplatePath.lastIndexOf(".")+1,reportTemplatePath.length());//模板文件后缀名
			JasperPrint jasperPrint = null;//模板填充数据后的打印对象 
			
			/**step2.判断模板文件类型*/
			if(reportTemplatetSuffix.equals("jrxml")){
				//表示读取模板文件类型为JRXML还未编译的设计模板文件
				jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(new FileInputStream(new File(filePath))));
			}else {
				//表示读取模板文件类型为JASPER编译后的模板文件
				jasperReport = (JasperReport) JRLoader.loadObject(filePath);
			}
			
			/**step3. 根据数据源类型分别填充报表模板*/
			if (reportTemplateType.equals("1")){
				//表示填充方式为JDBC,直接绑定DATASOURCE，SQL语句已经在模板中定义好了
				jasperPrint = JasperFillManager.fillReport(jasperReport, reportTemplateParams, dataSource.getConnection());
			}else{
				//表示填充方式为BEAN,数据源绑定用户传入的LIST集合
				datesource = new JRBeanCollectionDataSource(dataSourceLst);
				//填充报表模板
				jasperPrint = JasperFillManager.fillReport(jasperReport, reportTemplateParams, datesource);
			}
			
			return jasperPrint;
			
		} catch (Exception e) {
			logger.error("报表导出出错:",e);
			return null;
		}
	}
	
	/**
	 * 生成报表,导出单页sheet
	 * 
	 * @param reportTemplatePath	 模板文件路径名称带后缀名(JRXML/JASPER)
	 * @param reportTemplateParams	 模板文件中定义的parameters参数map
	 * @param reportTemplateType	 模板填充方式  1.JDBC数据源 / 2.BEAN数据源
	 * @param dataSourceLst			 数据源,模板类型为BEAN数据源时传后台转换出来的LIST泛型对象
	 * @param exportReportType		 报表文件导出之后的格式(PDF/XSL/CSV/HTML)，常量类中有配置
	 * @param exportReportName		 报表文件导出之后的文件名
	 * @param response			          报表生成后输出的介质 可以直接写入response的输出流，或者写入服务器指定文件路径输出流
	 * @param sheetName			          报表EXCEL报表后sheet名称
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public void createReportSingletonSheet(String reportTemplatePath,Map reportTemplateParams,
			String reportTemplateType,List dataSourceLst,String exportReportType,String exportReportName,HttpServletResponse response,String sheetName){
		//输出文件名
		String outputFileName = StringUtils.isNotBlank(exportReportName) ? exportReportName : DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()) + "报表文件";
		//输出文件流
		OutputStream os = null;
		try {
			/**step1.初始化变量*/
			os = response == null ? new FileOutputStream(new File(outputPath + outputFileName + "." + exportReportType)) : new BufferedOutputStream(response.getOutputStream());
			JasperPrint jasperPrint = null;
			//如果导出EXCEL则忽略分页
			if(exportReportType.equals(Constants.EXPORT_REPORT_TYPE_XLS)) reportTemplateParams.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
			jasperPrint = this.createJasperPrint(reportTemplatePath, reportTemplateParams, reportTemplateType, dataSourceLst);//模板填充数据后打印对象
			JRAbstractExporter exporter = null;//导出对象
			//List<JRPrintPage> lst = jasperPrint.getPages();//总页数

			/**导出操作*/
			if(exportReportType.equals(Constants.EXPORT_REPORT_TYPE_XLS)){
				exporter = new JRXlsExporter();//设置填充后的模板文件
				exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.FALSE);//特有属性
				exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
				exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.TRUE);
				exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);
				exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,new String[] { sheetName});
			}else if(exportReportType.equals(Constants.EXPORT_REPORT_TYPE_PDF)){
				exporter = new JRPdfExporter();
			}else if(exportReportType.equals(Constants.EXPORT_REPORT_TYPE_CSV)){
				exporter = new JRCsvExporter();
			}else if(exportReportType.equals(Constants.EXPORT_REPORT_TYPE_HTML)){
				exporter = new JRHtmlExporter();
				exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
			}
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
			//exporter.setParameter(JRExporterParameter.PAGE_INDEX,1);//分页
			exporter.exportReport();//导出
		} catch (Exception e) {
			logger.error("报表导出出错:",e);
		}finally{
			//关闭流
			try {os.close();} catch (IOException e) {logger.error("报表导出，关闭流失败:",e);}
			if(response == null) logger.info("本地导出报表文件:"+ outputFileName + "." + exportReportType +"导出成功! 文件路径为:" + outputPath + outputFileName + "." + exportReportType);
			else logger.info("服务器下载报表文件:"+ outputFileName  + "成功!");
		}
	}
	
	/**
	 * 生成报表,导出多页sheet
	 * 
	 * @param jasperPrints			 每个sheet对应的 JASPER模板填充文件
	 * @param sheetsNames		 	 每个sheet的名称
	 * @param exportReportName		 报表文件导出之后的文件名
	 * @param response			          报表生成后输出的介质 可以直接写入response的输出流，或者写入服务器指定文件路径输出流
	 */
	@Override
	public void createReportManySheet(List<JasperPrint> jasperPrints,String [] sheetsNames,String exportReportName,HttpServletResponse response){
		//输出文件名
		String outputFileName = StringUtils.isNotBlank(exportReportName) ? exportReportName : DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date()) + "报表文件.xsl";
		//输出文件流
		OutputStream os = null;
		try {
			os = response == null ? new FileOutputStream(new File(outputPath + outputFileName)) : new BufferedOutputStream(response.getOutputStream());
			/**导出操作*/
			JRXlsExporter exporter = new JRXlsExporter();//设置填充后的模板文件
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.FALSE);//删除空行
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.TRUE);//设置EXCEL为白色背景
			exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);//设置EXCEL的单元格类型
			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,jasperPrints);//此处的list为JasperPrint的list集合 
			//设置为true，即可在一个excel中，每个单独的JASPER对象放入到一个sheet页中
			//（注意true会吧一个sheet中分页的数据放在另外一个sheet中，所以还是设置为false1个sheet中的分页在一个sheet中全部显示完）
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,sheetsNames);//每个SHEET的名称
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);//输出参数
			//导出
			exporter.exportReport();
		} catch (Exception e) {
			logger.error("报表导出出错:",e);
		}finally{
			//关闭流
			try {os.close();} catch (IOException e) {logger.error("报表导出，关闭流失败:",e);}
			if(response == null) logger.info("本地导出报表文件:"+ outputFileName  +"导出成功! 文件路径为:" + outputPath + outputFileName);
			else logger.info("服务器下载报表文件:"+ outputFileName  + "成功!");
		}
	}

}
