package com.eci.cosw.springbootsecureapi.model;

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

    private String username;

    private String password;

    private String email;

    public User()
    {
    }

    public User( String name, String lastname, String image, String username,String password, String email )
    {
        this.email = email;
        this.password = password;
        this.setName(name);
        this.lastname = lastname;
        this.username=username;
        this.image=image;
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

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", firstname='"
            + getName() + '\'' + '}';
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
}
