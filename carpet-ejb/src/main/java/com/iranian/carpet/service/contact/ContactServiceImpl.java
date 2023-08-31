package com.iranian.carpet.service.contact;

import com.iranian.carpet.dao.contact.ContactDao;
import com.iranian.carpet.dto.contact.ContactDto;
import com.iranian.carpet.dto.contact.ContactDtoManager;
import com.iranian.carpet.model.Contact;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

public class ContactServiceImpl implements ContactService{
    @Inject
    private ContactDao contactDao;

    private ContactDtoManager contactDtoManager = Mappers.getMapper(ContactDtoManager.class);
    @Override
    public Optional<Contact> save(ContactDto contactDto) throws Exception {
        return contactDao.save(contactDtoManager.transferContactDtoToEntity(contactDto));
    }
}
