/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.PeriodolectivoFacadeLocal;
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
@Named(value = "registrarPeriodoLectivoController")
@ViewScoped
public class RegistrarPeriodoLectivoController implements Serializable{

    @EJB
    private PeriodolectivoFacadeLocal periodoLectivoEJB;
    private Periodolectivo periodoLectivo;

    public Periodolectivo getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(Periodolectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    

    @PostConstruct
    public void init(){
        periodoLectivo = new Periodolectivo();
    }
    
    /**
     * Creates a new instance of RegistrarPeriodoLectivoController
     */
    public RegistrarPeriodoLectivoController() {
    }
    
    public void registrarPeriodoLectivo(){
        try {
            periodoLectivoEJB.create(periodoLectivo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Periodo lectivo registrado con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Operación sin éxito, id periodo ya existe", ""));

        }
    }
}
