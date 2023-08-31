package com.iranian.carpet.view.product;

import com.iranian.carpet.dto.product.ProductDto;
import com.iranian.carpet.model.Product;
import com.iranian.carpet.service.product.ProductService;
import com.iranian.carpet.util.ProductType;
import com.iranian.carpet.util.SubProductType;
import com.iranian.carpet.view.utils.FileConvertor;
import com.iranian.carpet.view.utils.MessageUtil;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.file.UploadedFile;

import javax.validation.constraints.Size;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Named
@ViewScoped
public class ProductManageBeanView  implements Serializable {
    private static final long serialVersionUID = 1L;

    private LazyDataModel<ProductDto> lazyModel;

    public LazyDataModel<ProductDto> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<ProductDto> lazyModel) {
        this.lazyModel = lazyModel;
    }

    @Getter
    @Setter
    private UploadedFile pic1;
    @Getter
    @Setter
    private UploadedFile pic2;
    @Getter
    @Setter
    private UploadedFile pic3;
    @Getter
    @Setter
    private UploadedFile pic4;
    @Getter
    @Setter
    private UploadedFile pic5;

    @Getter
    @Setter
    private ProductDto productDto;
    @Inject
    private ProductService productService;
    @PostConstruct
    public void init(){
        lazyModel = new LazyProductDataModel(productService);
        productDto = new ProductDto();
    }

    public String convertPicture(UploadedFile uploadedFile) {
        try {
            return FileConvertor.convertPicture(uploadedFile);
        } catch (Exception e) {
            return null;
        }
    }

    private void addPictuer(){
        if(pic1!=null) productDto.setPic1(convertPicture(pic1));
        if(pic2!=null) productDto.setPic2(convertPicture(pic2));
        if(pic3!=null) productDto.setPic3(convertPicture(pic3));
        if(pic4!=null) productDto.setPic4(convertPicture(pic4));
        if(pic5!=null) productDto.setPic5(convertPicture(pic5));
    }

    public List<ProductType> productTypes(){
        return List.of(ProductType.values());
    }
    public List<SubProductType> subProductTypes(){
        return List.of(SubProductType.values());
    }

    public void save(){
        try {
            addPictuer();
            productService.save(productDto);
            MessageUtil.addMessage(FacesMessage.SEVERITY_INFO, "Success", "Success");;
        } catch (Exception e) {
            MessageUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Message Content");;
        }
    }

    public List<ProductDto> findAllProduct(){
        return productService.findAllProduct();
    }

    public void onRowSelect(SelectEvent<ProductDto> event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/carpet-web/admin/product/product.xhtml?productId=" + event.getObject().getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onRowUnselect(UnselectEvent<ProductDto> event) {
        MessageUtil.addMessage(FacesMessage.SEVERITY_INFO, "Product Selected", String.valueOf(event.getObject().getId()));
    }

    public void delete(){
        productService.delete(productDto);
    }

    public ProductDto findProductById(Long id){
        this.productDto = productService.findProductById(id);
        if(productDto==null)
            productDto = new ProductDto();
            return productDto;
    }

}
