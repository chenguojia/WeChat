package com.cardvalue.wechat.model;

/**
 * Created by Mr tao on 2015/6/2.
 */
public class UploadFileMainModel {
    private String title;
    private String lackFiles;//缺少上传照片数量

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLackFiles() {
        return lackFiles;
    }

    public void setLackFiles(String lackFiles) {
        this.lackFiles = lackFiles;
    }
}
