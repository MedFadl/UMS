package com.medhat.ums.repositories;

import com.medhat.ums.dto.SemesterDTO;
import com.medhat.ums.entities.Semester;
import com.medhat.ums.projections.SemesterProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SemesterRepository extends JpaRepository<Semester, Long>, JpaSpecificationExecutor<Semester> {

    List<SemesterProjection> findAllProjectedBy();

    @Query("SELECT new com.medhat.ums.dto.SemesterDTO(s.id, s.academicYear, s.term, s.isActive) FROM Semester s")
    List<SemesterDTO> findAllSemesterDTOs();
}
