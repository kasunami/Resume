package com.burnettcodeworks.resume.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "degree")
    private String degree;

    @Column(name = "major")
    private String major;

    @Column(name = "minor")
    private String minor;

    @Column(name = "gpa")
    private Long gpa;

    @ManyToOne
    @JoinColumn(name = "contact_info_id")
    private ContactInfo contactInfo;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
