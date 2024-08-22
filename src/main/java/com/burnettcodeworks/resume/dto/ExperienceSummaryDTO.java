package com.burnettcodeworks.resume.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ExperienceSummaryDTO {

    private UUID id;
    private CompanyDTO company;
    private int orderNumber;
    private String summary;
    private boolean achievement;
    private WorkExperienceDTO workExperience;
}