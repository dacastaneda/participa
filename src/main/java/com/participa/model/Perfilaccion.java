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
@Table(name = "perfilaccion")
@NamedQueries({
    @NamedQuery(name = "Perfilaccion.findAll", query = "SELECT p FROM Perfilaccion p"),
    @NamedQuery(name = "Perfilaccion.findByIdPerfilAccion", query = "SELECT p FROM Perfilaccion p WHERE p.idPerfilAccion = :idPerfilAccion"),
    @NamedQuery(name = "Perfilaccion.findByEstadoPerfil", query = "SELECT p FROM Perfilaccion p WHERE p.estadoPerfil = :estadoPerfil")})
public class Perfilaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPerfilAccion")
    private Integer idPerfilAccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoPerfil")
    private boolean estadoPerfil;
    @JoinColumn(name = "idMenuNivel3", referencedColumnName = "idMenuNivel3")
    @ManyToOne(optional = false)
    private Menunivel3 idMenuNivel3;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public Perfilaccion() {
    }

    public Perfilaccion(Integer idPerfilAccion) {
        this.idPerfilAccion = idPerfilAccion;
    }

    public Perfilaccion(Integer idPerfilAccion, boolean estadoPerfil) {
        this.idPerfilAccion = idPerfilAccion;
        this.estadoPerfil = estadoPerfil;
    }

    public Integer getIdPerfilAccion() {
        return idPerfilAccion;
    }

    public void setIdPerfilAccion(Integer idPerfilAccion) {
        this.idPerfilAccion = idPerfilAccion;
    }

    public boolean getEstadoPerfil() {
        return estadoPerfil;
    }

    public void setEstadoPerfil(boolean estadoPerfil) {
        this.estadoPerfil = estadoPerfil;
    }

    public Menunivel3 getIdMenuNivel3() {
        return idMenuNivel3;
    }

    public void setIdMenuNivel3(Menunivel3 idMenuNivel3) {
        this.idMenuNivel3 = idMenuNivel3;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilAccion != null ? idPerfilAccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfilaccion)) {
            return false;
        }
        Perfilaccion other = (Perfilaccion) object;
        if ((this.idPerfilAccion == null && other.idPerfilAccion != null) || (this.idPerfilAccion != null && !this.idPerfilAccion.equals(other.idPerfilAccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Perfilaccion[ idPerfilAccion=" + idPerfilAccion + " ]";
    }
    
}
