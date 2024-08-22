package com.burnettcodeworks.resume.service;

import com.burnettcodeworks.resume.dto.ContactInfoDTO;
import com.burnettcodeworks.resume.entity.ContactInfo;
import com.burnettcodeworks.resume.mapper.ContactInfoMapper;
import com.burnettcodeworks.resume.repository.ContactInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContactInfoService {

    private final ContactInfoRepository contactInfoRepository;

    public ContactInfoService(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    public ContactInfoDTO createContactInfo(ContactInfoDTO contactInfoDTO) {
        ContactInfo contactInfo = ContactInfoMapper.toEntity(contactInfoDTO);
        return ContactInfoMapper.toDTO(contactInfoRepository.save(contactInfo));
    }

    public ContactInfoDTO updateContactInfo(UUID id, ContactInfoDTO contactInfoDTO) {
        ContactInfo contactInfo = ContactInfoMapper.toEntity(contactInfoDTO);
        contactInfo.setId(id);
        return ContactInfoMapper.toDTO(contactInfoRepository.save(contactInfo));
    }

    public void deleteContactInfo(UUID id) {
        contactInfoRepository.deleteById(id);
    }

    public List<ContactInfoDTO> getAllContactInfo() {
        return contactInfoRepository.findAll().stream()
                .map(ContactInfoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContactInfoDTO getContactInfoById(UUID id) {
        return contactInfoRepository.findById(id)
                .map(ContactInfoMapper::toDTO)
                .orElse(null);
    }
}