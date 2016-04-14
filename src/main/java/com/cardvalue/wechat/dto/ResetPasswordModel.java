package com.cardvalue.wechat.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Mr tao on 2015/2/9.
 */

@Entity
public class ResetPasswordModel {

    @Id
    private Long id;

    private String username;

    private String password;

    private String name;

    private String contactName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
