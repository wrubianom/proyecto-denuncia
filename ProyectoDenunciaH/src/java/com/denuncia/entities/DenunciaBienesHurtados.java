/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "denuncia_bienes_hurtados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DenunciaBienesHurtados.findAll", query = "SELECT d FROM DenunciaBienesHurtados d"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByIdDenunciaBienesHurtados", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.idDenunciaBienesHurtados = :idDenunciaBienesHurtados"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByAsegurado", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.asegurado = :asegurado"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByZona", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.zona = :zona"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByMarca", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.marca = :marca"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByLinea", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.linea = :linea"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByElementoEstatal", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.elementoEstatal = :elementoEstatal"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByCantidad", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByValorActual", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.valorActual = :valorActual"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByValorComercial", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.valorComercial = :valorComercial"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByIdDenuncia", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.idDenuncia.idDenuncia = :IntIdDenuncia"),
    @NamedQuery(name = "DenunciaBienesHurtados.findByDelitoInvolucrado", query = "SELECT d FROM DenunciaBienesHurtados d WHERE d.delitoInvolucrado = :delitoInvolucrado")})
public class DenunciaBienesHurtados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_denuncia_bienes_hurtados")
    private Integer idDenunciaBienesHurtados;
    @Column(name = "asegurado")
    private Boolean asegurado;
    @Size(max = 20)
    @Column(name = "zona")
    private String zona;
    @Size(max = 20)
    @Column(name = "marca")
    private String marca;
    @Size(max = 20)
    @Column(name = "linea")
    private String linea;
    @Column(name = "elemento_estatal")
    private Boolean elementoEstatal;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "valor_actual")
    private BigInteger valorActual;
    @Column(name = "valor_comercial")
    private BigInteger valorComercial;
    @Size(max = 50)
    @Column(name = "delito_involucrado")
    private String delitoInvolucrado;
    @JoinColumn(name = "id_tipo_novedad", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idTipoNovedad;
    @JoinColumn(name = "id_ciudad_autoridad", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idCiudadAutoridad;
    @JoinColumn(name = "id_autoridad", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idAutoridad;
    @JoinColumn(name = "id_destino", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idDestino;
    @JoinColumn(name = "id_institucion", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idInstitucion;
    @JoinColumn(name = "id_tipo_bien", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idTipoBien;
    @JoinColumn(name = "id_clase_bien", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idClaseBien;
    @JoinColumn(name = "id_denuncia", referencedColumnName = "id_denuncia")
    @ManyToOne
    private Denuncia idDenuncia;

    public DenunciaBienesHurtados() {
    }

    public DenunciaBienesHurtados(Integer idDenunciaBienesHurtados) {
        this.idDenunciaBienesHurtados = idDenunciaBienesHurtados;
    }

    public Integer getIdDenunciaBienesHurtados() {
        return idDenunciaBienesHurtados;
    }

    public void setIdDenunciaBienesHurtados(Integer idDenunciaBienesHurtados) {
        this.idDenunciaBienesHurtados = idDenunciaBienesHurtados;
    }

    public Boolean getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(Boolean asegurado) {
        this.asegurado = asegurado;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public Boolean getElementoEstatal() {
        return elementoEstatal;
    }

    public void setElementoEstatal(Boolean elementoEstatal) {
        this.elementoEstatal = elementoEstatal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getValorActual() {
        return valorActual;
    }

    public void setValorActual(BigInteger valorActual) {
        this.valorActual = valorActual;
    }

    public BigInteger getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(BigInteger valorComercial) {
        this.valorComercial = valorComercial;
    }

    public String getDelitoInvolucrado() {
        return delitoInvolucrado;
    }

    public void setDelitoInvolucrado(String delitoInvolucrado) {
        this.delitoInvolucrado = delitoInvolucrado;
    }

    public Parametro getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(Parametro idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
    }

    public Parametro getIdCiudadAutoridad() {
        return idCiudadAutoridad;
    }

    public void setIdCiudadAutoridad(Parametro idCiudadAutoridad) {
        this.idCiudadAutoridad = idCiudadAutoridad;
    }

    public Parametro getIdAutoridad() {
        return idAutoridad;
    }

    public void setIdAutoridad(Parametro idAutoridad) {
        this.idAutoridad = idAutoridad;
    }

    public Parametro getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Parametro idDestino) {
        this.idDestino = idDestino;
    }

    public Parametro getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Parametro idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Parametro getIdTipoBien() {
        return idTipoBien;
    }

    public void setIdTipoBien(Parametro idTipoBien) {
        this.idTipoBien = idTipoBien;
    }

    public Parametro getIdClaseBien() {
        return idClaseBien;
    }

    public void setIdClaseBien(Parametro idClaseBien) {
        this.idClaseBien = idClaseBien;
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
        hash += (idDenunciaBienesHurtados != null ? idDenunciaBienesHurtados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DenunciaBienesHurtados)) {
            return false;
        }
        DenunciaBienesHurtados other = (DenunciaBienesHurtados) object;
        if ((this.idDenunciaBienesHurtados == null && other.idDenunciaBienesHurtados != null) || (this.idDenunciaBienesHurtados != null && !this.idDenunciaBienesHurtados.equals(other.idDenunciaBienesHurtados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.denuncia.entities.DenunciaBienesHurtados[ idDenunciaBienesHurtados=" + idDenunciaBienesHurtados + " ]";
    }
    
}
