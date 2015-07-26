/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author dacastanedah
 */
@FacesConverter("idGradoConverter")
public class IdGradoConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       String idAsignaturaGrado = "";
       
       try{
        if (value != null) {
            idAsignaturaGrado = (String) value;
            switch (idAsignaturaGrado){
                case "10DEM": idAsignaturaGrado = "10-Democracia";
                    break;
                case "10EDF": idAsignaturaGrado = "10-Educación Física";
                    break;
                case "10ESP": idAsignaturaGrado = "10-Español";
                    break;
                case "10EST": idAsignaturaGrado = "10-Estetica";
                    break;
                case "10FIL": idAsignaturaGrado = "10-Filosofia";
                    break;
                case "10FIS": idAsignaturaGrado = "10-Física";
                    break;
                case "10MAT": idAsignaturaGrado = "10-Matemáticas";
                    break;
                case "10QUI": idAsignaturaGrado = "10-Química";
                    break;
                case "10REL": idAsignaturaGrado = "10-Religión";
                    break;
                case "10SIS": idAsignaturaGrado = "10-Sistemas";
                    break;
                case "11DEM": idAsignaturaGrado = "11-Democracia";
                    break;
                case "11EDF": idAsignaturaGrado = "11-Educación Física";
                    break;
                case "11ESP": idAsignaturaGrado = "11-Español";
                    break;
                case "11EST": idAsignaturaGrado = "11-Estetica";
                    break;
                case "11FIL": idAsignaturaGrado = "11-Filosofia";
                    break;
                case "11FIS": idAsignaturaGrado = "11-Física";
                    break;
                case "11MAT": idAsignaturaGrado = "11-Matemáticas";
                    break;
                case "11QUI": idAsignaturaGrado = "11-Química";
                    break;
                case "11REL": idAsignaturaGrado = "11-Religión";
                    break;
                case "11SIS": idAsignaturaGrado = "11-Sistemas";
                    break;
                case "6DEM": idAsignaturaGrado = "6-Democracia";
                    break;
                case "6EDF": idAsignaturaGrado = "6-Educación Física";
                    break;
                case "6ESP": idAsignaturaGrado = "6-Español";
                    break;
                case "6EST": idAsignaturaGrado = "6-Estetica";
                    break;
                case "6FIL": idAsignaturaGrado = "6-Filosofia";
                    break;
                case "6FIS": idAsignaturaGrado = "6-Física";
                    break;
                case "6MAT": idAsignaturaGrado = "6-Matemáticas";
                    break;
                case "6QUI": idAsignaturaGrado = "6-Química";
                    break;
                case "6REL": idAsignaturaGrado = "6-Religión";
                    break;
                case "6SIS": idAsignaturaGrado = "6-Sistemas";
                    break;
                case "7DEM": idAsignaturaGrado = "7-Democracia";
                    break;
                case "7EDF": idAsignaturaGrado = "7-Educación Física";
                    break;
                case "7ESP": idAsignaturaGrado = "7-Español";
                    break;
                case "7EST": idAsignaturaGrado = "7-Estetica";
                    break;
                case "7FIL": idAsignaturaGrado = "7-Filosofia";
                    break;
                case "7FIS": idAsignaturaGrado = "7-Física";
                    break;
                case "7MAT": idAsignaturaGrado = "7-Matemáticas";
                    break;
                case "7QUI": idAsignaturaGrado = "7-Química";
                    break;
                case "7REL": idAsignaturaGrado = "7-Religión";
                    break;
                case "7SIS": idAsignaturaGrado = "7-Sistemas";
                    break;
                case "8DEM": idAsignaturaGrado = "8-Democracia";
                    break;
                case "8EDF": idAsignaturaGrado = "8-Educación Física";
                    break;
                case "8ESP": idAsignaturaGrado = "8-Español";
                    break;
                case "8EST": idAsignaturaGrado = "8-Estetica";
                    break;
                case "8FIL": idAsignaturaGrado = "8-Filosofia";
                    break;
                case "8FIS": idAsignaturaGrado = "8-Física";
                    break;
                case "8MAT": idAsignaturaGrado = "8-Matemáticas";
                    break;
                case "8QUI": idAsignaturaGrado = "8-Química";
                    break;
                case "8REL": idAsignaturaGrado = "8-Religión";
                    break;
                case "8SIS": idAsignaturaGrado = "8-Sistemas";
                    break;
                case "9DEM": idAsignaturaGrado = "9-Democracia";
                    break;
                case "9EDF": idAsignaturaGrado = "9-Educación Física";
                    break;
                case "9ESP": idAsignaturaGrado = "9-Español";
                    break;
                case "9EST": idAsignaturaGrado = "9-Estetica";
                    break;
                case "9FIL": idAsignaturaGrado = "9-Filosofia";
                    break;
                case "9FIS": idAsignaturaGrado = "9-Física";
                    break;
                case "9MAT": idAsignaturaGrado = "9-Matemáticas";
                    break;
                case "9QUI": idAsignaturaGrado = "9-Química";
                    break;
                case "9REL": idAsignaturaGrado = "9-Religión";
                    break;
                case "9SIS": idAsignaturaGrado = "9-Sistemas";
                    break;
            }
        }
        return idAsignaturaGrado;
       }catch(Exception e){
           String msg = null;
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se logro convertir", ""));
          return  msg;
       }
    }
    
       
}
