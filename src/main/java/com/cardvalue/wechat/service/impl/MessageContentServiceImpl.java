package com.cardvalue.wechat.service.impl;

import com.cardvalue.wechat.dto.MessageContentDTO;
import com.cardvalue.wechat.repository.MessageContentRepository;
import com.cardvalue.wechat.service.MessageContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Mr tao on 2015/1/8.
 */
@Service(value = "messageContentService")
public class MessageContentServiceImpl implements MessageContentService {

    @Resource
    private MessageContentRepository messageContentRepository;

    @Override
    @Transactional
    public String submitMessageContent(MessageContentDTO dto, String type) {
        String result = messageContentRepository.submitMessageContent(dto,type);
        return result;
    }
}
