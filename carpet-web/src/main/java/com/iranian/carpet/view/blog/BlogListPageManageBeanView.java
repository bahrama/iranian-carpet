package com.iranian.carpet.view.blog;

import com.iranian.carpet.dto.blog.BlogDto;
import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.service.blog.BlogService;
import com.iranian.carpet.util.BlogType;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import com.iranian.carpet.view.utils.StringConvertUtil;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Named
@ViewScoped
public class BlogListPageManageBeanView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private BlogService blogService;

    @Getter
    @Setter
    private String blogType;

    public List<BlogDto> findBlogByType(String blogType,int pageSize, int page) {
        BlogType blogType1=null;
        if(this.blogType!=null)
            blogType = this.blogType;
        if (!blogType.isEmpty()){
            try {
                blogType1 = BlogType.valueOf(blogType);
            }catch (Exception e){
                blogType1 = null;
            }
        }
        if(page==0)
            page=1;
        return blogService.findBlogByType(blogType1, pageSize, (page - 1) * pageSize);
    }

    public List<Integer> findPaginationNumbers(String blogType,int pageSize){
        List<Integer> integers = new ArrayList<>();
        BlogType blogType1=null;
        if (!blogType.isEmpty()){
            try {
                blogType1 = BlogType.valueOf(blogType);
            }catch (Exception e){
                blogType1 = null;
            }
        }
        Integer count = blogService.paginationCount(blogType1);
        int size = 0;
        if(count%12==0)
            size = count/12;
        else
            size = count/12 + 1;

        for (int i = 1; i <= size;i++){
            integers.add(i);
        }
        return integers;
    }

    public String replaceSpaceWithDash(String name){
       return StringConvertUtil.convertSpaceToDash(name);
    }
}
