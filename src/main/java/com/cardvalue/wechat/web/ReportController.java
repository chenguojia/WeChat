package com.cardvalue.wechat.web;

import com.cardvalue.wechat.dto.JRParameterCustom;
import com.cardvalue.wechat.model.Merchant;
import com.cardvalue.wechat.model.Parameter;
import com.cardvalue.wechat.model.Report;
import com.cardvalue.wechat.repository.ParamRepository;
import com.cardvalue.wechat.repository.ReportRepository;
import com.cardvalue.wechat.service.ReportService;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.Utility;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/report")
@SessionAttributes({Constants.SESSION_KEY_USER, Constants.SESSION_KEY_MERCHANT})
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(MerchantUserController.class);

    @Resource
    public ReportService reportService;

    @Resource
    public ReportRepository reportRepository;

    @Resource
    public ParamRepository paramRepository;


    /**
     * 报表功能首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = {RequestMethod.GET,RequestMethod.POST})
    public String home() {
        return "/background/report/report-home";
    }

    /**
     * 加载左边所有报表列表
     *
     * @return
     */
    @RequestMapping(value = "/loadAllReportTempls", method = {RequestMethod.GET})
    @ResponseBody
    public List<Report> loadAllReportTempls() {
        List<Report> reports = new ArrayList<Report>();
        Iterator<Report> iter = reportRepository.findAll().iterator();
        while (iter.hasNext()) {
            Report report = iter.next();
            reports.add(report);
        }
        return reports;
    }

    /**
     * 加载选中报表的参数
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loadReportParams", method = {RequestMethod.GET})
    @ResponseBody
    public  List<JRParameterCustom>  loadReportParams(String id) throws Exception {
        Report report = reportRepository.findById(Integer.valueOf(id));
        //动态获取模板参数
        JRParameter[] jrpParameters = reportService.getJRParameters(report.getPath(), "3");
        //存储改变后的集合
        List<JRParameterCustom> parameterCustoms = new ArrayList<JRParameterCustom>();
        //将参数对象装换成制定的对象
        for(JRParameter jrParameter : jrpParameters){
            JRParameterCustom jRParameterCustom = new JRParameterCustom();
            jRParameterCustom.setName(jrParameter.getName());
            jRParameterCustom.setDescription(jrParameter.getDescription());
            jRParameterCustom.setValueClassName(jrParameter.getValueClassName());
            if(jrParameter.getPropertiesMap() != null){
                Map<String,String> properties = new HashMap<String, String>();
                for (String key : jrParameter.getPropertiesMap().getPropertyNames()){
                    properties.put(key,jrParameter.getPropertiesMap().getProperty(key));
                }
                jRParameterCustom.setProperties(properties);
            }
            if(StringUtils.isNotBlank(jrParameter.getPropertiesMap().getProperty("selectEnum"))){
                //表示是下拉框，获取值集设置对象中
                List<Parameter> parameters = paramRepository.findByGroup(jrParameter.getPropertiesMap().getProperty("selectEnum"));
                jRParameterCustom.setParameters(parameters);
            }
            parameterCustoms.add(jRParameterCustom);
        }
       logger.info("报表参数集合转json为:" +  new ObjectMapper().writeValueAsString(parameterCustoms));
        return parameterCustoms;
    }


    /**
     * 加载左边所有报表列表
     *
     * @return
     */
    @RequestMapping(value = "/getPageWidth", method = {RequestMethod.GET})
    @ResponseBody
    public String getPageWidth(String id) {
        Report report = reportRepository.findById(Integer.valueOf(id));
        return reportService.getPageWidth(report.getPath());
    }

    /**
     * 导出单个报表详情
     *
     * @param id
     * @param request
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/exportReport", method = {RequestMethod.POST})
    public void exportReport(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Report report = reportRepository.findById(Integer.valueOf(id));
        //动态获取模板参数
        JRParameter[] parameters = reportService.getJRParameters(report.getPath(), "3");

        /**初始化参数*/
        Map map = new HashMap();
        if (parameters != null) {
            for (JRParameter jrParameter : parameters) {
                //判断类型
                if (jrParameter.getValueClassName().equals("java.util.Date")) {
                    //表示Date类型参数
                    map.put(jrParameter.getName(), new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter(jrParameter.getName())));
                } else {
                    //表示非Date类型参数，判断参数是否设置like属性
                    if (jrParameter.getPropertiesMap().getProperty("isLike") != null && jrParameter.getPropertiesMap().getProperty("isLike").equals("1")) {
                        map.put(jrParameter.getName(), "%" + request.getParameter(jrParameter.getName()) + "%");//表示此参数是模糊查询
                    } else if (jrParameter.getPropertiesMap().getProperty("isWhereSql") != null && jrParameter.getPropertiesMap().getProperty("isWhereSql").equals("1")) {
                        //判断用户前台输入此参数的值是否为空，如果不为空则拼接SQL
                        if(StringUtils.isNotBlank(request.getParameter(jrParameter.getName()))){
                            String whereNameCondition = jrParameter.getPropertiesMap().getProperty("whereNameCondition");
                            map.put(jrParameter.getName(), whereNameCondition + "'" + request.getParameter(jrParameter.getName()) + "'");//表此字段是拼接条SQL的字段,可以有也可以没有
                        }else{
                            //前端没有输入值，查询所有
                            map.put(jrParameter.getName(), " and 1=1 ");
                        }
                    } else {
                        map.put(jrParameter.getName(), "'" + request.getParameter(jrParameter.getName()) + "'");//表示一般Sting类型参数
                    }
                }
            }
        }

        /**设置浏览器弹出下载框*/
        String exportReportName = report.getName() + "." + Constants.EXPORT_REPORT_TYPE_XLS;//导出文件名
        /**设置浏览器弹出下载框*/
        response.setContentType("application/x-msdown;charset=utf-8");//IE框下载类型
        response.setHeader("Content-Disposition", "attachment;filename=\"" + new String(exportReportName.getBytes("GBK"), "iso-8859-1") + "\"");//IE弹出下载框

        /**导出*/
        reportService.createReportSingletonSheet(report.getPath(), map, "1", null, Constants.EXPORT_REPORT_TYPE_XLS, exportReportName, response, "sheet1");
    }

    /**
     * 预览单个报表详情
     *
     * @param id
     * @param request
     * @throws Exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/previewReport", method = {RequestMethod.POST})
    public void previewReport(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Report report = reportRepository.findById(Integer.valueOf(id));
        //动态获取模板参数
        JRParameter[] parameters = reportService.getJRParameters(report.getPath(), "3");

        /**初始化参数*/
        Map map = new HashMap();
        if (parameters != null) {
            for (JRParameter jrParameter : parameters) {
                //判断类型
                if (jrParameter.getValueClassName().equals("java.util.Date")) {
                    //表示Date类型参数
                    map.put(jrParameter.getName(), new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter(jrParameter.getName())));
                } else {
                    //表示非Date类型参数，判断参数是否设置like属性
                    if (jrParameter.getPropertiesMap().getProperty("isLike") != null && jrParameter.getPropertiesMap().getProperty("isLike").equals("1")) {
                        map.put(jrParameter.getName(), "%" + request.getParameter(jrParameter.getName()) + "%");//表示此参数是模糊查询
                    } else if (jrParameter.getPropertiesMap().getProperty("isWhereSql") != null && jrParameter.getPropertiesMap().getProperty("isWhereSql").equals("1")) {
                        //判断用户前台输入此参数的值是否为空，如果不为空则拼接SQL
                        if(StringUtils.isNotBlank(request.getParameter(jrParameter.getName()))){
                            String whereNameCondition = jrParameter.getPropertiesMap().getProperty("whereNameCondition");
                            map.put(jrParameter.getName(), whereNameCondition + "'" + request.getParameter(jrParameter.getName()) + "'");//表此字段是拼接条SQL的字段,可以有也可以没有
                        }else{
                            //前端没有输入值，查询所有
                            map.put(jrParameter.getName(), " and 1=1 ");
                        }
                    } else {
                        map.put(jrParameter.getName(), "'" + request.getParameter(jrParameter.getName()) + "'");//表示一般Sting类型参数
                    }
                }
            }
        }

        String exportReportName = report.getName() + "." + Constants.EXPORT_REPORT_TYPE_HTML;//导出文件名
        /**设置浏览器预览*/
        response.setContentType("text/html;charset=utf-8");//IE框下载类型

        /**导出*/
        reportService.createReportSingletonSheet(report.getPath(), map, "1", null, Constants.EXPORT_REPORT_TYPE_HTML, exportReportName, response, "sheet1");
    }


    /**
     * 导出 '微信平台每日统计报告'
     *
     * @param response
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes"})
    @RequestMapping(value = "/dailyReport", method = {RequestMethod.GET})
    public void dailyReport(HttpServletResponse response) throws Exception {

        /**初始化参数*/
        Map map = new HashMap();//模板中的参数
        String exportReportName = "微信平台每日统计报告(" + Utility.formatLongDate(new Date()) + ")" + "." + Constants.EXPORT_REPORT_TYPE_XLS;//导出文件名

        /**设置浏览器弹出下载框*/
        response.setContentType("application/x-msdown;charset=utf-8");//IE框下载类型
        response.setHeader("Content-Disposition", "attachment;filename=\"" + new String(exportReportName.getBytes("GBK"), "iso-8859-1") + "\"");//IE弹出下载框

        /**导出多sheet*/
        List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();//组装多个sheet的报表填充对象
        jasperPrints.add(reportService.createJasperPrint("loggedSales.jrxml", map, "1", null));
        jasperPrints.add(reportService.createJasperPrint("notLoggedSales.jrxml", map, "1", null));
        jasperPrints.add(reportService.createJasperPrint("loggedSalesInBranch.jrxml", map, "1", null));
        jasperPrints.add(reportService.createJasperPrint("loggedSalesInDate.jrxml", map, "1", null));
        //设置多个sheet的名字
        String[] sheetNames = {"已登录客户经理列表", "未登录客户经理列表", "按分支机构统计", "按登录日期统计"};

        //导出
        reportService.createReportManySheet(jasperPrints, sheetNames, exportReportName, response);

    }

    /**
     * 导出 '微信平台客户经理积分统计报告'
     *
     * @param response
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/pointSummaryReport", method = {RequestMethod.GET})
    public void pointSummaryReport(HttpServletResponse response) throws Exception {

        /**初始化参数*/
        Map map = new HashMap();
        map.put("auther", "taoxin");
        String exportReportName = "微信平台客户经理积分统计报告" + "." + Constants.EXPORT_REPORT_TYPE_XLS;//导出文件名

        /**设置浏览器弹出下载框*/
        response.setContentType("application/x-msdown;charset=utf-8");//IE框下载类型
        response.setHeader("Content-Disposition", "attachment;filename=\"" + new String(exportReportName.getBytes("GBK"), "iso-8859-1") + "\"");//IE弹出下载框

        /**导出*/
        reportService.createReportSingletonSheet("salesPointSummaries.jrxml", map, "1", null, Constants.EXPORT_REPORT_TYPE_XLS, exportReportName, response, "积分统计");
    }


    /***
     * 以下方法都为例子
     */


    /**
     * JDBC方式(单个sheet导出)测试创建报表
     *
     * @param response
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/testCreateReportJdbc", method = {RequestMethod.GET})
    public void testCreateReportJdbc(HttpServletResponse response) throws Exception {

        /**初始化参数*/
        Map map = new HashMap();
        map.put("auther", "taoxin");
        String exportReportName = "2014商户报表" + "." + Constants.EXPORT_REPORT_TYPE_XLS;//导出文件名

        /**设置浏览器弹出下载框*/
        response.setContentType("application/x-msdown;charset=utf-8");//IE框下载类型
        response.setHeader("Content-Disposition", "attachment;filename=\"" + new String(exportReportName.getBytes("GBK"), "iso-8859-1") + "\"");//IE弹出下载框

        /**导出*/
        reportService.createReportSingletonSheet("d:/reportTemplate/merchantjdbc.jasper", map, "1", null, Constants.EXPORT_REPORT_TYPE_XLS, exportReportName, response, "sheet1");
    }

    /**
     * JDBC方式(多个sheet导出)测试创建报表
     *
     * @param response
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/testCreateReportJdbcManySheet", method = {RequestMethod.GET})
    public void testCreateReportJdbcManySheet(HttpServletResponse response) throws Exception {

        /**初始化参数*/
        Map map = new HashMap();
        map.put("auther", "taoxin");
        String exportReportName = "多张sheet商户表" + "." + Constants.EXPORT_REPORT_TYPE_XLS;//导出文件名

        /**设置浏览器弹出下载框*/
        response.setContentType("application/x-msdown;charset=utf-8");//IE框下载类型
        response.setHeader("Content-Disposition", "attachment;filename=\"" + new String(exportReportName.getBytes("GBK"), "iso-8859-1") + "\"");//IE弹出下载框

        /**导出多sheet*/

        //组装多个sheet的报表填充对象
        List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();
        jasperPrints.add(reportService.createJasperPrint("d:/reportTemplate/merchantjdbc.jasper", map, "1", null));
        jasperPrints.add(reportService.createJasperPrint("d:/reportTemplate/merchantjdbc.jasper", map, "1", null));
        jasperPrints.add(reportService.createJasperPrint("d:/reportTemplate/merchantjdbc.jasper", map, "1", null));
        jasperPrints.add(reportService.createJasperPrint("d:/reportTemplate/merchantjdbc.jasper", map, "1", null));

        //设置多个sheet的名字
        String[] sheetNames = {"sheet1", "sheet2", "sheet3", "sheet4"};

        //导出
        reportService.createReportManySheet(jasperPrints, sheetNames, exportReportName, response);

    }

    /**
     * BEAN方式(单个sheet导出)测试创建报表
     *
     * @param response
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/testCreateReportBean", method = {RequestMethod.GET})
    public void testCreateReportBean(HttpServletResponse response) throws Exception {

        /**初始化参数*/
        List<Merchant> list = new ArrayList<Merchant>();//初始化显示集合
        list.add(new Merchant("123456789123451", "张三1", "18600125680"));
        list.add(new Merchant("123456789123452", "张三2", "18600125681"));
        list.add(new Merchant("123456789123453", "张三3", "18600125682"));
        list.add(new Merchant("123456789123454", "张三4", "18600125683"));
        list.add(new Merchant("123456789123455", "张三5", "18600125684"));
        list.add(new Merchant("123456789123456", "张三6", "18600125685"));
        list.add(new Merchant("123456789123456", "张三7", "18600125685"));
        list.add(new Merchant("123456789123456", "张三8", "18600125685"));
        list.add(new Merchant("123456789123456", "张三9", "18600125685"));
        list.add(new Merchant("123456789123456", "张三10", "18600125685"));
        Map map = new HashMap();//初始化参数
        map.put("auther", "taoxin");
        String exportReportName = "2014商户报表" + "." + Constants.EXPORT_REPORT_TYPE_XLS;//导出文件名

        /**设置浏览器弹出下载框*/
        response.setContentType("application/x-msdown;charset=utf-8");//IE框下载类型
        response.setHeader("Content-Disposition", "attachment;filename=\"" + new String(exportReportName.getBytes("GBK"), "iso-8859-1") + "\"");//IE弹出下载框

        /**导出*/
        reportService.createReportSingletonSheet("d:/reportTemplate/merchantRep.jasper", map, "2", list, Constants.EXPORT_REPORT_TYPE_XLS, exportReportName, response, "sheet1");
    }

    /**
     * BEAN方式(多个sheet导出)测试创建报表
     *
     * @param response
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/testCreateReportBeanManySheet", method = {RequestMethod.GET})
    public void testCreateReportBeanManySheet(HttpServletResponse response) throws Exception {

        /**初始化参数*/
        List<Merchant> list = new ArrayList<Merchant>();//初始化显示集合
        list.add(new Merchant("123456789123451", "张三1", "18600125680"));
        list.add(new Merchant("123456789123452", "张三2", "18600125681"));
        list.add(new Merchant("123456789123453", "张三3", "18600125682"));
        list.add(new Merchant("123456789123454", "张三4", "18600125683"));
        list.add(new Merchant("123456789123455", "张三5", "18600125684"));
        list.add(new Merchant("123456789123456", "张三6", "18600125685"));
        list.add(new Merchant("123456789123456", "张三7", "18600125685"));
        list.add(new Merchant("123456789123456", "张三8", "18600125685"));
        list.add(new Merchant("123456789123456", "张三9", "18600125685"));
        list.add(new Merchant("123456789123456", "张三10", "18600125685"));
        Map map = new HashMap();//初始化参数
        map.put("auther", "taoxin");
        String exportReportName = "2014商户报表" + "." + Constants.EXPORT_REPORT_TYPE_XLS;//导出文件名

        /**设置浏览器弹出下载框*/
        response.setContentType("application/x-msdown;charset=utf-8");//IE框下载类型
        response.setHeader("Content-Disposition", "attachment;filename=\"" + new String(exportReportName.getBytes("GBK"), "iso-8859-1") + "\"");//IE弹出下载框


        /**导出多sheet*/

        //组装多个sheet的报表填充对象
        List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();
        jasperPrints.add(reportService.createJasperPrint("d:/reportTemplate/merchantRep.jasper", map, "2", list));
        jasperPrints.add(reportService.createJasperPrint("d:/reportTemplate/merchantRep.jasper", map, "2", list));
        jasperPrints.add(reportService.createJasperPrint("d:/reportTemplate/merchantRep.jasper", map, "2", list));
        jasperPrints.add(reportService.createJasperPrint("d:/reportTemplate/merchantRep.jasper", map, "2", list));

        //设置多个sheet的名字
        String[] sheetNames = {"sheet1", "sheet2", "sheet3", "sheet4"};

        //导出
        reportService.createReportManySheet(jasperPrints, sheetNames, exportReportName, response);

    }

}
