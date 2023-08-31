package com.iranian.carpet.view.home;

import com.iranian.carpet.dto.home.HomeDto;
import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.service.home.HomeService;
import com.iranian.carpet.util.HomeType;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.view.utils.FileConvertor;
import com.iranian.carpet.view.utils.MessageUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.file.UploadedFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class HomeManageBeanView implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private LazyHomeDataModel lazyHomeDataModel;

    @Getter
    @Setter
    private HomeDto homeDto;

    @Getter
    @Setter
    private UploadedFile pic;
    @Inject
    private HomeService homeService;

    @PostConstruct
    public void init(){
        lazyHomeDataModel = new LazyHomeDataModel(homeService);
        homeDto = new HomeDto();
    }

    public String convertPicture(UploadedFile uploadedFile) {
        try {
            return FileConvertor.convertPicture(uploadedFile);
        } catch (Exception e) {
            return null;
        }
    }

    private void addPictuer(){
        if(pic!=null) homeDto.setPic(convertPicture(pic));
    }

    public List<HomeType> homeTypes(){
        return List.of(HomeType.values());
    }

    public void save(){
        try {
            addPictuer();
            homeService.save(homeDto);
        } catch (Exception e) {
            MessageUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Message Content");;
        }
    }

    public List<HomeDto> findAllHome(){
        return homeService.findAllHome();
    }

    public void onRowSelect(SelectEvent<HomeDto> event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/carpet-web/admin/home/home.xhtml?homeId=" + event.getObject().getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onRowUnselect(UnselectEvent<HomeDto> event) {
        MessageUtil.addMessage(FacesMessage.SEVERITY_INFO, "Product Selected", String.valueOf(event.getObject().getId()));
    }

    public void delete(){
        homeService.delete(homeDto);
    }

    public HomeDto findHomeById(Long id){
        this.homeDto = homeService.findHomeById(id);
        if(homeDto==null)
            homeDto = new HomeDto();
        return homeDto;
    }
}
