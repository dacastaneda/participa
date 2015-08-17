package com.participa.controller;

import com.participa.ejb.PerfilusuarioFacadeLocal;
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
@Named(value = "eliminarUsuariosPerfilesController")
@SessionScoped
public class EliminarUsuariosPerfilesController implements Serializable {//inicio de clase

//Variables globales----------------------comienzo----------------------------    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private PerfilusuarioFacadeLocal perfilUsuarioEJB;
    private Usuario usuario;
//---------------------------------------------fin----------------------------    

    
    
//Método Constructor y PostConstructor---------comienzo-----------------------    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }
    
    public EliminarUsuariosPerfilesController() {
    }
//-----------------------------------------------fin---------------------------
    

    
//Métodos de acceso-------------------comienzo---------------------------------
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
//---------------------------------------fin-----------------------------------
    
    

//Método para leer los datos de un usuario---------comienzo-------------------    
    public void leerUsuario(Usuario user) {
        this.setUsuario(user);
    }
//-----------------------------------------fin--------------------------------
    
  
    
// Método que obtiene el usuario del formulario y lo elimina con los metodos del AbstractFacade.java
//Se utiliza un procedimiento almacenado que elimina el usuario de la tabla PerfilUsuarios.
//-------------------------------------comienzo-------------------------------  
    public void eliminarUsuario() {
        try {
            eliminarPerfilUsuario();//---->Procedimiento almacenado 
            usuarioEJB.remove(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación éxitosa: ", "Se elimino el usuario " + usuario.getNombreUsuario()));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no se puede eliminar, no esta permitido. ", ""));
        }
    }
//-------------------------------------------fin-------------------------------
    
    
    
    
//Método que elimina al usuario de la tabla perfil usuario con un procedimiento almacenado
//invocado desde el facade de PerfilUsuario-----------comienzo-----------------
    public void eliminarPerfilUsuario() {
        perfilUsuarioEJB.invocarProcedure(usuario.getIdPersona());
    }
//---------------------------------------------fin-----------------------------
    
}//fin de clase
