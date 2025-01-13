package com.Garcia.ForoHub.application.services;

import com.Garcia.ForoHub.application.dtos.CourseDTO;
import com.Garcia.ForoHub.domain.entities.Course;
import com.Garcia.ForoHub.domain.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setNombre(courseDTO.getNombre());
        course.setCategoria(courseDTO.getCategoria());
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, CourseDTO courseDTO) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setNombre(courseDTO.getNombre());
            course.setCategoria(courseDTO.getCategoria());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
