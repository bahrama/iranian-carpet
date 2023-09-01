package com.iranian.carpet.dto.blog;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.model.Blog;
import com.iranian.carpet.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface BlogDtoManager {
    @Mapping(source = "id" , target = "id")
    @Mapping(source = "description" , target = "description")
    @Mapping(source = "link1" , target = "link1")
    @Mapping(source = "link2" , target = "link2")
    @Mapping(source = "link3" , target = "link3")
    @Mapping(source = "link4" , target = "link4")
    @Mapping(source = "link5" , target = "link5")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "pic1" , target = "pic1")
    @Mapping(source = "metaKeywords" , target = "metaKeywords")
    @Mapping(source = "metaDescription" , target = "metaDescription")
    @Mapping(source = "createDate" , target = "createDate")
    @Mapping(source = "updateDate" , target = "updateDate")
    @Mapping(source = "title" , target = "title")
    @Mapping(source = "altPic1" , target = "altPic1")
    @Mapping(source = "h1Title" , target = "h1Title")
    @Mapping(source = "littleDesc" , target = "littleDesc")
    BlogDto transferBlogToDto(Blog blog);

    @InheritInverseConfiguration
    Blog transferBlogDtoToEntity(BlogDto blogDto);
}
