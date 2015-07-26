/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.UsuarioFacadeLocal;
import com.participa.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author dacastanedah
 */
@Named
@ViewScoped
public class IndexController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal EJBUsuario;
    private Usuario usuario;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public String iniciarSesion(){
        Usuario us;
        String redireccion = null;
        try{
            us = EJBUsuario.iniciarSesion(usuario);
            if(us != null){
                
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", us);
            redireccion = "paginas/logueado?faces-redirect=true";
            }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Datos invalidos",""));
  
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso","Datos invalidos"));
        }
        return redireccion;
    }
}
