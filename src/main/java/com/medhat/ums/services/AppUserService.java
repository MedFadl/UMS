package com.medhat.ums.services;

import com.medhat.ums.dto.AppUserDTO;
import com.medhat.ums.entities.AppUser;
import com.medhat.ums.projections.AppUserProjection;
import com.medhat.ums.repositories.AppUserRepository;
import com.medhat.ums.repositories.specs.AppUserSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public List<AppUserProjection> getSummaries() {
        return appUserRepository.findAllProjectedBy();
    }

    public List<AppUserDTO> getDTOs() {
        return appUserRepository.findAllAppUserDTOs();
    }

    public AppUser addAppUser(AppUser appUser) {
        if (appUserRepository.existsByEmail(appUser.getEmail())) {
            throw new RuntimeException("Already exists!!! >:c");
        }
        return appUserRepository.save(appUser);
    }

    public List<AppUser> searchAppUsers(String keyword) {
        return appUserRepository.findAll(AppUserSpecifications.emailContains(keyword));
    }
}
