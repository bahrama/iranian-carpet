package com.iranian.carpet.dao.product;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.model.Product;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import jakarta.ejb.Local;
import jakarta.transaction.Transactional;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Local
public interface ProductDao {
    Optional<Product> findProductById(Long id);

    Optional<Product> findProductByCode(String code);

    @Transactional(Transactional.TxType.REQUIRED)
    Optional<Product> save(Product product) throws Exception;

    List<Product> findAllProduct();

    Long delete(Product product);

    List<Product> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy);

    int countProduct();

    List<Product> findProductByType(ProductType productType,
                                    SubProductType subProductType,
                                    int pageSize, int offset);

    int paginationCount(ProductType productType,
                        SubProductType subProductType);

    List<Product> lastSixProduct();

    List<Product> findProductBySameCategory(ProductDto productDto);
}
