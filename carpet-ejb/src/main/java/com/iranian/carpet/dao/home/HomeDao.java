package com.iranian.carpet.dao.home;

import com.iranian.carpet.model.Home;
import com.iranian.carpet.model.Product;
import com.iranian.carpet.util.HomeType;
import jakarta.ejb.Local;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Local
public interface HomeDao {

    Optional<Home> findHomeById(Long id);

    @Transactional(Transactional.TxType.REQUIRED)
    Optional<Home> save(Home home) throws Exception;

    List<Home> findAllHome();

    Long delete(Home home);

    List<Home> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy);

    int countHome();

    List<Home> findHomePage(Boolean active, HomeType homeType);
}
