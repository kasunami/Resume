package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.dto.WorkExperienceDTO;
import com.burnettcodeworks.resume.entity.WorkExperience;
import com.burnettcodeworks.resume.mapper.WorkExperienceMapper;
import com.burnettcodeworks.resume.repository.WorkExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkExperienceService {

    private final WorkExperienceRepository workExperienceRepository;

    public WorkExperienceService(WorkExperienceRepository workExperienceRepository) {
        this.workExperienceRepository = workExperienceRepository;
    }

    public WorkExperienceDTO createWorkExperience(WorkExperienceDTO workExperienceDTO) {
        WorkExperience workExperience = WorkExperienceMapper.toEntity(workExperienceDTO);
        return WorkExperienceMapper.toDTO(workExperienceRepository.save(workExperience));
    }

    public WorkExperienceDTO updateWorkExperience(UUID id, WorkExperienceDTO workExperienceDTO) {
        workExperienceDTO.setId(id);
        WorkExperience updatedWorkExperience = WorkExperienceMapper.toEntity(workExperienceDTO);
        return WorkExperienceMapper.toDTO(workExperienceRepository.save(updatedWorkExperience));
    }

    public void deleteWorkExperience(UUID id) {
        workExperienceRepository.deleteById(id);
    }

    public List<WorkExperienceDTO> getAllWorkExperiences() {
        return WorkExperienceMapper.toDTOList(workExperienceRepository.findAll());
    }

    public WorkExperienceDTO getWorkExperienceById(UUID id) {
        return workExperienceRepository.findById(id)
                .map(WorkExperienceMapper::toDTO)
                .orElse(null);
    }
}