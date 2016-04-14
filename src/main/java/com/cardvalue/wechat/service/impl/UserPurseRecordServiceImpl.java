package com.cardvalue.wechat.service.impl;

import com.cardvalue.wechat.model.Sales;
import com.cardvalue.wechat.model.UserPurseRecord;
import com.cardvalue.wechat.model.WeUser;
import com.cardvalue.wechat.repository.UserPurseRecordRepository;
import com.cardvalue.wechat.service.CommonService;
import com.cardvalue.wechat.service.UserPointService;
import com.cardvalue.wechat.service.UserPurseRecordService;
import com.cardvalue.wechat.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Mr tao on 2015/1/9.
 */
@Service(value = "userPurseRecordService")
public class UserPurseRecordServiceImpl implements UserPurseRecordService {

    private static final Logger logger = LoggerFactory.getLogger(UserPurseRecordServiceImpl.class);

    @Resource
    private UserPurseRecordRepository userPurseRecordRepository;

    @Resource
    private UserPointService userPointService;

    @Resource
    private CommonService commonService;

    /**
     * 审批
     * @param ids
     * @param status
     * @param reason
     * @return
     */
    @Override
    @Transactional
    public String approve(String ids, String status, String reason,HttpSession session) {
        //获取审批人
        String approveName = "";
        WeUser user = (WeUser) session.getAttribute(Constants.SESSION_KEY_USER);
        approveName = "管理员:" + user.getUsername();
        if(session.getAttribute(Constants.SESSION_KEY_SALES) != null) {
            Sales sales = (Sales) session.getAttribute(Constants.SESSION_KEY_SALES);
            approveName = sales.getName();
        }
        try {
            if (StringUtils.isNotBlank(status)) {
                if (status.equals("1")) {
                    //通过
                    String [] idArr = ids.split(",");
                    for (String id : idArr) {
                        UserPurseRecord userPurseRecord = userPurseRecordRepository.findOne(Long.valueOf(id));//可以批量通过
                        userPurseRecord.setFlag(1);//设置状态为已通过
                        //设置审批相关字段
                        userPurseRecord.setApproverUserId(user.getId());
                        userPurseRecord.setApproverName(approveName);
                        userPurseRecord.setApproverDate(new Date());
                        userPurseRecord.setReason("");
                        userPurseRecordRepository.save(userPurseRecord);//修改当前记录
                        logger.info("用户提现记录审批已通过，id为:" + userPurseRecord.getId());
                    }
                    return "1";
                } else {
                    //驳回
                    UserPurseRecord userPurseRecord = userPurseRecordRepository.findOne(Long.valueOf(ids));//只能单条记录驳回
                    userPointService.addBalance(userPurseRecord.getUserId(), userPurseRecord.getAmount(),reason);//将金额返回原用户
                    userPurseRecord.setFlag(2);//设置状态为已驳回
                    //设置审批相关字段
                    userPurseRecord.setApproverUserId(user.getId());
                    userPurseRecord.setApproverName(approveName);
                    userPurseRecord.setApproverDate(new Date());
                    userPurseRecord.setReason(reason);
                    userPurseRecordRepository.save(userPurseRecord);//修改当前记录
                    logger.info("用户提现记录审批已驳回，id为:" + userPurseRecord.getId());
                    return "1";
                }
            } else {
                return "0";
            }
        } catch (Exception e) {
            logger.error("审批出现异常:", e);
            return "0";
        }
    }

}
