package com.cardvalue.wechat.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mr tao on 2015/3/12.
 */
@Entity
@Table(name="we_resident")
public class WeResident implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="province_name")
    private String provinceName;

    @Column
    private String name;

    @Column
    private String enable;

    @Column(name="user_id")
    private String userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
