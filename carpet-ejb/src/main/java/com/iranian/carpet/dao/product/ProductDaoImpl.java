package com.iranian.carpet.dao.product;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.model.Product;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.*;

@Stateless
public class ProductDaoImpl implements ProductDao{

    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    @Override
    public Optional<Product> findProductById(Long id) {
            Product product = em.find(Product.class , id);
            return product != null ? Optional.of(product):Optional.empty();
    }
    @Override
    public Optional<Product> findProductByCode(String code) {
        String q = "select * from product \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        queryBuilder.append("where code = ?");
        Query query = em.createNativeQuery(queryBuilder.toString(), Product.class);
        query.setParameter(1,code);
        Product product = (Product) query.getSingleResult();
        return Optional.ofNullable(product);
    }
    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public Optional<Product> save(Product product) throws Exception {
        try {
            if (product.getId() == null) {
                em.persist(product);
            } else {
                product = em.merge(product);
            }
            return Optional.of(product);
        }catch (Exception e){
            throw new Exception();
        }
        }
        @Override
        public List<Product> findAllProduct(){
            String q = "select p from Product p";
            StringBuilder queryBuilder =new StringBuilder(q);
            Query query = em.createQuery(q,Product.class);
            return query.getResultList();
        }
        @Override
        public Long delete(Product product){
        Optional<Product> product1 = findProductById(product.getId());
        if(product1.isPresent())
        em.remove(product1.get());
        return product.getId();
        }
        @Override
        public List<Product> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
            String q = "select * from product \n";
            StringBuilder queryBuilder =new StringBuilder(q);
            if(filterBy.size()>0){
                queryBuilder.append(" where 1=1 \n");
                filterBy.forEach((k,v) ->{
                    if(k.equals("productType"))
                        k="product_type";
                    queryBuilder.append(" and " + k + " like" + " '%" + v + "%' \n");
                });
            }
            if(sortBy.size()>0){
                sortBy.forEach((k,v) ->{
                    if(k.equals("productType"))
                        k="product_type";
                    if(v.equals("ASCENDING"))
                        v="asc";
                    else
                        v="desc";
                    queryBuilder.append(" order by " + k + " " + v);
                });
            }
            Query query = em.createNativeQuery(queryBuilder.toString(), Product.class);
            query.setFirstResult(offset);
            query.setMaxResults(pageSize);
            List<Product> product = query.getResultList();
            return product;
        }
    @Override
    public int countProduct(){
        String q = "select count(*) as count from product \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }
    @Override
    public List<Product> findProductByType(ProductType productType,
                                           SubProductType subProductType,
                                           int pageSize, int offset){
        String q = "select * from product where 1=1 \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(productType!=null &&!productType.toString().isEmpty()){
            queryBuilder.append(" and product_type = ? \n");
        }
        if(subProductType!=null && !subProductType.toString().isEmpty()){
            queryBuilder.append(" and sub_product_type = ? \n");
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), Product.class);
        if(productType!=null && !productType.toString().isEmpty()){
            query.setParameter(1,productType.toString());
        }
        if(subProductType!=null && !subProductType.toString().isEmpty()){
            query.setParameter(2,subProductType.toString());
        }
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
    @Override
    public int paginationCount(ProductType productType,
                               SubProductType subProductType){
        String q = "select count(*) as count from product where 1=1 \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(productType!=null &&!productType.toString().isEmpty()){
            queryBuilder.append(" and product_type = ? \n");
        }
        if(subProductType!=null && !subProductType.toString().isEmpty()){
            queryBuilder.append(" and sub_product_type = ? \n");
        }
        Query query = em.createNativeQuery(queryBuilder.toString());
        if(productType!=null && !productType.toString().isEmpty()){
            query.setParameter(1,productType.toString());
        }
        if(subProductType!=null && !subProductType.toString().isEmpty()){
            query.setParameter(2,subProductType.toString());
        }
        Long count = (Long) query.getSingleResult();
        return count.intValue();
    }
    @Override
    public List<Product> lastSixProduct(){
        String q = "select * from product order by id desc limit 6 \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        Query query = em.createNativeQuery(queryBuilder.toString(), Product.class);
        return query.getResultList();
    }
    @Override
    public List<Product> findProductBySameCategory(ProductDto productDto){
        String q = "select * from product where 1=1 \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(productDto.getColor()!=null &&!productDto.getColor().isEmpty()){
            queryBuilder.append(" and color = ? \n");
        }
        queryBuilder.append(" order by id desc limit 6 \n");
        Query query = em.createNativeQuery(queryBuilder.toString(), Product.class);
        if(productDto.getColor()!=null &&!productDto.getColor().isEmpty()) {
            query.setParameter(1, productDto.getColor());
        }
        return query.getResultList();
    }
}
