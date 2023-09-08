package com.iranian.carpet.service.search;

import com.iranian.carpet.dao.search.SearchDao;
import com.iranian.carpet.dto.search.SearchDto;
import com.iranian.carpet.util.BlogType;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class SearchServiceImpl implements SearchService{
    @Inject
    private SearchDao searchDao;

    @Override
    public List<SearchDto> search(String search, int offset, int pageSize){
        List<SearchDto> searchDtos = new ArrayList<>();
        searchDao.search(search,offset,pageSize).forEach(p->{
            SearchDto searchDto = new SearchDto();
            searchDto.setCode(Long.valueOf(p[0].toString()));
            searchDto.setName(p[1].toString());
            searchDto.setPic1(p[4].toString());
            searchDto.setType(p[6].toString());
            searchDto.setBlogType(BlogType.valueOf(p[5].toString()));
            searchDto.setProductType(ProductType.valueOf(p[5].toString()));
            if(!p[8].toString().equals(""))
                    searchDto.setSubProductType(SubProductType.valueOf(p[8].toString()));

            searchDtos.add(searchDto);
        });
        return searchDtos;
    }
}
