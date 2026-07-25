package com.medhat.ums.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String code;
    private String name;
    private Integer credits;
}
