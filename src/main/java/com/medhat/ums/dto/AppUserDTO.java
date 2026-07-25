package com.medhat.ums.dto;

import com.medhat.ums.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppUserDTO {
    private Long id;
    private String email;
    private UserRole role;
    private Boolean isActive;
}
