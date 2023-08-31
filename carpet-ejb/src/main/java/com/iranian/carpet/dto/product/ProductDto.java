package com.iranian.carpet.dto.product;

import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private ProductType productType ;
    private String name;
    private String title;
    private String code;
    private String pic1;
    private String pic2;
    private String pic3;
    private String pic4;
    private String pic5;
    private String description;
    private String link1;
    private String link2;
    private String link3;
    private String link4;
    private String link5;
    private String metaDescription;
    private String metaKeywords;
    private Double price;
    private Date productDate;
    private Date createDate;
    private Date updateDate;
    private SubProductType subProductType;
    private String size;
    private String color;
    private String altPic1;
    private String altPic2;
    private String altPic3;
    private String altPic4;
    private String altPic5;
    private String h1Title;
    private String littleDesc;
    private Integer metric;
}
