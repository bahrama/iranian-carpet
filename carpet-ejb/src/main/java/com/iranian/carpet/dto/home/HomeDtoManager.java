package com.iranian.carpet.dto.home;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.model.Home;
import com.iranian.carpet.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface HomeDtoManager {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "description" , target = "description")
    @Mapping(source = "pic" , target = "pic")
    @Mapping(source = "homeType" , target = "homeType")
    @Mapping(source = "title" , target = "title")
    @Mapping(source = "title2" , target = "title2")
    @Mapping(source = "link" , target = "link")
    @Mapping(source = "active" , target = "active")
    HomeDto transferHomeToDto(Home home);

    @InheritInverseConfiguration
    Home transferHomeDtoToEntity(HomeDto homeDto);
}
