package com.participa.controller;

import com.participa.ejb.PeriodocalificableFacadeLocal;
import com.participa.ejb.PeriodolectivoFacadeLocal;
import com.participa.model.Periodocalificable;
import com.participa.model.Periodolectivo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dacastanedah
 */
@Named(value = "actualizarPeriodoCalificableController")
@ViewScoped
public class ActualizarPeriodoCalificableController implements Serializable {//Inicio clase

//Variables globales-------------------comienzo-------------------------------
    @EJB
    private PeriodocalificableFacadeLocal periodoCalificableEJB;
    @EJB
    private PeriodolectivoFacadeLocal periodoLectivoEJB;
    private Periodocalificable periodoCalificable;
    private Periodolectivo periodoLectivo;
    private List<SelectItem> periodoList;

//------------------------------------fin-------------------------------------    
//Métodos Constructor y PostConstructor---------------comienzo---------------- 
    @PostConstruct
    public void init() {
        periodoCalificable = new Periodocalificable();
        periodoLectivo = new Periodolectivo();
        periodoList = new ArrayList<>();
    }

    public ActualizarPeriodoCalificableController() {
    }
    
    @PreDestroy
    public void finish(){
        periodoLectivo = periodoCalificable.getIdPeriodoLectivo();
    }
//----------------------------------fin---------------------------------------    

    
    
//Métodos de acceso--------------comienzo-------------------------------------

    public List<SelectItem> getPeriodoList() {
        periodoList = periodoLectivoEJB.listarPeriodoLectivo();
        return periodoList;
    }

    public void setPeriodoList(List<SelectItem> periodoList) {
        this.periodoList = periodoList;
    }

    
    public Periodolectivo getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(Periodolectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }
    
    
    public Periodocalificable getPeriodoCalificable() {
        return periodoCalificable;
    }

    public void setPeriodoCalificable(Periodocalificable periodoCalificable) {
        this.periodoCalificable = periodoCalificable;
    }

//-----------------------------------fin--------------------------------------    
// Método que obtiene el periodo calificable del formulario y lo modifica con los metodos del AbstractFacade.java
//--------------------------------------comienzo-------------------------------
    public void modificarPeriodo() {
        try {
            periodoCalificable.setIdPeriodoLectivo(periodoLectivo);
            periodoCalificableEJB.edit(periodoCalificable);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El periodo calificable " + periodoCalificable.getNombrePeriodoCalificable() + ", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El periodo calificable " + periodoCalificable.getNombrePeriodoCalificable() + ", no se actualizo: Periodo lectivo no existe", ""));
        }
    }
//----------------------------------------fin----------------------------------   

//Método que obtiene los datos de un periodo calificable desde el formulario para, despues ser 
//pasado a una variable global del controlador---------------------------------
//------------------------------------Comienzo---------------------------------    
    public void leerPeriodo(Periodocalificable periodo) {
        this.setPeriodoCalificable(periodo);
    }
//------------------------------------------fin--------------------------------

}//fin de clase
