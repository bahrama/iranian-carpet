package com.iranian.carpet.model;

import com.iranian.carpet.util.UserRole;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.persistence.internal.jpa.config.queries.PlsqlRecordImpl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="user_entity")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Cacheable(value = false)
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100 , nullable = false , unique = true)
    private String mail;
    @Column(length = 200)
    private String pass;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role" , length = 10)
    private UserRole userRole;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="user",
            cascade= CascadeType.ALL , orphanRemoval = true)
    private Set<ProductOrder> orders = new HashSet<>();

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="user",
            cascade= CascadeType.ALL , orphanRemoval = true)
    private Set<Observe> observes = new HashSet<>();
}
