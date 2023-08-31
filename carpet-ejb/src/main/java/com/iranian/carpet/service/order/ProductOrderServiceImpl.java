package com.iranian.carpet.service.order;

import com.iranian.carpet.dao.order.ProductOrderDao;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ProductOrderServiceImpl implements ProductOrderService{
    @Inject
    private ProductOrderDao productOrderDao;
}
