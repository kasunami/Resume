package com.burnettcodeworks.resume.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CompanyDTO {

    private UUID id;
    private String name;
    private ContactInfoDTO contactInfo;
    private String industry;
    private String size;
}