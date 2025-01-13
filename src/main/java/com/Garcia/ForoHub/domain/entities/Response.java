package com.Garcia.ForoHub.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.Date;

public class Response {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    private String mensaje;
    private Topic topico;
    private Date fechaCreaion;
    private String autor;
    private String solucion;

    public Response() {
    }

    public Response(String mensaje, Topic topico, Date fechaCreaion, String autor, String solucion) {
        this.mensaje = mensaje;
        this.topico = topico;
        this.fechaCreaion = fechaCreaion;
        this.autor = autor;
        this.solucion = solucion;
    }


}

