package com.Garcia.ForoHub.app.mapper;

import com.Garcia.ForoHub.application.dtos.CourseDTO;
import com.Garcia.ForoHub.domain.entities.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getNombre(),
                course.getCategoria()
        );
    }

    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setNombre(courseDTO.getNombre());
        course.setCategoria(courseDTO.getCategoria());
        return course;
    }
}
