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
@Table(name = "asignaturagrado")
@NamedQueries({
    @NamedQuery(name = "Asignaturagrado.findAll", query = "SELECT a FROM Asignaturagrado a"),
    @NamedQuery(name = "Asignaturagrado.findByIdAsignaturaGrado", query = "SELECT a FROM Asignaturagrado a WHERE a.idAsignaturaGrado = :idAsignaturaGrado"),
    @NamedQuery(name = "Asignaturagrado.findByEstadoAsignaturaGrado", query = "SELECT a FROM Asignaturagrado a WHERE a.estadoAsignaturaGrado = :estadoAsignaturaGrado")})
public class Asignaturagrado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idAsignaturaGrado")
    private String idAsignaturaGrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoAsignaturaGrado")
    private boolean estadoAsignaturaGrado;
    @JoinColumn(name = "idAsignatura", referencedColumnName = "idAsignatura")
    @ManyToOne(optional = false)
    private Asignatura idAsignatura;
    @JoinColumn(name = "idDocente", referencedColumnName = "idDocente")
    @ManyToOne(optional = false)
    private Docente idDocente;
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    @ManyToOne(optional = false)
    private Grado idGrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsignaturaGrado")
    private Collection<Componente> componenteCollection;

    public Asignaturagrado() {
    }

    public Asignaturagrado(String idAsignaturaGrado) {
        this.idAsignaturaGrado = idAsignaturaGrado;
    }

    public Asignaturagrado(String idAsignaturaGrado, boolean estadoAsignaturaGrado) {
        this.idAsignaturaGrado = idAsignaturaGrado;
        this.estadoAsignaturaGrado = estadoAsignaturaGrado;
    }

    public String getIdAsignaturaGrado() {
        return idAsignaturaGrado;
    }

    public void setIdAsignaturaGrado(String idAsignaturaGrado) {
        this.idAsignaturaGrado = idAsignaturaGrado;
    }

    public boolean getEstadoAsignaturaGrado() {
        return estadoAsignaturaGrado;
    }

    public void setEstadoAsignaturaGrado(boolean estadoAsignaturaGrado) {
        this.estadoAsignaturaGrado = estadoAsignaturaGrado;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Docente getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Docente idDocente) {
        this.idDocente = idDocente;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    public Collection<Componente> getComponenteCollection() {
        return componenteCollection;
    }

    public void setComponenteCollection(Collection<Componente> componenteCollection) {
        this.componenteCollection = componenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignaturaGrado != null ? idAsignaturaGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturagrado)) {
            return false;
        }
        Asignaturagrado other = (Asignaturagrado) object;
        if ((this.idAsignaturaGrado == null && other.idAsignaturaGrado != null) || (this.idAsignaturaGrado != null && !this.idAsignaturaGrado.equals(other.idAsignaturaGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Asignaturagrado[ idAsignaturaGrado=" + idAsignaturaGrado + " ]";
    }
    
}
