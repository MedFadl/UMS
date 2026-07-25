package com.medhat.ums.projections;

public interface SemesterProjection {
    Long getId();
    Integer getAcademicYear();
    String getTerm();
    Boolean getIsActive();
}
