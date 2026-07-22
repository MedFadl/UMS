package com.medhat.ums.repositories;

import com.medhat.ums.entities.Course;
import com.medhat.ums.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
