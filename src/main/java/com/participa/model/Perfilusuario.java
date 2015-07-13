/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dacastanedah
 */
@Entity
@Table(name = "perfilusuario")
@NamedQueries({
    @NamedQuery(name = "Perfilusuario.findAll", query = "SELECT p FROM Perfilusuario p"),
    @NamedQuery(name = "Perfilusuario.findByIdPerfilUsuario", query = "SELECT p FROM Perfilusuario p WHERE p.idPerfilUsuario = :idPerfilUsuario"),
    @NamedQuery(name = "Perfilusuario.findByEstadoPerfilUsuario", query = "SELECT p FROM Perfilusuario p WHERE p.estadoPerfilUsuario = :estadoPerfilUsuario")})
public class Perfilusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPerfilUsuario")
    private Integer idPerfilUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoPerfilUsuario")
    private boolean estadoPerfilUsuario;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(optional = false)
    private Perfil idPerfil;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Usuario idPersona;

    public Perfilusuario() {
    }

    public Perfilusuario(Integer idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

    public Perfilusuario(Integer idPerfilUsuario, boolean estadoPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
        this.estadoPerfilUsuario = estadoPerfilUsuario;
    }

    public Integer getIdPerfilUsuario() {
        return idPerfilUsuario;
    }

    public void setIdPerfilUsuario(Integer idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

    public boolean getEstadoPerfilUsuario() {
        return estadoPerfilUsuario;
    }

    public void setEstadoPerfilUsuario(boolean estadoPerfilUsuario) {
        this.estadoPerfilUsuario = estadoPerfilUsuario;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Usuario getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Usuario idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilUsuario != null ? idPerfilUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfilusuario)) {
            return false;
        }
        Perfilusuario other = (Perfilusuario) object;
        if ((this.idPerfilUsuario == null && other.idPerfilUsuario != null) || (this.idPerfilUsuario != null && !this.idPerfilUsuario.equals(other.idPerfilUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Perfilusuario[ idPerfilUsuario=" + idPerfilUsuario + " ]";
    }
    
}
