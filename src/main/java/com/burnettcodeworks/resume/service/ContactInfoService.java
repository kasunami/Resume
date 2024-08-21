package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.entity.ContactInfo;
import com.burnettcodeworks.resume.repository.ContactInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactInfoService {

    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoService(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    public ContactInfo createContactInfo(ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }

    public ContactInfo updateContactInfo(UUID id, ContactInfo contactInfo) {
        contactInfo.setId(id);
        return contactInfoRepository.save(contactInfo);
    }

    public void deleteContactInfo(UUID id) {
        contactInfoRepository.deleteById(id);
    }

    public List<ContactInfo> getAllContactInfo() {
        return contactInfoRepository.findAll();
    }

    public ContactInfo getContactInfoById(UUID id) {
        return contactInfoRepository.findById(id).orElse(null);
    }
}