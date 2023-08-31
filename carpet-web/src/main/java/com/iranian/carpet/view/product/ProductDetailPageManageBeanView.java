package com.iranian.carpet.view.product;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.service.product.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProductDetailPageManageBeanView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private ProductService productService;

    @Getter
    @Setter
    private ProductDto productDto;
    @PostConstruct
    public void init(){
        productDto = new ProductDto();
    }

    public ProductDto findProductByCode(String code){
        productDto = productService.findProductByCode(code);
        return productDto;
    }

    public List<ProductDto> findProductBySameCategory(){
        return productService.findProductBySameCategory(productDto);
    }
}
