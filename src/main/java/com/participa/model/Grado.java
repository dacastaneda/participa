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
@Table(name = "grado")
@NamedQueries({
    @NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g"),
    @NamedQuery(name = "Grado.findByIdGrado", query = "SELECT g FROM Grado g WHERE g.idGrado = :idGrado"),
    @NamedQuery(name = "Grado.findByNombreGrado", query = "SELECT g FROM Grado g WHERE g.nombreGrado = :nombreGrado"),
    @NamedQuery(name = "Grado.findByEstadoGrado", query = "SELECT g FROM Grado g WHERE g.estadoGrado = :estadoGrado")})
public class Grado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idGrado")
    private String idGrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreGrado")
    private String nombreGrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoGrado")
    private boolean estadoGrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrado")
    private Collection<Asignaturagrado> asignaturagradoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrado")
    private Collection<Cursoestudiante> cursoestudianteCollection;

    public Grado() {
    }

    public Grado(String idGrado) {
        this.idGrado = idGrado;
    }

    public Grado(String idGrado, String nombreGrado, boolean estadoGrado) {
        this.idGrado = idGrado;
        this.nombreGrado = nombreGrado;
        this.estadoGrado = estadoGrado;
    }

    public String getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(String idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public boolean getEstadoGrado() {
        return estadoGrado;
    }

    public void setEstadoGrado(boolean estadoGrado) {
        this.estadoGrado = estadoGrado;
    }

    public Collection<Asignaturagrado> getAsignaturagradoCollection() {
        return asignaturagradoCollection;
    }

    public void setAsignaturagradoCollection(Collection<Asignaturagrado> asignaturagradoCollection) {
        this.asignaturagradoCollection = asignaturagradoCollection;
    }

    public Collection<Cursoestudiante> getCursoestudianteCollection() {
        return cursoestudianteCollection;
    }

    public void setCursoestudianteCollection(Collection<Cursoestudiante> cursoestudianteCollection) {
        this.cursoestudianteCollection = cursoestudianteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrado != null ? idGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grado)) {
            return false;
        }
        Grado other = (Grado) object;
        if ((this.idGrado == null && other.idGrado != null) || (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Grado[ idGrado=" + idGrado + " ]";
    }
    
}
