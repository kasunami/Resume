package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.dto.CompanyDTO;
import com.burnettcodeworks.resume.entity.Company;
import com.burnettcodeworks.resume.mapper.CompanyMapper;
import com.burnettcodeworks.resume.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = CompanyMapper.toEntity(companyDTO);
        return CompanyMapper.toDTO(companyRepository.save(company));
    }

    public CompanyDTO updateCompany(UUID id, CompanyDTO companyDTO) {
        Company company = CompanyMapper.toEntity(companyDTO);
        company.setId(id);
        return CompanyMapper.toDTO(companyRepository.save(company));
    }

    public void deleteCompany(UUID id) {
        companyRepository.deleteById(id);
    }

    public List<CompanyDTO> getAllCompanies() {
        return CompanyMapper.toDTOList(companyRepository.findAll());
    }

    public CompanyDTO getCompanyById(UUID id) {
        return companyRepository.findById(id).map(CompanyMapper::toDTO).orElse(null);
    }

    public List<CompanyDTO> getCompaniesByIndustry(String industry) {
        return CompanyMapper.toDTOList(companyRepository.findByIndustry(industry));
    }

    public List<CompanyDTO> getCompaniesBySize(String size) {
        return CompanyMapper.toDTOList(companyRepository.findBySize(size));
    }
}