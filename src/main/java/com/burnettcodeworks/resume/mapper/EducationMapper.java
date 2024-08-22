package com.burnettcodeworks.resume.mapper;

import com.burnettcodeworks.resume.dto.EducationDTO;
import com.burnettcodeworks.resume.entity.Education;

import java.util.List;
import java.util.stream.Collectors;

public class EducationMapper {

    public static EducationDTO toDTO(Education education) {
        if (education == null) {
            return null;
        }

        EducationDTO dto = new EducationDTO();
        dto.setId(education.getId());
        dto.setSchoolName(education.getSchoolName());
        dto.setDegree(education.getDegree());
        dto.setMajor(education.getMajor());
        dto.setMinor(education.getMinor());
        dto.setGpa(education.getGpa());
        dto.setContactInfo(ContactInfoMapper.toDTO(education.getContactInfo()));
        dto.setStartDate(education.getStartDate());
        dto.setEndDate(education.getEndDate());

        return dto;
    }

    public static Education toEntity(EducationDTO dto) {
        if (dto == null) {
            return null;
        }

        Education education = new Education();
        education.setId(dto.getId());
        education.setSchoolName(dto.getSchoolName());
        education.setDegree(dto.getDegree());
        education.setMajor(dto.getMajor());
        education.setMinor(dto.getMinor());
        education.setGpa(dto.getGpa());
        education.setContactInfo(ContactInfoMapper.toEntity(dto.getContactInfo()));
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());

        return education;
    }

    public static List<EducationDTO> toDTOList(List<Education> educations) {
        return educations.stream().map(EducationMapper::toDTO).collect(Collectors.toList());
    }

    public static List<Education> toEntityList(List<EducationDTO> dtos) {
        return dtos.stream().map(EducationMapper::toEntity).collect(Collectors.toList());
    }
}