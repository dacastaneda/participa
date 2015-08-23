/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.PeriodocalificableFacadeLocal;
import com.participa.ejb.PeriodolectivoFacadeLocal;
import com.participa.model.Periodocalificable;
import com.participa.model.Periodolectivo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dacastanedah
 */
@Named(value = "registrarPeriodoCalificableController")
@ViewScoped
public class RegistrarPeriodoCalificableController implements Serializable{

    @EJB
    private PeriodocalificableFacadeLocal periodoCalificableEJB;
    
    private Periodolectivo periodoLectivo;
    
    private Periodocalificable periodoCalificable;

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

    

    

    @PostConstruct
    public void init(){
        periodoCalificable = new Periodocalificable();
        periodoLectivo = new Periodolectivo();
    }
    
    /**
     * Creates a new instance of RegistrarPeriodoLectivoController
     */
    public RegistrarPeriodoCalificableController() {
    }
    
    public void registrarPeriodoCalificable(){
        try {
            periodoCalificable.setIdPeriodoLectivo(periodoLectivo);
            periodoCalificableEJB.create(periodoCalificable);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Periodo calificable registrado con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Operación sin éxito, id periodo ya existe", ""));

        }
    }
}
