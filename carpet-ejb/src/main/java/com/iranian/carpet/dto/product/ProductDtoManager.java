package com.iranian.carpet.dto.product;

import com.iranian.carpet.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ProductDtoManager {

    @Mapping(source = "id" , target = "id")
    @Mapping(source = "code" , target = "code")
    @Mapping(source = "description" , target = "description")
    @Mapping(source = "link1" , target = "link1")
    @Mapping(source = "link2" , target = "link2")
    @Mapping(source = "link3" , target = "link3")
    @Mapping(source = "link4" , target = "link4")
    @Mapping(source = "link5" , target = "link5")
    @Mapping(source = "name" , target = "name")
    @Mapping(source = "pic1" , target = "pic1")
    @Mapping(source = "pic2" , target = "pic2")
    @Mapping(source = "pic3" , target = "pic3")
    @Mapping(source = "pic4" , target = "pic4")
    @Mapping(source = "pic5" , target = "pic5")
    @Mapping(source = "price" , target = "price")
    @Mapping(source = "productDate" , target = "productDate")
    @Mapping(source = "productType" , target = "productType")
    @Mapping(source = "subProductType" , target = "subProductType")
    @Mapping(source = "metaKeywords" , target = "metaKeywords")
    @Mapping(source = "metaDescription" , target = "metaDescription")
    @Mapping(source = "createDate" , target = "createDate")
    @Mapping(source = "updateDate" , target = "updateDate")
    @Mapping(source = "title" , target = "title")
    @Mapping(source = "color" , target = "color")
    @Mapping(source = "size" , target = "size")
    @Mapping(source = "altPic1" , target = "altPic1")
    @Mapping(source = "altPic2" , target = "altPic2")
    @Mapping(source = "altPic3" , target = "altPic3")
    @Mapping(source = "altPic4" , target = "altPic4")
    @Mapping(source = "altPic5" , target = "altPic5")
    @Mapping(source = "h1Title" , target = "h1Title")
    @Mapping(source = "littleDesc" , target = "littleDesc")
    @Mapping(source = "metric" , target = "metric")
ProductDto transferProductToDto(Product product);

@InheritInverseConfiguration
Product transferProductDtoToEntity(ProductDto productDto);
}
