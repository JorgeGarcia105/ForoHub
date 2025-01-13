package com.Garcia.ForoHub.app.mapper;

import com.Garcia.ForoHub.application.dtos.ResponseDTO;
import com.Garcia.ForoHub.domain.entities.Response;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {

    public ResponseDTO toDTO(Response response) {
        return new ResponseDTO(
                response.getId(),
                response.getMensaje(),
                response.getTopico() != null ? response.getTopico().getId() : null,
                response.getFechaCreaion(),
                response.getAutor(),
                response.getSolucion()
        );
    }

    public Response toEntity(ResponseDTO responseDTO) {
        Response response = new Response();
        response.setId(responseDTO.getId());
        response.setMensaje(responseDTO.getMensaje());
        response.setFechaCreaion(responseDTO.getFechaCreacion());
        response.setAutor(responseDTO.getAutor());
        response.setSolucion(responseDTO.getSolucion());
        // Asumir que el topico se asignará de alguna forma
        return response;
    }
}
