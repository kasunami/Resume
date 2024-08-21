package com.burnettcodeworks.resume.controller;

import com.burnettcodeworks.resume.entity.ExperienceSummary;
import com.burnettcodeworks.resume.service.ExperienceSummaryService;
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
@RequestMapping("/experience-summary")
public class ExperienceSummaryController {

    private final ExperienceSummaryService experienceSummaryService;

    public ExperienceSummaryController(ExperienceSummaryService experienceSummaryService) {
        this.experienceSummaryService = experienceSummaryService;
    }

    @PostMapping
    public ResponseEntity<ExperienceSummary> createExperienceSummary(@RequestBody ExperienceSummary experienceSummary) {
        ExperienceSummary createdExperienceSummary = experienceSummaryService.createExperienceSummary(experienceSummary);
        return new ResponseEntity<>(createdExperienceSummary, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceSummary> updateExperienceSummary(@PathVariable UUID id, @RequestBody ExperienceSummary experienceSummary) {
        ExperienceSummary updatedExperienceSummary = experienceSummaryService.updateExperienceSummary(id, experienceSummary);
        return new ResponseEntity<>(updatedExperienceSummary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperienceSummary(@PathVariable UUID id) {
        experienceSummaryService.deleteExperienceSummary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ExperienceSummary>> getAllExperienceSummaries() {
        List<ExperienceSummary> experienceSummaries = experienceSummaryService.getAllExperienceSummaries();
        return new ResponseEntity<>(experienceSummaries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceSummary> getExperienceSummaryById(@PathVariable UUID id) {
        ExperienceSummary experienceSummary = experienceSummaryService.getExperienceSummaryById(id);
        return new ResponseEntity<>(experienceSummary, HttpStatus.OK);
    }
}