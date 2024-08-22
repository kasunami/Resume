package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.dto.ExperienceSummaryDTO;
import com.burnettcodeworks.resume.entity.ExperienceSummary;
import com.burnettcodeworks.resume.mapper.ExperienceSummaryMapper;
import com.burnettcodeworks.resume.repository.ExperienceSummaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ExperienceSummaryService {

    private final ExperienceSummaryRepository experienceSummaryRepository;

    public ExperienceSummaryService(ExperienceSummaryRepository experienceSummaryRepository) {
        this.experienceSummaryRepository = experienceSummaryRepository;
    }

    public ExperienceSummaryDTO createExperienceSummary(ExperienceSummaryDTO experienceSummaryDTO) {
        ExperienceSummary experienceSummary = ExperienceSummaryMapper.toEntity(experienceSummaryDTO);
        return ExperienceSummaryMapper.toDTO(experienceSummaryRepository.save(experienceSummary));
    }

    public ExperienceSummaryDTO updateExperienceSummary(UUID id, ExperienceSummaryDTO experienceSummaryDTO) {
        ExperienceSummary experienceSummary = ExperienceSummaryMapper.toEntity(experienceSummaryDTO);
        experienceSummary.setId(id);
        return ExperienceSummaryMapper.toDTO(experienceSummaryRepository.save(experienceSummary));
    }

    public void deleteExperienceSummary(UUID id) {
        experienceSummaryRepository.deleteById(id);
    }

    public List<ExperienceSummaryDTO> getAllExperienceSummaries() {
        return experienceSummaryRepository.findAll().stream()
                .map(ExperienceSummaryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ExperienceSummaryDTO getExperienceSummaryById(UUID id) {
        return experienceSummaryRepository.findById(id)
                .map(ExperienceSummaryMapper::toDTO)
                .orElse(null);
    }
}