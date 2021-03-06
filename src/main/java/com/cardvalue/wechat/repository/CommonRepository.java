package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.dto.QueryPageModel;

import java.util.List;

/**
 * 共有的Repository
 * Created by Mr tao on 2015/1/8.
 */
public interface CommonRepository {

    public QueryPageModel queryAll(Integer currPageNum, Class<?> cla);

    public QueryPageModel queryAll(String sql, String hql, Class<?> cla);

    public List<?> queryAll(Class<?> cla);

    public String delObj(String ids, Class<?> cla);

    public Object findById(String id, Class<?> cla);

    public QueryPageModel queryAll(Integer currPageNum, String sql, String hql, Class<?> cla);
}
