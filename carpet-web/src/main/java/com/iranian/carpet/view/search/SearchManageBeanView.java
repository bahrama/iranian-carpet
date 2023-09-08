package com.iranian.carpet.view.search;

import com.iranian.carpet.dto.search.SearchDto;
import com.iranian.carpet.service.search.SearchService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.SessionMap;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Named
public class SearchManageBeanView implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private SearchService searchService;
    @Getter
    @Setter
    private String searchWord;


    public void searchPage(String searchWord){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/search/"+ searchWord +"/1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SearchDto> search(String searchWord, int pageSize, int page){
       return searchService.search(searchWord,(page - 1) * pageSize,pageSize);
    }
}
