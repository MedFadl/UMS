package com.medhat.ums.repositories;

import com.medhat.ums.dto.CourseDTO;
import com.medhat.ums.entities.Course;
import com.medhat.ums.projections.CourseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    List<CourseProjection> findAllProjectedBy();

    boolean existsByCode(String code);

    @Query("SELECT new com.medhat.ums.dto.CourseDTO(c.id, c.code, c.name, c.credits) FROM Course c")
    List<CourseDTO> findAllCourseDTOs();
}
