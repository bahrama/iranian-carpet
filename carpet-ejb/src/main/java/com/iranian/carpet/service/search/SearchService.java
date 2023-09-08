package com.iranian.carpet.service.search;

import com.iranian.carpet.dto.search.SearchDto;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface SearchService {
    List<SearchDto> search(String search, int offset, int pageSize);
}
