package com.burnettcodeworks.resume.entity;

import com.burnettcodeworks.resume.enums.Proficiency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "proficiency")
    @Enumerated(EnumType.STRING)
    private Proficiency proficiencyLevel;

    @Column(name = "years_experience")
    private int yearsOfExperience;

    @ManyToOne
    @JoinColumn(name = "work_experience_id")
    private WorkExperience workExperience;
}
