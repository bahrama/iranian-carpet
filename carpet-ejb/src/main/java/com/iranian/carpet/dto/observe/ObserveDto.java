package com.iranian.carpet.dto.observe;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ObserveDto {
    private Long id;
    private Date observeDate;
}
