package com.participa.controller;

import com.participa.ejb.GradoFacadeLocal;
import com.participa.ejb.PeriodolectivoFacadeLocal;
import com.participa.model.Grado;
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
@Named(value = "consultarPeriodoLectivoController")
@ViewScoped
public class ConsultarPeriodoLectivoController implements Serializable {//Inicio de clase

//Variables globales-----------------comienzo--------------------------------    
    @EJB
    private PeriodolectivoFacadeLocal periodoLectivoEJB;
    private Periodolectivo periodoLectivo;
    private List<Periodolectivo> periodoList;
//------------------------------------fin------------------------------------

//Métodos de acceso-----------------------comienzo--------------------------    
    public Periodolectivo getPeriodoLectivo() {
        return periodoLectivo;
    }

    public void setPeriodoLectivo(Periodolectivo periodoLectivo) {
        this.periodoLectivo = periodoLectivo;
    }

    public List<Periodolectivo> getPeriodoList() {
        periodoList = consultarPeriodoLectivo();

        return periodoList;
    }

    public void setPeriodoList(List<Periodolectivo> periodoList) {
        this.periodoList = periodoList;
    }

//--------------------------------fin----------------------------------------    
//Método constructor------------comienzo-------------------------------------    
    public ConsultarPeriodoLectivoController() {
    }
//-------------------------------fin-----------------------------------------

//Método que llena la lista periodoList-----------comienzo---------------
    public List<Periodolectivo> consultarPeriodoLectivo() {
        return periodoLectivoEJB.findAll();
    }
//---------------------fin-------------------------------------------------- 

    public String colorEstado(boolean estado) {
        String color = "";

        if (estado == true) {
            color = "greenyellow";
        } else {
            if (estado == false) {
                color = "red";
            }
        }
        return color;
    }

    
    public void cambioEstado(Periodolectivo periodo){
        if (periodo.getEstadoPeriodoLectivo() == true) {
            periodo.setEstadoPeriodoLectivo(false);
            periodoLectivoEJB.edit(periodo);
        }else{
            if (periodo.getEstadoPeriodoLectivo() == false) {
                periodo.setEstadoPeriodoLectivo(true);
                periodoLectivoEJB.edit(periodo);
            }
        }
    }
}//fin de clase
