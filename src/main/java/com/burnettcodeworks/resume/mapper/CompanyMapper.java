package com.burnettcodeworks.resume.mapper;

import com.burnettcodeworks.resume.dto.CompanyDTO;
import com.burnettcodeworks.resume.entity.Company;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyMapper {

    public static CompanyDTO toDTO(Company company) {
        if (company == null) {
            return null;
        }

        CompanyDTO dto = new CompanyDTO();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setContactInfo(ContactInfoMapper.toDTO(company.getContactInfo()));
        dto.setIndustry(company.getIndustry());
        dto.setSize(company.getSize());

        return dto;
    }

    public static Company toEntity(CompanyDTO dto) {
        if (dto == null) {
            return null;
        }

        Company company = new Company();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setContactInfo(ContactInfoMapper.toEntity(dto.getContactInfo()));
        company.setIndustry(dto.getIndustry());
        company.setSize(dto.getSize());

        return company;
    }

    public static List<CompanyDTO> toDTOList(List<Company> companies) {
        return companies.stream().map(CompanyMapper::toDTO).collect(Collectors.toList());
    }

    public static List<Company> toEntityList(List<CompanyDTO> dtos) {
        return dtos.stream().map(CompanyMapper::toEntity).collect(Collectors.toList());
    }
}