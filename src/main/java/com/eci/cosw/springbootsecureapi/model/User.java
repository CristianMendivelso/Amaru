package com.eci.cosw.springbootsecureapi.model;

import java.util.ArrayList;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public class User
{

    private long id;

    private String name;

    private String lastname;

    private String image;

    private String phone;

    private String password;

    private String email;

    private String description;

    private String type;

    private String username;

    private float rate;

    private int totalVotes;

    private ArrayList<Group> groups;


    public User()
    {
    }

    public User( String name, String lastname, String image, String phone,String password, String email, String description, String type,String username, float rate , int totalVotes,ArrayList<Group> groups)

    {
        this.email = email;
        this.password = password;
        this.name=name;
        this.lastname = lastname;
        this.setPhone(phone);
        this.image=image;
        this.setDescription(description);
        this.setType(type);
        this.username=username;
        this.rate=rate;
        this.totalVotes=totalVotes;
        this.setGroups(groups);
    }


    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    public float getRate() { return rate; }

    public void setRate( float rate )
    {
        this.rate = rate;
    }

    public int getTotalVotes()
    {
        return totalVotes;
    }

    public void setTotalVotes( int totalVotes )
    {
        this.totalVotes = totalVotes;
    }


    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", firstname='"
            + getName() + "username "+ getUsername()+ "phone "+ getPhone()+ "description "+getDescription()+ "password " +  getPassword()+'\'' + '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
}
