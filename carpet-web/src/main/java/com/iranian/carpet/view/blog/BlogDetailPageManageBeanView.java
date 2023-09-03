package com.iranian.carpet.view.blog;

import com.iranian.carpet.dto.blog.BlogDto;
import com.iranian.carpet.service.blog.BlogService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Named
@ViewScoped
public class BlogDetailPageManageBeanView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private BlogService blogService;

    @Getter
    @Setter
    private BlogDto blogDto;
    @PostConstruct
    public void init(){
        blogDto = new BlogDto();
    }

    public BlogDto findBlogDtoById(Long id){
        blogDto = blogService.findBlogById(id);
        return blogDto;
    }


}
