/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "menunivel3")
@NamedQueries({
    @NamedQuery(name = "Menunivel3.findAll", query = "SELECT m FROM Menunivel3 m"),
    @NamedQuery(name = "Menunivel3.findByIdMenuNivel3", query = "SELECT m FROM Menunivel3 m WHERE m.idMenuNivel3 = :idMenuNivel3"),
    @NamedQuery(name = "Menunivel3.findByNombreMenuNivel3", query = "SELECT m FROM Menunivel3 m WHERE m.nombreMenuNivel3 = :nombreMenuNivel3"),
    @NamedQuery(name = "Menunivel3.findByDescripcion", query = "SELECT m FROM Menunivel3 m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Menunivel3.findByUrl", query = "SELECT m FROM Menunivel3 m WHERE m.url = :url"),
    @NamedQuery(name = "Menunivel3.findByEstadoMenuNivel3", query = "SELECT m FROM Menunivel3 m WHERE m.estadoMenuNivel3 = :estadoMenuNivel3"),
    @NamedQuery(name = "Menunivel3.findByRol", query = "SELECT m FROM Menunivel3 m WHERE m.rol = :rol"),
    @NamedQuery(name = "Menunivel3.findByTipo", query = "SELECT m FROM Menunivel3 m WHERE m.tipo = :tipo")})
public class Menunivel3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMenuNivel3")
    private Integer idMenuNivel3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreMenuNivel3")
    private String nombreMenuNivel3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoMenuNivel3")
    private boolean estadoMenuNivel3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "submenu")
    private Collection<Menunivel3> menunivel3Collection;
    @JoinColumn(name = "submenu", referencedColumnName = "idMenuNivel3")
    @ManyToOne
    private Menunivel3 submenu;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public Menunivel3() {
    }

    public Menunivel3(Integer idMenuNivel3) {
        this.idMenuNivel3 = idMenuNivel3;
    }

    public Menunivel3(Integer idMenuNivel3, String nombreMenuNivel3, String descripcion, String url, boolean estadoMenuNivel3, String rol, String tipo) {
        this.idMenuNivel3 = idMenuNivel3;
        this.nombreMenuNivel3 = nombreMenuNivel3;
        this.descripcion = descripcion;
        this.url = url;
        this.estadoMenuNivel3 = estadoMenuNivel3;
        this.rol = rol;
        this.tipo = tipo;
    }

    public Integer getIdMenuNivel3() {
        return idMenuNivel3;
    }

    public void setIdMenuNivel3(Integer idMenuNivel3) {
        this.idMenuNivel3 = idMenuNivel3;
    }

    public String getNombreMenuNivel3() {
        return nombreMenuNivel3;
    }

    public void setNombreMenuNivel3(String nombreMenuNivel3) {
        this.nombreMenuNivel3 = nombreMenuNivel3;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getEstadoMenuNivel3() {
        return estadoMenuNivel3;
    }

    public void setEstadoMenuNivel3(boolean estadoMenuNivel3) {
        this.estadoMenuNivel3 = estadoMenuNivel3;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Collection<Menunivel3> getMenunivel3Collection() {
        return menunivel3Collection;
    }

    public void setMenunivel3Collection(Collection<Menunivel3> menunivel3Collection) {
        this.menunivel3Collection = menunivel3Collection;
    }

    public Menunivel3 getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Menunivel3 submenu) {
        this.submenu = submenu;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenuNivel3 != null ? idMenuNivel3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menunivel3)) {
            return false;
        }
        Menunivel3 other = (Menunivel3) object;
        if ((this.idMenuNivel3 == null && other.idMenuNivel3 != null) || (this.idMenuNivel3 != null && !this.idMenuNivel3.equals(other.idMenuNivel3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.participa.model.Menunivel3[ idMenuNivel3=" + idMenuNivel3 + " ]";
    }
    
}
