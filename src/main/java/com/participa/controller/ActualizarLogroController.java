package com.participa.controller;

import com.participa.ejb.LogroFacadeLocal;
import com.participa.model.Logro;
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
 * @author dacastanedah
 */
@Named(value = "actualizarLogroController")
@SessionScoped
public class ActualizarLogroController implements Serializable {//inicio clase

//Variables globales--------------comienzo------------------------------------    
    @EJB
    private LogroFacadeLocal logroEJB;
    private Logro logro;
    private List<Logro> logroList;
//------------------------------------fin-------------------------------------
    
//Método constructor y postConstructor---------comienzo-----------------------    
    @PostConstruct
    public void init() {
        logro = new Logro();
    }

    public ActualizarLogroController() {
    }
//--------------------------------------------fin-----------------------------
    
//Métodos de acceso---------------comienzo------------------------------------    
    public Logro getLogro() {
        return logro;
    }

    public void setLogro(Logro logro) {
        this.logro = logro;
    }

    public List<Logro> getLogroList() {
        logroList = listarLogro();
        return logroList;
    }

    public void setLogroList(List<Logro> logroList) {
        this.logroList = logroList;
    }

//--------------------------------fin-----------------------------------------
    

    public List<Logro> listarLogro() {
        try {
            logroList = this.logroEJB.findAll();

        } catch (Exception e) {
        }

        return logroList;
    }

    public void leerLogro(Logro log) {
        this.setLogro(log);
    }

    public void actualizarLogro() {

        try {
            logroEJB.edit(logro);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El componente con codigo " + logro.getIdLogro() + ", se actualizó con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El componente con codigo " + logro.getIdLogro() + ", no se actualizo", ""));
        }
    }
}
