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
@Table(name = "inversion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inversion.findAll", query = "SELECT i FROM Inversion i")
    , @NamedQuery(name = "Inversion.findByIdInversion", query = "SELECT i FROM Inversion i WHERE i.idInversion = :idInversion")
    , @NamedQuery(name = "Inversion.findByCantidad", query = "SELECT i FROM Inversion i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "Inversion.findByMetodoPago", query = "SELECT i FROM Inversion i WHERE i.metodoPago = :metodoPago")
    , @NamedQuery(name = "Inversion.findByIdProyecto", query = "SELECT i FROM Inversion i WHERE i.idProyecto = :idProyecto")
    , @NamedQuery(name = "Inversion.findByFechaEmision", query = "SELECT i FROM Inversion i WHERE i.fechaEmision = :fechaEmision")})
public class Inversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInversion")
    private Integer idInversion;
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
    @Column(name = "idProyecto")
    private int idProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEmision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @JoinColumn(name = "idEvento", referencedColumnName = "idEvento")
    @ManyToOne(optional = false)
    private Evento idEvento;
    @JoinColumn(name = "IdUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Inversion() {
    }

    public Inversion(Integer idInversion) {
        this.idInversion = idInversion;
    }

    public Inversion(Integer idInversion, int cantidad, String metodoPago, int idProyecto, Date fechaEmision) {
        this.idInversion = idInversion;
        this.cantidad = cantidad;
        this.metodoPago = metodoPago;
        this.idProyecto = idProyecto;
        this.fechaEmision = fechaEmision;
    }

    public Integer getIdInversion() {
        return idInversion;
    }

    public void setIdInversion(Integer idInversion) {
        this.idInversion = idInversion;
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

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInversion != null ? idInversion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inversion)) {
            return false;
        }
        Inversion other = (Inversion) object;
        if ((this.idInversion == null && other.idInversion != null) || (this.idInversion != null && !this.idInversion.equals(other.idInversion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inversion[ idInversion=" + idInversion + " ]";
    }
    
}
