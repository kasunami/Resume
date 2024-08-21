package com.burnettcodeworks.resume.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "experience_summary")
public class ExperienceSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "summary")
    private String summary;

    @Column(name = "achievement")
    private boolean achievement;

    @ManyToOne
    @JoinColumn(name = "work_experience_id")
    private WorkExperience workExperience;
}