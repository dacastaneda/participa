package com.participa.controller;

import com.participa.ejb.GradoFacadeLocal;
import com.participa.ejb.PerfilFacadeLocal;
import com.participa.model.Grado;
import com.participa.model.Perfil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dacastanedah
 */
@Named(value = "actualizarPerfilController")
@SessionScoped
public class ActualizarPerfilController implements Serializable {//Inicio clase

//Variables globales-------------------comienzo-------------------------------
    @EJB
    private PerfilFacadeLocal perfilEJB; 
    private Perfil perfil;
    
//------------------------------------fin-------------------------------------    
    
//Métodos Constructor y PostConstructor---------------comienzo---------------- 
    @PostConstruct
    public void init(){
      perfil = new Perfil();
    }
    public ActualizarPerfilController() {
    }
//----------------------------------fin---------------------------------------    
    
//Métodos de acceso--------------comienzo-------------------------------------

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
     
    
//-----------------------------------fin--------------------------------------    

// Método que obtiene el grado del formulario y lo modifica con los metodos del AbstractFacade.java
//--------------------------------------comienzo-------------------------------
    public void modificarPerfil() {
        try {
            perfilEJB.edit(perfil);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El perfil " + perfil.getNombrePerfil() + ", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El perfil " + perfil.getNombrePerfil() + ", no se actualizo", ""));
        }
    }
//----------------------------------------fin----------------------------------   
    
//Método que obtiene los datos de un grado desde el formulario para, despues ser 
//pasado a una variable global del controlador---------------------------------
//------------------------------------Comienzo---------------------------------    
    public void leerPerfil(Perfil perfil) {
        this.setPerfil(perfil);
    }
//------------------------------------------fin--------------------------------
      
}//fin de clase
