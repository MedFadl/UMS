package com.medhat.ums.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MajorDTO {
    private Long id;
    private String name;
    private Integer graduationCredits;
}
