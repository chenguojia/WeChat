package com.cardvalue.wechat.model;

import java.util.List;

/**
 * Created by Mr tao on 2015/6/2.
 */
public class UploadFileRootModel {
    private String title;//根分组名称
    private List<UploadFileMainModel> items;//分组下元素

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<UploadFileMainModel> getItems() {
        return items;
    }

    public void setItems(List<UploadFileMainModel> items) {
        this.items = items;
    }
}
