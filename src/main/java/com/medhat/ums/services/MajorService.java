package com.medhat.ums.services;

import com.medhat.ums.dto.MajorDTO;
import com.medhat.ums.entities.Major;
import com.medhat.ums.projections.MajorProjection;
import com.medhat.ums.repositories.MajorRepository;
import com.medhat.ums.repositories.specs.MajorSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService {

    private final MajorRepository majorRepository;

    public List<MajorProjection> getSummaries() {
        return majorRepository.findAllProjectedBy();
    }

    public List<MajorDTO> getDTOs() {
        return majorRepository.findAllMajorDTOs();
    }

    public Major addMajor(Major major) {
        if (majorRepository.existsByName(major.getName())) {
            throw new RuntimeException("Already exists!!! >:c");
        }
        return majorRepository.save(major);
    }

    public List<Major> searchMajors(String keyword) {
        return majorRepository.findAll(MajorSpecifications.nameContains(keyword));
    }
}
