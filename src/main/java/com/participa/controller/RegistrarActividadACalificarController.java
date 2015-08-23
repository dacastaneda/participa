/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.ActividadacalificarFacadeLocal;
import com.participa.ejb.LogroFacadeLocal;
import com.participa.ejb.PeriodocalificableFacadeLocal;
import com.participa.model.Actividadacalificar;
import com.participa.model.Logro;
import com.participa.model.Periodocalificable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author DIANA
 */
@Named(value = "registrarActividadACalificarController")
@SessionScoped
public class RegistrarActividadACalificarController implements Serializable {

    /**
     * Creates a new instance of RegistrarActividadACalificarController
     */
  
    
    @EJB
    private LogroFacadeLocal logroEJB;
    
    @EJB
    private ActividadacalificarFacadeLocal actividadEJB;
    
    private List<SelectItem> periodocalificableList;
    private List<SelectItem> logroLista;
    private List<Logro> logroList;
    
    private Actividadacalificar actividadacalificar;
    private Logro logro;
    
    private String periodocalificableV;
    private String logroV;
    
    @PostConstruct
    public void init(){
        actividadacalificar = new Actividadacalificar();
        logro = new Logro();
        logroLista = new ArrayList<>();
    }

    public List<SelectItem> getLogroLista() {
        logroLista = logroEJB.listarLogro();
        return logroLista;
    }

    public void setLogroLista(List<SelectItem> logroLista) {
        this.logroLista = logroLista;
    }

 

    

    public Actividadacalificar getActividadacalificar() {
        return actividadacalificar;
    }

    public void setActividadacalificar(Actividadacalificar actividadacalificar) {
        this.actividadacalificar = actividadacalificar;
    }

    public List<SelectItem> getPeriodocalificableList() {
        return periodocalificableList;
    }

    public void setPeriodocalificableList(List<SelectItem> periodocalificableList) {
        this.periodocalificableList = periodocalificableList;
    }

    public List<Logro> getLogroList() {
        
    
       logroList = logroEJB.findAll();
        return logroList;
    }

    public void setLogroList(List<Logro> logroList) {
        this.logroList = logroList;
    }

    

    public Logro getLogro() {
        return logro;
    }

    public void setLogro(Logro logro) {
        this.logro = logro;
    }

    public String getPeriodocalificableV() {
        return periodocalificableV;
    }

    public void setPeriodocalificableV(String periodocalificableV) {
        this.periodocalificableV = periodocalificableV;
    }

    public String getLogroV() {
        return logroV;
    }

    public void setLogroV(String logroV) {
        this.logroV = logroV;
    }
    
    public void registrarActividad(){
        try {
            actividadacalificar.setIdLogro(logro);
           
    
            actividadEJB.create(actividadacalificar);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actividad registrada", "ok"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "¡La actividad ya existe!", ""));
        }
    }
            
    public RegistrarActividadACalificarController() {
    }
    
   
    
}
