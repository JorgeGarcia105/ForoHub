package com.Garcia.ForoHub.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    private String nombre;
    private String categoria;

    public Course() {
    }

    public Course(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }
}
