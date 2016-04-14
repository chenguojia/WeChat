package com.cardvalue.wechat.service.impl;

import com.cardvalue.wechat.dto.QueryPageModel;
import com.cardvalue.wechat.repository.CommonRepository;
import com.cardvalue.wechat.service.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Mr tao on 2015/1/8.
 */
@Service(value = "commonService")
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonRepository commonRepository;

    @Override
    public QueryPageModel queryAll(Integer currPageNum, Class<?> cla) {
        return commonRepository.queryAll(currPageNum,cla);
    }

    @Override
    public QueryPageModel queryAll(Integer currPageNum, String sql, String hql, Class<?> cla) {
        return commonRepository.queryAll(currPageNum,sql,hql,cla);
    }

    @Override
    public List<?> queryAll(Class<?> cla) {
        return commonRepository.queryAll(cla);
    }

    @Override
    @Transactional
    public String delObj(String ids, Class<?> cla) {
        String result = commonRepository.delObj(ids, cla);
        return result;
    }

    @Override
    public Object findById(String id, Class<?> cla) {
        return commonRepository.findById(id, cla);
    }


}
