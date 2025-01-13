package com.Garcia.ForoHub.application.dtos;

import java.util.Date;

public class ResponseDTO {
    private Long id;
    private String mensaje;
    private Long topicoId; // Asumimos que se manejará un ID de Topic
    private Date fechaCreacion;
    private String autor;
    private String solucion;

    public ResponseDTO() {
    }

    public ResponseDTO(Long id, String mensaje, Long topicoId, Date fechaCreacion, String autor, String solucion) {
        this.id = id;
        this.mensaje = mensaje;
        this.topicoId = topicoId;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
        this.solucion = solucion;
    }

    // Getters and setters
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

    public Long getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(Long topicoId) {
        this.topicoId = topicoId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
}
