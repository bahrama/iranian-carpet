package com.iranian.carpet.service.blog;

import com.iranian.carpet.dao.blog.BlogDao;
import com.iranian.carpet.dto.blog.BlogDto;
import com.iranian.carpet.dto.blog.BlogDtoManager;
import com.iranian.carpet.model.Blog;
import com.iranian.carpet.util.BlogType;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.*;

@Stateless
public class BlogServiceImpl implements BlogService{
    @Inject
    private BlogDao blogDao;

    private BlogDtoManager blogDtoManager = Mappers.getMapper(BlogDtoManager.class);

    @Override
    public Optional<Blog> save(BlogDto blogDto) throws Exception {
        return blogDao.save(blogDtoManager.transferBlogDtoToEntity(blogDto));
    }
    @Override
    public Long delete(BlogDto blogDto){
        return blogDao.delete(blogDtoManager.transferBlogDtoToEntity(blogDto));
    }

    @Override
    public BlogDto findBlogById(Long id) throws NoSuchElementException {
        try {
            return blogDtoManager.transferBlogToDto(blogDao.findBlogById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<BlogDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<Blog> blogs = blogDao.search(offset,pageSize,sortBy,filterBy);
        List<BlogDto> blogDtos = new ArrayList<>();
        blogs.stream().forEach(i->{
            blogDtos.add(blogDtoManager.transferBlogToDto(i));
        });
        return blogDtos;
    }

    @Override
    public int countBlog(){
        return blogDao.countBlog();
    }

    @Override
    public List<BlogDto> findBlogByType(BlogType blogType,
                                        int pageSize, int offset){
        List<BlogDto> blogDtos = new ArrayList<>();
        List<Blog> blogs = blogDao.findBlogByType(blogType,pageSize,offset);
        blogs.forEach(i->{
            blogDtos.add(blogDtoManager.transferBlogToDto(i));
        });
        return blogDtos;
    }

    @Override
    public int paginationCount(BlogType blogType){
        return blogDao.paginationCount(blogType);
    }



}
