package com.iranian.carpet.view.login;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginManageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    @Inject
    private HttpSession session;

    public void login() throws IOException {
        if(username.equals("ali") && password.equals("a680313A^*)#!#"))
        {
            session.setAttribute("username" , "ali");
            FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/product/product.xhtml");
        }
    }

    public void isUser(ComponentSystemEvent event){
        FacesContext contex = FacesContext.getCurrentInstance();
        try{
            String mobile=(String) session.getAttribute("username");
            if((mobile!=null) || (!mobile.equals("")))
                System.out.println("******************ok******************");
            else
                FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/Login.xhtml");
        }catch (Exception e) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/Login.xhtml");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
