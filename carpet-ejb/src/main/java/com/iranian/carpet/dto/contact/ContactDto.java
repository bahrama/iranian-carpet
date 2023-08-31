package com.iranian.carpet.dto.contact;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ContactDto {
    private Long id;
    private Date messDate;
    private String fullName;
    private String email;
    private String phone;
    private String message;
}
