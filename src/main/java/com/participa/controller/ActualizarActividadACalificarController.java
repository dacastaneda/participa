/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.ActividadacalificarFacadeLocal;
import com.participa.model.Actividadacalificar;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author DIANA
 */
@Named(value = "actualizarActividadACalificarController")
@SessionScoped
public class ActualizarActividadACalificarController implements Serializable {

    @EJB
    
    private ActividadacalificarFacadeLocal actividadACalificarEJB;
    private Actividadacalificar actividadACalificar;
    private List<Actividadacalificar> actividadACalificarList;
    
    @PostConstruct
    public void init() {
        actividadACalificar = new Actividadacalificar();
    }
     /**
     * Creates a new instance of ActualizarActividadACalificarController
     */
    public ActualizarActividadACalificarController() {
    }

    public Actividadacalificar getActividadACalificar() {
        return actividadACalificar;
    }

    public void setActividadACalificar(Actividadacalificar actividadACalificar) {
        this.actividadACalificar = actividadACalificar;
    }

    public List<Actividadacalificar> getActividadACalificarList() {
        actividadACalificarList = listarActividadACalificar();
        return actividadACalificarList;
    }

    public void setActividadACalificarList(List<Actividadacalificar> actividadACalificarList) {
        this.actividadACalificarList = actividadACalificarList;
    }

    private List<Actividadacalificar> listarActividadACalificar() {
        try {
            actividadACalificarList = this.actividadACalificarEJB.findAll();
        } catch (Exception e) {
        }
       return actividadACalificarList;
       
    }
    public void leerActividadACalificar(Actividadacalificar actividadACal){
    this.setActividadACalificar(actividadACal);
    }
    
    public void actualizarActividadACalificar(){
        try {
            actividadACalificarEJB.edit(actividadACalificar);
            
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El componente con codigo " + actividadACalificar.getIdActividadCalificada() + ", se actualizó con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El componente con codigo " + actividadACalificar.getIdActividadCalificada() + ", no se actualizo", ""));
        }
        }
    
    }

