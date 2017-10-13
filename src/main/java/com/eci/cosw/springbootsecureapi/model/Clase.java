package com.eci.cosw.springbootsecureapi.model;

public class Clase {
    private long Group_id;
    private String fecha;
    private String hour;
    private String place;
    private long id_clase;
    private String Group_name;

    public Clase(long Group_id,String fecha,String hour,String place,long id_clase,String Group_name){
        this.Group_id=Group_id;
        this.fecha=fecha;
        this.hour=hour;
        this.place=place;
        this.id_clase=id_clase;
        this.Group_name=Group_name;
    }

    public  Clase(){}



    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getGroup_id() {
        return Group_id;
    }

    public void setGroup_id(long group_id) {
        Group_id = group_id;
    }

    public long getId_clase() {
        return id_clase;
    }

    public void setId_clase(long id_clase) {
        this.id_clase = id_clase;
    }

    public String getGroup_name() {
        return Group_name;
    }

    public void setGroup_name(String group_name) {
        Group_name = group_name;
    }
}


