/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dacastanedah
 */
@Entity
@Table(name = "actividadacalificar")
@NamedQueries({
    @NamedQuery(name = "Actividadacalificar.findAll", query = "SELECT a FROM Actividadacalificar a"),
    @NamedQuery(name = "Actividadacalificar.findByIdActividadCalificada", query = "SELECT a FROM Actividadacalificar a WHERE a.idActividadCalificada = :idActividadCalificada"),
    @NamedQuery(name = "Actividadacalificar.findByTipo", query = "SELECT a FROM Actividadacalificar a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Actividadacalificar.findByFechaInicial", query = "SELECT a FROM Actividadacalificar a WHERE a.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Actividadacalificar.findByFechaFinal", query = "SELECT a FROM Actividadacalificar a WHERE a.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Actividadacalificar.findByEstadoActividadACalificar", query = "SELECT a FROM Actividadacalificar a WHERE a.estadoActividadACalificar = :estadoActividadACalificar")})
public class Actividadacalificar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idActividadCalificada")
    private String idActividadCalificada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFinal")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoActividadACalificar")
    private boolean estadoActividadACalificar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadCalificada")
    private Collection<Notas> notasCollection;
    @JoinColumn(name = "idLogro", referencedColumnName = "idLogro")
    @ManyToOne(optional = false)
    private Logro idLogro;

    public Actividadacalificar() {
    }

    public Actividadacalificar(String idActividadCalificada) {
        this.idActividadCalificada = idActividadCalificada;
    }

    public Actividadacalificar(String idActividadCalificada, String tipo, Date fechaInicial, Date fechaFinal, boolean estadoActividadACalificar) {
        this.idActividadCalificada = idActividadCalificada;
        this.tipo = tipo;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.estadoActividadACalificar = estadoActividadACalificar;
    }

    public String getIdActividadCalificada() {
        return idActividadCalificada;
    }

    public void setIdActividadCalificada(String idActividadCalificada) {
        this.idActividadCalificada = idActividadCalificada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean getEstadoActividadACalificar() {
        return estadoActividadACalificar;
    }

    public void setEstadoActividadACalificar(boolean estadoActividadACalificar) {
        this.estadoActividadACalificar = estadoActividadACalificar;
    }

    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
    }

    public Logro getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(Logro idLogro) {
        this.idLogro = idLogro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividadCalificada != null ? idActividadCalificada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividadacalificar)) {
            return false;
        }
        Actividadacalificar other = (Actividadacalificar) object;
        if ((this.idActividadCalificada == null && other.idActividadCalificada != null) || (this.idActividadCalificada != null && !this.idActividadCalificada.equals(other.idActividadCalificada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Actividadacalificar[ idActividadCalificada=" + idActividadCalificada + " ]";
    }
    
}
