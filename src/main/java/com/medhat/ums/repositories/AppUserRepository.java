package com.medhat.ums.repositories;

import com.medhat.ums.dto.AppUserDTO;
import com.medhat.ums.entities.AppUser;
import com.medhat.ums.projections.AppUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long>, JpaSpecificationExecutor<AppUser> {

    List<AppUserProjection> findAllProjectedBy();

    boolean existsByEmail(String email);

    Optional<AppUser> findByEmail(String email);

    @Query("SELECT new com.medhat.ums.dto.AppUserDTO(u.id, u.email, u.role, u.isActive) FROM AppUser u")
    List<AppUserDTO> findAllAppUserDTOs();
}
