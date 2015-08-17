package com.participa.controller;

import com.participa.ejb.ComponenteFacadeLocal;
import com.participa.model.Componente;
import java.io.Serializable;
import java.util.List;
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
@Named(value = "actualizarComponenteController")
@ViewScoped
public class ActualizarComponenteController implements Serializable {//comienzo de clase
    
//Variables globales---------comienzo------------------------------------------
    @EJB
    private ComponenteFacadeLocal componenteEJB;
    private Componente componente;
    private List<Componente> componenteList;
//----------------------------fin----------------------------------------------
 
//Método Constructor y PostConstructor-----comienzo----------------------------    
    public ActualizarComponenteController() {
    }
    
    @PostConstruct
    public void init() {
        componente = new Componente();
    }
//----------------------------fin----------------------------------------------    
    
//Métodos de acceso-----------comienzo-----------------------------------------
    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public List<Componente> getComponenteList() {
        componenteList = listarComponente();
        return componenteList;
    }

    public void setComponenteList(List<Componente> componenteList) {
        this.componenteList = componenteList;
    }
//----------------------------fin----------------------------------------------
    
    
//Método que lista los datos de la tabla Componente utilizando los métodos del AbstractFacade.java
//---------------------------comienzo-----------------------------------------    
   

    public List<Componente> listarComponente() {
        try {
            componenteList = this.componenteEJB.findAll();
        } catch (Exception e) {
        }
        return componenteList;
    }
//--------------------------------fin------------------------------------------
    
//Método que obtiene los datos del usuario y los pasa a la variable global componente
//-------------------------------comienzo--------------------------------------
    public void leerComponente(Componente comp) {
        this.setComponente(comp);

    }
//---------------------------------fin-----------------------------------------
    
//Método que actualiza los datos de la tabla Componente utilizando los métodos del AbstractFacade.java
//------------------------------comienzo---------------------------------------    
    public void actualizarComponente() {
        try {
            componenteEJB.edit(componente);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El componente con codigo " + componente.getIdComponente() + ", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El componente con codigo " + componente.getIdComponente() + ", no se actualizo", ""));
        }
    }
//----------------------------------fin----------------------------------------
    
}//fin de clase
