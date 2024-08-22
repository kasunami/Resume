package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.dto.SkillDTO;
import com.burnettcodeworks.resume.entity.Skill;
import com.burnettcodeworks.resume.mapper.SkillMapper;
import com.burnettcodeworks.resume.repository.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public SkillDTO createSkill(SkillDTO skillDTO) {
        Skill skill = SkillMapper.toEntity(skillDTO);
        return SkillMapper.toDTO(skillRepository.save(skill));
    }

    public SkillDTO updateSkill(UUID id, SkillDTO updatedSkillDTO) {
        verifyExistingSkill(id);
        Skill updatedSkill = SkillMapper.toEntity(updatedSkillDTO);
        updatedSkill.setId(id);
        return SkillMapper.toDTO(skillRepository.save(updatedSkill));
    }

    public void deleteSkill(UUID id) {
        verifyExistingSkill(id);
        skillRepository.deleteById(id);
    }

    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(SkillMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SkillDTO getSkillById(UUID id) {
        Skill skill = verifyExistingSkill(id);
        return SkillMapper.toDTO(skill);
    }

    private Skill verifyExistingSkill(UUID id) {
        Optional<Skill> existingSkillOpt = skillRepository.findById(id);

        if (existingSkillOpt.isEmpty()) {
            throw new EntityNotFoundException("Skill with id " + id + " not found");
        }

        return existingSkillOpt.get();
    }
}