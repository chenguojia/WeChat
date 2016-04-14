package com.cardvalue.wechat.model;

import java.util.List;

/**
 * Created by Mr tao on 2015/6/2.
 */
public class UploadFileChildModel {
    private String layerSecond;//上级分组名称
    private String checklistId;//当前分组id
    private String abbr;//当前分组名称缩写
    private String title;//当前分组名称
    private String rfe;//补件备注说明
    private String demo;//示例图片url
    private List<UploadFileChildDetailModel> files;//分组下文件列表

    public String getLayerSecond() {
        return layerSecond;
    }

    public void setLayerSecond(String layerSecond) {
        this.layerSecond = layerSecond;
    }

    public String getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(String checklistId) {
        this.checklistId = checklistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRfe() {
        return rfe;
    }

    public void setRfe(String rfe) {
        this.rfe = rfe;
    }

    public List<UploadFileChildDetailModel> getFiles() {
        return files;
    }

    public void setFiles(List<UploadFileChildDetailModel> files) {
        this.files = files;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
}
