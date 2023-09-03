package com.iranian.carpet.view.product;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.service.product.ProductService;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import com.iranian.carpet.view.utils.StringConvertUtil;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ProductListPageManageBeanView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private ProductService productService;
    @Getter
    @Setter
    private String productType;
    @Getter
    @Setter
    private String subProductType;



    public List<ProductDto> findProductByType(String productType,
                                              String subProductType,
                                              int pageSize,int page) {
        ProductType productType1=null;
        SubProductType subProductType1=null;
        if(this.productType!=null)
            productType = this.productType;
        if (!productType.isEmpty()){
            try {
                productType1 = ProductType.valueOf(productType);
            }catch (Exception e){
                productType1 = null;
            }
        }
        if (!subProductType.isEmpty()) {
            try {
                subProductType1 = SubProductType.valueOf(subProductType);
            }catch (Exception e){
                subProductType1 = null;
            }
        }
        if(page==0)
            page=1;
            return productService.findProductByType(productType1, subProductType1, pageSize, (page - 1) * pageSize);
    }

    public List<Integer> findPaginationNumbers(String productType,
                                               String subProductType ,int pageSize){
        List<Integer> integers = new ArrayList<>();
        ProductType productType1=null;
        SubProductType subProductType1=null;
        if (!productType.isEmpty()){
            try {
                productType1 = ProductType.valueOf(productType);
            }catch (Exception e){
                productType1 = null;
            }
            }
        if (!subProductType.isEmpty()) {
            try {
                subProductType1 = SubProductType.valueOf(subProductType);
            }catch (Exception e){
                subProductType1 = null;
            }
            }
            Integer count = productService.paginationCount(productType1,subProductType1);
            int size = 0;
            if(count%12==0)
                size = count/12;
            else
                size = count/12 + 1;

            for (int i = 1; i <= size;i++){
                integers.add(i);
            }
        return integers;
    }

    public void changeProdDrop(AjaxBehaviorEvent event) {
         System.out.println(productType);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/carpet-web/pages/product-list.xhtml?productType=" + productType + "&page=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertSpaceToDash(String name){
        return StringConvertUtil.convertSpaceToDash(name);
    }

}
