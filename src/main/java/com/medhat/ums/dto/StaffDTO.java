package com.medhat.ums.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StaffDTO {
    private Long id;
    private String employeeNumber;
    private String firstName;
    private String lastName;
}
