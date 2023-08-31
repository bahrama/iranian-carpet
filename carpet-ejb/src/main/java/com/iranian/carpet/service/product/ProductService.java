package com.iranian.carpet.service.product;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.model.Product;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import jakarta.ejb.Local;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Local
public interface ProductService {
    Optional<Product> save(ProductDto productDto) throws Exception;

    List<ProductDto> findAllProduct();

    Long delete(ProductDto productDto);

    ProductDto findProductById(Long id);

    ProductDto findProductByCode(String code) throws NoSuchElementException;

    List<ProductDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy);

    int countProduct();

    List<ProductDto> findProductByType(ProductType productType,
                                       SubProductType subProductType,
                                       int pageSize, int offset);

    int paginationCount(ProductType productType,
                        SubProductType subProductType);

    List<ProductDto> lastSixProduct();

    List<ProductDto> findProductBySameCategory(ProductDto productDto);
}
