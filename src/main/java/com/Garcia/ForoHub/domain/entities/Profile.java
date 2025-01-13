package com.Garcia.ForoHub.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

public class Profile extends Thread {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    private String nombre;

    public Profile() {
    }

    public Profile(String nombre) {
        this.nombre = nombre;
    }

}
