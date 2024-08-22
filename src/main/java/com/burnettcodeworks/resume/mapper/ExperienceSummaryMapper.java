package com.burnettcodeworks.resume.mapper;

import com.burnettcodeworks.resume.dto.ExperienceSummaryDTO;
import com.burnettcodeworks.resume.entity.ExperienceSummary;

import java.util.List;
import java.util.stream.Collectors;

public class ExperienceSummaryMapper {

    public static ExperienceSummaryDTO toDTO(ExperienceSummary experienceSummary) {
        if (experienceSummary == null) {
            return null;
        }

        ExperienceSummaryDTO dto = new ExperienceSummaryDTO();
        dto.setId(experienceSummary.getId());
        dto.setCompany(CompanyMapper.toDTO(experienceSummary.getCompany()));
        dto.setOrderNumber(experienceSummary.getOrderNumber());
        dto.setSummary(experienceSummary.getSummary());
        dto.setAchievement(experienceSummary.isAchievement());
        dto.setWorkExperience(WorkExperienceMapper.toDTO(experienceSummary.getWorkExperience()));

        return dto;
    }

    public static ExperienceSummary toEntity(ExperienceSummaryDTO dto) {
        if (dto == null) {
            return null;
        }

        ExperienceSummary experienceSummary = new ExperienceSummary();
        experienceSummary.setId(dto.getId());
        experienceSummary.setCompany(CompanyMapper.toEntity(dto.getCompany()));
        experienceSummary.setOrderNumber(dto.getOrderNumber());
        experienceSummary.setSummary(dto.getSummary());
        experienceSummary.setAchievement(dto.isAchievement());
        experienceSummary.setWorkExperience(WorkExperienceMapper.toEntity(dto.getWorkExperience()));

        return experienceSummary;
    }

    public static List<ExperienceSummaryDTO> toDTOList(List<ExperienceSummary> experienceSummaries) {
        return experienceSummaries.stream().map(ExperienceSummaryMapper::toDTO).collect(Collectors.toList());
    }

    public static List<ExperienceSummary> toEntityList(List<ExperienceSummaryDTO> dtos) {
        return dtos.stream().map(ExperienceSummaryMapper::toEntity).collect(Collectors.toList());
    }
}