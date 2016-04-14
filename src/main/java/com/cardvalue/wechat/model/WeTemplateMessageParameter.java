package com.cardvalue.wechat.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mr tao on 2015/3/12.
 */
@Entity
@Table(name="we_template_message_parameter")
public class WeTemplateMessageParameter implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="temp_id")
    private Integer tempId;

    @Column
    private String name;

    @Column
    private String memo;

    @Column
    private String color;

    @Column
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
