package com.medhat.ums.repositories;

import com.medhat.ums.dto.StaffDTO;
import com.medhat.ums.entities.Staff;
import com.medhat.ums.projections.StaffProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long>, JpaSpecificationExecutor<Staff> {

    List<StaffProjection> findAllProjectedBy();

    boolean existsByEmployeeNumber(String employeeNumber);

    @Query("SELECT new com.medhat.ums.dto.StaffDTO(s.id, s.employeeNumber, s.firstName, s.lastName) FROM Staff s")
    List<StaffDTO> findAllStaffDTOs();
}
