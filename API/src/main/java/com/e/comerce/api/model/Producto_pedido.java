package com.e.comerce.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Productos_pedido")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Productos_pedido.findAll", query = "SELECT pp FROM Producto_pedido pp")})
public class Producto_pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer id_carrito;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private Integer id_producto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unitario")
    private float precio_unitario;

    public Producto_pedido() {
    }

    public Producto_pedido(Integer id_carrito, Integer cantidad, Integer id_producto, float precio_unitario) {
        this.id_carrito = id_carrito;
        this.cantidad = cantidad;
        this.id_producto = id_producto;
        this.precio_unitario = precio_unitario;
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

    @NotNull
    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(@NotNull float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}
