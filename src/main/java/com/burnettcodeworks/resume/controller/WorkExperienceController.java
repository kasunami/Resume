package com.burnettcodeworks.resume.controller;

import com.burnettcodeworks.resume.dto.WorkExperienceDTO;
import com.burnettcodeworks.resume.service.WorkExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/work-experiences")
public class WorkExperienceController {

    private final WorkExperienceService workExperienceService;

    public WorkExperienceController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping
    public ResponseEntity<WorkExperienceDTO> createWorkExperience(@RequestBody WorkExperienceDTO workExperienceDTO) {
        WorkExperienceDTO createdWorkExperience = workExperienceService.createWorkExperience(workExperienceDTO);
        return new ResponseEntity<>(createdWorkExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkExperienceDTO> updateWorkExperience(@PathVariable UUID id, @RequestBody WorkExperienceDTO workExperienceDTO) {
        WorkExperienceDTO updatedWorkExperience = workExperienceService.updateWorkExperience(id, workExperienceDTO);
        return new ResponseEntity<>(updatedWorkExperience, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkExperience(@PathVariable UUID id) {
        workExperienceService.deleteWorkExperience(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<WorkExperienceDTO>> getAllWorkExperiences() {
        List<WorkExperienceDTO> workExperiences = workExperienceService.getAllWorkExperiences();
        return new ResponseEntity<>(workExperiences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkExperienceDTO> getWorkExperienceById(@PathVariable UUID id) {
        WorkExperienceDTO workExperience = workExperienceService.getWorkExperienceById(id);
        return new ResponseEntity<>(workExperience, HttpStatus.OK);
    }
}