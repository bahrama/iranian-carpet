package com.iranian.carpet.dao.blog;

import com.iranian.carpet.model.Blog;
import com.iranian.carpet.model.Product;
import com.iranian.carpet.util.BlogType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Stateless
public class BlogDaoImpl implements BlogDao{

    @PersistenceContext(unitName="aliUnit")
    private EntityManager em;

    @Override
    public Optional<Blog> findBlogById(Long id) {
        Blog blog = em.find(Blog.class , id);
        return blog != null ? Optional.of(blog):Optional.empty();
    }

    @Override
    public Long delete(Blog blog){
        Optional<Blog> blog1 = findBlogById(blog.getId());
        if(blog1.isPresent())
            em.remove(blog1.get());
        return blog.getId();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public Optional<Blog> save(Blog blog) throws Exception {
        try {
            if (blog.getId() == null) {
                em.persist(blog);
            } else {
                blog = em.merge(blog);
            }
            return Optional.of(blog);
        }catch (Exception e){
            throw new Exception();
        }
    }

    @Override
    public List<Blog> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select * from blog \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(filterBy.size()>0){
            queryBuilder.append(" where 1=1 \n");
            filterBy.forEach((k,v) ->{
                if(k.equals("blogType"))
                    k="blog_type";
                queryBuilder.append(" and " + k + " like" + " '%" + v + "%' \n");
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                if(k.equals("blogType"))
                    k="blog_type";
                if(v.equals("ASCENDING"))
                    v="asc";
                else
                    v="desc";
                queryBuilder.append(" order by " + k + " " + v);
            });
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), Blog.class);
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<Blog> blog = query.getResultList();
        return blog;
    }
    @Override
    public int countBlog(){
        String q = "select count(*) as count from blog \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

    @Override
    public List<Blog> findBlogByType(BlogType blogType,
                                        int pageSize, int offset){
        String q = "select * from blog where 1=1 \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(blogType!=null &&!blogType.toString().isEmpty()){
            queryBuilder.append(" and blog_type = ? \n");
        }
        Query query = em.createNativeQuery(queryBuilder.toString(), Blog.class);
        if(blogType!=null && !blogType.toString().isEmpty()){
            query.setParameter(1,blogType.toString());
        }
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public int paginationCount(BlogType blogType){
        String q = "select count(*) as count from blog where 1=1 \n";
        StringBuilder queryBuilder =new StringBuilder(q);
        if(blogType!=null &&!blogType.toString().isEmpty()){
            queryBuilder.append(" and blog_type = ? \n");
        }
        Query query = em.createNativeQuery(queryBuilder.toString());
        if(blogType!=null && !blogType.toString().isEmpty()){
            query.setParameter(1,blogType.toString());
        }
        Long count = (Long) query.getSingleResult();
        return count.intValue();
    }


}
