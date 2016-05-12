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
@Table(name = "denuncia_delito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DenunciaDelito.findAll", query = "SELECT d FROM DenunciaDelito d"),
    @NamedQuery(name = "DenunciaDelito.findByIdDenunciaDelito", query = "SELECT d FROM DenunciaDelito d WHERE d.idDenunciaDelito = :idDenunciaDelito"),
    @NamedQuery(name = "DenunciaDelito.findByLatitud", query = "SELECT d FROM DenunciaDelito d WHERE d.latitud = :latitud"),
    @NamedQuery(name = "DenunciaDelito.findByLongitud", query = "SELECT d FROM DenunciaDelito d WHERE d.longitud = :longitud"),
    @NamedQuery(name = "DenunciaDelito.findByClaseSitio", query = "SELECT d FROM DenunciaDelito d WHERE d.claseSitio = :claseSitio"),
    @NamedQuery(name = "DenunciaDelito.findByZona", query = "SELECT d FROM DenunciaDelito d WHERE d.zona = :zona"),
    @NamedQuery(name = "DenunciaDelito.findByTipoDireccion", query = "SELECT d FROM DenunciaDelito d WHERE d.tipoDireccion = :tipoDireccion"),
    @NamedQuery(name = "DenunciaDelito.findByCom1", query = "SELECT d FROM DenunciaDelito d WHERE d.com1 = :com1"),
    @NamedQuery(name = "DenunciaDelito.findByLetra1", query = "SELECT d FROM DenunciaDelito d WHERE d.letra1 = :letra1"),
    @NamedQuery(name = "DenunciaDelito.findByTipoDireccion2", query = "SELECT d FROM DenunciaDelito d WHERE d.tipoDireccion2 = :tipoDireccion2"),
    @NamedQuery(name = "DenunciaDelito.findByCom2", query = "SELECT d FROM DenunciaDelito d WHERE d.com2 = :com2"),
    @NamedQuery(name = "DenunciaDelito.findByLetra2", query = "SELECT d FROM DenunciaDelito d WHERE d.letra2 = :letra2"),
    @NamedQuery(name = "DenunciaDelito.findByIdDenuncia", query = "SELECT d FROM DenunciaDelito d WHERE d.idDenuncia.idDenuncia = :ingDenuncia"),
    @NamedQuery(name = "DenunciaDelito.findByPuntoCardenal", query = "SELECT d FROM DenunciaDelito d WHERE d.puntoCardenal = :puntoCardenal")})
public class DenunciaDelito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_denuncia_delito")
    private Integer idDenunciaDelito;
    @Column(name = "latitud")
    private BigInteger latitud;
    @Column(name = "longitud")
    private BigInteger longitud;
    @Size(max = 20)
    @Column(name = "clase_sitio")
    private String claseSitio;
    @Size(max = 20)
    @Column(name = "zona")
    private String zona;
    @Size(max = 20)
    @Column(name = "tipo_direccion")
    private String tipoDireccion;
    @Size(max = 20)
    @Column(name = "com1")
    private String com1;
    @Size(max = 20)
    @Column(name = "letra1")
    private String letra1;
    @Size(max = 20)
    @Column(name = "tipo_direccion2")
    private String tipoDireccion2;
    @Size(max = 20)
    @Column(name = "com2")
    private String com2;
    @Size(max = 20)
    @Column(name = "letra2")
    private String letra2;
    @Size(max = 20)
    @Column(name = "punto_cardenal")
    private String puntoCardenal;
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idBarrio;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idMunicipio;
    @JoinColumn(name = "id_denuncia", referencedColumnName = "id_denuncia")
    @ManyToOne
    private Denuncia idDenuncia;

    public DenunciaDelito() {
    }

    public DenunciaDelito(Integer idDenunciaDelito) {
        this.idDenunciaDelito = idDenunciaDelito;
    }

    public Integer getIdDenunciaDelito() {
        return idDenunciaDelito;
    }

    public void setIdDenunciaDelito(Integer idDenunciaDelito) {
        this.idDenunciaDelito = idDenunciaDelito;
    }

    public BigInteger getLatitud() {
        return latitud;
    }

    public void setLatitud(BigInteger latitud) {
        this.latitud = latitud;
    }

    public BigInteger getLongitud() {
        return longitud;
    }

    public void setLongitud(BigInteger longitud) {
        this.longitud = longitud;
    }

    public String getClaseSitio() {
        return claseSitio;
    }

    public void setClaseSitio(String claseSitio) {
        this.claseSitio = claseSitio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    public String getCom1() {
        return com1;
    }

    public void setCom1(String com1) {
        this.com1 = com1;
    }

    public String getLetra1() {
        return letra1;
    }

    public void setLetra1(String letra1) {
        this.letra1 = letra1;
    }

    public String getTipoDireccion2() {
        return tipoDireccion2;
    }

    public void setTipoDireccion2(String tipoDireccion2) {
        this.tipoDireccion2 = tipoDireccion2;
    }

    public String getCom2() {
        return com2;
    }

    public void setCom2(String com2) {
        this.com2 = com2;
    }

    public String getLetra2() {
        return letra2;
    }

    public void setLetra2(String letra2) {
        this.letra2 = letra2;
    }

    public String getPuntoCardenal() {
        return puntoCardenal;
    }

    public void setPuntoCardenal(String puntoCardenal) {
        this.puntoCardenal = puntoCardenal;
    }

    public Parametro getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Parametro idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Parametro getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Parametro idMunicipio) {
        this.idMunicipio = idMunicipio;
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
        hash += (idDenunciaDelito != null ? idDenunciaDelito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DenunciaDelito)) {
            return false;
        }
        DenunciaDelito other = (DenunciaDelito) object;
        if ((this.idDenunciaDelito == null && other.idDenunciaDelito != null) || (this.idDenunciaDelito != null && !this.idDenunciaDelito.equals(other.idDenunciaDelito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.denuncia.entities.DenunciaDelito[ idDenunciaDelito=" + idDenunciaDelito + " ]";
    }
    
}
