package com.medhat.ums.services;

import com.medhat.ums.dto.CourseDTO;
import com.medhat.ums.entities.Course;
import com.medhat.ums.projections.CourseProjection;
import com.medhat.ums.repositories.CourseRepository;
import com.medhat.ums.repositories.specs.CourseSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<CourseProjection> getSummaries() {
        return courseRepository.findAllProjectedBy();
    }

    public List<CourseDTO> getDTOs() {
        return courseRepository.findAllCourseDTOs();
    }

    public Course addCourse(Course course) {
        if (courseRepository.existsByCode(course.getCode())) {
            throw new RuntimeException("Already exists!!! >:c");
        }
        return courseRepository.save(course);
    }

    public List<Course> searchCourses(String keyword) {
        return courseRepository.findAll(CourseSpecifications.nameContains(keyword));
    }
}
