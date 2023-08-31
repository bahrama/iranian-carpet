package com.iranian.carpet.dto.user;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String mail;
    private String pass;
}
