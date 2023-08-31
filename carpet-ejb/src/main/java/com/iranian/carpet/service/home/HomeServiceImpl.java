package com.iranian.carpet.service.home;

import com.iranian.carpet.dao.home.HomeDao;
import com.iranian.carpet.dto.home.HomeDto;
import com.iranian.carpet.dto.home.HomeDtoManager;
import com.iranian.carpet.model.Home;
import com.iranian.carpet.util.HomeType;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.*;

@Stateless
public class HomeServiceImpl implements HomeService{
    @Inject
    private HomeDao homeDao;

    private HomeDtoManager homeDtoManager = Mappers.getMapper(HomeDtoManager.class);
    @Override
    public Optional<Home> save(HomeDto homeDto) throws Exception {
        return homeDao.save(homeDtoManager.transferHomeDtoToEntity(homeDto));
    }

    @Override
    public List<HomeDto> findAllHome(){
        List<HomeDto> homeDtos = new ArrayList<>();
        homeDao.findAllHome().stream()
                .forEach(p -> {
                    homeDtos.add(homeDtoManager.transferHomeToDto(p));
                });
        return homeDtos;
    }

    @Override
    public Long delete(HomeDto homeDto){
        return homeDao.delete(homeDtoManager.transferHomeDtoToEntity(homeDto));
    }
    @Override
    public HomeDto findHomeById(Long id) throws NoSuchElementException {
        try {
            return homeDtoManager.transferHomeToDto(homeDao.findHomeById(id).get());
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<HomeDto> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        List<Home> homes = homeDao.search(offset,pageSize,sortBy,filterBy);
        List<HomeDto> homeDtos = new ArrayList<>();
        homes.stream().forEach(i->{
            homeDtos.add(homeDtoManager.transferHomeToDto(i));
        });
        return homeDtos;
    }

    @Override
    public int countHome(){
        return homeDao.countHome();
    }

    @Override
    public List<HomeDto> findHomePage(Boolean active, HomeType homeType){
        List<HomeDto> homeDtos = new ArrayList<>();
        List<Home> homes = homeDao.findHomePage(active,homeType);
        homes.forEach(i->{
            homeDtos.add(homeDtoManager.transferHomeToDto(i));
        });
        return homeDtos;
    }
}
