package com.e.comerce.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Productos_carrito")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Productos_carrito.findAll", query = "SELECT pc FROM Producto_carrito pc")})
public class Producto_carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrito")
    private Integer id_carrito;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private Integer id_producto;

    public Producto_carrito() {
    }

    public Producto_carrito(Integer id_carrito, Integer cantidad, Integer id_producto) {
        this.id_carrito = id_carrito;
        this.cantidad = cantidad;
        this.id_producto = id_producto;
    }

    public Integer getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
    }

    public @NotNull Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(@NotNull Integer cantidad) {
        this.cantidad = cantidad;
    }

    public @NotNull Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(@NotNull Integer id_producto) {
        this.id_producto = id_producto;
    }
}
