package com.burnettcodeworks.resume.dto;


import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Data
public class ContactInfoDTO {

    private UUID id;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phoneNumber;

    @Email
    private String email;

    @URL
    private String website;

    @URL
    private String linkedIn;

    @URL
    private String github;
}