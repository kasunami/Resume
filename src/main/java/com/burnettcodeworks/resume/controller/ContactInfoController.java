package com.burnettcodeworks.resume.controller;

import com.burnettcodeworks.resume.entity.ContactInfo;
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
    public ResponseEntity<ContactInfo> createContactInfo(@RequestBody ContactInfo contactInfo) {
        ContactInfo createdContactInfo = contactInfoService.createContactInfo(contactInfo);
        return new ResponseEntity<>(createdContactInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInfo> updateContactInfo(@PathVariable UUID id, @RequestBody ContactInfo contactInfo) {
        ContactInfo updatedContactInfo = contactInfoService.updateContactInfo(id, contactInfo);
        return new ResponseEntity<>(updatedContactInfo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactInfo(@PathVariable UUID id) {
        contactInfoService.deleteContactInfo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ContactInfo>> getAllContactInfo() {
        List<ContactInfo> contactInfos = contactInfoService.getAllContactInfo();
        return new ResponseEntity<>(contactInfos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactInfo> getContactInfoById(@PathVariable UUID id) {
        ContactInfo contactInfo = contactInfoService.getContactInfoById(id);
        return new ResponseEntity<>(contactInfo, HttpStatus.OK);
    }
}