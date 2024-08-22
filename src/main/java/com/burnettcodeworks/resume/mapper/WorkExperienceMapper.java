package com.burnettcodeworks.resume.mapper;

import com.burnettcodeworks.resume.dto.WorkExperienceDTO;
import com.burnettcodeworks.resume.entity.WorkExperience;

import java.util.List;
import java.util.stream.Collectors;

public class WorkExperienceMapper {

    public static WorkExperienceDTO toDTO(WorkExperience workExperience) {
        if (workExperience == null) {
            return null;
        }

        WorkExperienceDTO dto = new WorkExperienceDTO();
        dto.setId(workExperience.getId());
        dto.setCompany(CompanyMapper.toDTO(workExperience.getCompany()));
        dto.setJobTitle(workExperience.getJobTitle());
        dto.setLocation(workExperience.getLocation());
        dto.setStartDate(workExperience.getStartDate());
        dto.setEndDate(workExperience.getEndDate());
        dto.setDepartment(workExperience.getDepartment());
        dto.setSkillsUsed(SkillMapper.toDTOList(workExperience.getSkillsUsed()));
        dto.setSummaryPoints(ExperienceSummaryMapper.toDTOList(workExperience.getSummaryPoints()));

        return dto;
    }

    public static WorkExperience toEntity(WorkExperienceDTO dto) {
        if (dto == null) {
            return null;
        }

        WorkExperience workExperience = new WorkExperience();
        workExperience.setId(dto.getId());
        workExperience.setCompany(CompanyMapper.toEntity(dto.getCompany()));
        workExperience.setJobTitle(dto.getJobTitle());
        workExperience.setLocation(dto.getLocation());
        workExperience.setStartDate(dto.getStartDate());
        workExperience.setEndDate(dto.getEndDate());
        workExperience.setDepartment(dto.getDepartment());
        workExperience.setSkillsUsed(SkillMapper.toEntityList(dto.getSkillsUsed()));
        workExperience.setSummaryPoints(ExperienceSummaryMapper.toEntityList(dto.getSummaryPoints()));

        return workExperience;
    }

    public static List<WorkExperienceDTO> toDTOList(List<WorkExperience> workExperiences) {
        return workExperiences.stream().map(WorkExperienceMapper::toDTO).collect(Collectors.toList());
    }

    public static List<WorkExperience> toEntityList(List<WorkExperienceDTO> dtos) {
        return dtos.stream().map(WorkExperienceMapper::toEntity).collect(Collectors.toList());
    }
}