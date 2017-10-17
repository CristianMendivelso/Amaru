package com.eci.cosw.springbootsecureapi.model;

public class Pojo {

    private long idclase;
    private long idgroup;
    private String username;

    public Pojo(long idclase,long idgroup,String username){
        this.idclase=idclase;
        this.idgroup=idgroup;
        this.username=username;
    }

    public Pojo(){}


    public long getIdclase() {
        return idclase;
    }

    public void setIdclase(long idclase) {
        this.idclase = idclase;
    }

    public long getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(long idgroup) {
        this.idgroup = idgroup;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
