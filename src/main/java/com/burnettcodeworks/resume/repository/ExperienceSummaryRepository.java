package com.burnettcodeworks.resume.repository;

import com.burnettcodeworks.resume.entity.ExperienceSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExperienceSummaryRepository extends JpaRepository<ExperienceSummary, UUID> {

    List<ExperienceSummary> findByCompanyId(UUID companyId);

    List<ExperienceSummary> findByWorkExperienceId(UUID workExperienceId);
}