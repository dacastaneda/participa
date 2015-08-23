package com.participa.controller;

import com.participa.ejb.PeriodocalificableFacadeLocal;
import com.participa.ejb.PeriodolectivoFacadeLocal;
import com.participa.model.Periodocalificable;
import com.participa.model.Periodolectivo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dacastanedah
 */
@Named(value = "consultarPeriodoCalificableController")
@ViewScoped
public class ConsultarPeriodoCalificableController implements Serializable{//Inicio de clase

//Variables globales-----------------comienzo--------------------------------    
    @EJB
    private PeriodocalificableFacadeLocal periodoCalificableEJB;
    private Periodocalificable periodoCalificable;
    private List<Periodocalificable> periodoList;
//------------------------------------fin------------------------------------

//Métodos de acceso-----------------------comienzo--------------------------    

    public Periodocalificable getPeriodoCalificable() {
        return periodoCalificable;
    }

    public void setPeriodoCalificable(Periodocalificable periodoCalificable) {
        this.periodoCalificable = periodoCalificable;
    }

    public List<Periodocalificable> getPeriodoList() {
        periodoList = consultarPeriodoLectivo();
        return periodoList;
    }

    public void setPeriodoList(List<Periodocalificable> periodoList) {
        this.periodoList = periodoList;
    }

    
   

//--------------------------------fin----------------------------------------    
    
//Método constructor------------comienzo-------------------------------------    
    public ConsultarPeriodoCalificableController() {
    }
//-------------------------------fin-----------------------------------------
    
    
//Método que llena la lista periodoList-----------comienzo---------------
  public List<Periodocalificable> consultarPeriodoLectivo(){
      return periodoCalificableEJB.findAll();
  }  
//---------------------fin--------------------------------------------------    
}//fin de clase
