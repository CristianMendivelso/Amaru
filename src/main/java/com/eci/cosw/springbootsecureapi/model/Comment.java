package com.eci.cosw.springbootsecureapi.model;

/**
 * Created by 2106088 on 9/6/17.
 */
public class Comment {

    private String text;
    private String groupName;
    private String user;

    public Comment() {
    }

    public Comment(String text, String user, String groupName) {
        this.text = text;
        this.groupName = groupName;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
