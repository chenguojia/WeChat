package com.cardvalue.wechat.service;

import com.cardvalue.wechat.dto.MessageContentDTO;

/**
 * Created by Mr tao on 2015/1/8.
 */
public interface MessageContentService {
    public String submitMessageContent(MessageContentDTO dto,String type);
}
