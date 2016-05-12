/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WIlliam Rubiano
 */
@Entity
@Table(name = "denuncia_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DenunciaPersona.findAll", query = "SELECT d FROM DenunciaPersona d"),
    @NamedQuery(name = "DenunciaPersona.findByIdDenunciaPersona", query = "SELECT d FROM DenunciaPersona d WHERE d.idDenunciaPersona = :idDenunciaPersona"),
    @NamedQuery(name = "DenunciaPersona.findByIdDenuncia", query = "SELECT d FROM DenunciaPersona d WHERE d.idDenuncia.idDenuncia = :intIdDenuncia"),
    @NamedQuery(name = "DenunciaPersona.findByAgresorIdentificado", query = "SELECT d FROM DenunciaPersona d WHERE d.agresorIdentificado = :agresorIdentificado"),
    @NamedQuery(name = "DenunciaPersona.findByObservaciones", query = "SELECT d FROM DenunciaPersona d WHERE d.observaciones = :observaciones")})
public class DenunciaPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_denuncia_persona")
    private Integer idDenunciaPersona;
    @Column(name = "agresor_identificado")
    private Boolean agresorIdentificado;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;
    @JoinColumn(name = "id_relaccion_agresor", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idRelaccionAgresor;
    @JoinColumn(name = "id_denuncia", referencedColumnName = "id_denuncia")
    @ManyToOne
    private Denuncia idDenuncia;

    public DenunciaPersona() {
    }

    public DenunciaPersona(Integer idDenunciaPersona) {
        this.idDenunciaPersona = idDenunciaPersona;
    }

    public Integer getIdDenunciaPersona() {
        return idDenunciaPersona;
    }

    public void setIdDenunciaPersona(Integer idDenunciaPersona) {
        this.idDenunciaPersona = idDenunciaPersona;
    }

    public Boolean getAgresorIdentificado() {
        return agresorIdentificado;
    }

    public void setAgresorIdentificado(Boolean agresorIdentificado) {
        this.agresorIdentificado = agresorIdentificado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Parametro getIdRelaccionAgresor() {
        return idRelaccionAgresor;
    }

    public void setIdRelaccionAgresor(Parametro idRelaccionAgresor) {
        this.idRelaccionAgresor = idRelaccionAgresor;
    }

    public Denuncia getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Denuncia idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDenunciaPersona != null ? idDenunciaPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DenunciaPersona)) {
            return false;
        }
        DenunciaPersona other = (DenunciaPersona) object;
        if ((this.idDenunciaPersona == null && other.idDenunciaPersona != null) || (this.idDenunciaPersona != null && !this.idDenunciaPersona.equals(other.idDenunciaPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.denuncia.entities.DenunciaPersona[ idDenunciaPersona=" + idDenunciaPersona + " ]";
    }
    
}
