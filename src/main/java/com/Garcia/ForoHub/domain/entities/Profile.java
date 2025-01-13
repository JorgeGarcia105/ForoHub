package com.Garcia.ForoHub.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Profile extends Thread {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Profile() {
    }

    public Profile(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
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

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
