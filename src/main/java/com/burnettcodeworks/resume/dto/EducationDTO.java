package com.burnettcodeworks.resume.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EducationDTO {

    private UUID id;
    private String schoolName;
    private String degree;
    private String major;
    private String minor;
    private Long gpa;
    private ContactInfoDTO contactInfo;
    private LocalDate startDate;
    private LocalDate endDate;
}