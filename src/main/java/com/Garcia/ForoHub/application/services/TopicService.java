package com.Garcia.ForoHub.application.services;

import com.Garcia.ForoHub.application.dtos.TopicDTO;
import com.Garcia.ForoHub.domain.entities.Topic;
import com.Garcia.ForoHub.domain.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic createTopic(TopicDTO topicDTO) {
        Topic topic = new Topic();
        topic.setTitulo(topicDTO.getTitulo());
        topic.setMensaje(topicDTO.getMensaje());
        topic.setFechaCreacion(topicDTO.getFechaCreacion());
        topic.setStatus(topicDTO.getStatus());
        topic.setAutor(topicDTO.getAutor());
        // Aquí se asignaría el Curso y la Respuesta
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Long id, TopicDTO topicDTO) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.setTitulo(topicDTO.getTitulo());
            topic.setMensaje(topicDTO.getMensaje());
            topic.setFechaCreacion(topicDTO.getFechaCreacion());
            topic.setStatus(topicDTO.getStatus());
            topic.setAutor(topicDTO.getAutor());
            // Actualizar curso y respuesta si es necesario
            return topicRepository.save(topic);
        }
        return null;
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
