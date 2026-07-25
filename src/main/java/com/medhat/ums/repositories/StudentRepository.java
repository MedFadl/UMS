package com.medhat.ums.repositories;

import com.medhat.ums.dto.StudentDTO;
import com.medhat.ums.entities.Student;
import com.medhat.ums.projections.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    List<StudentProjection> findAllProjectedBy();

    boolean existsByUniversityId(String universityId);

    @Query("SELECT new com.medhat.ums.dto.StudentDTO(s.id, s.universityId, s.firstName, s.lastName) FROM Student s")
    List<StudentDTO> findAllStudentDTOs();
}
