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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "logro")
@NamedQueries({
    @NamedQuery(name = "Logro.findAll", query = "SELECT l FROM Logro l"),
    @NamedQuery(name = "Logro.findByIdLogro", query = "SELECT l FROM Logro l WHERE l.idLogro = :idLogro"),
    @NamedQuery(name = "Logro.findByNombreLogro", query = "SELECT l FROM Logro l WHERE l.nombreLogro = :nombreLogro"),
    @NamedQuery(name = "Logro.findByEstadoLogro", query = "SELECT l FROM Logro l WHERE l.estadoLogro = :estadoLogro")})
public class Logro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idLogro")
    private String idLogro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombreLogro")
    private String nombreLogro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoLogro")
    private boolean estadoLogro;
    @JoinColumn(name = "idComponente", referencedColumnName = "idComponente")
    @ManyToOne(optional = false)
    private Componente idComponente;
    @JoinColumn(name = "dPeriodoCalificable", referencedColumnName = "idPeriodoCalificable")
    @ManyToOne(optional = false)
    private Periodocalificable dPeriodoCalificable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLogro")
    private Collection<Actividadacalificar> actividadacalificarCollection;

    public Logro() {
    }

    public Logro(String idLogro) {
        this.idLogro = idLogro;
    }

    public Logro(String idLogro, String nombreLogro, boolean estadoLogro) {
        this.idLogro = idLogro;
        this.nombreLogro = nombreLogro;
        this.estadoLogro = estadoLogro;
    }

    public String getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(String idLogro) {
        this.idLogro = idLogro;
    }

    public String getNombreLogro() {
        return nombreLogro;
    }

    public void setNombreLogro(String nombreLogro) {
        this.nombreLogro = nombreLogro;
    }

    public boolean getEstadoLogro() {
        return estadoLogro;
    }

    public void setEstadoLogro(boolean estadoLogro) {
        this.estadoLogro = estadoLogro;
    }

    public Componente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componente idComponente) {
        this.idComponente = idComponente;
    }

    public Periodocalificable getDPeriodoCalificable() {
        return dPeriodoCalificable;
    }

    public void setDPeriodoCalificable(Periodocalificable dPeriodoCalificable) {
        this.dPeriodoCalificable = dPeriodoCalificable;
    }

    public Collection<Actividadacalificar> getActividadacalificarCollection() {
        return actividadacalificarCollection;
    }

    public void setActividadacalificarCollection(Collection<Actividadacalificar> actividadacalificarCollection) {
        this.actividadacalificarCollection = actividadacalificarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogro != null ? idLogro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logro)) {
            return false;
        }
        Logro other = (Logro) object;
        if ((this.idLogro == null && other.idLogro != null) || (this.idLogro != null && !this.idLogro.equals(other.idLogro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Logro[ idLogro=" + idLogro + " ]";
    }
    
}
