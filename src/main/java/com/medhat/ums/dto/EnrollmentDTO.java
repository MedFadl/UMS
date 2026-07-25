package com.medhat.ums.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnrollmentDTO {
    private Long id;
    private String status;
    private Float finalGrade;
}
