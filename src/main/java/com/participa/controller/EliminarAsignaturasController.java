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
@Named(value = "eliminarAsignaturasController")
@SessionScoped
public class EliminarAsignaturasController implements Serializable {//Inicio clase

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
    public EliminarAsignaturasController() {
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

// Método que obtiene la asignatura del formulario y lo elimina con los metodos del AbstractFacade.java
//--------------------------------------comienzo-------------------------------
    public void eliminarAsignatura() {
        try {
            asignaturaEJB.remove(asignatura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La asignatura " + asignatura.getNombreAsignatura() + ", se elimino con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La asignatura " + asignatura.getNombreAsignatura() + ", no se elimino", ""));
        }
    }
//----------------------------------------fin----------------------------------   
    
//Método que obtiene los datos de una asignatura desde el formulario para, despues ser 
//pasado a una variable global del controlador---------------------------------
//------------------------------------Comienzo---------------------------------    
    public void leerUsuario(Asignatura asignatura) {
        this.setAsignatura(asignatura);
    }
//------------------------------------------fin--------------------------------
      
}//fin de clase
