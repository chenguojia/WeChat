package com.cardvalue.wechat.service;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperPrint;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface ReportService {

	/**
	 * 获取报表文件的宽度
	 *
	 * @param filePath	 模板文件绝对路径
	 */
	public String getPageWidth(String filePath);

	/**
	 * 生成报表jasperPrint打印对象
	 * 
	 * @param reportTemplatePath	 模板文件路径名称带后缀名(JRXML/JASPER)
	 * @param reportTemplateParams	 模板文件中定义的parameters参数map
	 * @param reportTemplateType	 模板填充方式  1.JDBC数据源 / 2.BEAN数据源
	 * @param dataSourceLst			 数据源,模板类型为BEAN数据源时传后台转换出来的LIST泛型对象
	 */
	public JasperPrint createJasperPrint(String reportTemplatePath,
										 Map reportTemplateParams, String reportTemplateType,
										 List dataSourceLst);

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
	public void createReportSingletonSheet(String reportTemplatePath,
										   Map reportTemplateParams, String reportTemplateType,
										   List dataSourceLst, String exportReportType,
										   String exportReportName, HttpServletResponse response, String sheetName);
	
	/**
	 * 生成报表,导出多页sheet
	 * 
	 * @param jasperPrints			 每个sheet对应的 JASPER模板填充文件
	 * @param sheetsNames		 	 每个sheet的名称
	 * @param exportReportName		 报表文件导出之后的文件名
	 * @param response			          报表生成后输出的介质 可以直接写入response的输出流，或者写入服务器指定文件路径输出流
	 */
	public void createReportManySheet(List<JasperPrint> jasperPrints,
									  String[] sheetsNames, String exportReportName,
									  HttpServletResponse response);

	/**
	 * 获取报表文件中的参数集合
	 * 
	 * @param filePath	 模板文件绝对路径
	 * @param type	    1返回所有参数 2返回系统参数3 返回用户自定义参数
	 */
	public JRParameter[] getJRParameters(String filePath, String type);

}
