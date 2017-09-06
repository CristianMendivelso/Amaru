package com.eci.cosw.springbootsecureapi.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 2107262 on 9/6/17.
 */
public class Group {
    private long id;

    private String name;

    private User instructor;

    private ArrayList<User> students;

    private Float score;

    //private ArrayList<Comment>Comment comments;

    private String place;

    private Date hour;

    private String[] days;

    private String description;

    public Group()
    {
    }

    public Group( String name, User instructor, String place, Date hour, String[] days, String description)
    {
        this.setName(name);
        this.setInstructor(instructor);
        this.setPlace(place);
        this.setHour(hour);
        this.setDays(days);
        this.setDescription(description);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public ArrayList<User> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String[] getDays() {
        return days;
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
