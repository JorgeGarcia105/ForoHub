package com.Garcia.ForoHub.app.controller;

import com.Garcia.ForoHub.app.mapper.ResponseMapper;
import com.Garcia.ForoHub.application.dtos.ResponseDTO;
import com.Garcia.ForoHub.application.services.ResponseService;
import com.Garcia.ForoHub.domain.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private ResponseMapper responseMapper;

    @GetMapping
    public List<Response> getAllResponses() {
        return responseService.getAllResponses();
    }

    @GetMapping("/{id}")
    public Optional<Response> getResponseById(@PathVariable Long id) {
        return responseService.getResponseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response createResponse(@RequestBody ResponseDTO responseDTO) {
        return responseService.createResponse(responseDTO);
    }

    @PutMapping("/{id}")
    public Response updateResponse(@PathVariable Long id, @RequestBody ResponseDTO responseDTO) {
        return responseService.updateResponse(id, responseDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResponse(@PathVariable Long id) {
        responseService.deleteResponse(id);
    }
}
