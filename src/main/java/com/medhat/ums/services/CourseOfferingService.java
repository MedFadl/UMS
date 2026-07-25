package com.medhat.ums.services;

import com.medhat.ums.dto.CourseOfferingDTO;
import com.medhat.ums.entities.CourseOffering;
import com.medhat.ums.projections.CourseOfferingProjection;
import com.medhat.ums.repositories.CourseOfferingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseOfferingService {

    private final CourseOfferingRepository courseOfferingRepository;

    public List<CourseOfferingProjection> getSummaries() {
        return courseOfferingRepository.findAllProjectedBy();
    }

    public List<CourseOfferingDTO> getDTOs() {
        return courseOfferingRepository.findAllCourseOfferingDTOs();
    }

    public CourseOffering addCourseOffering(CourseOffering courseOffering) {
        return courseOfferingRepository.save(courseOffering);
    }
}
