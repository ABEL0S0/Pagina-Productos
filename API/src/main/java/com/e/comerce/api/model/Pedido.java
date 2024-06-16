package com.e.comerce.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.Date;

@Entity
@Table(name = "Pedidos")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedido p")})
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido")
    private Date fecha_pedido;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer id_usuario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private String estado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;

}
