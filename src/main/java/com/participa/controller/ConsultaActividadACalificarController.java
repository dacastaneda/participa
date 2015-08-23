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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author DIANA
 */
@Named(value = "consultaActividadACalificarController")
@SessionScoped
public class ConsultaActividadACalificarController implements Serializable {

    
    
    @EJB
    
    private ActividadacalificarFacadeLocal actividadACalificarEJB;
    
    private List<Actividadacalificar> listaActividadACalificar;

    public List<Actividadacalificar> getListaActividadACalificar() {
        
        listaActividadACalificar = actividadACalificarEJB.findAll();
        
        
        return listaActividadACalificar;
    }

    public void setListaActividadACalificar(List<Actividadacalificar> listaActividadACalificar) {
        this.listaActividadACalificar = listaActividadACalificar;
    }
    
    
    
    /**
     * Creates a new instance of ConsultaActividadACalificarController
     */
    public ConsultaActividadACalificarController() {
    }
    
}
