package com.burnettcodeworks.resume.entity;


import com.burnettcodeworks.resume.enums.Location;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "work_experience")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "title")
    private String jobTitle;

    @Column(name = "location")
    @Enumerated(EnumType.STRING)
    private Location location;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "workExperience", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skillsUsed;

    @OneToMany(mappedBy = "workExperience", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienceSummary> summaryPoints;
}
