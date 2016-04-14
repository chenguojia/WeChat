package com.cardvalue.wechat.service;

import com.cardvalue.wechat.model.WeUser;

import javax.servlet.http.HttpSession;

/**
 * Created by Mr tao on 2015/1/9.
 */
public interface UserPurseRecordService {
    public String approve(String ids, String status, String reason,HttpSession session);
}
