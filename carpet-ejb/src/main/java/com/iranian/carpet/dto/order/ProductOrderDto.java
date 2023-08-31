package com.iranian.carpet.dto.order;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductOrderDto {
    private Long id;
    private int productNumber;
    private Date orderDate;
}
