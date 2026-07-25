package com.medhat.ums.repositories.specs;

import com.medhat.ums.entities.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecifications {
    public static Specification<Student> nameContains(String keyword) {
        return (root, query, cb) -> {
            if (keyword == null || keyword.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(root.get("firstName"), "%" + keyword + "%");
        };
    }
}
