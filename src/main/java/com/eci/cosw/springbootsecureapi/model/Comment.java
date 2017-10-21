package com.eci.cosw.springbootsecureapi.model;

import javax.persistence.*;

/**
 * Created by 2106088 on 9/6/17.
 */
@Entity
@Table(name = "Comment" )
public class Comment {

    private String contenido;
    private long Groupid;
    private String usuario;
    private String fecha;
    private long id;

    public Comment() {
    }

    public Comment(String contenido, long Groupid, String usuario, String fecha,long id) {
        this.contenido = contenido;
        this.Groupid = Groupid;
        this.usuario = usuario;
        this.fecha = fecha;
        this.id=id;
    }

    @Column(name = "contenido", nullable = false, length = 1000)
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Column(name = "Groupid", nullable = false)
    public long getGroupId() {
        return Groupid;
    }

    public void setGroupId(long Groupid) {
        this.Groupid = Groupid;
    }

    @Column(name = "usuario", nullable = false, length = 100)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "fecha", nullable = false, length = 100)
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String date) {
        this.fecha = date;
    }

    @Id
    @Column(name = "id", nullable = false, length = 100)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}