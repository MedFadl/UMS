package com.medhat.ums.services;

import com.medhat.ums.dto.StaffDTO;
import com.medhat.ums.entities.Staff;
import com.medhat.ums.projections.StaffProjection;
import com.medhat.ums.repositories.StaffRepository;
import com.medhat.ums.repositories.specs.StaffSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;

    public List<StaffProjection> getSummaries() {
        return staffRepository.findAllProjectedBy();
    }

    public List<StaffDTO> getDTOs() {
        return staffRepository.findAllStaffDTOs();
    }

    public Staff addStaff(Staff staff) {
        if (staffRepository.existsByEmployeeNumber(staff.getEmployeeNumber())) {
            throw new RuntimeException("Already exists!!! >:c");
        }
        return staffRepository.save(staff);
    }

    public List<Staff> searchStaff(String keyword) {
        return staffRepository.findAll(StaffSpecifications.nameContains(keyword));
    }
}
