package com.iranian.carpet.service.product;

import com.iranian.carpet.dao.product.ProductDao;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.dto.product.ProductDtoManager;
import com.iranian.carpet.model.Product;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.*;

@Stateless
public class ProductServiceImpl implements ProductService{
    @Inject
    private ProductDao productDao;
    private ProductDtoManager productDtoManager = Mappers.getMapper(ProductDtoManager.class);
    @Override
    public Optional<Product> save(ProductDto productDto) throws Exception {
       return productDao.save(productDtoManager.transferProductDtoToEntity(productDto));
    }

    @Override
    public List<ProductDto> findAllProduct(){
        List<ProductDto> productDtos = new ArrayList<>();
        productDao.findAllProduct().stream()
                .forEach(p -> {
                    productDtos.add(productDtoManager.transferProductToDto(p));
                });
        return productDtos;
    }

    @Override
    public Long delete(ProductDto productDto){
       return productDao.delete(productDtoManager.transferProductDtoToEntity(productDto));
    }
    @Override
    public ProductDto findProductById(Long id) throws NoSuchElementException {
        try {
            return productDtoManager.transferProductToDto(productDao.findProductById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }
    @Override
    public ProductDto findProductByCode(String code) throws NoSuchElementException {
        try {
            return productDtoManager.transferProductToDto(productDao.findProductByCode(code).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }
     @Override
    public List<ProductDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<Product> products = productDao.search(offset,pageSize,sortBy,filterBy);
        List<ProductDto> productDtos = new ArrayList<>();
         products.stream().forEach(i->{
             productDtos.add(productDtoManager.transferProductToDto(i));
        });
        return productDtos;
    }

    @Override
    public int countProduct(){
        return productDao.countProduct();
    }

    @Override
    public List<ProductDto> findProductByType(ProductType productType,
                                              SubProductType subProductType,
                                              int pageSize, int offset) {
    List<ProductDto> productDtos = new ArrayList<>();
    List<Product> products = productDao.findProductByType(productType,subProductType,pageSize,offset);
    products.forEach(i->{
        productDtos.add(productDtoManager.transferProductToDto(i));
    });
    return productDtos;
    }

    @Override
    public int paginationCount(ProductType productType,
                               SubProductType subProductType){
        return productDao.paginationCount(productType,subProductType);
    }

    @Override
    public List<ProductDto> lastSixProduct(){
        List<ProductDto> productDtos = new ArrayList<>();
        productDao.lastSixProduct().forEach(i->{
            productDtos.add(productDtoManager.transferProductToDto(i));
        });
        return productDtos;
    }
    @Override
    public List<ProductDto> findProductBySameCategory(ProductDto productDto){
        List<ProductDto> productDtos = new ArrayList<>();
        productDao.findProductBySameCategory(productDto).forEach(i->{
            productDtos.add(productDtoManager.transferProductToDto(i));
        });
        return productDtos;
    }

    }

