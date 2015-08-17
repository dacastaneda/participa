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
public class RegistrarUsuariosPerfilesController implements Serializable {//inicio de clase

    
//Variables globales------------------------comienzo---------------------------    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;
//-----------------------------------------fin---------------------------------
    
    
//Métodos de acceso-------------------comienzo---------------------------------    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
//---------------------------------------fin-----------------------------------
    

//Método Constructor y PostConstructor-----------comienzo----------------------    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public RegistrarUsuariosPerfilesController() {
    }
//---------------------------------------fin-----------------------------------
    
    
//Método que registra al usuario en la base de datos por medio de los metodos
//definidos el el AbstractFacade.java-----------comienzo-----------------------    
    public void registrarUsuario() {
        try {
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Registrado", "ok"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Registrado", "No, se logró registrar"));
        }
    }
//---------------------------------------fin-----------------------------------
    
    
}//fin de clase
