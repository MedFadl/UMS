package com.medhat.ums.repositories;

import com.medhat.ums.dto.MajorDTO;
import com.medhat.ums.entities.Major;
import com.medhat.ums.projections.MajorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Long>, JpaSpecificationExecutor<Major> {

    List<MajorProjection> findAllProjectedBy();

    boolean existsByName(String name);

    @Query("SELECT new com.medhat.ums.dto.MajorDTO(m.id, m.name, m.graduationCredits) FROM Major m")
    List<MajorDTO> findAllMajorDTOs();
}
