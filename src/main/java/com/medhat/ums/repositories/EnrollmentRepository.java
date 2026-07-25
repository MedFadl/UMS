package com.medhat.ums.repositories;

import com.medhat.ums.dto.EnrollmentDTO;
import com.medhat.ums.entities.Enrollment;
import com.medhat.ums.projections.EnrollmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>, JpaSpecificationExecutor<Enrollment> {

    List<EnrollmentProjection> findAllProjectedBy();

    @Query("SELECT new com.medhat.ums.dto.EnrollmentDTO(e.id, e.status, e.finalGrade) FROM Enrollment e")
    List<EnrollmentDTO> findAllEnrollmentDTOs();
}
