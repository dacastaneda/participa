package com.participa.controller;

import com.participa.ejb.GradoFacadeLocal;
import com.participa.model.Grado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dacastanedah
 */
@Named(value = "consultarGradosController")
@ViewScoped
public class ConsultarGradosController implements Serializable{//Inicio de clase

//Variables globales-----------------comienzo--------------------------------    
    @EJB
    private GradoFacadeLocal gradoEJB;
    private Grado grado;
    private List<Grado> gradoList;
//------------------------------------fin------------------------------------

//Métodos de acceso-----------------------comienzo--------------------------    
    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public List<Grado> getGradoList() {
        gradoList = consultarGrado();
        return gradoList;
    }

    public void setGradoList(List<Grado> gradoList) {
        this.gradoList = gradoList;
    }

//--------------------------------fin----------------------------------------    
    
//Método constructor------------comienzo-------------------------------------    
    public ConsultarGradosController() {
    }
//-------------------------------fin-----------------------------------------
    
    
//Método que llena la lista gradoList-----------comienzo---------------
  public List<Grado> consultarGrado(){
      return gradoEJB.findAll();
  }  
//---------------------fin--------------------------------------------------    
}//fin de clase
