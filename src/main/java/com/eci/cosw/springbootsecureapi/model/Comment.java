package com.eci.cosw.springbootsecureapi.model;

/**
 * Created by 2106088 on 9/6/17.
 */
public class Comment {

    private String text;
    private String user;
    private boolean date;

    public Comment() {
    }

    public Comment(String text, String user, boolean date) {
        this.text = text;
        this.user = user;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isDate() {
        return date;
    }

    public void setDate(boolean date) {
        this.date = date;
    }
}

