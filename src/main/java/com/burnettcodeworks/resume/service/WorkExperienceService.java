package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.entity.WorkExperience;
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

    public WorkExperience createWorkExperience(WorkExperience workExperience) {
        return workExperienceRepository.save(workExperience);
    }

    public WorkExperience updateWorkExperience(UUID id, WorkExperience workExperience) {
        workExperience.setId(id);
        return workExperienceRepository.save(workExperience);
    }

    public void deleteWorkExperience(UUID id) {
        workExperienceRepository.deleteById(id);
    }

    public List<WorkExperience> getAllWorkExperiences() {
        return workExperienceRepository.findAll();
    }

    public WorkExperience getWorkExperienceById(UUID id) {
        return workExperienceRepository.findById(id).orElse(null);
    }
}