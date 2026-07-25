package com.medhat.ums.repositories.specs;

import com.medhat.ums.entities.Major;
import org.springframework.data.jpa.domain.Specification;

public class MajorSpecifications {
    public static Specification<Major> nameContains(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(root.get("name"), "%" + keyword + "%");
        };
    }
}
