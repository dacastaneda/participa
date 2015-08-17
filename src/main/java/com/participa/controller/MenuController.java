package com.participa.controller;

import com.participa.ejb.Menunivel3FacadeLocal;
import com.participa.model.Menunivel3;
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
public class MenuController implements Serializable{//inicio de clase
    
//Variables globales--------------comienzo-------------------------------------    
    @EJB
    private Menunivel3FacadeLocal EJBMenunivel3;
    private MenuModel model;
    private List<Menunivel3> lista1;
//-------------------------------------fin-------------------------------------
    
    
//Método PostConstructor--------------comienzo---------------------------------
    @PostConstruct
    public void init(){
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }
//---------------------------------------fin-----------------------------------    
    
    
//Métodos de acceso--------------------comienzo--------------------------------
    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
//----------------------------------------fin----------------------------------    
    
    
//Método listarMenus, este metodo nos trae todos los datos contenidos en la tabla
//MenuNivel3, donde se encuentran las url, menu y submenu.-----comienzo-------
    public void listarMenus(){
        try{
            lista1 = EJBMenunivel3.findAll(); 
        }catch(Exception e){   
        }
    }
//--------------------------------------------fin------------------------------  
    
    
    
//Método para cerrar la sesión de usuario--------comienzo----------------------
//Este metodo invalida la sesión.
        public void cerrarSesion(){
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
//-----------------------------------------fin---------------------------------
        
        
  
//Método para establecer permisos del menu--------comienzo---------------------        
    public void establecerPermisos() {
//Se obtiene la sesión del usuario que esta logueado.
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");

        for (Menunivel3 m : lista1) {//recorremos la lista que llenamos con listarMenu
            if (m.getTipo().equals("S") && m.getRol().equals(us.getRol())) {//si el tipo de menu es = a "S"
                //y el rol del menu y el de usuario logueado son iguales crea un submeu
                DefaultSubMenu primerSubMenu = new DefaultSubMenu(m.getNombreMenuNivel3());//con getNombre le asigo nombre al submenu
                for (Menunivel3 i : lista1) {//Volvemos a recorrer la lista
                    Menunivel3 submenu = i.getSubmenu();//traemos los datos de la columna SubMenu de la base de datos
                    if (submenu != null) {//Si son diferentes a null y
                        if (submenu.getIdMenuNivel3() == m.getIdMenuNivel3()) {//si son iguales los id
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombreMenuNivel3());//se crean los items del submenu
                            item.setUrl(i.getUrl());//se les enlaza una url
                            primerSubMenu.addElement(item);//se le agregan los item al submenu
                        }
                    }
                }
                model.addElement(primerSubMenu);//se agrega el submenu al modelo
            } else {
                if (m.getSubmenu() == null && m.getRol().equals(us.getRol())) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombreMenuNivel3());
                    item.setUrl(m.getUrl());
                    model.addElement(item);
                }
            }
        }
    }
//-----------------------------------------------fin----------------------------
    
    
    
//Método que nos devuelve el nombre del usuario logueado-----------------------
//------------------------------------comienzo---------------------------------    
    public String nombreUsuario() {
        String nombre = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        nombre = us.getPrimerNombre() + " " + us.getPrimerApellido();
        return nombre;
    }
//----------------------------------------fin----------------------------------
    
    
//Método que nos devuelve el rol del usuario logueado--------------------------
//--------------------------------------comienzo-------------------------------
    public String rolUsuario() {
        String rol = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User");
        rol = us.getRol();
        return rol;
    }
//----------------------------------------fin----------------------------------
    
    
}//fin de clase
