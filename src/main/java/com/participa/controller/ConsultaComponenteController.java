package com.participa.controller;

import com.participa.ejb.ComponenteFacadeLocal;
import com.participa.model.Asignatura;
import com.participa.model.Componente;
import com.participa.model.Grado;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
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
public class ConsultaComponenteController implements Serializable {//inicia clase

//Variables globales-------------------comienzo--------------------------------    
    @EJB
    private ComponenteFacadeLocal componenteEJB;
    private Asignatura asignatura;
    private Grado grado;
    private String asignaturas;
    private String grados;
    private List<SelectItem> asignaturaList;
    private List<SelectItem> gradoList;
    private List<Componente> componenteList;
//----------------------------------------fin----------------------------------
    
    
    

//Métodos PostConstructor---------comienzo-------------------------------------    
    @PostConstruct
    public void init() {
        asignaturaList = new ArrayList<>();
        asignatura = new Asignatura();
        gradoList = new ArrayList<>();
        grado = new Grado();
    }
//----------------------------------------fin----------------------------------
    
    
    

//Métodos de acceso----------------------comienzo------------------------------   
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
//------------------------------------------------fin---------------------------
    
    
    

//Método para listar los datos de la tabla componentes, se utiliza métodos de la 
//clase AbstractFacade.java
//Actualmente no se esta utilizando-----------------comienzo--------------------
    public List<Componente> listarComponentes() {
        try {
            return this.componenteEJB.findAll();
        } catch (Exception e) {
        }
        return null;
    }
//---------------------------------------------------fin-----------------------
    
    
    

//Método que lista los datos de la tabla componente, traidos por medio de un procedimiento
//almacenado, el cual tiene de entrada dos parametros "grados" y "asignaturas"
//------------------------------comienzo--------------------------------------    
    public void consultaComponente() {
//Se llena la lista componenteList con los datos traidos del procedimiento
        this.componenteList = componenteEJB.invocarProcedure(grados, asignaturas);
    }
//---------------------------------fin-----------------------------------------
    
    

//Método para exportar el reporte a pdf--------------comienzo------------------
//Se declara un Map con clave String y valor Object
    public void exportarPdf() throws JRException, IOException {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idGrado", this.grados);//se añaden los parametros al Map
        parametros.put("idAsignatura", this.asignaturas);

//Creamos un archivo y le agregamos el reporte .jasper mediante .getRealPath para obtener el archivo desde su 
//ubicación
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/reportComponente.jasper"));
        
//Pasamos los datos al reporte "Pintamos el reporte", le pasamos el archivo, los parametros, y la lista.        
        JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.componenteList));
        
//Funcionalidad para el envio de una respuesta  
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=componenteReporte.pdf");//nombre y tipo de archivo
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jp, stream);//exportar a PDF

            stream.flush();//Se obliga a pasar todos los datos al archivo, vacia buffers de salida
            stream.close();//liberar los recursos del outPutStream
        }
        FacesContext.getCurrentInstance().responseComplete();//se termina la respuesta
    }
//---------------------------------------------fin----------------------------
    
    
    
    
//Método para exportar a formato axcel--------------comienzo------------------    
    public void exportarExcel() throws JRException, IOException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idGrado", this.grados);
        parametros.put("idAsignatura", this.asignaturas);

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/reportComponente.jasper"));
        JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.componenteList));
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=componenteReporte.xls");
        try (ServletOutputStream stream = response.getOutputStream()) {

            JRXlsExporter exporter = new JRXlsExporter();//Exportar excel
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();//exportar reporte

            stream.flush();
            stream.close();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
//------------------------------------------fin-------------------------------
    
    
    
  
//Método para exportar a power point---------comienzo------------------------ -   
    public void exportarPpt() throws JRException, IOException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idGrado", this.grados);
        parametros.put("idAsignatura", this.asignaturas);

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/reportComponente.jasper"));
        JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.componenteList));
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=componenteReporte.ppt");
        try (ServletOutputStream stream = response.getOutputStream()) {

            JRPptxExporter exporter = new JRPptxExporter();//exportar a power point
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();

            stream.flush();
            stream.close();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
//-----------------------------------------fin--------------------------------
    
    
    

//Exportar a word .doc-----------------comienzo-------------------------------    
    public void exportarDoc() throws JRException, IOException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idGrado", this.grados);
        parametros.put("idAsignatura", this.asignaturas);

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/reportComponente.jasper"));
        JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.componenteList));
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=componenteReporte.doc");
        try (ServletOutputStream stream = response.getOutputStream()) {

            JRDocxExporter exporter = new JRDocxExporter();//Exportar a word .doc
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
            exporter.exportReport();

            stream.flush();
            stream.close();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
//---------------------------------------fin----------------------------------
    
}//fin de clase
