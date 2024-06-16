package com.e.comerce.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.Date;

@Entity
@Table(name = "Carritos")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Carritos.findAll", query = "SELECT c FROM Carrito c")})
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrito")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer id_usuario;

    public Carrito() {}

    public Carrito(Integer id, Date fecha_creacion, Integer id_usuario) {
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.id_usuario = id_usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(@NotNull Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public @NotNull Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(@NotNull Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
}
