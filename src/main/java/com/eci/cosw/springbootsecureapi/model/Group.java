package com.eci.cosw.springbootsecureapi.model;

import javafx.beans.Observable;

import java.util.ArrayList;



/**
 * Created by 2107262 on 9/6/17.
 */
public class Group {

    private long id;

    private String name;

    private User instructor;

    private ArrayList<User> students;

    private Float score;

    private ArrayList<Comment> comments;

    private String place;

    private String hour;

    private String[] days;

    private String description;

    public Group()
    {
    }

    public Group( String name, User instructor, String place, String[] days, String hour,  String description)
    {
        this.setName(name);
        this.setInstructor(instructor);
        this.setPlace(place);
        this.setHour(hour);
        this.setDays(days);
        this.setDescription(description);
        this.setComments(new ArrayList<Comment>());
    }
    public Group( String name, String place,  String[] days, String hour, String description)
    {
        this.setName(name);
        this.setPlace(place);
        this.setHour(hour);
        this.setDays(days);
        this.setDescription(description);
        this.setComments(new ArrayList<Comment>());
    }

    @Override
    public String toString()
    {
        String n = "";
        for (String a : this.days){
            n = n + a;
        }
        return "Group{" + "id=" + id + "days=" + n + "Instructor = " + instructor + "}";
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

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
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

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
