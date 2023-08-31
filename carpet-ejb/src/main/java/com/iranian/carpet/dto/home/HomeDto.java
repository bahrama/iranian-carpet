package com.iranian.carpet.dto.home;

import com.iranian.carpet.util.HomeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeDto {
    private Long id;
    private HomeType homeType;
    private String pic;
    private String link;
    private String description;
    private String title;
    private String title2;
    private Boolean active;
}
