package com.iranian.carpet.view.home;

import com.iranian.carpet.dto.home.HomeDto;
import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.service.home.HomeService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LazyHomeDataModel extends LazyDataModel<HomeDto> {
    private HomeService homeService;
    public LazyHomeDataModel(HomeService homeService){
        this.homeService = homeService;
    }

    @Override
    public int count(Map<String, FilterMeta> map) {
        return homeService.countHome();
    }

    @Override
    public HomeDto getRowData(String rowKey) {
        if(!rowKey.equals("null"))
            return homeService.findHomeById(Long.valueOf(rowKey));
        else
            return new HomeDto();
    }

    @Override
    public String getRowKey(HomeDto homeDto) {
        return String.valueOf(homeDto.getId());
    }

    @Override
    public List<HomeDto> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
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
        return homeService.search(offset,pageSize,sort,filter);
    }
}
