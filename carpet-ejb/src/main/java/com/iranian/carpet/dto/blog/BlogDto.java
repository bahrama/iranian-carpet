package com.iranian.carpet.dto.blog;

import com.iranian.carpet.util.BlogType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BlogDto {
    private Long id;
    private BlogType blogType;
    private String name;
    private String title;
    private String h1Title;
    private String pic1;
    private String altPic1;
    private String description;
    private String link1;
    private String link2;
    private String link3;
    private String link4;
    private String link5;
    private Date blogDate;
    private Date createDate;
    private Date updateDate;
    private String metaDescription;
    private String metaKeywords;
    private String littleDesc;
}
