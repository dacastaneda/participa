package com.participa.controller;

import com.participa.ejb.GradoFacadeLocal;
import com.participa.model.Grado;
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
@Named(value = "registrarGradosController")
@ViewScoped
public class RegistrarGradosController implements Serializable{//Inicio clase

    @EJB
    private GradoFacadeLocal gradoEJB;
    private Grado grado;

    
//Métodos de acceso---------------comienzo------------------------------------    
    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }
//------------------------------------fin-------------------------------------    
    
    
    
    
//Método para registrar los grados----------comienzo-----------------------
   public void registrarGrados(){
       try {
           gradoEJB.create(grado);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Grado registrado con éxito", ""));
       } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El grado no se logro registrar", ""));
       }
       
   } 
//-----------------------fin--------------------------------------------------    
    
    
//Método constructor------------comienzo--------------------------------------     
    public RegistrarGradosController() {
    }
    @PostConstruct
    public void init(){
       grado = new Grado();
    }
//---------------------------------fin----------------------------------------    
}//Fin de clase
