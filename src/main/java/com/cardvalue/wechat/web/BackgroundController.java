package com.cardvalue.wechat.web;

import com.cardvalue.wechat.dto.*;
import com.cardvalue.wechat.model.*;
import com.cardvalue.wechat.repository.*;
import com.cardvalue.wechat.service.*;
import com.cardvalue.wechat.util.ColumnConfig;
import com.cardvalue.wechat.util.Constants;
import com.cardvalue.wechat.util.ExcelHelper;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 后台管理
 * Created by Administrator on 2015/1/5.
 */

@Controller
@RequestMapping(value = "/background")
public class BackgroundController {

    private static final Logger logger = LoggerFactory.getLogger(BackgroundController.class);

    @Resource
    private MessageRuleService messageRuleService;

    @Resource
    private CommonService commonService;

    @Resource
    private MessageContentService messageContentService;

    @Resource
    private UserPurseRecordService userPurseRecordService;

    @Resource
    private SalesRepository salesRepository;

    @Resource
    private UserPurseRecordRepository userPurseRecordRepository;

    @Resource
    private UserAdminRepository userAdminRepository;

    @Resource
    private WeQrCodeService qrCodeService;

    @Resource
    private ParamRepository paramRepository;

    @Resource
    private WeNewActivitiesRepository weNewActivitiesRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private CommonRepository commonRepository;

    @Resource
    private UtilRepository utilRepository;

