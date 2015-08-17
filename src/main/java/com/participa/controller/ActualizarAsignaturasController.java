package com.participa.controller;

import com.participa.ejb.AsignaturaFacadeLocal;
import com.participa.model.Asignatura;
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
@Named(value = "actualizarAsignaturasController")
@SessionScoped
public class ActualizarAsignaturasController implements Serializable {//Inicio clase

//Variables globales-------------------comienzo-------------------------------
    @EJB
    private AsignaturaFacadeLocal asignaturaEJB; 
    private Asignatura asignatura;
    
//------------------------------------fin-------------------------------------    
    
//Métodos Constructor y PostConstructor---------------comienzo---------------- 
    @PostConstruct
    public void init(){
      asignatura = new Asignatura();
    }
    public ActualizarAsignaturasController() {
    }
//----------------------------------fin---------------------------------------    
    
//Métodos de acceso--------------comienzo-------------------------------------
     public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
//-----------------------------------fin--------------------------------------    

// Método que obtiene la asignatura del formulario y lo modifica con los metodos del AbstractFacade.java
//--------------------------------------comienzo-------------------------------
    public void modificarAsignatura() {
        try {
            asignaturaEJB.edit(asignatura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La asignatura " + asignatura.getNombreAsignatura() + ", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La asignatura " + asignatura.getNombreAsignatura() + ", no se actualizo", ""));
        }
    }
//----------------------------------------fin----------------------------------   
    
//Método que obtiene los datos de una asignatura desde el formulario para, despues ser 
//pasado a una variable global del controlador---------------------------------
//------------------------------------Comienzo---------------------------------    
    public void leerUsuario(Asignatura asig) {
        this.setAsignatura(asig);
    }
//------------------------------------------fin--------------------------------
      
}//fin de clase
