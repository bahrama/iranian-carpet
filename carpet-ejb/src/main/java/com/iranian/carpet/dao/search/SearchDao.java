package com.iranian.carpet.dao.search;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface SearchDao {

    List<Object[]> search(String search, int offset, int pageSize);
}
