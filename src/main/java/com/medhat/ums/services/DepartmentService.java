package com.medhat.ums.services;


import com.medhat.ums.entities.Department;
import com.medhat.ums.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }


    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

}
