package com.participa.controller;

import com.participa.ejb.GradoFacadeLocal;
import com.participa.ejb.PeriodolectivoFacadeLocal;
import com.participa.model.Grado;
import com.participa.model.Periodolectivo;
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
@Named(value = "actualizarPeriodoLectivoController")
@SessionScoped
public class ActualizarPeriodoLectivoController implements Serializable {//Inicio clase

//Variables globales-------------------comienzo-------------------------------
    @EJB
    private PeriodolectivoFacadeLocal periodoLectivoEJB; 
    private Periodolectivo periodolectivo;
    
//------------------------------------fin-------------------------------------    
    
//Métodos Constructor y PostConstructor---------------comienzo---------------- 
    @PostConstruct
    public void init(){
      periodolectivo = new Periodolectivo();
    }
    public ActualizarPeriodoLectivoController() {
    }
//----------------------------------fin---------------------------------------    
    
//Métodos de acceso--------------comienzo-------------------------------------

    public Periodolectivo getPeriodolectivo() {
        return periodolectivo;
    }

    public void setPeriodolectivo(Periodolectivo periodolectivo) {
        this.periodolectivo = periodolectivo;
    }
     
    
//-----------------------------------fin--------------------------------------    

// Método que obtiene el periodo lectivo del formulario y lo modifica con los metodos del AbstractFacade.java
//--------------------------------------comienzo-------------------------------
    public void modificarPeriodo() {
        try {
            periodoLectivoEJB.edit(periodolectivo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El periodo lectivo " + periodolectivo.getAno() + ", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El periodo lectivo " + periodolectivo.getAno() + ", no se actualizo", ""));
        }
    }
//----------------------------------------fin----------------------------------   
    
//Método que obtiene los datos de un periodo lectivo desde el formulario para, despues ser 
//pasado a una variable global del controlador---------------------------------
//------------------------------------Comienzo---------------------------------    
    public void leerPeriodo(Periodolectivo periodo) {
        this.setPeriodolectivo(periodo);
    }
//------------------------------------------fin--------------------------------
      
}//fin de clase
