package com.medhat.ums.repositories.specs;

import com.medhat.ums.entities.Department;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentSpecifications {
    public static Specification<Department> nameContains(String keyword){
        return (root, query , cb) ->{
            if(keyword == null || keyword.isEmpty()){
                return cb.conjunction();
            }
            return cb.like(root.get("name"), "%" + keyword + "%");
        };
    }
}
