/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.AsignaturaFacadeLocal;
import com.participa.ejb.AsignaturagradoFacadeLocal;
import com.participa.ejb.ComponenteFacade;
import com.participa.ejb.ComponenteFacadeLocal;
import com.participa.ejb.GradoFacadeLocal;
import com.participa.ejb.PeriodocalificableFacadeLocal;
import com.participa.ejb.PeriodolectivoFacade;
import com.participa.ejb.PeriodolectivoFacadeLocal;
import com.participa.model.Asignatura;
import com.participa.model.Componente;
import com.participa.model.Grado;
import com.participa.model.Periodocalificable;
import com.participa.model.Periodolectivo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author dacastanedah
 */
@Named
@ViewScoped
public class ConsultaComponenteController implements Serializable{
    
    @EJB
    private GradoFacadeLocal gradoEJB;
   
    @EJB
    private AsignaturaFacadeLocal asignaturaEJB;
    
    @EJB
    private ComponenteFacadeLocal componenteEJB;
    
    private Asignatura asignatura;
    private Grado grado;
    
    private List<SelectItem> asignaturaList;
    private List<SelectItem> gradoList;
    
    private List<Componente> componenteList;
    
    
   @PostConstruct
   public void init(){
       asignaturaList = new ArrayList<>();
       asignatura = new Asignatura();
       gradoList = new ArrayList<>();
       grado = new Grado();
       
       
        
   }

    

   
   
    public List<Componente> getComponenteList() {
        componenteList = this.listarComponentes();
        return componenteList;
    }

    public void setComponenteList(List<Componente> componenteList) {
        this.componenteList = componenteList;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public List<SelectItem> getGradoList() {
        gradoList = gradoEJB.listarGrado();
        return gradoList;
    }

    public void setGradoList(List<SelectItem> gradoList) {
        this.gradoList = gradoList;
    }

   
   
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<SelectItem> getAsignaturaList() {
        asignaturaList = asignaturaEJB.listarAsignatura();
        return asignaturaList;
    }

    public void setAsignaturaList(List<SelectItem> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

   
   public List<Componente> listarComponentes(){
       try {
           return this.componenteEJB.findAll();
       } catch (Exception e) {
       }
   
       
        return null;
       
       
   }
    
    
        
        
    
}
