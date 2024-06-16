package com.e.comerce.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Productos")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Producto p")})
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;

    @Basic(optional = true)
    @Column(name = "image")
    private String img;

    public Producto() {}



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 50) String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull @Size(min = 1, max = 50) String nombre) {
        this.nombre = nombre;
    }

    public @NotNull String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull String descripcion) {
        this.descripcion = descripcion;
    }

    @NotNull
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull float precio) {
        this.precio = precio;
    }

    public @NotNull Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(@NotNull Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    @NotNull
    public int getStock() {
        return stock;
    }

    public void setStock(@NotNull int stock) {
        this.stock = stock;
    }
}
