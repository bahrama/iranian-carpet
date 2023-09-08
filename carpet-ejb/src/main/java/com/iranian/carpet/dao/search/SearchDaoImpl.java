package com.iranian.carpet.dao.search;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class SearchDaoImpl implements SearchDao{
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;
    @Override
    public List<Object[]> search(String search, int offset, int pageSize){
        if(search !=null && search.getBytes().length>3) {
            String q = "select * from (select b.id code , b.name , b.h1_title , b.description , b.pic1 , b.blog_type com_type, 'blog' t_type\n" +
                    "                    ,b.product_date date_time , '' sub_type\n" +
                    "               from blog b\n" +
                    "               union\n" +
                    "               select CAST (p.code AS bigint) , p.name , p.h1_title , p.description , p.pic1 , p.product_type , 'product'\n" +
                    "                    , p.product_date as date_time , p.sub_product_type\n" +
                    "               from product p) un\n" ;

            StringBuilder queryBuilder = new StringBuilder(q);
            queryBuilder.append(" where lower(un.name)  like" + " '%" + search.toLowerCase() + "%' \n");
            queryBuilder.append(" or  lower(un.h1_title)  like" + " '%" + search.toLowerCase() + "%' \n");
            queryBuilder.append(" or  lower(un.description)  like" + " '%" + search.toLowerCase() + "%' \n");
            queryBuilder.append(" or  lower(un.com_type)  like" + " '%" + search.toLowerCase() + "%' \n");
            queryBuilder.append(" or  lower(un.t_type)  like" + " '%" + search.toLowerCase() + "%' \n");
            Query query = em.createNativeQuery(queryBuilder.toString());
            query.setFirstResult(offset);
            query.setMaxResults(pageSize);
            List<Object[]> product = query.getResultList();
            return product;
        }
        else {
            return new ArrayList<>();
        }
    }
}
