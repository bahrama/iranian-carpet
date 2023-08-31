package com.iranian.carpet.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN(1,"admin") , USER(2,"user");

    private int prefix;
    private String value;
}
