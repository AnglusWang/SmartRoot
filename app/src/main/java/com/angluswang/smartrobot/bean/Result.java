package com.angluswang.smartrobot.bean;

/**
 * Created by Jeson on 2016/6/16.
 * 用于映射服务器返回的内容
 */

public class Result {
    private int mCode;
    private String mText;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }
}
