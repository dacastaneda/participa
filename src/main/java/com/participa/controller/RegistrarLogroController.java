/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;

import com.participa.ejb.AsignaturaFacadeLocal;
import com.participa.ejb.ComponenteFacadeLocal;
import com.participa.ejb.GradoFacadeLocal;
import com.participa.ejb.PeriodocalificableFacadeLocal;
import com.participa.model.Asignatura;
import com.participa.model.Componente;
import com.participa.model.Grado;
import com.participa.model.Periodocalificable;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author DIANA
 */
@Named(value = "registrarLogroController")
@SessionScoped
public class RegistrarLogroController implements Serializable {

    @EJB
    private GradoFacadeLocal gradoEJB;

    @EJB
    private AsignaturaFacadeLocal asignaturaEJB;

    @EJB
    private ComponenteFacadeLocal componenteEJB;

    @EJB
    private PeriodocalificableFacadeLocal periodocalificableEJB;

    private List<SelectItem> gradoList;
    private List<SelectItem> asignaturaList;
    private List<SelectItem> componenteList;
    private List<SelectItem> periodocalificableList;

    private Grado grado;
    private Asignatura asignatura;
    private Componente componente;
    private Periodocalificable periodocomponente;

    private String gradoV;
    private String asignaturaV;
    private String componenteV;
    private String periodoComponenteV;
    private String logroV;

    private String prueba;

    public String getPrueba() {

        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public String getLogroV() {
        return logroV;
    }

    public void setLogroV(String logroV) {
        this.logroV = logroV;
    }

    public String getAsignaturaV() {
        return asignaturaV;
    }

    public void setAsignaturaV(String asignaturaV) {
        this.asignaturaV = asignaturaV;
    }

    public String getComponenteV() {
        return componenteV;
    }

    public void setComponenteV(String componenteV) {
        this.componenteV = componenteV;
    }

    public String getPeriodoComponenteV() {
        return periodoComponenteV;
    }

    public void setPeriodoComponenteV(String periodoComponenteV) {
        this.periodoComponenteV = periodoComponenteV;
    }

    public String getGradoV() {
        return gradoV;
    }

    public void setGradoV(String gradoV) {
        this.gradoV = gradoV;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public Periodocalificable getPeriodocomponente() {
        return periodocomponente;
    }

    public void setPeriodocomponente(Periodocalificable periodocomponente) {
        this.periodocomponente = periodocomponente;
    }

    /**
     * Creates a new instance of RegistrarLogroController
     */
    public RegistrarLogroController() {
    }

    public List<SelectItem> getGradoList() {

        this.gradoList = gradoEJB.listarGrado();

        return gradoList;
    }

    public void setGradoList(List<SelectItem> gradoList) {
        this.gradoList = gradoList;
    }

    public List<SelectItem> getAsignaturaList() {

        this.asignaturaList = asignaturaEJB.listarAsignatura();

        return asignaturaList;
    }

    public void setAsignaturaList(List<SelectItem> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

    public List<SelectItem> getComponenteList() {
        return componenteList;
    }

    public void setComponenteList(List<SelectItem> componenteList) {
        this.componenteList = componenteList;
    }

    public List<SelectItem> getPeriodocalificableList() {

        periodocalificableList = periodocalificableEJB.listarPeriodoCalificable();

        return periodocalificableList;
    }

    public void setPeriodocalificableList(List<SelectItem> periodocalificableList) {
        this.periodocalificableList = periodocalificableList;
    }

   
}
