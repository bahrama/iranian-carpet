package com.iranian.carpet.dto.search;

import com.iranian.carpet.util.BlogType;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SearchDto {
    private Long code;
    private ProductType productType;
    private SubProductType subProductType;
    private BlogType blogType;
    private String title;
    private String name;
    private String h1Title;
    private String littleDesc;
    private String description;
    private String pic1;
    private Date varDate;
    private String type;
}
