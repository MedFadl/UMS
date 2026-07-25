package com.medhat.ums.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String universityId;
    private String firstName;
    private String lastName;
}
