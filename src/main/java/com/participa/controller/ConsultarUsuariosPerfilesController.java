package com.participa.controller;

import com.participa.ejb.UsuarioFacadeLocal;
import com.participa.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author dacastanedah
 */
@Named(value = "consultarUsuariosPerfilesController")
@SessionScoped
public class ConsultarUsuariosPerfilesController implements Serializable {

//Variable globales--------------comienzo------------------------------------
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;
    private List<Usuario> usuarioList;
//---------------------------------fin---------------------------------------

//Métodos Constructor y PostConstructor---------comienzo---------------------    
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public ConsultarUsuariosPerfilesController() {
    }
//-------------------------------------------fin-----------------------------
    
    
 
//Métodos de acceso---------------------comienzo------------------------------    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioList() {
        usuarioList = this.listarUsuarios();
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
//--------------------------------fin----------------------------------------
   
 
//Método que lista los usuarios del sistema------------comienzo--------------    
    public List<Usuario> listarUsuarios() {
        try {
            return this.usuarioEJB.findAll();
        } catch (Exception e) {
        }
        return null;
    }
//-------------------------------------------fin-----------------------------
    
    
 
//Método para leer los datos de un usuario especifico, recibe un usuario, el cual
//es enviado desde la interfaz de usuario---------comienzo--------------------    
    public void leerUsuario(Usuario user) {
//recibe el usuario y se lo pasa a la variable global usuario.
        this.setUsuario(user);
    }
//----------------------------------------------fin---------------------------
    
}//fin de clase
