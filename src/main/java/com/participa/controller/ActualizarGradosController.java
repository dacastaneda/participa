package com.participa.controller;

import com.participa.ejb.GradoFacadeLocal;
import com.participa.model.Grado;
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
@Named(value = "actualizarGradosController")
@SessionScoped
public class ActualizarGradosController implements Serializable {//Inicio clase

//Variables globales-------------------comienzo-------------------------------
    @EJB
    private GradoFacadeLocal gradoEJB; 
    private Grado grado;
    
//------------------------------------fin-------------------------------------    
    
//Métodos Constructor y PostConstructor---------------comienzo---------------- 
    @PostConstruct
    public void init(){
      grado = new Grado();
    }
    public ActualizarGradosController() {
    }
//----------------------------------fin---------------------------------------    
    
//Métodos de acceso--------------comienzo-------------------------------------
     public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    
//-----------------------------------fin--------------------------------------    

// Método que obtiene el grado del formulario y lo modifica con los metodos del AbstractFacade.java
//--------------------------------------comienzo-------------------------------
    public void modificarGrado() {
        try {
            gradoEJB.edit(grado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El grado " + grado.getNombreGrado() + ", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El grado " + grado.getNombreGrado() + ", no se actualizo", ""));
        }
    }
//----------------------------------------fin----------------------------------   
    
//Método que obtiene los datos de un grado desde el formulario para, despues ser 
//pasado a una variable global del controlador---------------------------------
//------------------------------------Comienzo---------------------------------    
    public void leerUsuario(Grado grado) {
        this.setGrado(grado);
    }
//------------------------------------------fin--------------------------------
      
}//fin de clase
