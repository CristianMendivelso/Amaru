package com.eci.cosw.springbootsecureapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "Clase" )
public class Clase  implements java.io.Serializable{
    private long idGrupo;
    private String fecha;
    private String hour;
    private String place;
    private long idClase;
    private String nombregrupo;
    private int numinscritos;
    private String usuario;

    public Clase(long idGrupo,String fecha,String hour,String place,long idClase,String nombregrupo,int numinscritos, String usuario){
        this.idGrupo=idGrupo;
        this.fecha=fecha;
        this.hour=hour;
        this.place=place;
        this.idClase=idClase;
        this.nombregrupo=nombregrupo;
        this.numinscritos=numinscritos;
        this.usuario = usuario;
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

    //@Column(name = "idgrupo", nullable = false)
    public long getIdgrupo() {
        return idGrupo;
    }

    public void setIdgrupo(long idgrupo) {
        this.idGrupo = idgrupo;
    }

    @Id
    @Column(name = "idclase", nullable = false)
    public long getIdclase() { return this.idClase; }

    public void setIdclase(long idclase) {
        this.idClase = idclase;
    }

    @Column(name = "nombregrupo", nullable = false, length = 300)
    public String getNombregrupo() {
        return this.nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    @Column(name = "numinscritos", nullable = false)
    public int getNuminscritos() {
        return numinscritos;
    }


    public void setNuminscritos(int numinscritos) {
        this.numinscritos = numinscritos;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}


