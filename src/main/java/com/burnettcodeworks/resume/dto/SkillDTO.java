package com.burnettcodeworks.resume.dto;

import com.burnettcodeworks.resume.enums.Proficiency;
import lombok.Data;
import java.util.UUID;

@Data
public class SkillDTO {

    private UUID id;
    private String name;
    private String type;
    private Proficiency proficiencyLevel;
    private int yearsOfExperience;
    private WorkExperienceDTO workExperience;
}