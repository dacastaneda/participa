package com.participa.controller;

import com.participa.ejb.GradoFacadeLocal;
import com.participa.ejb.PerfilFacadeLocal;
import com.participa.model.Grado;
import com.participa.model.Perfil;
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
@Named(value = "registrarPerfilController")
@ViewScoped
public class RegistrarPerfilController implements Serializable{//Inicio clase

    @EJB
    private PerfilFacadeLocal perfilEJB;
    private Perfil perfil;

    
//Métodos de acceso---------------comienzo------------------------------------    
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
//------------------------------------fin-------------------------------------    

    
    
    
    
    
//Método para registrar los perfiles----------comienzo-----------------------
   public void registrarPerfil(){
       try {
           perfilEJB.create(perfil);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil registrado con éxito", ""));
       } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El perfil no se logro registrar", ""));
       }
       
   } 
//-----------------------fin--------------------------------------------------    
    
    
//Método constructor------------comienzo--------------------------------------     
    public RegistrarPerfilController() {
    }
    @PostConstruct
    public void init(){
       perfil = new Perfil();
    }
//---------------------------------fin----------------------------------------    
}//Fin de clase
