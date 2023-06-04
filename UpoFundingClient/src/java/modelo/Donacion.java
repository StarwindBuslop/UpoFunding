/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author frank
 */
@Entity
@Table(name = "donacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donacion.findAll", query = "SELECT d FROM Donacion d")
    , @NamedQuery(name = "Donacion.findByIdDonacion", query = "SELECT d FROM Donacion d WHERE d.idDonacion = :idDonacion")
    , @NamedQuery(name = "Donacion.findByCantidad", query = "SELECT d FROM Donacion d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Donacion.findByMetodoPago", query = "SELECT d FROM Donacion d WHERE d.metodoPago = :metodoPago")
    , @NamedQuery(name = "Donacion.findByFechaEmision", query = "SELECT d FROM Donacion d WHERE d.fechaEmision = :fechaEmision")})
public class Donacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDonacion")
    private Integer idDonacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "metodoPago")
    private String metodoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEmision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "idONG", referencedColumnName = "idONG")
    @ManyToOne(optional = false)
    private Solidaria idONG;
    @JoinColumn(name = "idProyecto", referencedColumnName = "idProyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public Donacion() {
    }

    public Donacion(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Donacion(Integer idDonacion, int cantidad, String metodoPago, Date fechaEmision) {
        this.idDonacion = idDonacion;
        this.cantidad = cantidad;
        this.metodoPago = metodoPago;
        this.fechaEmision = fechaEmision;
    }

    public Integer getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(Integer idDonacion) {
        this.idDonacion = idDonacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Solidaria getIdONG() {
        return idONG;
    }

    public void setIdONG(Solidaria idONG) {
        this.idONG = idONG;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDonacion != null ? idDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donacion)) {
            return false;
        }
        Donacion other = (Donacion) object;
        if ((this.idDonacion == null && other.idDonacion != null) || (this.idDonacion != null && !this.idDonacion.equals(other.idDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Donacion[ idDonacion=" + idDonacion + " ]";
    }
    
}
