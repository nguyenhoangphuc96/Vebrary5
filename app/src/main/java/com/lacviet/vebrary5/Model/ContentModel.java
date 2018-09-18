package com.lacviet.vebrary5.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentModel {

    @SerializedName("Type")
    @Expose
    private Integer type;
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("Order")
    @Expose
    private Integer order;

    public ContentModel(Integer type, String value, Integer order) {
        this.type = type;
        this.value = value;
        this.order = order;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}