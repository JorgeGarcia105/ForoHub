package com.Garcia.ForoHub.domain.repositories;

import com.Garcia.ForoHub.domain.entities.Topic;

import java.util.List;
import java.util.Optional;

public class TopicRepository {
    public List<Topic> findAll() {
        return List.of();
    }

    public Topic save(Topic topico) {
        return null;
    }

    public Optional<Topic> findById(Long id) {
        return Optional.empty();
    }

    public void deleteById(Long id) {

    }
}
