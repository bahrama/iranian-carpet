package com.iranian.carpet.view.blog;

import com.iranian.carpet.dto.blog.BlogDto;
import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.service.blog.BlogService;
import com.iranian.carpet.util.BlogType;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.view.product.LazyProductDataModel;
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
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.file.UploadedFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class BlogManageBeanView implements Serializable {
    private static final long serialVersionUID = 1L;

    private LazyDataModel<BlogDto> lazyModel;
    @Inject
    private BlogService blogService;

    @Getter
    @Setter
    private UploadedFile pic1;
    @Getter
    @Setter
    private BlogDto blogDto;

    public LazyDataModel<BlogDto> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<BlogDto> lazyModel) {
        this.lazyModel = lazyModel;
    }

    @PostConstruct
    public void init(){
        lazyModel = new LazyBlogDataModel(blogService);
        blogDto = new BlogDto();
    }

    public String convertPicture(UploadedFile uploadedFile) {
        try {
            return FileConvertor.convertPicture(uploadedFile);
        } catch (Exception e) {
            return null;
        }
    }

    private void addPictuer(){
        if(pic1!=null) blogDto.setPic1(convertPicture(pic1));
    }

    public List<BlogType> blogTypes(){
        return List.of(BlogType.values());
    }

    public void save(){
        try {
            addPictuer();
            blogService.save(blogDto);
            MessageUtil.addMessage(FacesMessage.SEVERITY_INFO, "Success", "Success");;
        } catch (Exception e) {
            MessageUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Message Content");;
        }
    }

    public void onRowSelect(SelectEvent<BlogDto> event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/blog/blog.xhtml?blogId=" + event.getObject().getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onRowUnselect(UnselectEvent<BlogDto> event) {
        MessageUtil.addMessage(FacesMessage.SEVERITY_INFO, "Product Selected", String.valueOf(event.getObject().getId()));
    }

    public void delete(){
        blogService.delete(blogDto);
    }

    public BlogDto findBlogById(Long id){
        this.blogDto = blogService.findBlogById(id);
        if(blogDto==null)
            blogDto = new BlogDto();
        return blogDto;
    }
}
