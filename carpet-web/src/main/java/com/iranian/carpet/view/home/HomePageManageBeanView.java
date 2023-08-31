package com.iranian.carpet.view.home;

import com.iranian.carpet.dto.home.HomeDto;
import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.service.home.HomeService;
import com.iranian.carpet.service.product.ProductService;
import com.iranian.carpet.util.HomeType;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class HomePageManageBeanView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private HomeService homeService;
    @Inject
    private ProductService productService;
    public List<HomeDto> findAllSlider(){
        return homeService.findHomePage(true, HomeType.SLIDER);
    }
    public List<HomeDto> findAllComm(){
        return homeService.findHomePage(true, HomeType.COMM);
    }

    public List<ProductDto> lastSixProduct(){
        return productService.lastSixProduct();
    }
}
