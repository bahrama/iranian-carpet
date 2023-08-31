package com.iranian.carpet.service.observe;

import com.iranian.carpet.dao.observe.ObserveDao;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ObserveServiceImpl implements ObserveService{
    @Inject
    private ObserveDao observeDao;
}
