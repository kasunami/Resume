package com.burnettcodeworks.resume.controller;

import com.burnettcodeworks.resume.entity.WorkExperience;
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
@RequestMapping("/work-experience")
public class WorkExperienceController {

    private final WorkExperienceService workExperienceService;

    public WorkExperienceController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping
    public ResponseEntity<WorkExperience> createWorkExperience(@RequestBody WorkExperience workExperience) {
        WorkExperience createdWorkExperience = workExperienceService.createWorkExperience(workExperience);
        return new ResponseEntity<>(createdWorkExperience, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkExperience> updateWorkExperience(@PathVariable UUID id, @RequestBody WorkExperience workExperience) {
        WorkExperience updatedWorkExperience = workExperienceService.updateWorkExperience(id, workExperience);
        return new ResponseEntity<>(updatedWorkExperience, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkExperience(@PathVariable UUID id) {
        workExperienceService.deleteWorkExperience(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<WorkExperience>> getAllWorkExperiences() {
        List<WorkExperience> workExperiences = workExperienceService.getAllWorkExperiences();
        return new ResponseEntity<>(workExperiences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkExperience> getWorkExperienceById(@PathVariable UUID id) {
        WorkExperience workExperience = workExperienceService.getWorkExperienceById(id);
        return new ResponseEntity<>(workExperience, HttpStatus.OK);
    }
}