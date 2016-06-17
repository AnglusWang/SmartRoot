package com.angluswang.smartrobot.bean;

import java.util.Date;

/**
 * Created by Jeson on 2016/6/16.
 * 聊天信息类
 */

public class ChatMessage {
    private String mName;
    private String mMsg;
    private Type mType;
    private Date mDate;

    public ChatMessage() {
    }

    public ChatMessage(String msg, Type type, Date date) {
        mMsg = msg;
        mType = type;
        mDate = date;
    }

    public enum Type {
        INCOMING, OUTCOMING
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
