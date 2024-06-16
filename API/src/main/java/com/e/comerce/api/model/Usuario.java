package com.e.comerce.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table (name = "Usuarios")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contrasena")
    private String contrasena;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;

    public Usuario(){}

    public Usuario(Integer id, String nombre, String correo, String contrasena, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public @NotNull @Size(min = 1, max = 50) String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotNull @Size(min = 1, max = 50) String correo) {
        this.correo = correo;
    }

    public @NotNull @Size(min = 1, max = 50) String getContrasena() {
        return contrasena;
    }

    public void setContrasena(@NotNull @Size(min = 1, max = 50) String contrasena) {
        this.contrasena = contrasena;
    }

    public @NotNull @Size(min = 1, max = 50) String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotNull @Size(min = 1, max = 50) String direccion) {
        this.direccion = direccion;
    }

    public @NotNull @Size(min = 1, max = 50) String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotNull @Size(min = 1, max = 50) String telefono) {
        this.telefono = telefono;
    }
}
