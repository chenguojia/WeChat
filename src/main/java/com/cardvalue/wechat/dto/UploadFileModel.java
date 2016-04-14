package com.cardvalue.wechat.dto;

/**
 * Created by Mr tao on 2015/5/29.
 */
public class UploadFileModel {
    private String url;//图片访问地址
    private String name;//图片名称
    private String suffix;//图片后缀名
    private float width;//图片宽度
    private float height;//图片高度
    private Double size;//图片大小,k单位

    public UploadFileModel() {
    }

    public UploadFileModel(String url, String name, String suffix, float width, float height, Double size) {
        this.url = url;
        this.name = name;
        this.suffix = suffix;
        this.width = width;
        this.height = height;
        this.size = size;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
