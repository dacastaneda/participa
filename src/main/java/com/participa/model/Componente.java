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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dacastanedah
 */
@Entity
@Table(name = "componente")
@NamedStoredProcedureQuery(name = "consultarComponente", procedureName = "consultarComponente",parameters = { 
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "idGrado",type = String.class), 
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "idAsignatura",type = String.class) })
@NamedQueries({
    @NamedQuery(name = "Componente.findAll", query = "SELECT c FROM Componente c"),
    @NamedQuery(name = "Componente.findByIdComponente", query = "SELECT c FROM Componente c WHERE c.idComponente = :idComponente"),
    @NamedQuery(name = "Componente.findByPreguntaProblematizadora", query = "SELECT c FROM Componente c WHERE c.preguntaProblematizadora = :preguntaProblematizadora"),
    @NamedQuery(name = "Componente.findByEstadoComponente", query = "SELECT c FROM Componente c WHERE c.estadoComponente = :estadoComponente")})
public class Componente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idComponente")
    private String idComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "preguntaProblematizadora")
    private String preguntaProblematizadora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoComponente")
    private boolean estadoComponente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponente")
    private Collection<Logro> logroCollection;
    @JoinColumn(name = "idAsignaturaGrado", referencedColumnName = "idAsignaturaGrado")
    @ManyToOne(optional = false)
    private Asignaturagrado idAsignaturaGrado;

    public Componente() {
    }

    public Componente(String idComponente) {
        this.idComponente = idComponente;
    }

    public Componente(String idComponente, String preguntaProblematizadora, boolean estadoComponente) {
        this.idComponente = idComponente;
        this.preguntaProblematizadora = preguntaProblematizadora;
        this.estadoComponente = estadoComponente;
    }

    public String getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(String idComponente) {
        this.idComponente = idComponente;
    }

    public String getPreguntaProblematizadora() {
        return preguntaProblematizadora;
    }

    public void setPreguntaProblematizadora(String preguntaProblematizadora) {
        this.preguntaProblematizadora = preguntaProblematizadora;
    }

    public boolean getEstadoComponente() {
        return estadoComponente;
    }

    public void setEstadoComponente(boolean estadoComponente) {
        this.estadoComponente = estadoComponente;
    }

    public Collection<Logro> getLogroCollection() {
        return logroCollection;
    }

    public void setLogroCollection(Collection<Logro> logroCollection) {
        this.logroCollection = logroCollection;
    }

    public Asignaturagrado getIdAsignaturaGrado() {
        return idAsignaturaGrado;
    }

    public void setIdAsignaturaGrado(Asignaturagrado idAsignaturaGrado) {
        this.idAsignaturaGrado = idAsignaturaGrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponente != null ? idComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componente)) {
            return false;
        }
        Componente other = (Componente) object;
        if ((this.idComponente == null && other.idComponente != null) || (this.idComponente != null && !this.idComponente.equals(other.idComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idComponente ;
    }
    
}
