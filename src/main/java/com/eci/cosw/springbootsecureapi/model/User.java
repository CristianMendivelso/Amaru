package com.eci.cosw.springbootsecureapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import static javax.persistence.CascadeType.ALL;


/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Entity
@Table(name = "user" )
public class User implements java.io.Serializable{

    private String name;

    private String lastname;

    private String image;

    private String phone;

    private String password;

    private String email;

    private String description;

    private String type;

    private String username;

    private Double rate;

    private int totalVotes;

    private List<Clase> clases;

    private int cupo;


    public User() {
    }

    public User(String name, String lastname, String image, String phone, String password, String email, String description, String type, String username, Double rate, int totalVotes, List<Clase> clases, int cupo)

    {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.setPhone(phone);
        this.image = image;
        this.setDescription(description);
        this.setType(type);
        this.username = username;
        this.rate = rate;
        this.totalVotes = totalVotes;
        this.setClases(clases);
        this.setCupo(cupo);
    }

    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false, length = 300)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "lastname", nullable = false, length = 100)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "rate", nullable = false)
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Column(name = "totalVotes", nullable = false)
    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }


    @Override
    public String toString() {
        return "User{"  + ", email='" + email + '\'' + ", password='" + password + '\'' + ", firstname='"
                + getName() + "username " + getUsername() + "phone " + getPhone() + "description " + getDescription() + "password " + getPassword() + '\'' + '}';
    }

    @Column(name = "image", nullable = false, length = 1000)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone", nullable = false, length = 100)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "description", nullable = false, length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "type", nullable = false, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Id
    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @OneToMany(cascade=ALL)
    @JoinColumn(name="[usuario]", referencedColumnName="username", nullable=false)
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    @Column(name = "cupo", nullable = false)
    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
