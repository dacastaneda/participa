package com.participa.controller;

import com.participa.ejb.AsignaturaFacadeLocal;
import com.participa.model.Asignatura;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dacastanedah
 */
@Named(value = "consultarAsignaturasController")
@ViewScoped
public class ConsultarAsignaturasController implements Serializable{//Inicio de clase

//Variables globales-----------------comienzo--------------------------------    
    @EJB
    private AsignaturaFacadeLocal asignaturaEJB;
    private Asignatura asignatura;
    private List<Asignatura> asignaturaList;
//------------------------------------fin------------------------------------

//Métodos de acceso-----------------------comienzo--------------------------    
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<Asignatura> getAsignaturaList() {
        asignaturaList = consultarAsignatura();
        return asignaturaList;
    }

    public void setAsignaturaList(List<Asignatura> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

//--------------------------------fin----------------------------------------    
    
//Método constructor------------comienzo-------------------------------------    
    public ConsultarAsignaturasController() {
    }
//-------------------------------fin-----------------------------------------
    
    
//Método que llena la lista asignaturaList-----------comienzo---------------
  public List<Asignatura> consultarAsignatura(){
      return asignaturaEJB.findAll();
  }  
//---------------------fin--------------------------------------------------    
}//fin de clase
