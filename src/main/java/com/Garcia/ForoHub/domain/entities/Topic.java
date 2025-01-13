package com.Garcia.ForoHub.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Topic {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // get y set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Course getCurso() {
        return curso;
    }

    public void setCurso(Course curso) {
        this.curso = curso;
    }

    public Response getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Response respuesta) {
        this.respuesta = respuesta;
    }
}
