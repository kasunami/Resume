package com.burnettcodeworks.resume.mapper;

import com.burnettcodeworks.resume.dto.ContactInfoDTO;
import com.burnettcodeworks.resume.entity.ContactInfo;

public class ContactInfoMapper {

    public static ContactInfoDTO toDTO(ContactInfo contactInfo) {
        if (contactInfo == null) {
            return null;
        }

        ContactInfoDTO dto = new ContactInfoDTO();
        dto.setId(contactInfo.getId());
        dto.setStreetAddress(contactInfo.getStreetAddress());
        dto.setCity(contactInfo.getCity());
        dto.setState(contactInfo.getState());
        dto.setZipCode(contactInfo.getZipCode());
        dto.setCountry(contactInfo.getCountry());
        dto.setPhoneNumber(contactInfo.getPhoneNumber());
        dto.setEmail(contactInfo.getEmail());
        dto.setWebsite(contactInfo.getWebsite());
        dto.setLinkedIn(contactInfo.getLinkedIn());
        dto.setGithub(contactInfo.getGithub());

        return dto;
    }

    public static ContactInfo toEntity(ContactInfoDTO dto) {
        if (dto == null) {
            return null;
        }

        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setId(dto.getId());
        contactInfo.setStreetAddress(dto.getStreetAddress());
        contactInfo.setCity(dto.getCity());
        contactInfo.setState(dto.getState());
        contactInfo.setZipCode(dto.getZipCode());
        contactInfo.setCountry(dto.getCountry());
        contactInfo.setPhoneNumber(dto.getPhoneNumber());
        contactInfo.setEmail(dto.getEmail());
        contactInfo.setWebsite(dto.getWebsite());
        contactInfo.setLinkedIn(dto.getLinkedIn());
        contactInfo.setGithub(dto.getGithub());

        return contactInfo;
    }
}