package com.participa.controller;

import com.participa.ejb.ComponenteFacadeLocal;
import com.participa.ejb.LogroFacadeLocal;
import com.participa.ejb.PeriodocalificableFacadeLocal;
import com.participa.model.Componente;
import com.participa.model.Logro;
import com.participa.model.Periodocalificable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author DIANA
 */
@Named(value = "registrarLogroController")
@SessionScoped
public class RegistrarLogroController implements Serializable {

//Variables globales----------------------comienzo----------------------------    
    @EJB
    private ComponenteFacadeLocal componenteEJB;
    @EJB
    private PeriodocalificableFacadeLocal periodocalificableEJB;
    @EJB
    private LogroFacadeLocal logroEJB;
    private Logro logro;
    private List<SelectItem> periodocalificableList;
    private List<SelectItem> componenteList;
    private List<Componente> componenteLista;
    private Componente componente;
    private Periodocalificable periodocomponente;
//-------------------------------------------fin------------------------------
    
//Constructor y Postconstructor-------------comienzo--------------------------    
    public RegistrarLogroController() {
    }
    
    @PostConstruct
    public void init(){
        periodocomponente = new Periodocalificable();
        componente = new Componente();
        logro = new Logro();
        
    }
//------------------------------------------fin------------------------------    
   
//Métodos de acceso---------------------comienzo----------------------------    

    public Logro getLogro() {
        return logro;
    }

    public void setLogro(Logro logro) {
        this.logro = logro;
    }

    
    
    public List<SelectItem> getComponenteList() {
        componenteList = componenteEJB.listarComponente();
        return componenteList;
    }

    public void setComponenteList(List<SelectItem> componenteList) {
        this.componenteList = componenteList;
    }
    
    
    
    public List<Componente> getComponenteLista() {
        componenteLista = componenteEJB.findAll();
        return componenteLista;
    }

    public void setComponenteLista(List<Componente> componenteLista) {
        this.componenteLista = componenteLista;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public Periodocalificable getPeriodocomponente() {
        return periodocomponente;
    }

    public void setPeriodocomponente(Periodocalificable periodocomponente) {
        this.periodocomponente = periodocomponente;
    }

    public List<SelectItem> getPeriodocalificableList() {

        periodocalificableList = periodocalificableEJB.listarPeriodoCalificable();

        return periodocalificableList;
    }

    public void setPeriodocalificableList(List<SelectItem> periodocalificableList) {
        this.periodocalificableList = periodocalificableList;
    }
    
    
    public void registrarLogro(){
        try {
            logro.setIdComponente(componente);
            logro.setDPeriodoCalificable(periodocomponente);
            
            logroEJB.create(logro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logro Registrado", "ok"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "¡El logro ya existe!", ""));
        }
    }
    
    
     public void leerComponente(Componente compo) {
         System.out.println("pase por aqui");
        this.setComponente(compo);
    }
}
