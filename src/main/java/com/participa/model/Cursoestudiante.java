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
@Table(name = "cursoestudiante")
@NamedQueries({
    @NamedQuery(name = "Cursoestudiante.findAll", query = "SELECT c FROM Cursoestudiante c"),
    @NamedQuery(name = "Cursoestudiante.findByIdGradoUsuario", query = "SELECT c FROM Cursoestudiante c WHERE c.idGradoUsuario = :idGradoUsuario"),
    @NamedQuery(name = "Cursoestudiante.findByEstadoCursoEstudiante", query = "SELECT c FROM Cursoestudiante c WHERE c.estadoCursoEstudiante = :estadoCursoEstudiante")})
public class Cursoestudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idGradoUsuario")
    private String idGradoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoCursoEstudiante")
    private boolean estadoCursoEstudiante;
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante")
    @ManyToOne(optional = false)
    private Estudiante idEstudiante;
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    @ManyToOne(optional = false)
    private Grado idGrado;

    public Cursoestudiante() {
    }

    public Cursoestudiante(String idGradoUsuario) {
        this.idGradoUsuario = idGradoUsuario;
    }

    public Cursoestudiante(String idGradoUsuario, boolean estadoCursoEstudiante) {
        this.idGradoUsuario = idGradoUsuario;
        this.estadoCursoEstudiante = estadoCursoEstudiante;
    }

    public String getIdGradoUsuario() {
        return idGradoUsuario;
    }

    public void setIdGradoUsuario(String idGradoUsuario) {
        this.idGradoUsuario = idGradoUsuario;
    }

    public boolean getEstadoCursoEstudiante() {
        return estadoCursoEstudiante;
    }

    public void setEstadoCursoEstudiante(boolean estadoCursoEstudiante) {
        this.estadoCursoEstudiante = estadoCursoEstudiante;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGradoUsuario != null ? idGradoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursoestudiante)) {
            return false;
        }
        Cursoestudiante other = (Cursoestudiante) object;
        if ((this.idGradoUsuario == null && other.idGradoUsuario != null) || (this.idGradoUsuario != null && !this.idGradoUsuario.equals(other.idGradoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Cursoestudiante[ idGradoUsuario=" + idGradoUsuario + " ]";
    }
    
}
