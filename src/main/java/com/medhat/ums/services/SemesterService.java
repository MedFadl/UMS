package com.medhat.ums.services;

import com.medhat.ums.dto.SemesterDTO;
import com.medhat.ums.entities.Semester;
import com.medhat.ums.projections.SemesterProjection;
import com.medhat.ums.repositories.SemesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SemesterService {

    private final SemesterRepository semesterRepository;

    public List<SemesterProjection> getSummaries() {
        return semesterRepository.findAllProjectedBy();
    }

    public List<SemesterDTO> getDTOs() {
        return semesterRepository.findAllSemesterDTOs();
    }

    public Semester addSemester(Semester semester) {
        return semesterRepository.save(semester);
    }
}
