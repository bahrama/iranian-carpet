package com.iranian.carpet.service.blog;

import com.iranian.carpet.dto.blog.BlogDto;
import com.iranian.carpet.model.Blog;
import com.iranian.carpet.util.BlogType;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Local
public interface BlogService {

    Optional<Blog> save(BlogDto blogDto) throws Exception;

    Long delete(BlogDto blogDto);

    BlogDto findBlogById(Long id) throws NoSuchElementException;

    List<BlogDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy);

    int countBlog();

    List<BlogDto> findBlogByType(BlogType blogType,
                                 int pageSize, int offset);

    int paginationCount(BlogType blogType);
}
