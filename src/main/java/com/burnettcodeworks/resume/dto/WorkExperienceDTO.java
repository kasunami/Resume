package com.burnettcodeworks.resume.dto;

import com.burnettcodeworks.resume.enums.Location;
import lombok.Data;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

@Data
public class WorkExperienceDTO {

    private UUID id;
    private CompanyDTO company;
    private String jobTitle;
    private Location location;
    private LocalDate startDate;
    private LocalDate endDate;
    private String department;
    private List<SkillDTO> skillsUsed;
    private List<ExperienceSummaryDTO> summaryPoints;
}