package com.burnettcodeworks.resume.repository;

import com.burnettcodeworks.resume.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    List<Company> findByIndustry(String industry);

    List<Company> findBySize(String size);
}