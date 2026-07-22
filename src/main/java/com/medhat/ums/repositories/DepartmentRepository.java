package com.medhat.ums.repositories;

import com.medhat.ums.entities.Course;
import com.medhat.ums.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
