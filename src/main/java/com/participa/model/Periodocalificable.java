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
@Table(name = "periodocalificable")
@NamedQueries({
    @NamedQuery(name = "Periodocalificable.findAll", query = "SELECT p FROM Periodocalificable p"),
    @NamedQuery(name = "Periodocalificable.findByIdPeriodoCalificable", query = "SELECT p FROM Periodocalificable p WHERE p.idPeriodoCalificable = :idPeriodoCalificable"),
    @NamedQuery(name = "Periodocalificable.findByNombrePeriodoCalificable", query = "SELECT p FROM Periodocalificable p WHERE p.nombrePeriodoCalificable = :nombrePeriodoCalificable"),
    @NamedQuery(name = "Periodocalificable.findByEstadoPeriodoCalificable", query = "SELECT p FROM Periodocalificable p WHERE p.estadoPeriodoCalificable = :estadoPeriodoCalificable")})
public class Periodocalificable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idPeriodoCalificable")
    private String idPeriodoCalificable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrePeriodoCalificable")
    private String nombrePeriodoCalificable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoPeriodoCalificable")
    private boolean estadoPeriodoCalificable;
    @JoinColumn(name = "idPeriodoLectivo", referencedColumnName = "idPeriodoLectivo")
    @ManyToOne(optional = false)
    private Periodolectivo idPeriodoLectivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dPeriodoCalificable")
    private Collection<Logro> logroCollection;

    public Periodocalificable() {
    }

    public Periodocalificable(String idPeriodoCalificable) {
        this.idPeriodoCalificable = idPeriodoCalificable;
    }

    public Periodocalificable(String idPeriodoCalificable, String nombrePeriodoCalificable, boolean estadoPeriodoCalificable) {
        this.idPeriodoCalificable = idPeriodoCalificable;
        this.nombrePeriodoCalificable = nombrePeriodoCalificable;
        this.estadoPeriodoCalificable = estadoPeriodoCalificable;
    }

    public String getIdPeriodoCalificable() {
        return idPeriodoCalificable;
    }

    public void setIdPeriodoCalificable(String idPeriodoCalificable) {
        this.idPeriodoCalificable = idPeriodoCalificable;
    }

    public String getNombrePeriodoCalificable() {
        return nombrePeriodoCalificable;
    }

    public void setNombrePeriodoCalificable(String nombrePeriodoCalificable) {
        this.nombrePeriodoCalificable = nombrePeriodoCalificable;
    }

    public boolean getEstadoPeriodoCalificable() {
        return estadoPeriodoCalificable;
    }

    public void setEstadoPeriodoCalificable(boolean estadoPeriodoCalificable) {
        this.estadoPeriodoCalificable = estadoPeriodoCalificable;
    }

    public Periodolectivo getIdPeriodoLectivo() {
        return idPeriodoLectivo;
    }

    public void setIdPeriodoLectivo(Periodolectivo idPeriodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
    }

    public Collection<Logro> getLogroCollection() {
        return logroCollection;
    }

    public void setLogroCollection(Collection<Logro> logroCollection) {
        this.logroCollection = logroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodoCalificable != null ? idPeriodoCalificable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodocalificable)) {
            return false;
        }
        Periodocalificable other = (Periodocalificable) object;
        if ((this.idPeriodoCalificable == null && other.idPeriodoCalificable != null) || (this.idPeriodoCalificable != null && !this.idPeriodoCalificable.equals(other.idPeriodoCalificable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Periodocalificable[ idPeriodoCalificable=" + idPeriodoCalificable + " ]";
    }
    
}
