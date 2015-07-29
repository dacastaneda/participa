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
       String idComponente = "";
       
       try{
        if (value != null) {
            idComponente= (String) value;
            switch (idComponente){
                case "10DEMC1": idComponente = "Decimo";
                    break;
                case "10EDF": idComponente = "10-Educación Física";
                    break;
                case "10ESP": idComponente = "10-Español";
                    break;
                case "10EST": idComponente = "10-Estetica";
                    break;
                case "10FIL": idComponente = "10-Filosofia";
                    break;
                case "10FIS": idComponente = "10-Física";
                    break;
                case "10MAT": idComponente = "10-Matemáticas";
                    break;
                case "10QUI": idComponente = "10-Química";
                    break;
                case "10REL": idComponente = "10-Religión";
                    break;
                case "10SIS": idComponente = "10-Sistemas";
                    break;
                case "11DEM": idComponente = "11-Democracia";
                    break;
                case "11EDF": idComponente = "11-Educación Física";
                    break;
                case "11ESP": idComponente = "11-Español";
                    break;
                case "11EST": idComponente = "11-Estetica";
                    break;
                case "11FIL": idComponente = "11-Filosofia";
                    break;
                case "11FIS": idComponente = "11-Física";
                    break;
                case "11MAT": idComponente = "11-Matemáticas";
                    break;
                case "11QUI": idComponente = "11-Química";
                    break;
                case "11REL": idComponente = "11-Religión";
                    break;
                case "11SIS": idComponente = "11-Sistemas";
                    break;
                case "6DEM": idComponente = "6-Democracia";
                    break;
                case "6EDF": idComponente = "6-Educación Física";
                    break;
                case "6ESP": idComponente = "6-Español";
                    break;
                case "6EST": idComponente = "6-Estetica";
                    break;
                case "6FIL": idComponente = "6-Filosofia";
                    break;
                case "6FIS": idComponente = "6-Física";
                    break;
                case "6MAT": idComponente = "6-Matemáticas";
                    break;
                case "6QUI": idComponente = "6-Química";
                    break;
                case "6REL": idComponente = "6-Religión";
                    break;
                case "6SIS": idComponente = "6-Sistemas";
                    break;
                case "7DEM": idComponente = "7-Democracia";
                    break;
                case "7EDF": idComponente = "7-Educación Física";
                    break;
                case "7ESP": idComponente = "7-Español";
                    break;
                case "7EST": idComponente = "7-Estetica";
                    break;
                case "7FIL": idComponente = "7-Filosofia";
                    break;
                case "7FIS": idComponente = "7-Física";
                    break;
                case "7MAT": idComponente = "7-Matemáticas";
                    break;
                case "7QUI": idComponente = "7-Química";
                    break;
                case "7REL": idComponente = "7-Religión";
                    break;
                case "7SIS": idComponente = "7-Sistemas";
                    break;
                case "8DEM": idComponente = "8-Democracia";
                    break;
                case "8EDF": idComponente = "8-Educación Física";
                    break;
                case "8ESP": idComponente = "8-Español";
                    break;
                case "8EST": idComponente = "8-Estetica";
                    break;
                case "8FIL": idComponente = "8-Filosofia";
                    break;
                case "8FIS": idComponente = "8-Física";
                    break;
                case "8MAT": idComponente = "8-Matemáticas";
                    break;
                case "8QUI": idComponente = "8-Química";
                    break;
                case "8REL": idComponente = "8-Religión";
                    break;
                case "8SIS": idComponente = "8-Sistemas";
                    break;
                case "9DEM": idComponente = "9-Democracia";
                    break;
                case "9EDF": idComponente = "9-Educación Física";
                    break;
                case "9ESP": idComponente = "9-Español";
                    break;
                case "9EST": idComponente = "9-Estetica";
                    break;
                case "9FIL": idComponente = "9-Filosofia";
                    break;
                case "9FIS": idComponente = "9-Física";
                    break;
                case "9MAT": idComponente = "9-Matemáticas";
                    break;
                case "9QUI": idComponente = "9-Química";
                    break;
                case "9REL": idComponente = "9-Religión";
                    break;
                case "9SIS": idComponente = "9-Sistemas";
                    break;
            }
        }
        return idComponente;
       }catch(Exception e){
           String msg = null;
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se logro convertir", ""));
          return  msg;
       }
    }
    
       
}
