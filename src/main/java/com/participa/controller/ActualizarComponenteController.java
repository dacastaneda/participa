/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.ComponenteFacadeLocal;
import com.participa.ejb.UsuarioFacadeLocal;
import com.participa.model.Componente;
import com.participa.model.Usuario;
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
public class ActualizarComponenteController implements Serializable{
   
@EJB
private ComponenteFacadeLocal componenteEJB;

private Componente componente;

private List<Componente> componenteList;

@PostConstruct

public void init(){
componente = new Componente();
}

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



    public ActualizarComponenteController() {
       
    }
    public List<Componente> listarComponente(){
        try {
           componenteList = this.componenteEJB.findAll();
        } catch (Exception e) {
        }
        
    return componenteList;
    }
    
    public void leerComponente(Componente comp){
        this.setComponente(comp);
        
    }
    public void actualizarComponente(){
        try {
            componenteEJB.edit(componente);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"El componente con codigo "+componente.getIdComponente()+", se actualizo con éxito", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"El componente con codigo "+componente.getIdComponente()+", no se actualizo", ""));

    }
}
}

