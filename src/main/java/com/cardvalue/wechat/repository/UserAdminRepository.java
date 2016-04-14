package com.cardvalue.wechat.repository;

import com.cardvalue.wechat.model.UserAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr tao on 2015/1/12.
 */
@Repository(value = "userAdminRepository")
public interface UserAdminRepository extends CrudRepository<UserAdmin,Integer> {
    public UserAdmin findByUserId(Integer userId);
}
