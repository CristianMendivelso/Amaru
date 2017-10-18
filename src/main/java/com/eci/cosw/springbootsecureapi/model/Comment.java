package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 2106088 on 9/6/17.
 */
@Entity
@Table(name = "comment" )
public class Comment {

    private String text;
    private long groupId;
    private String user;
    private String date;
    private long id;

    public Comment() {
    }

    public Comment(String text, long groupId, String user, String date,long id) {
        this.text = text;
        this.groupId = groupId;
        this.user = user;
        this.date = date;
        this.id=id;
    }

    @Column(name = "text", nullable = false, length = 1000)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //@Column(name = "Groupid", nullable = false)
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "user", nullable = false, length = 100)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Column(name = "date", nullable = false, length = 100)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Id
    @Column(name = "id", nullable = false, length = 100)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}