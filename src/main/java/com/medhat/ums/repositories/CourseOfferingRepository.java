package com.medhat.ums.repositories;

import com.medhat.ums.dto.CourseOfferingDTO;
import com.medhat.ums.entities.CourseOffering;
import com.medhat.ums.projections.CourseOfferingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long>, JpaSpecificationExecutor<CourseOffering> {

    List<CourseOfferingProjection> findAllProjectedBy();

    @Query("SELECT new com.medhat.ums.dto.CourseOfferingDTO(c.id, c.capacity) FROM CourseOffering c")
    List<CourseOfferingDTO> findAllCourseOfferingDTOs();
}
