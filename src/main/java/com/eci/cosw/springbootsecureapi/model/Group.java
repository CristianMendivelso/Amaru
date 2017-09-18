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

    private Comment[] comments;

    private String place;

    private String hour;

    private String[] days;

    private String description;

    private String category;

    private String image;

    private float rate;

    private Integer totalVotes;

    public Group()
    {
    }

    public Group( String name, User instructor, String place, String[] days, String hour,  String description, String category, Comment[] comment, float rate, Integer totalVotes ,String image)
    {
        this.setName(name);
        this.setInstructor(instructor);
        this.setPlace(place);
        this.setHour(hour);
        this.setDays(days);
        this.setDescription(description);
        //this.setComments(new ArrayList<Comment>());
        this.comments=comment;
        this.setCategory(category);
        this.setImage(image);
        this.setRate(rate);
        this.setTotalVotes(totalVotes);
    }

    public Group( String name, String place,  String[] days, String hour, String description)
    {
        this.setName(name);
        this.setPlace(place);
        this.setHour(hour);
        this.setDays(days);
        this.setDescription(description);
        //this.setComments(new ArrayList<Comment>());
    }

    @Override
    public String toString()
    {
        String n = "";
        for (String a : this.days){
            n = n + a;
        }
        return "Group{" + "id=" + id + "days=" + n + "Category= " + category + "Instructor = " + instructor + "}";
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

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    //public void addComment(Comment comment){ this.comments.add(comment); }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }
}
