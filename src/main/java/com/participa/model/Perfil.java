/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dacastanedah
 */
@Entity
@Table(name = "perfil")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByIdPerfil", query = "SELECT p FROM Perfil p WHERE p.idPerfil = :idPerfil"),
    @NamedQuery(name = "Perfil.findByNombrePerfil", query = "SELECT p FROM Perfil p WHERE p.nombrePerfil = :nombrePerfil"),
    @NamedQuery(name = "Perfil.findByDescripcionPerfil", query = "SELECT p FROM Perfil p WHERE p.descripcionPerfil = :descripcionPerfil"),
    @NamedQuery(name = "Perfil.findByEstadoPerfil", query = "SELECT p FROM Perfil p WHERE p.estadoPerfil = :estadoPerfil")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPerfil")
    private Integer idPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrePerfil")
    private String nombrePerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcionPerfil")
    private String descripcionPerfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoPerfil")
    private boolean estadoPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<Perfilusuario> perfilusuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private Collection<Perfilaccion> perfilaccionCollection;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(Integer idPerfil, String nombrePerfil, String descripcionPerfil, boolean estadoPerfil) {
        this.idPerfil = idPerfil;
        this.nombrePerfil = nombrePerfil;
        this.descripcionPerfil = descripcionPerfil;
        this.estadoPerfil = estadoPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    public boolean getEstadoPerfil() {
        return estadoPerfil;
    }

    public void setEstadoPerfil(boolean estadoPerfil) {
        this.estadoPerfil = estadoPerfil;
    }

    public Collection<Perfilusuario> getPerfilusuarioCollection() {
        return perfilusuarioCollection;
    }

    public void setPerfilusuarioCollection(Collection<Perfilusuario> perfilusuarioCollection) {
        this.perfilusuarioCollection = perfilusuarioCollection;
    }

    public Collection<Perfilaccion> getPerfilaccionCollection() {
        return perfilaccionCollection;
    }

    public void setPerfilaccionCollection(Collection<Perfilaccion> perfilaccionCollection) {
        this.perfilaccionCollection = perfilaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
