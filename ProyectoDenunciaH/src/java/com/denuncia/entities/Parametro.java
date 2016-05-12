/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WIlliam Rubiano
 */
@Entity
@Table(name = "parametro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p"),
    @NamedQuery(name = "Parametro.findByIdParametro", query = "SELECT p FROM Parametro p WHERE p.idParametro = :idParametro"),
    @NamedQuery(name = "Parametro.findByCodigoParametro", query = "SELECT p FROM Parametro p WHERE p.codigoParametro = :codigoParametro"),
    @NamedQuery(name = "Parametro.findByTipoParametro", query = "SELECT p FROM Parametro p WHERE p.tipoParametro = :tipoParametro"),
    @NamedQuery(name = "Parametro.findByNombreParametro", query = "SELECT p FROM Parametro p WHERE p.nombreParametro = :nombreParametro")})
public class Parametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametro")
    private Integer idParametro;
    @Size(max = 20)
    @Column(name = "codigo_parametro")
    private String codigoParametro;
    @Size(max = 20)
    @Column(name = "tipo_parametro")
    private String tipoParametro;
    @Size(max = 230)
    @Column(name = "nombre_parametro")
    private String nombreParametro;
    @OneToMany(mappedBy = "idRelaccionAgresor")
    private List<DenunciaPersona> denunciaPersonaList;
    @OneToMany(mappedBy = "idBarrio")
    private List<DenunciaDelito> denunciaDelitoList;
    @OneToMany(mappedBy = "idMunicipio")
    private List<DenunciaDelito> denunciaDelitoList1;
    @OneToMany(mappedBy = "lugarNacimiento")
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "sexo")
    private List<Usuario> usuarioList1;
    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<Usuario> usuarioList2;
    @OneToMany(mappedBy = "movilAgreado")
    private List<Denuncia> denunciaList;
    @OneToMany(mappedBy = "armaEmpleada")
    private List<Denuncia> denunciaList1;
    @OneToMany(mappedBy = "modalidad")
    private List<Denuncia> denunciaList2;
    @OneToMany(mappedBy = "unidadInvestigativa")
    private List<Denuncia> denunciaList3;
    @OneToMany(mappedBy = "idDelito")
    private List<Denuncia> denunciaList4;
    @OneToMany(mappedBy = "idTipoDelito")
    private List<Denuncia> denunciaList5;
    @OneToMany(mappedBy = "movilVictima")
    private List<Denuncia> denunciaList6;
    @OneToMany(mappedBy = "idTipoNovedad")
    private List<DenunciaBienesHurtados> denunciaBienesHurtadosList;
    @OneToMany(mappedBy = "idCiudadAutoridad")
    private List<DenunciaBienesHurtados> denunciaBienesHurtadosList1;
    @OneToMany(mappedBy = "idAutoridad")
    private List<DenunciaBienesHurtados> denunciaBienesHurtadosList2;
    @OneToMany(mappedBy = "idDestino")
    private List<DenunciaBienesHurtados> denunciaBienesHurtadosList3;
    @OneToMany(mappedBy = "idInstitucion")
    private List<DenunciaBienesHurtados> denunciaBienesHurtadosList4;
    @OneToMany(mappedBy = "idTipoBien")
    private List<DenunciaBienesHurtados> denunciaBienesHurtadosList5;
    @OneToMany(mappedBy = "idClaseBien")
    private List<DenunciaBienesHurtados> denunciaBienesHurtadosList6;
    @OneToMany(mappedBy = "idTipoDocumento")
    private List<Persona> personaList;
    @OneToMany(mappedBy = "idProfesion")
    private List<Persona> personaList1;
    @OneToMany(mappedBy = "idClaseEmpleado")
    private List<Persona> personaList2;
    @OneToMany(mappedBy = "idNivelAcademico")
    private List<Persona> personaList3;
    @OneToMany(mappedBy = "idEstadoCivil")
    private List<Persona> personaList4;
    @OneToMany(mappedBy = "lugarNacimiento")
    private List<Persona> personaList5;
    @OneToMany(mappedBy = "sexo")
    private List<Persona> personaList6;

    public Parametro() {
    }

    public Parametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getCodigoParametro() {
        return codigoParametro;
    }

    public void setCodigoParametro(String codigoParametro) {
        this.codigoParametro = codigoParametro;
    }

    public String getTipoParametro() {
        return tipoParametro;
    }

    public void setTipoParametro(String tipoParametro) {
        this.tipoParametro = tipoParametro;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
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

    @XmlTransient
    public List<DenunciaDelito> getDenunciaDelitoList1() {
        return denunciaDelitoList1;
    }

    public void setDenunciaDelitoList1(List<DenunciaDelito> denunciaDelitoList1) {
        this.denunciaDelitoList1 = denunciaDelitoList1;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList1() {
        return usuarioList1;
    }

    public void setUsuarioList1(List<Usuario> usuarioList1) {
        this.usuarioList1 = usuarioList1;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList2() {
        return usuarioList2;
    }

    public void setUsuarioList2(List<Usuario> usuarioList2) {
        this.usuarioList2 = usuarioList2;
    }

    @XmlTransient
    public List<Denuncia> getDenunciaList() {
        return denunciaList;
    }

    public void setDenunciaList(List<Denuncia> denunciaList) {
        this.denunciaList = denunciaList;
    }

    @XmlTransient
    public List<Denuncia> getDenunciaList1() {
        return denunciaList1;
    }

    public void setDenunciaList1(List<Denuncia> denunciaList1) {
        this.denunciaList1 = denunciaList1;
    }

    @XmlTransient
    public List<Denuncia> getDenunciaList2() {
        return denunciaList2;
    }

    public void setDenunciaList2(List<Denuncia> denunciaList2) {
        this.denunciaList2 = denunciaList2;
    }

    @XmlTransient
    public List<Denuncia> getDenunciaList3() {
        return denunciaList3;
    }

    public void setDenunciaList3(List<Denuncia> denunciaList3) {
        this.denunciaList3 = denunciaList3;
    }

    @XmlTransient
    public List<Denuncia> getDenunciaList4() {
        return denunciaList4;
    }

    public void setDenunciaList4(List<Denuncia> denunciaList4) {
        this.denunciaList4 = denunciaList4;
    }

    @XmlTransient
    public List<Denuncia> getDenunciaList5() {
        return denunciaList5;
    }

    public void setDenunciaList5(List<Denuncia> denunciaList5) {
        this.denunciaList5 = denunciaList5;
    }

    @XmlTransient
    public List<Denuncia> getDenunciaList6() {
        return denunciaList6;
    }

    public void setDenunciaList6(List<Denuncia> denunciaList6) {
        this.denunciaList6 = denunciaList6;
    }

    @XmlTransient
    public List<DenunciaBienesHurtados> getDenunciaBienesHurtadosList() {
        return denunciaBienesHurtadosList;
    }

    public void setDenunciaBienesHurtadosList(List<DenunciaBienesHurtados> denunciaBienesHurtadosList) {
        this.denunciaBienesHurtadosList = denunciaBienesHurtadosList;
    }

    @XmlTransient
    public List<DenunciaBienesHurtados> getDenunciaBienesHurtadosList1() {
        return denunciaBienesHurtadosList1;
    }

    public void setDenunciaBienesHurtadosList1(List<DenunciaBienesHurtados> denunciaBienesHurtadosList1) {
        this.denunciaBienesHurtadosList1 = denunciaBienesHurtadosList1;
    }

    @XmlTransient
    public List<DenunciaBienesHurtados> getDenunciaBienesHurtadosList2() {
        return denunciaBienesHurtadosList2;
    }

    public void setDenunciaBienesHurtadosList2(List<DenunciaBienesHurtados> denunciaBienesHurtadosList2) {
        this.denunciaBienesHurtadosList2 = denunciaBienesHurtadosList2;
    }

    @XmlTransient
    public List<DenunciaBienesHurtados> getDenunciaBienesHurtadosList3() {
        return denunciaBienesHurtadosList3;
    }

    public void setDenunciaBienesHurtadosList3(List<DenunciaBienesHurtados> denunciaBienesHurtadosList3) {
        this.denunciaBienesHurtadosList3 = denunciaBienesHurtadosList3;
    }

    @XmlTransient
    public List<DenunciaBienesHurtados> getDenunciaBienesHurtadosList4() {
        return denunciaBienesHurtadosList4;
    }

    public void setDenunciaBienesHurtadosList4(List<DenunciaBienesHurtados> denunciaBienesHurtadosList4) {
        this.denunciaBienesHurtadosList4 = denunciaBienesHurtadosList4;
    }

    @XmlTransient
    public List<DenunciaBienesHurtados> getDenunciaBienesHurtadosList5() {
        return denunciaBienesHurtadosList5;
    }

    public void setDenunciaBienesHurtadosList5(List<DenunciaBienesHurtados> denunciaBienesHurtadosList5) {
        this.denunciaBienesHurtadosList5 = denunciaBienesHurtadosList5;
    }

    @XmlTransient
    public List<DenunciaBienesHurtados> getDenunciaBienesHurtadosList6() {
        return denunciaBienesHurtadosList6;
    }

    public void setDenunciaBienesHurtadosList6(List<DenunciaBienesHurtados> denunciaBienesHurtadosList6) {
        this.denunciaBienesHurtadosList6 = denunciaBienesHurtadosList6;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Persona> getPersonaList1() {
        return personaList1;
    }

    public void setPersonaList1(List<Persona> personaList1) {
        this.personaList1 = personaList1;
    }

    @XmlTransient
    public List<Persona> getPersonaList2() {
        return personaList2;
    }

    public void setPersonaList2(List<Persona> personaList2) {
        this.personaList2 = personaList2;
    }

    @XmlTransient
    public List<Persona> getPersonaList3() {
        return personaList3;
    }

    public void setPersonaList3(List<Persona> personaList3) {
        this.personaList3 = personaList3;
    }

    @XmlTransient
    public List<Persona> getPersonaList4() {
        return personaList4;
    }

    public void setPersonaList4(List<Persona> personaList4) {
        this.personaList4 = personaList4;
    }

    @XmlTransient
    public List<Persona> getPersonaList5() {
        return personaList5;
    }

    public void setPersonaList5(List<Persona> personaList5) {
        this.personaList5 = personaList5;
    }

    @XmlTransient
    public List<Persona> getPersonaList6() {
        return personaList6;
    }

    public void setPersonaList6(List<Persona> personaList6) {
        this.personaList6 = personaList6;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.denuncia.entities.Parametro[ idParametro=" + idParametro + " ]";
    }
    
}
