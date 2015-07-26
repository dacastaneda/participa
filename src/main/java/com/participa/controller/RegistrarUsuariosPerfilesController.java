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
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dacastanedah
 */
@Named(value = "registrarUsuariosPerfilesController")
@ViewScoped
public class RegistrarUsuariosPerfilesController implements Serializable{

@EJB
private UsuarioFacadeLocal usuarioEJB;
private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    /**
     * Creates a new instance of RegistrarUsuariosPerfilesController
     */
    public RegistrarUsuariosPerfilesController() {
    }
    
    public void registrarUsuario(){
        try {
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Registrado", "ok"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario Registrado", "No, se logró registrar"));

        }
    }
    
}
