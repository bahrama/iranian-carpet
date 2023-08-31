package com.iranian.carpet.dao.observe;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ObserveDaoImpl implements ObserveDao{

    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;


}
