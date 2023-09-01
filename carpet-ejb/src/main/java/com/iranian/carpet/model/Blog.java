package com.iranian.carpet.model;

import com.iranian.carpet.util.BlogType;
import com.iranian.carpet.util.CodeGenerator;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="blog")
@Getter
@Setter
@EqualsAndHashCode
@Cacheable(value = false)
@NoArgsConstructor
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "blog_type" , length = 30 , nullable = false)
    private BlogType blogType;
    @Column(length = 200 , nullable = false , unique = true)
    private String name;
    @Column(length = 300 , nullable = false , unique = true)
    private String title;
    @Column(name = "h1_title",length = 300 , nullable = false , unique = true)
    private String h1Title;
    @Column(length = 100)
    private String pic1;
    @Column(name = "alt_pic1",length = 100)
    private String altPic1;
    private String description;
    @Column(length = 1000)
    private String link1;
    @Column(length = 1000)
    private String link2;
    @Column(length = 1000)
    private String link3;
    @Column(length = 1000)
    private String link4;
    @Column(length = 1000)
    private String link5;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="product_date")
    private Date blogDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;
    @Column(length = 200)
    private String metaDescription;
    @Column(length = 300)
    private String metaKeywords;
    @Column(name = "little_desc",length = 2000)
    private String littleDesc;

    @PrePersist
    protected void onCreateDate(){
        this.createDate = new Date();
    }
    @PreUpdate
    protected void onUpdateDate(){
        this.createDate = new Date();
    }
    @PreRemove
    protected void onRemove(){
    }
}
