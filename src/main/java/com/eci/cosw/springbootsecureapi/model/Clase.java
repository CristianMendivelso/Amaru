package com.eci.cosw.springbootsecureapi.model;

public class Clase {
    private long group_id;
    private String fecha;
    private String hour;
    private String place;
    private long id_clase;
    private String group_name;
    private int num_inscritos;

    public Clase(long group_id,String fecha,String hour,String place,long id_clase,String group_name,int num_inscritos){
        this.group_id=group_id;
        this.fecha=fecha;
        this.hour=hour;
        this.place=place;
        this.id_clase=id_clase;
        this.group_name=group_name;
        this.num_inscritos=num_inscritos;
    }

    public  Clase(){}



    public String getFecha() {
        return this.fecha;
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
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public long getId_clase() {
        return this.id_clase;
    }

    public void setId_clase(long id_clase) {
        this.id_clase = id_clase;
    }

    public String getGroup_name() {
        return this.group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getNum_inscritos() {
        return num_inscritos;
    }

    public void setNum_inscritos(int num_inscritos) {
        this.num_inscritos = num_inscritos;
    }
}


