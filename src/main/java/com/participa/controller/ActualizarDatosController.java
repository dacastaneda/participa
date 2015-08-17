package com.participa.controller;

import com.participa.ejb.UsuarioFacadeLocal;
import com.participa.model.Usuario;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class ActualizarDatosController implements Serializable {//comienzo de clase

//Variables globales---------comienzo------------------------------------------    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private String fecha;
//-----------------------------fin---------------------------------------------
    
//Formato para la fecha------comienzo------------------------------------------
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//-----------------------------fin---------------------------------------------    

//Variable de sessión del usuario--------comienzo------------------------------    
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
//-----------------------------fin---------------------------------------------
    
//Método constructor-------------------comienzo--------------------------------
    public ActualizarDatosController() {
    }
//---------------------------------------fin-----------------------------------
    
//Métodos de acceso--------------------comienzo--------------------------------      
    public String getFecha() {
        fecha = df.format(us.getFechaNacimiento());
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
//-------------------------------------------fin-------------------------------
    
//Método para modificar el usuario utilizando el método del AbstractFacade.java
//-----------------------------------comienzo----------------------------------
    public void modificarUsuario() {
        try {
            usuarioEJB.edit(us);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario " + us.getNombreUsuario() + ", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario " + us.getNombreUsuario() + ", no se actualizo", ""));
        }
    }
//----------------------------------------fin----------------------------------
    
}//fin de clase
