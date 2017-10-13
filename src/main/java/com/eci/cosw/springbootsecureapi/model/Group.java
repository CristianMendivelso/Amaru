package com.eci.cosw.springbootsecureapi.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 2107262 on 9/6/17.
 */
public class Group {

    private long id;

    private String name;

    private String instructor;

    private List<Comment> comments;

    private String description;

    private String category;

    private Double rate;

    private int totalVotes;

    private String image;

    private List<Clase> clases;

    public Group(long id,String name,String instructor,List<Comment> comments,String description,String category, Double rate,int totalVotes,String image,List<Clase> clases) {
        this.id=id;
        this.name=name;
        this.instructor=instructor;
        this.comments=comments;
        this.description=description;
        this.category=category;
        this.rate=rate;
        this.totalVotes=totalVotes;
        this.image=image;
        this.clases=clases;
    }

    public Group() {
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
}
