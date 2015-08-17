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
public class IndexController implements Serializable {//inicio de clase

//Variables globales--------------------comienzo------------------------------    
    @EJB
    private UsuarioFacadeLocal EJBUsuario;
    private Usuario usuario;
//-----------------------------------------fin--------------------------------

//Método PostConstructor----------comienzo-----------------------------------    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }
//-----------------------------------fin---------------------------------------
    
    
    
//Métodos de acceso-------------------comienzo---------------------------------    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
//-----------------------------------fin--------------------------------------
    

    
//Método para iniciar la sesión del usuario, el cual obtiene un usuario con los datos ingresados por
//el formulario--------------------------comienzo-----------------------------
    public String iniciarSesion() {
        Usuario us;
        String redireccion = null;
        try {
            us = EJBUsuario.iniciarSesion(usuario);//recibe el usuario
            if (us != null) {//pregunta si el usuario no esta vacio, el que trae la consulta.
                //Mapea la sesión.
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", us);
                //redirecciona al usuario
                redireccion = "paginas/logueado?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos invalidos", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Datos invalidos"));
        }
        return redireccion;//retorna la pagina
    }
//-----------------------------------------------fin---------------------------
    
}//fin de clase
