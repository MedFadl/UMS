package com.medhat.ums.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SemesterDTO {
    private Long id;
    private Integer academicYear;
    private String term;
    private Boolean isActive;
}
