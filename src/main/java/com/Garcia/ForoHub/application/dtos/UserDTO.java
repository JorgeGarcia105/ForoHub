package com.Garcia.ForoHub.application.dtos;

import lombok.Getter;
import lombok.Setter;


public class UserDTO {

    // Getters y Setters
    private Long id;
    private String nombre;
    private String email;
    private String contraseña;
    private String perfilNombre;

    public UserDTO() {
    }

    public UserDTO(Long id, String nombre, String email, String contraseña, String perfilNombre) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.perfilNombre = perfilNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPerfilNombre() {
        return perfilNombre;
    }

    public void setPerfilNombre(String perfilNombre) {
        this.perfilNombre = perfilNombre;
    }
}
