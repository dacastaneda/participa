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

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;

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
    
    private String asignaturas;
    private String grados;
    
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

    public String getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String getGrados() {
        return grados;
    }

    public void setGrados(String grados) {
        this.grados = grados;
    }

    

   
   
    public List<Componente> getComponenteList() {
        
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
    
     public void consultaComponente(){
         
                 this.componenteList =  componenteEJB.invocarProcedure(grados,asignaturas);
       
   }
        
   public void exportarPdf() throws JRException, IOException{
       Map<String, Object> parametros = new HashMap<>();
       parametros.put("idGrado", this.grados);
       parametros.put("idAsignatura", this.asignaturas);
       
       File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/reportComponente.jasper"));
       JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.componenteList));
       HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       response.addHeader("Content-disposition", "attachment; filename=componenteReporte.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jp, stream);
            
            stream.flush();
            stream.close();
        }
       FacesContext.getCurrentInstance().responseComplete();
   }
   
   public void exportarExcel() throws JRException, IOException{
       Map<String, Object> parametros = new HashMap<>();
       parametros.put("idGrado", this.grados);
       parametros.put("idAsignatura", this.asignaturas);
       
       File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/reportComponente.jasper"));
       JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.componenteList));
       HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       response.addHeader("Content-disposition", "attachment; filename=componenteReporte.xls");
        try (ServletOutputStream stream = response.getOutputStream()) {
            
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();
            
            stream.flush();
            stream.close();
        }
       FacesContext.getCurrentInstance().responseComplete();
   }
    
   
   public void exportarPpt() throws JRException, IOException{
       Map<String, Object> parametros = new HashMap<>();
       parametros.put("idGrado", this.grados);
       parametros.put("idAsignatura", this.asignaturas);
       
       File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/reportComponente.jasper"));
       JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.componenteList));
       HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       response.addHeader("Content-disposition", "attachment; filename=componenteReporte.ppt");
        try (ServletOutputStream stream = response.getOutputStream()) {
            
            JRPptxExporter exporter = new JRPptxExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();
            
            stream.flush();
            stream.close();
        }
       FacesContext.getCurrentInstance().responseComplete();
   }
   
   public void exportarDoc() throws JRException, IOException{
       Map<String, Object> parametros = new HashMap<>();
       parametros.put("idGrado", this.grados);
       parametros.put("idAsignatura", this.asignaturas);
       
       File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/reportComponente.jasper"));
       JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.componenteList));
       HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       response.addHeader("Content-disposition", "attachment; filename=componenteReporte.doc");
        try (ServletOutputStream stream = response.getOutputStream()) {
            
            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();
            
            stream.flush();
            stream.close();
        }
       FacesContext.getCurrentInstance().responseComplete();
   }
}
