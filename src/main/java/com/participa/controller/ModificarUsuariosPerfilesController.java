/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.UsuarioFacadeLocal;
import com.participa.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dacastanedah
 */
@Named(value = "modificarUsuariosPerfilesController")
@SessionScoped
public class ModificarUsuariosPerfilesController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioEJB;

    private Usuario usuario;

    private List<Usuario> usuarioList;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioList() {
        usuarioList = this.listarUsuarios();
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    /**
     * Creates a new instance of modificarUsuariosPerfilesController
     */
    public ModificarUsuariosPerfilesController() {
    }

    public List<Usuario> listarUsuarios() {
        try {
            return this.usuarioEJB.findAll();
        } catch (Exception e) {
        }

        return null;

    }

    public void leerUsuario(Usuario user) {

        this.setUsuario(user);

    }
    
   public void modificarUsuario(){
       
        try {
            usuarioEJB.edit(usuario);
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"El usuario "+usuario.getNombreUsuario()+", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"El usuario "+usuario.getNombreUsuario()+", no se actualizo", ""));

        }
       
   }
}
