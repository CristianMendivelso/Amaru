package com.eci.cosw.springbootsecureapi.model;

/**
 * Created by 2106088 on 9/6/17.
 */
public class Comment {

    private String text;
    private long groupId;
    private String user;
    private String date;

    public Comment() {
    }

    public Comment(String text, long groupId, String user, String date) {
        this.text = text;
        this.groupId = groupId;
        this.user = user;
        this.date = date;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}