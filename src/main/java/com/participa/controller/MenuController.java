/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.controller;


import com.participa.ejb.Menunivel3FacadeLocal;

import com.participa.model.Menunivel3;
import com.participa.model.Perfil;
import com.participa.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;


/**
 *
 * @author dacastanedah
 */
@Named
@SessionScoped
public class MenuController implements Serializable{
    
    @EJB
    private Menunivel3FacadeLocal EJBMenunivel3;
    
    
    private MenuModel model;
    
    private List<Menunivel3> lista1;

    
    
    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
        
    }
    
    
    
    @PostConstruct
    public void init(){
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }
    
    public void listarMenus(){
        try{
            lista1 = EJBMenunivel3.findAll();
            
        }catch(Exception e){
            
        }
    }
    
        public void cerrarSesion(){
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
    
    public void establecerPermisos(){
        
         Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");

        for (Menunivel3 m: lista1) {
            if (m.getTipo().equals("S") && m.getRol().equals(us.getRol()) ) {
                DefaultSubMenu primerSubMenu = new DefaultSubMenu(m.getNombreMenuNivel3());
                for (Menunivel3 i : lista1) {
                    Menunivel3 submenu = i.getSubmenu();
                    if (submenu != null) {
                        if (submenu.getIdMenuNivel3() == m.getIdMenuNivel3() ) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombreMenuNivel3());
                            item.setUrl(i.getUrl());
                        primerSubMenu.addElement(item);
                        }
                    }
                }
            model.addElement(primerSubMenu);
            }else{
                
                if (m.getSubmenu()== null && m.getRol().equals(us.getRol()) ) {
                    
                   DefaultMenuItem item = new DefaultMenuItem(m.getNombreMenuNivel3());
                   item.setUrl(m.getUrl());
                   
                model.addElement(item); 
                }
                
            }
        }
        
        
    }
    
    public String nombreUsuario(){
        String nombre = null;
         Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
         
        nombre = us.getPrimerNombre()+" "+us.getPrimerApellido();
        
        
        return nombre;
    }
    
    public String rolUsuario(){
        String rol = null;
         Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
         
        rol = us.getRol();
        
        
        return rol;
    }
}
