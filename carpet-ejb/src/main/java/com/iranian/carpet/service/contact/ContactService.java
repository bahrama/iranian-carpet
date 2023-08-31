package com.iranian.carpet.service.contact;

import com.iranian.carpet.dto.contact.ContactDto;
import com.iranian.carpet.model.Contact;

import java.util.Optional;

public interface ContactService {
    Optional<Contact> save(ContactDto contactDto) throws Exception;
}
