package com.medhat.ums.repositories;

import com.medhat.ums.dto.DepartmentDTO;
import com.medhat.ums.entities.Course;
import com.medhat.ums.entities.Department;
import com.medhat.ums.projections.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long > , JpaSpecificationExecutor<Department> {


    List<DepartmentProjection> findAllProjectedBy();


    boolean existsByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %:keyword%")
    List<Department> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT new com.medhat.ums.dto.DepartmentDTO(d.id, d.name) FROM Department d")
    List<DepartmentDTO> findAllDepartmentDTOs();
}
