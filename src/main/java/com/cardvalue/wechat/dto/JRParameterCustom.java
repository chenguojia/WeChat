package com.cardvalue.wechat.dto;

import com.cardvalue.wechat.model.Parameter;

import java.util.List;
import java.util.Map;

/**
 * 自定义的报表参数对象
 */
public class JRParameterCustom {

    private String name;//参数name

    private String description;//参数中文名称

    private String valueClassName;//参数类型

    private Map<String,String> properties;//参数属性

    private List<Parameter> parameters;//下拉框值集

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValueClassName() {
        return valueClassName;
    }

    public void setValueClassName(String valueClassName) {
        this.valueClassName = valueClassName;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
