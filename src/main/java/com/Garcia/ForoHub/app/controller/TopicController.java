package com.Garcia.ForoHub.app.controller;

import com.Garcia.ForoHub.app.mapper.TopicMapper;
import com.Garcia.ForoHub.application.dtos.TopicDTO;
import com.Garcia.ForoHub.application.services.TopicService;
import com.Garcia.ForoHub.domain.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private TopicMapper topicMapper;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Optional<Topic> getTopicById(@PathVariable Long id) {
        return topicService.getTopicById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Topic createTopic(@RequestBody TopicDTO topicDTO) {
        return topicService.createTopic(topicDTO);
    }

    @PutMapping("/{id}")
    public Topic updateTopic(@PathVariable Long id, @RequestBody TopicDTO topicDTO) {
        return topicService.updateTopic(id, topicDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }
}
