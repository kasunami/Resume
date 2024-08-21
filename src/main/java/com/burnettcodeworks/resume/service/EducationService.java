package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.entity.Education;
import com.burnettcodeworks.resume.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education updateEducation(UUID id, Education education) {
        education.setId(id);
        return educationRepository.save(education);
    }

    public void deleteEducation(UUID id) {
        educationRepository.deleteById(id);
    }

    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    public Education getEducationById(UUID id) {
        return educationRepository.findById(id).orElse(null);
    }
}