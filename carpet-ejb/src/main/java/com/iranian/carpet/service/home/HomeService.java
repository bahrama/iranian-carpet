package com.iranian.carpet.service.home;

import com.iranian.carpet.dto.home.HomeDto;
import com.iranian.carpet.model.Home;
import com.iranian.carpet.util.HomeType;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Local
public interface HomeService {

    Optional<Home> save(HomeDto homeDto) throws Exception;

    List<HomeDto> findAllHome();

    Long delete(HomeDto homeDto);

    HomeDto findHomeById(Long id) throws NoSuchElementException;

    List<HomeDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy);

    int countHome();

    List<HomeDto> findHomePage(Boolean active, HomeType homeType);
}
