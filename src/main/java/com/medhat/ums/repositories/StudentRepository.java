package com.medhat.ums.repositories;

import com.medhat.ums.entities.Course;
import com.medhat.ums.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
