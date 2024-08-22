package com.burnettcodeworks.resume.controller;

import com.burnettcodeworks.resume.dto.EducationDTO;
import com.burnettcodeworks.resume.service.EducationService;
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
@RequestMapping("/education")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<EducationDTO> createEducation(@RequestBody EducationDTO educationDTO) {
        EducationDTO createdEducation = educationService.createEducation(educationDTO);
        return new ResponseEntity<>(createdEducation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationDTO> updateEducation(@PathVariable UUID id, @RequestBody EducationDTO educationDTO) {
        EducationDTO updatedEducation = educationService.updateEducation(id, educationDTO);
        return new ResponseEntity<>(updatedEducation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable UUID id) {
        educationService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<EducationDTO>> getAllEducation() {
        List<EducationDTO> educations = educationService.getAllEducation();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationDTO> getEducationById(@PathVariable UUID id) {
        EducationDTO education = educationService.getEducationById(id);
        return new ResponseEntity<>(education, HttpStatus.OK);
    }
}