    @Resource
    private WeResidentRepository weResidentRepository;

    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "background/home";
    }

    /**
     * 账户管理
     *
     * @return
     */
    @RequestMapping(value = "/account", method = {RequestMethod.GET, RequestMethod.POST})
    public String account() {
        return "background/account/index";
    }

    /**
     * 微信配置
     *
     * @return
     */
    @RequestMapping(value = "/weixin", method = {RequestMethod.GET, RequestMethod.POST})
    public String weixin() {
        return "background/wexin/index";
    }

    /***********************************************************************************/
    /*****************************“关键字检索”模块************************************/
    /***********************************************************************************/

    /**
     * 关键字检索-初始化
     *
     * @return
     */
    @RequestMapping(value = "/rule/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initRule(String currPageNum) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/rule/list");
        mv.addObject("moduleName", "rule");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        QueryPageModel queryPageModel = commonService.queryAll(pageNum, MessageRule.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 关键字检索-分页查询
     *
     * @return
     */
    @RequestMapping(value = "/rule/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queryRule(String currPageNum) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/rule/page");
        mv.addObject("moduleName", "rule");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        QueryPageModel queryPageModel = commonService.queryAll(pageNum, MessageRule.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 关键字检索-删除
     *
     * @return
     */
    @RequestMapping(value = "/rule/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String deleteRule(String ids) {
        return commonService.delObj(ids, MessageRule.class);
    }

    /**
     * 关键字检索-新增查看
     *
     * @return
     */
    @RequestMapping(value = "/rule/new", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView newRule() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/rule/view");
        mv.addObject("moduleName", "rule");//模块名称
        return mv;
    }

    /**
     * 关键字检索-查看-修改查看
     *
     * @return
     */
    @RequestMapping(value = "/rule/view", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView viewRule(String id, String optType) {
        ModelAndView mv = new ModelAndView();
        MessageRule rule = (MessageRule) commonService.findById(id, MessageRule.class);
        mv.setViewName("/background/wexin/rule/view");
        mv.addObject("returnObj", rule);
        mv.addObject("optType", optType);
        mv.addObject("moduleName", "rule");//模块名称
        mv.addObject("responseObj", messageRuleService.getRuleResponseByTypeAndId(rule.getResponseType(), rule.getResponseId()));
        return mv;
    }

    /**
     * 关键字检索-新增提交-修改提交
     *
     * @return
     */
    @RequestMapping(value = "/rule/submit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String submitRule(MessageRuleDTO dto) {
        //提交
        return messageRuleService.submitRule(dto);
    }

    /**
     * 关键字检索-通过消息类型,获取类型关联逻辑
     *
     * @return
     */
    @RequestMapping(value = "/rule/getRuleResponseByType", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List getRuleResponseByType(String responseType) {
        //获取信息
        return messageRuleService.getRuleResponseByType(responseType);
    }


    /***********************************************************************************/
    /*****************************“关键字关联类型”模块********************************/
    /***********************************************************************************/

    /**
     * 关键字关联类型-TAB界面
     *
     * @return
     */
    @RequestMapping(value = "/messageContent/tab", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView tabMessageContent() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/messageContent/tab");
        return mv;
    }

    /**
     * 关键字关联类型-初始化
     *
     * @return
     */
    @RequestMapping(value = "/messageContent/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initMessageContent(String currPageNum, String type) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/messageContent/list");
        mv.addObject("moduleName", "messageContent");//模块名称
        mv.addObject("type", type);//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        //根据不同类型查询不同的关联类型
        Class className = null;
        if (type.equals("text")) {
            className = TextMessageContent.class;
        } else if (type.equals("news")) {
            className = NewsMessageContent.class;
        } else {
            className = FunctionMessageContent.class;
        }
        QueryPageModel queryPageModel = commonService.queryAll(pageNum, className);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 关键字关联类型-分页查询
     *
     * @return
     */
    @RequestMapping(value = "/messageContent/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queryMessageContent(String currPageNum, String type) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/messageContent/page");
        mv.addObject("moduleName", "messageContent");//模块名称
        mv.addObject("type", type);//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        //根据不同类型查询不同的关联类型
        Class className = null;
        if (type.equals("text")) {
            className = TextMessageContent.class;
        } else if (type.equals("news")) {
            className = NewsMessageContent.class;
        } else {
            className = FunctionMessageContent.class;
        }
        QueryPageModel queryPageModel = commonService.queryAll(pageNum, className);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 关键字检索-删除
     *
     * @return
     */
    @RequestMapping(value = "/messageContent/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String deleteMessageContent(String ids, String type) {
        Class className = null;
        if (type.equals("text")) {
            className = TextMessageContent.class;
        } else if (type.equals("news")) {
            className = NewsMessageContent.class;
        } else {
            className = FunctionMessageContent.class;
        }
        return commonService.delObj(ids, className);
    }

    /**
     * 关键字检索-新增查看
     *
     * @return
     */
    @RequestMapping(value = "/messageContent/new", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView newMessageContent(String type) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/messageContent/view");
        mv.addObject("type", type);
        mv.addObject("moduleName", "messageContent");//模块名称
        return mv;
    }

    /**
     * 关键字检索-查看-修改查看
     *
     * @return
     */
    @RequestMapping(value = "/messageContent/view", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView viewMessageContent(String id, String optType, String type) {
        ModelAndView mv = new ModelAndView();
        Class className = null;
        if (type.equals("text")) {
            className = TextMessageContent.class;
        } else if (type.equals("news")) {
            className = NewsMessageContent.class;
        } else {
            className = FunctionMessageContent.class;
        }
        Object messageContent = commonService.findById(id, className);
        mv.setViewName("/background/wexin/messageContent/view");
        mv.addObject("returnObj", messageContent);
        mv.addObject("optType", optType);
        mv.addObject("type", type);
        mv.addObject("moduleName", "messageContent");//模块名称
        if (type.equals("news")) {
            NewsMessageContent newsMessageContent = (NewsMessageContent) messageContent;
            if(newsMessageContent.getParentId() != null) {
                NewsMessageContent parentNode = (NewsMessageContent) commonService.findById(newsMessageContent.getParentId().toString(), NewsMessageContent.class);
                mv.addObject("parentNode", parentNode);
            }
        }
        return mv;
    }

    /**
     * 关键字检索-新增提交-修改提交
     *
     * @return
     */
    @RequestMapping(value = "/messageContent/submit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String submitMessageContent(MessageContentDTO dto) {
        //提交
        return messageContentService.submitMessageContent(dto, dto.getType());
    }

    /**
     * 关键字检索-图文消息-查询父节点
     *
     * @return
     */
    @RequestMapping(value = "/messageContent/queryParentNode", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<?> queryParentNode() {
        return commonService.queryAll(NewsMessageContent.class);
    }


    /***********************************************************************************/
    /*****************************“二维码生成”模块********************************/
    /***********************************************************************************/

    /**
     * 二维码生成-显示界面
     *
     * @return
     */
    @RequestMapping(value = "/qr/view", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView viewQrCode() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/qr/view");
        mv.addObject("moduleName", "qr");
        return mv;
    }

    /**
     * 二维码生成-新增提交-修改提交
     *
     * @return
     */
    @RequestMapping(value = "/qr/submit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String submitQr(QrCodeDTO dto) {
        try {
            //参数
            String parameter = "";
            if(StringUtils.isNotBlank(dto.getParamas())) {
                parameter = dto.getParamas();
            }/* else {
                //创建 referrer对象
                long linkId = 7961; //运营专员id
                parameter = Constants.QRCODE_PREFIX_LINK_DISTRIBUTOR + String.valueOf(linkId);
            }*/

            //生成二维码
            WeCreateQrCodeResponseDTO response = qrCodeService.createQrCode(parameter, true);
            //获取二维码图片地址链接
            String qrCodeUrl = qrCodeService.getQrCodeUrl(response.getTicket());
            return qrCodeUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /***********************************************************************************/
    /*****************************“关注回复”模块********************************/
    /***********************************************************************************/

    /**
     * 关注回复-显示界面
     *
     * @return
     */
    @RequestMapping(value = "/attentation/view", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView viewAttentation() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/attentation/view");
        mv.addObject("moduleName", "attentation");
        //查询关注的记录
        Parameter typeParam = paramRepository.findByGroupAndName("welcome_message", "type");
        Parameter idParam = paramRepository.findByGroupAndName("welcome_message", "message_id");
        if (typeParam != null && idParam != null) {
            mv.addObject("responseType", typeParam.getValue());
            mv.addObject("responseId", idParam.getValue());
        }
        return mv;
    }

    /**
     * 关注回复-新增提交-修改提交
     *
     * @return
     */
    @RequestMapping(value = "/attentation/submit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @Transactional
    public String submitAttentation(String responseType,String responseId) {
        try {
            Parameter typeParam = paramRepository.findByGroupAndName("welcome_message", "type");
            Parameter idParam = paramRepository.findByGroupAndName("welcome_message", "message_id");
            typeParam.setValue(responseType);
            idParam.setValue(responseId);
            paramRepository.save(typeParam);
            paramRepository.save(idParam);
            logger.info("修改关注提醒消息成功!");
            return "1";
        } catch (Exception e) {
            logger.error("添加关键字检索出错:", e);
            return "0";
        }
    }

    /***********************************************************************************/
    /*****************************“最新活动推送配置”模块************************************/
    /***********************************************************************************/

    /**
     * 最新活动推送配置-初始化
     *
     * @return
     */
    @RequestMapping(value = "/newActivities/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initNewActivities(String currPageNum) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/newActivities/list");
        mv.addObject("moduleName", "newActivities");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        QueryPageModel queryPageModel = commonService.queryAll(pageNum, WeNewActivities.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 最新活动推送配置-分页查询
     *
     * @return
     */
    @RequestMapping(value = "/newActivities/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queryNewActivities(String currPageNum) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/newActivities/page");
        mv.addObject("moduleName", "newActivities");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        QueryPageModel queryPageModel = commonService.queryAll(pageNum, WeNewActivities.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 最新活动推送配置-删除
     *
     * @return
     */
    @RequestMapping(value = "/newActivities/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String deleteNewActivities(String ids) {
        return commonService.delObj(ids, WeNewActivities.class);
    }

    /**
     *最新活动推送配置-新增查看
     *
     * @return
     */
    @RequestMapping(value = "/newActivities/new", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView newNewActivities() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/wexin/newActivities/view");
        mv.addObject("moduleName", "newActivities");//模块名称
        return mv;
    }

    /**
     *最新活动推送配置-查看-修改查看
     *
     * @return
     */
    @RequestMapping(value = "/newActivities/view", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView viewNewActivities(String id, String optType) {
        ModelAndView mv = new ModelAndView();
        WeNewActivities weNewActivities = (WeNewActivities) commonService.findById(id, WeNewActivities.class);
        mv.setViewName("/background/wexin/newActivities/view");
        mv.addObject("returnObj", weNewActivities);
        mv.addObject("optType", optType);
        mv.addObject("moduleName", "newActivities");//模块名称
        mv.addObject("responseObj", messageRuleService.getRuleResponseByTypeAndId(weNewActivities.getResponseType(), weNewActivities.getResponseId().toString()));
        return mv;
    }

    /**
     * 最新活动推送配置-新增提交-修改提交
     *
     * @return
     */
    @RequestMapping(value = "/newActivities/submit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String submitNewActivities(WeNewActivitiesDto dto) {
        //提交
        try {
            if(dto.getId() == null) {
                //新增，需要做排重
                if(weNewActivitiesRepository.findByUserType(dto.getUserType()) == null) {
                    //新增提交
                    WeNewActivities weNewActivities = new WeNewActivities();
                    PropertyUtils.copyProperties(weNewActivities, dto);
                    weNewActivitiesRepository.save(weNewActivities);
                    logger.info("新增|修改最新活动推送配置成功!id为:" + weNewActivities.getId());
                    return "1";
                } else {
                    return "2";//表示已经有相同的类型了
                }
            } else {
                //修改，不做排重
                WeNewActivities weNewActivities = new WeNewActivities();
                PropertyUtils.copyProperties(weNewActivities, dto);
                weNewActivitiesRepository.save(weNewActivities);
                logger.info("新增|修改最新活动推送配置成功!id为:" + weNewActivities.getId());
                return "1";
            }
        } catch (Exception e) {
            logger.error("添加最新活动推送配置出错:", e);
            return "0";
        }
    }


    /***********************************************************************************/
    /*****************************“用户提现”模块************************************/
    /***********************************************************************************/

    /**
     * 用户提现-初始化
     *
     * @return
     */
    @RequestMapping(value = "/purse/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initPurse(String currPageNum,HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/purse/list");
        mv.addObject("moduleName", "purse");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String sql = " SELECT t3.name,t2.username,t2.we_id AS weId,t.id,t.user_id AS userId,t.action,t.amount,t.balance,t.memo,t.create_date createDate,t.flag ,t.approver_name approverName" +
                     ",t4.code AS branchCode,IFNULL(t4.label,'') AS branchLabel,t5.code AS regionCode,IFNULL(t5.label,'') AS  regionLabel,t3.mobile" +
                     ",CASE" +
                     "   WHEN t.flag = '' " +
                     "   THEN  '' " +
                     "   ELSE t.reason " +
                     " END reason " +
                     " FROM user_purse_record t LEFT JOIN USER t2 ON t.user_id = t2.id LEFT JOIN sales t3 ON t2.id = t3.user_id " +
                     " LEFT JOIN master_branch t4 ON t3.branch_code = t4.code" +
                     " LEFT JOIN master_region t5 ON t3.region_code = t5.code" +
                     " WHERE t.action = 2 ";
        //判断是否为驻地专员
        if(session.getAttribute(Constants.SESSION_KEY_SALES) != null) {
            Sales sales = (Sales)session.getAttribute(Constants.SESSION_KEY_SALES);
            List<WeResident> weResidents = weResidentRepository.findByName(sales.getName());
            if(weResidents != null && weResidents.size() > 0) {
                sql += " and t4.code = " + sales.getBranchCode();//表示为驻地专员,查询改驻地专员负责地区
            }
        }

        sql += " ORDER BY t.flag ASC,t.create_date DESC ,t.user_id";//acion等于1表示系统给用户充值，2等于用户自己提现

        QueryPageModel queryPageModel = commonService.queryAll(pageNum,sql,null,UserPurseRecordModel.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 用户提现-分页查询
     *
     * @return
     */
    @RequestMapping(value = "/purse/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView querPurse(String currPageNum,HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/purse/page");
        mv.addObject("moduleName", "purse");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String sql = " SELECT t3.name,t2.username,t2.we_id AS weId,t.id,t.user_id AS userId,t.action,t.amount,t.balance,t.memo,t.create_date createDate,t.flag ,t.approver_name approverName" +
                ",t4.code AS branchCode,IFNULL(t4.label,'') AS branchLabel,t5.code AS regionCode,IFNULL(t5.label,'') AS  regionLabel,t3.mobile" +
                ",CASE" +
                "   WHEN t.flag = '' " +
                "   THEN  '' " +
                "   ELSE t.reason " +
                " END reason " +
                " FROM user_purse_record t LEFT JOIN USER t2 ON t.user_id = t2.id LEFT JOIN sales t3 ON t2.id = t3.user_id " +
                " LEFT JOIN master_branch t4 ON t3.branch_code = t4.code" +
                " LEFT JOIN master_region t5 ON t3.region_code = t5.code" +
                " WHERE t.action = 2 " ;

        //判断是否为驻地专员
        if(session.getAttribute(Constants.SESSION_KEY_SALES) != null) {
            Sales sales = (Sales)session.getAttribute(Constants.SESSION_KEY_SALES);
            List<WeResident> weResidents = weResidentRepository.findByName(sales.getName());
            if(weResidents != null && weResidents.size() > 0) {
                sql += " and t4.code = " + sales.getBranchCode();//表示为驻地专员,查询改驻地专员负责地区
            }
        }

        sql += " ORDER BY t.flag ASC,t.create_date DESC ,t.user_id";//acion等于1表示系统给用户充值，2等于用户自己提现

        QueryPageModel queryPageModel = commonService.queryAll(pageNum,sql,null,UserPurseRecordModel.class);
        mv.addObject("queryPageModel", queryPageModel);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 用户提现-导出excel
     *
     * @return
     */
    @RequestMapping(value = "/purse/export", method = {RequestMethod.GET, RequestMethod.POST})
    public void exportXlsPurse(String currPageNum,HttpServletRequest request, HttpServletResponse response,HttpSession session) {

        /**查询导出数据集合*/
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String sql = " SELECT t3.name,t2.username,t2.we_id AS weId,t.id,t.user_id AS userId,t.action,t.amount,t.balance,t.memo,DATE_FORMAT(t.create_date, '%Y-%m-%d %h:%i:%s') createDate,t.approver_name approverName," +
                " CASE" +
                "    WHEN t.flag = '0' THEN '待处理'" +
                "    WHEN t.flag = '1' THEN '已通过'" +
                "    ELSE '已驳回' " +
                " END flag," +
                "CASE" +
                "   WHEN t.flag = '' " +
                "   THEN  '' " +
                "   ELSE t.reason " +
                "END reason" +
                ",t4.code AS branchCode,IFNULL(t4.label,'') AS branchLabel,t5.code AS regionCode,IFNULL(t5.label,'') AS  regionLabel,t3.mobile" +
                " FROM user_purse_record t LEFT JOIN USER t2 ON t.user_id = t2.id LEFT JOIN sales t3 ON t2.id = t3.user_id " +
                " LEFT JOIN master_branch t4 ON t3.branch_code = t4.code" +
                " LEFT JOIN master_region t5 ON t3.region_code = t5.code" +
                " WHERE t.action = 2 " ;

        //判断是否为驻地专员
        if(session.getAttribute(Constants.SESSION_KEY_SALES) != null) {
            Sales sales = (Sales)session.getAttribute(Constants.SESSION_KEY_SALES);
            List<WeResident> weResidents = weResidentRepository.findByName(sales.getName());
            if(weResidents != null && weResidents.size() > 0) {
                sql += " and t4.code = " + sales.getBranchCode();//表示为驻地专员,查询改驻地专员负责地区
            }
        }

        sql += " ORDER BY t.flag ASC,t.create_date DESC ,t.user_id";//acion等于1表示系统给用户充值，2等于用户自己提现

        QueryPageModel queryPageModel = commonRepository.queryAll(sql,null,UserPurseRecordModel.class);


        /**初始化Excel列*/
        List<ColumnConfig> cols = new ArrayList<ColumnConfig>();

        ColumnConfig col0 = new ColumnConfig();
        col0.setHeader("姓名");
        col0.setProperty("name");

        ColumnConfig col1 = new ColumnConfig();
        col1.setHeader("省份");
        col1.setProperty("branchLabel");

        ColumnConfig col2 = new ColumnConfig();
        col2.setHeader("城市");
        col2.setProperty("regionLabel");

        ColumnConfig col3 = new ColumnConfig();
        col3.setHeader("手机");
        col3.setProperty("mobile");

        ColumnConfig col4 = new ColumnConfig();
        col4.setHeader("微信名称");
        col4.setProperty("weId");

        ColumnConfig col5 = new ColumnConfig();
        col5.setHeader("提现金额");
        col5.setProperty("amount");

        ColumnConfig col6 = new ColumnConfig();
        col6.setHeader("创建时间");
        col6.setProperty("createDate");

        ColumnConfig col7 = new ColumnConfig();
        col7.setHeader("状态");
        col7.setProperty("flag");

        ColumnConfig col8 = new ColumnConfig();
        col8.setHeader("审批人");
        col8.setProperty("approverName");

        ColumnConfig col9 = new ColumnConfig();
        col9.setHeader("审批理由");
        col9.setProperty("reason");

        cols.add(col0);
        cols.add(col1);
        cols.add(col2);
        cols.add(col3);
        cols.add(col4);
        cols.add(col5);
        cols.add(col6);
        cols.add(col7);
        cols.add(col8);
        cols.add(col9);

        //导出
        HSSFWorkbook workbook = ExcelHelper.createWorkbook();
        ServletOutputStream os = null;
        try {
            /**构建Excel的sheet*/
            HSSFSheet sheet = ExcelHelper.createSheet(workbook, "用户提现明细表");
            ExcelHelper.build(sheet, 0, 0, cols, queryPageModel.getList());

            /**设置浏览器弹出下载框*/
            response.setContentType("application/x-msdown;charset=utf-8");//IE框下载类型
            response.setHeader("Content-Disposition", "attachment;filename=\"" + new String("用户提现明细表.xls".getBytes("GBK"), "iso-8859-1") + "\"");//IE弹出下载框

            /**导出*/
            os = response.getOutputStream();
            workbook.write(os);

        } catch (Exception e) {
            logger.error("导出Excel报表出错",e);
        }finally {
            try {
                if(os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关键字检索-查看-修改查看
     *
     * @return
     */
    @RequestMapping(value = "/purse/view", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView viewPurse(String id, String optType) {
        ModelAndView mv = new ModelAndView();
        UserPurseRecord purse = userPurseRecordRepository.findOne(Long.valueOf(id));
        WeUser user = (WeUser) commonService.findById(purse.getUserId().toString(), WeUser.class);
        Sales sales = salesRepository.findByUserId(purse.getUserId());
        mv.setViewName("/background/account/purse/view");
        mv.addObject("returnObj", purse);
        mv.addObject("optType", optType);
        mv.addObject("moduleName", "rule");//模块名称
        mv.addObject("user", user);//模块名称
        mv.addObject("sales", sales);//模块名称
        mv.addObject("branchLabel", utilRepository.getBranchLabelByCode(sales.getBranchCode()));//模块名称
        mv.addObject("regionLabel", utilRepository.getRegionLabelByCode(sales.getRegionCode()));//模块名称
        return mv;
    }

    /**
     * 用户提现-审批
     *
     * @return
     */
    @RequestMapping(value = "/purse/approve", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String approvePurse(String ids,String status,String reason,HttpSession session) {
        //提交
        return userPurseRecordService.approve(ids,status,reason,session);
    }

    /***********************************************************************************/
    /*****************************“管理员配置”模块************************************/
    /***********************************************************************************/

    /**
     * 管理员配置-初始化
     *
     * @return
     */
    @RequestMapping(value = "/admin/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initAdmin(String currPageNum) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/admin/list");
        mv.addObject("moduleName", "admin");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String sql = " SELECT t.id,t.user_id userId,t.create_date createDate,t2.username FROM user_admin t LEFT JOIN USER t2 ON t.user_id = t2.id " ;
        QueryPageModel queryPageModel = commonService.queryAll(pageNum,sql,null,UserAdminModel.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 管理员配置-分页查询
     *
     * @return
     */
    @RequestMapping(value = "/admin/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queryAdmin(String currPageNum) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/admin/page");
        mv.addObject("moduleName", "admin");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String sql = " SELECT t.id,t.user_id userId,t.create_date createDate,t2.username FROM user_admin t LEFT JOIN USER t2 ON t.user_id = t2.id " ;
        QueryPageModel queryPageModel = commonService.queryAll(pageNum,sql,null,UserAdminModel.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 管理员配置-删除
     *
     * @return
     */
    @RequestMapping(value = "/admin/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String deleteAdmin(String ids) {
        return commonService.delObj(ids, UserAdmin.class);
    }

    /**
     * 管理员配置-新增查看
     *
     * @return
     */
    @RequestMapping(value = "/admin/new", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView newAdmin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/admin/view");
        mv.addObject("moduleName", "admin");//模块名称
        return mv;
    }

    /**
     * 管理员配置-查看-修改查看
     *
     * @return
     */
    @RequestMapping(value = "/admin/view", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView viewAdmin(String id, String optType) {
        ModelAndView mv = new ModelAndView();
        UserAdmin admin = (UserAdmin) commonService.findById(id, UserAdmin.class);
        WeUser user = userRepository.findById(admin.getUserId());
        mv.setViewName("/background/account/admin/view");
        mv.addObject("returnObj", admin);
        mv.addObject("user", user);
        mv.addObject("optType", optType);
        mv.addObject("moduleName", "admin");//模块名称
        return mv;
    }

    /**
     * 管理员配置-新增提交-修改提交
     *
     * @return
     */
    @RequestMapping(value = "/admin/submit", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String submitAdmin(UserAdminDTO dto) {
        try {
            if (userAdminRepository.findByUserId(dto.getUserId()) == null) {
                //提交
                UserAdmin userAdmin = new UserAdmin();
                PropertyUtils.copyProperties(userAdmin, dto);
                userAdminRepository.save(userAdmin);
                return "1";
            } else {
                return "2"; //表示已存在
            }
        } catch (Exception e) {
            return "0";
        }

    }

    /**
     * 管理员配置-选择模态窗口-查询用户-初始化
     *
     * @return
     */
    @RequestMapping(value = "/admin/modal/user/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initModalUser(String currPageNum,String targetLabelId,String targetValueId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/admin/modal/list");
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String hql = "SELECT t1 FROM WeUser t1 WHERE t1.id NOT IN (SELECT t2.id FROM UserAdmin t2)" ;
        QueryPageModel queryPageModel = commonService.queryAll(pageNum,null,hql,WeUser.class);
        mv.addObject("queryPageModel", queryPageModel);
        mv.addObject("moduleName", "admin/modal/user");//模块名称
        mv.addObject("modalTitle", "用户");//选择框模态窗体标题
        mv.addObject("targetLabelId", targetLabelId);//填充文本的对象id
        mv.addObject("targetValueId", targetValueId);//填充id的的对象的id
        return mv;
    }

    /**
     * 管理员配置-选择模态窗口-查询用户-分页查询
     *
     * @return
     */
    @RequestMapping(value = "/admin/modal/user/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queryModalUser(String currPageNum,String targetLabelId,String targetValueId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/admin/modal/page");
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String hql = "SELECT t1 FROM WeUser t1 WHERE t1.id NOT IN (SELECT t2.id FROM UserAdmin t2)" ;
        QueryPageModel queryPageModel = commonService.queryAll(pageNum,null,hql,WeUser.class);
        mv.addObject("queryPageModel", queryPageModel);
        mv.addObject("moduleName", "admin/modal/user");//模块名称
        mv.addObject("modalTitle", "用户");//选择框模态窗体标题
        mv.addObject("targetLabelId", targetLabelId);//填充文本的对象id
        mv.addObject("targetValueId", targetValueId);//填充id的的对象的id
        return mv;
    }


    /***********************************************************************************/
    /*****************************“商户密码重置”模块************************************/
    /***********************************************************************************/

    /**
     * 商户密码重置-初始化
     *
     * @return
     */
    @RequestMapping(value = "/resetPassword/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView initResetPassword(String currPageNum) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/resetPassword/list");
        mv.addObject("moduleName", "resetPassword");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String sql = " SELECT u.id,u.username,u.password,m.name,m.contact_name contactName " +
                     " FROM USER u LEFT JOIN merchant m ON u.id = m.user_id " +
                     " WHERE u.`type` = 4 ORDER BY u.username ";
        QueryPageModel queryPageModel = commonService.queryAll(pageNum, sql, null, ResetPasswordModel.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     * 商户密码重置-分页查询
     *
     * @return
     */
    @RequestMapping(value = "/resetPassword/list", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView querResetPassword(String currPageNum) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/background/account/resetPassword/page");
        mv.addObject("moduleName", "resetPassword");//模块名称
        Integer pageNum = StringUtils.isNotBlank(currPageNum) ? Integer.parseInt(currPageNum) : 1;
        String sql = " SELECT u.id,u.username,u.password,m.name,m.contact_name contactName " +
                     " FROM USER u LEFT JOIN merchant m ON u.id = m.user_id " +
                     " WHERE u.`type` = 4 ORDER BY u.username ";
        QueryPageModel queryPageModel = commonService.queryAll(pageNum, sql, null, ResetPasswordModel.class);
        mv.addObject("queryPageModel", queryPageModel);
        return mv;
    }

    /**
     *商户密码重置 - 重置操作
     *
     * @return
     */
    @RequestMapping(value = "/resetPassword/operation", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String operationResetPassword(String id,String newPassword) {
        //提交
        try {
            WeUser user = userRepository.findById(Integer.parseInt(id));
            user.setPassword(newPassword);
            userRepository.save(user);
            return "1";
        } catch (Exception e) {
            return "0";
        }
    }

}
