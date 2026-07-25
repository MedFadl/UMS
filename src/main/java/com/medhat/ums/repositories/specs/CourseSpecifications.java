package com.medhat.ums.repositories.specs;

import com.medhat.ums.entities.Course;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecifications {
    public static Specification<Course> nameContains(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(root.get("name"), "%" + keyword + "%");
        };
    }
}
