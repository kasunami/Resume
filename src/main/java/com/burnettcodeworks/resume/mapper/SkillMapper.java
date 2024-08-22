package com.burnettcodeworks.resume.mapper;

import com.burnettcodeworks.resume.dto.SkillDTO;
import com.burnettcodeworks.resume.entity.Skill;

import java.util.List;
import java.util.stream.Collectors;

public class SkillMapper {

    public static SkillDTO toDTO(Skill skill) {
        if (skill == null) {
            return null;
        }

        SkillDTO dto = new SkillDTO();
        dto.setId(skill.getId());
        dto.setName(skill.getName());
        dto.setType(skill.getType());
        dto.setProficiencyLevel(skill.getProficiencyLevel());
        dto.setYearsOfExperience(skill.getYearsOfExperience());
        dto.setWorkExperience(WorkExperienceMapper.toDTO(skill.getWorkExperience()));

        return dto;
    }

    public static Skill toEntity(SkillDTO dto) {
        if (dto == null) {
            return null;
        }

        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setType(dto.getType());
        skill.setProficiencyLevel(dto.getProficiencyLevel());
        skill.setYearsOfExperience(dto.getYearsOfExperience());
        skill.setWorkExperience(WorkExperienceMapper.toEntity(dto.getWorkExperience()));

        return skill;
    }

    public static List<SkillDTO> toDTOList(List<Skill> skills) {
        return skills.stream().map(SkillMapper::toDTO).collect(Collectors.toList());
    }

    public static List<Skill> toEntityList(List<SkillDTO> dtos) {
        return dtos.stream().map(SkillMapper::toEntity).collect(Collectors.toList());
    }
}