package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.entity.ExperienceSummary;
import com.burnettcodeworks.resume.repository.ExperienceSummaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExperienceSummaryService {

    private final ExperienceSummaryRepository experienceSummaryRepository;

    public ExperienceSummaryService(ExperienceSummaryRepository experienceSummaryRepository) {
        this.experienceSummaryRepository = experienceSummaryRepository;
    }

    public ExperienceSummary createExperienceSummary(ExperienceSummary experienceSummary) {
        return experienceSummaryRepository.save(experienceSummary);
    }

    public ExperienceSummary updateExperienceSummary(UUID id, ExperienceSummary experienceSummary) {
        experienceSummary.setId(id);
        return experienceSummaryRepository.save(experienceSummary);
    }

    public void deleteExperienceSummary(UUID id) {
        experienceSummaryRepository.deleteById(id);
    }

    public List<ExperienceSummary> getAllExperienceSummaries() {
        return experienceSummaryRepository.findAll();
    }

    public ExperienceSummary getExperienceSummaryById(UUID id) {
        return experienceSummaryRepository.findById(id).orElse(null);
    }
}