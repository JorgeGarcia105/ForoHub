package com.Garcia.ForoHub.app.mapper;

import com.Garcia.ForoHub.application.dtos.TopicDTO;
import com.Garcia.ForoHub.domain.entities.Topic;
import org.springframework.stereotype.Component;

@Component
public class TopicMapper {

    public TopicDTO toDTO(Topic topic) {
        return new TopicDTO(
                topic.getId(),
                topic.getTitulo(),
                topic.getMensaje(),
                topic.getFechaCreacion(),
                topic.getStatus(),
                topic.getAutor(),
                topic.getCurso() != null ? topic.getCurso().getId() : null,
                topic.getRespuesta() != null ? topic.getRespuesta().getId() : null
        );
    }

    public Topic toEntity(TopicDTO topicDTO) {
        Topic topic = new Topic();
        topic.setId(topicDTO.getId());
        topic.setTitulo(topicDTO.getTitulo());
        topic.setMensaje(topicDTO.getMensaje());
        topic.setFechaCreacion(topicDTO.getFechaCreacion());
        topic.setStatus(topicDTO.getStatus());
        topic.setAutor(topicDTO.getAutor());
        // Aquí se asignarían Curso y Respuesta si se desean
        return topic;
    }
}
