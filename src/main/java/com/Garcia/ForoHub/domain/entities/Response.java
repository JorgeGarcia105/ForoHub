package com.Garcia.ForoHub.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.Date;

public class Response {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Topic getTopico() {
        return topico;
    }

    public void setTopico(Topic topico) {
        this.topico = topico;
    }

    public Date getFechaCreaion() {
        return fechaCreaion;
    }

    public void setFechaCreaion(Date fechaCreaion) {
        this.fechaCreaion = fechaCreaion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", mensaje='" + mensaje + '\'' +
                ", topico=" + topico +
                ", fechaCreaion=" + fechaCreaion +
                ", autor='" + autor + '\'' +
                ", solucion='" + solucion + '\'' +
                '}';
    }

    public void update(Response response) {
        this.mensaje = response.getMensaje();
        this.topico = response.getTopico();
        this.fechaCreaion = response.getFechaCreaion();
        this.autor = response.getAutor();
        this.solucion = response.getSolucion();
    }

    public void delete() {
        this.mensaje = null;
        this.topico = null;
        this.fechaCreaion = null;
        this.autor = null;
        this.solucion = null;
    }

    public boolean isNull() {
        return this.mensaje == null && this.topico == null && this.fechaCreaion == null && this.autor == null && this.solucion == null;
    }

    public boolean isNotNull() {
        return this.mensaje != null && this.topico != null && this.fechaCreaion != null && this.autor != null && this.solucion != null;
    }

    public boolean isSolucion() {
        return this.solucion != null;
    }

    public boolean isNotSolucion() {
        return this.solucion == null;
    }

    public boolean isAutor(String autor) {
        return this.autor.equals(autor);
    }

    public boolean isNotAutor(String autor) {
        return !this.autor.equals(autor);
    }

    public boolean isTopico(Topic topico) {
        return this.topico.equals(topico);
    }

    public boolean isNotTopico(Topic topico) {
        return !this.topico.equals(topico);
    }
}

