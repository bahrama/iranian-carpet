package com.iranian.carpet.dao.blog;

import com.iranian.carpet.model.Blog;
import com.iranian.carpet.util.BlogType;
import jakarta.ejb.Local;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Local
public interface BlogDao {
    Optional<Blog> findBlogById(Long id);

    Long delete(Blog blog);

    @Transactional(Transactional.TxType.REQUIRED)
    Optional<Blog> save(Blog blog) throws Exception;

    List<Blog> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy);

    int countBlog();


    List<Blog> findBlogByType(BlogType blogType,
                              int pageSize, int offset);

    int paginationCount(BlogType blogType);
}
