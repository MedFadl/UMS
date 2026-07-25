package com.medhat.ums.projections;

import com.medhat.ums.models.UserRole;

public interface AppUserProjection {
    Long getId();
    String getEmail();
    UserRole getRole();
    Boolean getIsActive();
}
