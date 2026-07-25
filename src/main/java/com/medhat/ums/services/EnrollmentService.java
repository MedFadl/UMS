package com.medhat.ums.services;

import com.medhat.ums.dto.EnrollmentDTO;
import com.medhat.ums.entities.Enrollment;
import com.medhat.ums.projections.EnrollmentProjection;
import com.medhat.ums.repositories.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public List<EnrollmentProjection> getSummaries() {
        return enrollmentRepository.findAllProjectedBy();
    }

    public List<EnrollmentDTO> getDTOs() {
        return enrollmentRepository.findAllEnrollmentDTOs();
    }

    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}
