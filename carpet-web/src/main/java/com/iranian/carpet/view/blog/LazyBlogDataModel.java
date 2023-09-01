package com.iranian.carpet.view.blog;

import com.iranian.carpet.dto.blog.BlogDto;
import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.service.blog.BlogService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyBlogDataModel extends LazyDataModel<BlogDto> {

    private BlogService blogService;
    public LazyBlogDataModel(BlogService blogService){
        this.blogService = blogService;
    }
    @Override
    public int count(Map<String, FilterMeta> map) {
        return blogService.countBlog();
    }

    @Override
    public BlogDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return blogService.findBlogById(Long.valueOf(rowKey));
        else
            return new BlogDto();
    }

    @Override
    public String getRowKey(BlogDto blogDto) {
        return String.valueOf(blogDto.getId());
    }




    @Override
    public List<BlogDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        Map<String,String> filter = new HashMap<>();
        Map<String,String> sort = new HashMap<>();
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                filter.put(k,v.getFilterValue().toString());
            });
        }
        if(sortBy.size()>0){
            sortBy.forEach((k,v) ->{
                sort.put(k,v.getOrder().name());
            });
        }
        return blogService.search(offset,pageSize,sort,filter);
    }


}
