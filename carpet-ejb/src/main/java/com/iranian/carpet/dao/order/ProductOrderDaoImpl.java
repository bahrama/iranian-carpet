package com.iranian.carpet.dao.order;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProductOrderDaoImpl implements ProductOrderDao{
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;


}
