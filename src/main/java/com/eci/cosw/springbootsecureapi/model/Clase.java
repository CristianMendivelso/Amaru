package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.*;


@Entity
@Table(name = "clase" )
public class Clase  implements java.io.Serializable{
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


    @Column(name = "fecha", nullable = false, length = 100)
    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Column(name = "hour", nullable = false, length = 100)
    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Column(name = "place", nullable = false, length = 100)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    //@Column(name = "Group_id", nullable = false)
    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    @Id
    @Column(name = "id_clase", nullable = false)
    public long getId_clase() {
        return this.id_clase;
    }

    public void setId_clase(long id_clase) {
        this.id_clase = id_clase;
    }

    @Column(name = "Group_name", nullable = false, length = 300)
    public String getGroup_name() {
        return this.group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    @Column(name = "num_inscritos", nullable = false)
    public int getNum_inscritos() {
        return num_inscritos;
    }


    public void setNum_inscritos(int num_inscritos) {
        this.num_inscritos = num_inscritos;
    }
}


