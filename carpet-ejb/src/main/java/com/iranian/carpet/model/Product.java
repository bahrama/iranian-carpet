package com.iranian.carpet.model;

import com.iranian.carpet.util.CodeGenerator;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="product")
@Getter
@Setter
@EqualsAndHashCode
@Cacheable(value = false)
@NoArgsConstructor
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "product_type" , length = 30 , nullable = false)
    private ProductType productType;
    @Enumerated(EnumType.STRING)
    @Column(name = "sub_product_type" , length = 50 , nullable = false)
    private SubProductType subProductType;
    @Column(length = 200 , nullable = false , unique = true)
    private String name;
    @Column(length = 300 , nullable = false , unique = true)
    private String title;
    @Column(name = "h1_title",length = 300 , nullable = false , unique = true)
    private String h1Title;
    @Column(length = 10 , nullable = false , unique = true)
    private String code;
    @Column(length = 100)
    private String pic1;
    @Column(name = "alt_pic1",length = 100)
    private String altPic1;
    @Column(length = 100)
    private String pic2;
    @Column(name = "alt_pic2",length = 100)
    private String altPic2;
    @Column(length = 100)
    private String pic3;
    @Column(name = "alt_pic3",length = 100)
    private String altPic3;
    @Column(length = 100)
    private String pic4;
    @Column(name = "alt_pic4",length = 100)
    private String altPic4;
    @Column(length = 100)
    private String pic5;
    @Column(name = "alt_pic5",length = 100)
    private String altPic5;
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
    private Double price;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="product_date")
    private Date productDate;
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
    @Column(length = 300)
    private String size;
    @Column(length = 300)
    private String color;
    @Column(name = "little_desc",length = 100)
    private String littleDesc;
    @Column(name = "metric",length = 100)
    private Integer metric;
    //orphanRemoval remove all child that no longer reference with parent
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="product",
            cascade= CascadeType.ALL , orphanRemoval = true)
    private Set<ProductOrder> orders = new HashSet<>();

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="product",
            cascade= CascadeType.ALL , orphanRemoval = true)
    private Set<Observe> observes = new HashSet<>();

    @PrePersist
    protected void onCreateDate(){
        this.createDate = new Date();
        this.code = CodeGenerator.carpetCodeGenerator();
    }
    @PreUpdate
    protected void onUpdateDate(){
        this.createDate = new Date();
    }
    @PreRemove
    protected void onRemove(){
    }
}
