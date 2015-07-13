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
import javax.validation.constraints.Size;

/**
 *
 * @author dacastanedah
 */
@Entity
@Table(name = "notas")
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n"),
    @NamedQuery(name = "Notas.findByIdActNotaEstudiante", query = "SELECT n FROM Notas n WHERE n.idActNotaEstudiante = :idActNotaEstudiante"),
    @NamedQuery(name = "Notas.findByNota", query = "SELECT n FROM Notas n WHERE n.nota = :nota"),
    @NamedQuery(name = "Notas.findByEstadoNota", query = "SELECT n FROM Notas n WHERE n.estadoNota = :estadoNota")})
public class Notas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idActNotaEstudiante")
    private String idActNotaEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota")
    private float nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoNota")
    private boolean estadoNota;
    @JoinColumn(name = "idActividadCalificada", referencedColumnName = "idActividadCalificada")
    @ManyToOne(optional = false)
    private Actividadacalificar idActividadCalificada;
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante")
    @ManyToOne(optional = false)
    private Estudiante idEstudiante;

    public Notas() {
    }

    public Notas(String idActNotaEstudiante) {
        this.idActNotaEstudiante = idActNotaEstudiante;
    }

    public Notas(String idActNotaEstudiante, float nota, boolean estadoNota) {
        this.idActNotaEstudiante = idActNotaEstudiante;
        this.nota = nota;
        this.estadoNota = estadoNota;
    }

    public String getIdActNotaEstudiante() {
        return idActNotaEstudiante;
    }

    public void setIdActNotaEstudiante(String idActNotaEstudiante) {
        this.idActNotaEstudiante = idActNotaEstudiante;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean getEstadoNota() {
        return estadoNota;
    }

    public void setEstadoNota(boolean estadoNota) {
        this.estadoNota = estadoNota;
    }

    public Actividadacalificar getIdActividadCalificada() {
        return idActividadCalificada;
    }

    public void setIdActividadCalificada(Actividadacalificar idActividadCalificada) {
        this.idActividadCalificada = idActividadCalificada;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActNotaEstudiante != null ? idActNotaEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idActNotaEstudiante == null && other.idActNotaEstudiante != null) || (this.idActNotaEstudiante != null && !this.idActNotaEstudiante.equals(other.idActNotaEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Notas[ idActNotaEstudiante=" + idActNotaEstudiante + " ]";
    }
    
}
