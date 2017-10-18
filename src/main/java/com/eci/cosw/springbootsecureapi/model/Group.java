package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;


/**
 * Created by 2107262 on 9/6/17.
 */
@Entity
@Table(name = "grupos" )
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

    public String toString(){
        return "id: "+id +"name: " +name+ "instructor: "+instructor +"clases: " + clases.size();
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "instructor", nullable = false, length = 100)
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @OneToMany(cascade=ALL)
    @JoinColumn(name="Groupid", referencedColumnName="id", nullable=false)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "category", nullable = false, length = 100)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "rate", nullable = false)
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Column(name = "totalVotes", nullable = false, length = 100)
    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    @Column(name = "image", nullable = false, length = 1000)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @OneToMany(cascade=ALL)
    @JoinColumn(name="Group_id", referencedColumnName="id", nullable=false)
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
}
