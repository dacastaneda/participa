package com.participa.controller;

import com.participa.ejb.UsuarioFacadeLocal;
import com.participa.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author dacastanedah
 */
@Named(value = "modificarUsuariosPerfilesController")
@SessionScoped
public class ModificarUsuariosPerfilesController implements Serializable {//inicio de clase

//Variables globales---------------------comienzo------------------------------    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;
//-----------------------------------------fin---------------------------------
    
    
//Método Constructor y PostConstructor-------comienzo--------------------------    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public ModificarUsuariosPerfilesController() {
    }
//----------------------------------------fin---------------------------------    
    
    
//Métodos de acceso--------------------comienzo-------------------------------    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
//-----------------------------------------fin---------------------------------
    

//Método que obtiene los datos de un usuario desde el formulario para, despues ser 
//pasado a una variable global del controlador---------------------------------
//------------------------------------Comienzo---------------------------------    
    public void leerUsuario(Usuario user) {
        this.setUsuario(user);
    }
//------------------------------------------fin--------------------------------
    
    
    
// Método que obtiene el usuario del formulario y lo modifica con los metodos del AbstractFacade.java
//--------------------------------------comienzo-------------------------------
    public void modificarUsuario() {
        try {
            usuarioEJB.edit(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario " + usuario.getNombreUsuario() + ", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario " + usuario.getNombreUsuario() + ", no se actualizo", ""));
        }
    }
//----------------------------------------fin----------------------------------
    
    
}//fin de clase
