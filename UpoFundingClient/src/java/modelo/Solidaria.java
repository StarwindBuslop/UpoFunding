/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author frank
 */
@Entity
@Table(name = "solidaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solidaria.findAll", query = "SELECT s FROM Solidaria s")
    , @NamedQuery(name = "Solidaria.findByIdONG", query = "SELECT s FROM Solidaria s WHERE s.idONG = :idONG")
    , @NamedQuery(name = "Solidaria.findByNombre", query = "SELECT s FROM Solidaria s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Solidaria.findByPais", query = "SELECT s FROM Solidaria s WHERE s.pais = :pais")
    , @NamedQuery(name = "Solidaria.findByLocalidad", query = "SELECT s FROM Solidaria s WHERE s.localidad = :localidad")
    , @NamedQuery(name = "Solidaria.findByProvincia", query = "SELECT s FROM Solidaria s WHERE s.provincia = :provincia")
    , @NamedQuery(name = "Solidaria.findByDescripcion", query = "SELECT s FROM Solidaria s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Solidaria.findByDireccion", query = "SELECT s FROM Solidaria s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Solidaria.findByIdProyecto", query = "SELECT s FROM Solidaria s WHERE s.idProyecto = :idProyecto")})
public class Solidaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idONG")
    private Integer idONG;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "idProyecto")
    private String idProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idONG")
    private Collection<Donacion> donacionCollection;

    public Solidaria() {
    }

    public Solidaria(Integer idONG) {
        this.idONG = idONG;
    }

    public Solidaria(Integer idONG, String nombre, String pais, String localidad, String provincia, String descripcion, String direccion, String idProyecto) {
        this.idONG = idONG;
        this.nombre = nombre;
        this.pais = pais;
        this.localidad = localidad;
        this.provincia = provincia;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.idProyecto = idProyecto;
    }

    public Integer getIdONG() {
        return idONG;
    }

    public void setIdONG(Integer idONG) {
        this.idONG = idONG;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    @XmlTransient
    public Collection<Donacion> getDonacionCollection() {
        return donacionCollection;
    }

    public void setDonacionCollection(Collection<Donacion> donacionCollection) {
        this.donacionCollection = donacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idONG != null ? idONG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solidaria)) {
            return false;
        }
        Solidaria other = (Solidaria) object;
        if ((this.idONG == null && other.idONG != null) || (this.idONG != null && !this.idONG.equals(other.idONG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Solidaria[ idONG=" + idONG + " ]";
    }
    
}
