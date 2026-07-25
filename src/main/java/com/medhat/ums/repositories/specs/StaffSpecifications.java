package com.medhat.ums.repositories.specs;

import com.medhat.ums.entities.Staff;
import org.springframework.data.jpa.domain.Specification;

public class StaffSpecifications {
    public static Specification<Staff> nameContains(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(root.get("firstName"), "%" + keyword + "%");
        };
    }
}
