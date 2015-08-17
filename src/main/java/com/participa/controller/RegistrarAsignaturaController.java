package com.participa.controller;

import com.participa.ejb.AsignaturaFacadeLocal;
import com.participa.model.Asignatura;
import java.io.Serializable;
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
@Named(value = "registrarAsignaturaController")
@ViewScoped
public class RegistrarAsignaturaController implements Serializable{//Inicio clase

    @EJB
    private AsignaturaFacadeLocal asignaturaEJB;
    private Asignatura asignatura;

    
//Métodos de acceso---------------comienzo------------------------------------    
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
//------------------------------------fin-------------------------------------    
    
    
    
    
//Método para registrar la asignatura----------comienzo-----------------------
   public void registrarAsignatura(){
       try {
           asignaturaEJB.create(asignatura);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignatura registrada con éxito", ""));
       } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La asignatura no se logro registrar", ""));
       }
       
   } 
//-----------------------fin--------------------------------------------------    
    
    
//Método constructor------------comienzo--------------------------------------     
    public RegistrarAsignaturaController() {
    }
    @PostConstruct
    public void init(){
       asignatura = new Asignatura();
    }
//---------------------------------fin----------------------------------------    
}//Fin de clase
