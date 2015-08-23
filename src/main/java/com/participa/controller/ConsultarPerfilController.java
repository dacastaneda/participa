/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.LogroFacadeLocal;
import com.participa.ejb.PerfilFacadeLocal;
import com.participa.model.Logro;
import com.participa.model.Perfil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author developer
 */
@Named(value = "consultarPerfilController")
@ViewScoped
public class ConsultarPerfilController implements Serializable{

    @EJB
    private PerfilFacadeLocal perfilEJB;
        
    private List<Perfil> listaPerfil;
    /**
     * Creates a new instance of ConsultarLogroController
     */
    public ConsultarPerfilController() {
    }

    public List<Perfil> getListaPerfil() {
        listaPerfil = perfilEJB.findAll();
        return listaPerfil;
    }

    public void setListaPerfil(List<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }

    
    
}
