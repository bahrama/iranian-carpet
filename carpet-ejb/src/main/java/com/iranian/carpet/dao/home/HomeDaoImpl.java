package com.iranian.carpet.dao.home;

import com.iranian.carpet.model.Home;
import com.iranian.carpet.util.HomeType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Stateless
public class HomeDaoImpl implements HomeDao{
    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    @Override
    public Optional<Home> findHomeById(Long id) {
        Home home = em.find(Home.class , id);
        return home != null ? Optional.of(home):Optional.empty();
    }
    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public Optional<Home> save(Home home) throws Exception {
        try {
            if (home.getId() == null) {
                em.persist(home);
            } else {
                home = em.merge(home);
            }
            return Optional.of(home);
        }catch (Exception e){
            throw new Exception();
        }
    }


    @Override
    public List<Home> findAllHome(){
        String q = "select p from Home p";
        StringBuilder queryBuilder =new StringBuilder(q);
        Query query = em.createQuery(q,Home.class);
        return query.getResultList();
    }
    @Override
    public Long delete(Home home){
        Optional<Home> home1 = findHomeById(home.getId());
        if(home1.isPresent())
            em.remove(home1.get());
        return home.getId();
    }
    @Override
    public List<Home> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from home \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("homeType"))
                    k="home_type";
                queryBuilder.append(" and " + k + " like" + " '%" + v + "%' \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("homeType"))
                    k="home_type";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by " + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), Home.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<Home> homes = query.getResultList();
        return homes;
    }
    @Override
    public int countHome(){
        String q = "select count(*) as count from home \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }
    @Override
    public List<Home> findHomePage(Boolean active, HomeType homeType){
        String q = "select * from home \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        queryBuilder.append(" where active = ? and home_type = ? ");
        Query query = em.createNativeQuery(queryBuilder.toString(), Home.class);
        query.setParameter(1,active);
        query.setParameter(2,homeType.toString());
        return query.getResultList();
    }

}
