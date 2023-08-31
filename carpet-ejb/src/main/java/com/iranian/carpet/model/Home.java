package com.iranian.carpet.model;

import com.iranian.carpet.util.HomeType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="home")
@Getter
@Setter
@EqualsAndHashCode
@Cacheable(value = false)
@NoArgsConstructor
public class Home implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "home_type" , length = 10 , nullable = false)
    private HomeType homeType;
    @Column(length = 200 , nullable = false)
    private String pic;
    @Column(length = 200 , nullable = false)
    private String link;
    @Column(length = 2000 , nullable = false)
    private String description;
    @Column(length = 200 , nullable = false)
    private String title;
    @Column(length = 200 , nullable = false)
    private String title2;
    private Boolean active;

}
