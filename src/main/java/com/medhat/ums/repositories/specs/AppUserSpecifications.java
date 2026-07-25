package com.medhat.ums.repositories.specs;

import com.medhat.ums.entities.AppUser;
import org.springframework.data.jpa.domain.Specification;

public class AppUserSpecifications {
    public static Specification<AppUser> emailContains(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(root.get("email"), "%" + keyword + "%");
        };
    }
}
