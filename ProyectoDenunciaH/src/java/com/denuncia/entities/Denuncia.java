/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIlliam Rubiano
 */
@Entity
@Table(name = "denuncia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Denuncia.findAll", query = "SELECT d FROM Denuncia d"),
    @NamedQuery(name = "Denuncia.findByIdDenuncia", query = "SELECT d FROM Denuncia d WHERE d.idDenuncia = :idDenuncia"),
    @NamedQuery(name = "Denuncia.findByFechaDelito", query = "SELECT d FROM Denuncia d WHERE d.fechaDelito = :fechaDelito"),
    @NamedQuery(name = "Denuncia.findByOtroDelito", query = "SELECT d FROM Denuncia d WHERE d.otroDelito = :otroDelito")})
public class Denuncia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_denuncia")
    private Integer idDenuncia;
    @Column(name = "fecha_delito")
    @Temporal(TemporalType.DATE)
    private Date fechaDelito;
    @Size(max = 250)
    @Column(name = "otro_delito")
    private String otroDelito;
    @OneToMany(mappedBy = "idDenuncia")
    private List<DenunciaPersona> denunciaPersonaList;
    @OneToMany(mappedBy = "idDenuncia")
    private List<DenunciaDelito> denunciaDelitoList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "movil_agreado", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro movilAgreado;
    @JoinColumn(name = "arma_empleada", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro armaEmpleada;
    @JoinColumn(name = "modalidad", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro modalidad;
    @JoinColumn(name = "unidad_investigativa", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro unidadInvestigativa;
    @JoinColumn(name = "id_delito", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idDelito;
    @JoinColumn(name = "id_tipo_delito", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idTipoDelito;
    @JoinColumn(name = "movil_victima", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro movilVictima;
    @OneToMany(mappedBy = "idDenuncia")
    private List<DenunciaBienesHurtados> denunciaBienesHurtadosList;

    public Denuncia() {
    }

    public Denuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Integer getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Date getFechaDelito() {
        return fechaDelito;
    }

    public void setFechaDelito(Date fechaDelito) {
        this.fechaDelito = fechaDelito;
    }

    public String getOtroDelito() {
        return otroDelito;
    }

    public void setOtroDelito(String otroDelito) {
        this.otroDelito = otroDelito;
    }

    @XmlTransient
    public List<DenunciaPersona> getDenunciaPersonaList() {
        return denunciaPersonaList;
    }

    public void setDenunciaPersonaList(List<DenunciaPersona> denunciaPersonaList) {
        this.denunciaPersonaList = denunciaPersonaList;
    }

    @XmlTransient
    public List<DenunciaDelito> getDenunciaDelitoList() {
        return denunciaDelitoList;
    }

    public void setDenunciaDelitoList(List<DenunciaDelito> denunciaDelitoList) {
        this.denunciaDelitoList = denunciaDelitoList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Parametro getMovilAgreado() {
        return movilAgreado;
    }

    public void setMovilAgreado(Parametro movilAgreado) {
        this.movilAgreado = movilAgreado;
    }

    public Parametro getArmaEmpleada() {
        return armaEmpleada;
    }

    public void setArmaEmpleada(Parametro armaEmpleada) {
        this.armaEmpleada = armaEmpleada;
    }

    public Parametro getModalidad() {
        return modalidad;
    }

    public void setModalidad(Parametro modalidad) {
        this.modalidad = modalidad;
    }

    public Parametro getUnidadInvestigativa() {
        return unidadInvestigativa;
    }

    public void setUnidadInvestigativa(Parametro unidadInvestigativa) {
        this.unidadInvestigativa = unidadInvestigativa;
    }

    public Parametro getIdDelito() {
        return idDelito;
    }

    public void setIdDelito(Parametro idDelito) {
        this.idDelito = idDelito;
    }

    public Parametro getIdTipoDelito() {
        return idTipoDelito;
    }

    public void setIdTipoDelito(Parametro idTipoDelito) {
        this.idTipoDelito = idTipoDelito;
    }

    public Parametro getMovilVictima() {
        return movilVictima;
    }

    public void setMovilVictima(Parametro movilVictima) {
        this.movilVictima = movilVictima;
    }

    @XmlTransient
    public List<DenunciaBienesHurtados> getDenunciaBienesHurtadosList() {
        return denunciaBienesHurtadosList;
    }

    public void setDenunciaBienesHurtadosList(List<DenunciaBienesHurtados> denunciaBienesHurtadosList) {
        this.denunciaBienesHurtadosList = denunciaBienesHurtadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDenuncia != null ? idDenuncia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denuncia)) {
            return false;
        }
        Denuncia other = (Denuncia) object;
        if ((this.idDenuncia == null && other.idDenuncia != null) || (this.idDenuncia != null && !this.idDenuncia.equals(other.idDenuncia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.denuncia.entities.Denuncia[ idDenuncia=" + idDenuncia + " ]";
    }
    
}
