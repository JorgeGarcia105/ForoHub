package com.Garcia.ForoHub.application.services;

import com.Garcia.ForoHub.application.dtos.ResponseDTO;
import com.Garcia.ForoHub.domain.entities.Response;
import com.Garcia.ForoHub.domain.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }

    public Optional<Response> getResponseById(Long id) {
        return responseRepository.findById(id);
    }

    public Response createResponse(ResponseDTO responseDTO) {
        Response response = new Response();
        response.setMensaje(responseDTO.getMensaje());
        response.setFechaCreaion(responseDTO.getFechaCreacion());
        response.setAutor(responseDTO.getAutor());
        response.setSolucion(responseDTO.getSolucion());
        // Asumimos que el topico se asigna de alguna manera (ej. buscar el Topic por id)
        // response.setTopico(topic);
        return responseRepository.save(response);
    }

    public Response updateResponse(Long id, ResponseDTO responseDTO) {
        Optional<Response> optionalResponse = responseRepository.findById(id);
        if (optionalResponse.isPresent()) {
            Response response = optionalResponse.get();
            response.setMensaje(responseDTO.getMensaje());
            response.setFechaCreaion(responseDTO.getFechaCreacion());
            response.setAutor(responseDTO.getAutor());
            response.setSolucion(responseDTO.getSolucion());
            // De igual forma, actualizar el topico si se requiere
            return responseRepository.save(response);
        }
        return null;
    }

    public void deleteResponse(Long id) {
        responseRepository.deleteById(id);
    }
}
