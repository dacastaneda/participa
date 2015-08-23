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
@Table(name = "periodolectivo")
@NamedQueries({
    @NamedQuery(name = "Periodolectivo.findAll", query = "SELECT p FROM Periodolectivo p"),
    @NamedQuery(name = "Periodolectivo.findAllAno", query = "SELECT p.ano FROM Periodolectivo p"),
    @NamedQuery(name = "Periodolectivo.findByIdPeriodoLectivo", query = "SELECT p FROM Periodolectivo p WHERE p.idPeriodoLectivo = :idPeriodoLectivo"),
    @NamedQuery(name = "Periodolectivo.findByAno", query = "SELECT p FROM Periodolectivo p WHERE p.ano = :ano"),
    @NamedQuery(name = "Periodolectivo.findByEstadoPeriodoLectivo", query = "SELECT p FROM Periodolectivo p WHERE p.estadoPeriodoLectivo = :estadoPeriodoLectivo")})
public class Periodolectivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "idPeriodoLectivo")
    private String idPeriodoLectivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano")
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoPeriodoLectivo")
    private boolean estadoPeriodoLectivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodoLectivo")
    private Collection<Periodocalificable> periodocalificableCollection;

    public Periodolectivo() {
    }

    public Periodolectivo(String idPeriodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
    }

    public Periodolectivo(String idPeriodoLectivo, String ano, boolean estadoPeriodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
        this.ano = ano;
        this.estadoPeriodoLectivo = estadoPeriodoLectivo;
    }

    public String getIdPeriodoLectivo() {
        return idPeriodoLectivo;
    }

    public void setIdPeriodoLectivo(String idPeriodoLectivo) {
        this.idPeriodoLectivo = idPeriodoLectivo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public boolean getEstadoPeriodoLectivo() {
        return estadoPeriodoLectivo;
    }

    public void setEstadoPeriodoLectivo(boolean estadoPeriodoLectivo) {
        this.estadoPeriodoLectivo = estadoPeriodoLectivo;
    }

    public Collection<Periodocalificable> getPeriodocalificableCollection() {
        return periodocalificableCollection;
    }

    public void setPeriodocalificableCollection(Collection<Periodocalificable> periodocalificableCollection) {
        this.periodocalificableCollection = periodocalificableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodoLectivo != null ? idPeriodoLectivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodolectivo)) {
            return false;
        }
        Periodolectivo other = (Periodolectivo) object;
        if ((this.idPeriodoLectivo == null && other.idPeriodoLectivo != null) || (this.idPeriodoLectivo != null && !this.idPeriodoLectivo.equals(other.idPeriodoLectivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPeriodoLectivo ;
    }
    
}
