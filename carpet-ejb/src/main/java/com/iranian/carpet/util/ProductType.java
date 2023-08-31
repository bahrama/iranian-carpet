package com.iranian.carpet.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;
@AllArgsConstructor
@Getter
public enum ProductType {
    CARPET(1,"carpet")
    ,RUG(2,"rug")
    ,CASHEW(3,"cashew")
    ,ENAMELS(4,"enamels");

    private int prefix;

    private String value;


}
