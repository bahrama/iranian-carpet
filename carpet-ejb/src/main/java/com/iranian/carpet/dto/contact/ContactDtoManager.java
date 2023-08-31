package com.iranian.carpet.dto.contact;

import com.iranian.carpet.dto.home.HomeDto;
import com.iranian.carpet.model.Contact;
import com.iranian.carpet.model.Home;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ContactDtoManager {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "email" , target = "email")
    @Mapping(source = "fullName" , target = "fullName")
    @Mapping(source = "message" , target = "message")
    @Mapping(source = "messDate" , target = "messDate")
    @Mapping(source = "phone" , target = "phone")
    ContactDto transferContatcToDto(Contact contact);

    @InheritInverseConfiguration
    Contact transferContactDtoToEntity(ContactDto contactDto);
}
