package com.burnettcodeworks.resume.controller;

import com.burnettcodeworks.resume.dto.ContactInfoDTO;
import com.burnettcodeworks.resume.service.ContactInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contact-info")
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    @PostMapping
    public ResponseEntity<ContactInfoDTO> createContactInfo(@RequestBody ContactInfoDTO contactInfoDTO) {
        ContactInfoDTO createdContactInfo = contactInfoService.createContactInfo(contactInfoDTO);
        return new ResponseEntity<>(createdContactInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInfoDTO> updateContactInfo(@PathVariable UUID id, @RequestBody ContactInfoDTO contactInfoDTO) {
        ContactInfoDTO updatedContactInfo = contactInfoService.updateContactInfo(id, contactInfoDTO);
        return new ResponseEntity<>(updatedContactInfo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactInfo(@PathVariable UUID id) {
        contactInfoService.deleteContactInfo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ContactInfoDTO>> getAllContactInfo() {
        List<ContactInfoDTO> contactInfos = contactInfoService.getAllContactInfo();
        return new ResponseEntity<>(contactInfos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactInfoDTO> getContactInfoById(@PathVariable UUID id) {
        ContactInfoDTO contactInfo = contactInfoService.getContactInfoById(id);
        return new ResponseEntity<>(contactInfo, HttpStatus.OK);
    }
}