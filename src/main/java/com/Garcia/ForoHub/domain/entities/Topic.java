package com.Garcia.ForoHub.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Topic {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    private String Titulo;
    private String mensaje;
    private Date fechaCreacion;
    private String Status;
    private String autor;
    private Course curso;
    private Response respuesta;

    public Topic() {
    }

    public Topic(String Titulo, String mensaje, Date fechaCreacion, String Status, String autor, Course curso, Response respuesta) {
        this.Titulo = Titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.Status = Status;
        this.autor = autor;
        this.curso = curso;
        this.respuesta = respuesta;
    }
}
