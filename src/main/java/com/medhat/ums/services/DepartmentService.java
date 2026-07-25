package com.medhat.ums.services;


import com.medhat.ums.dto.DepartmentDTO;
import com.medhat.ums.entities.Department;
import com.medhat.ums.projections.DepartmentProjection;
import com.medhat.ums.repositories.DepartmentRepository;
import com.medhat.ums.repositories.specs.DepartmentSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentProjection> getSummaries() {
        return departmentRepository.findAllProjectedBy();
    }

    public List<DepartmentDTO> getDTOs() {
        return departmentRepository.findAllDepartmentDTOs();
    }

    public Department addDepartment(Department department){
        if (departmentRepository.existsByName(department.getName())) {
            throw new RuntimeException("Already exists!!! >:c");
        }
        return departmentRepository.save(department);
    }

    public List<Department> findDepartmentsByKeyword(String keyword) {
        return departmentRepository.searchByKeyword(keyword);
    }




    public List<Department> searchDepartments(String keyword){
        return departmentRepository.findAll(DepartmentSpecifications.nameContains(keyword));
    }

}
