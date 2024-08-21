package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.entity.Skill;
import com.burnettcodeworks.resume.repository.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill(UUID id, Skill updatedSkill) {
        verifyExistingSkill(id);
        updatedSkill.setId(id);
        return skillRepository.save(updatedSkill);
    }

    public void deleteSkill(UUID id) {
        verifyExistingSkill(id);
        skillRepository.deleteById(id);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(UUID id) {
        return verifyExistingSkill(id);
    }

    private Skill verifyExistingSkill(UUID id) {
        Optional<Skill> existingSkillOpt = skillRepository.findById(id);

        if (existingSkillOpt.isEmpty()) {
            throw new EntityNotFoundException("Skill with id " + id + " not found");
        }

        return existingSkillOpt.get();
    }
}