package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.dto.EducationDTO;
import com.burnettcodeworks.resume.entity.Education;
import com.burnettcodeworks.resume.mapper.EducationMapper;
import com.burnettcodeworks.resume.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public EducationDTO createEducation(EducationDTO educationDTO) {
        Education education = EducationMapper.toEntity(educationDTO);
        return EducationMapper.toDTO(educationRepository.save(education));
    }

    public EducationDTO updateEducation(UUID id, EducationDTO educationDTO) {
        Education education = EducationMapper.toEntity(educationDTO);
        education.setId(id);
        return EducationMapper.toDTO(educationRepository.save(education));
    }

    public void deleteEducation(UUID id) {
        educationRepository.deleteById(id);
    }

    public List<EducationDTO> getAllEducation() {
        return educationRepository.findAll().stream()
                .map(EducationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EducationDTO getEducationById(UUID id) {
        return educationRepository.findById(id)
                .map(EducationMapper::toDTO)
                .orElse(null);
    }
}