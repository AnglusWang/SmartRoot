package com.angluswang.smartrobot.bean;

/**
 * Created by Jeson on 2016/6/16.
 * 用于映射服务器返回的内容
 */

public class Result {
    private int code;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
