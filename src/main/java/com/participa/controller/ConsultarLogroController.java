/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.LogroFacadeLocal;
import com.participa.model.Logro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author developer
 */
@Named(value = "consultarLogroController")
@ViewScoped
public class ConsultarLogroController implements Serializable{

    @EJB
    private LogroFacadeLocal logroEJB;
        
    private List<Logro> listaLogro;
    /**
     * Creates a new instance of ConsultarLogroController
     */
    public ConsultarLogroController() {
    }

    public List<Logro> getListaLogro() {
        listaLogro = logroEJB.findAll();
        return listaLogro;
    }

    public void setListaLogro(List<Logro> listaLogro) {
        this.listaLogro = listaLogro;
    }

    
    
}
