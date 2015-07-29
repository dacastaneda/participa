/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.UsuarioFacadeLocal;
import com.participa.model.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dacastanedah
 */
@Named(value = "actualizarDatosController")
@ViewScoped
public class ActualizarDatosController implements Serializable{
     @EJB
    private UsuarioFacadeLocal usuarioEJB;

    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
    /**
     * Creates a new instance of ActualizarDatosController
     */
    public ActualizarDatosController() {
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
    
    public void modificarUsuario(){
       
        try {
            usuarioEJB.edit(us);
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"El usuario "+us.getNombreUsuario()+", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"El usuario "+us.getNombreUsuario()+", no se actualizo", ""));

        }
       
   }
}
