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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNumeroDocumento", query = "SELECT p FROM Persona p WHERE p.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Persona.findByLugarExpedicion", query = "SELECT p FROM Persona p WHERE p.lugarExpedicion = :lugarExpedicion"),
    @NamedQuery(name = "Persona.findByPrimerNombre", query = "SELECT p FROM Persona p WHERE p.primerNombre = :primerNombre"),
    @NamedQuery(name = "Persona.findBySegundoNombre", query = "SELECT p FROM Persona p WHERE p.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Persona.findByPrimerApellido", query = "SELECT p FROM Persona p WHERE p.primerApellido = :primerApellido"),
    @NamedQuery(name = "Persona.findBySegundoApellido", query = "SELECT p FROM Persona p WHERE p.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findByCorreElectronico", query = "SELECT p FROM Persona p WHERE p.correElectronico = :correElectronico")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Size(max = 20)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Size(max = 20)
    @Column(name = "lugar_expedicion")
    private String lugarExpedicion;
    @Size(max = 20)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 20)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Size(max = 20)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 20)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 50)
    @Column(name = "corre_electronico")
    private String correElectronico;
    @OneToMany(mappedBy = "idPersona")
    private List<DenunciaPersona> denunciaPersonaList;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idTipoDocumento;
    @JoinColumn(name = "id_profesion", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idProfesion;
    @JoinColumn(name = "id_clase_empleado", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idClaseEmpleado;
    @JoinColumn(name = "id_nivel_academico", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idNivelAcademico;
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro idEstadoCivil;
    @JoinColumn(name = "lugar_nacimiento", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro lugarNacimiento;
    @JoinColumn(name = "sexo", referencedColumnName = "id_parametro")
    @ManyToOne
    private Parametro sexo;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreElectronico() {
        return correElectronico;
    }

    public void setCorreElectronico(String correElectronico) {
        this.correElectronico = correElectronico;
    }

    @XmlTransient
    public List<DenunciaPersona> getDenunciaPersonaList() {
        return denunciaPersonaList;
    }

    public void setDenunciaPersonaList(List<DenunciaPersona> denunciaPersonaList) {
        this.denunciaPersonaList = denunciaPersonaList;
    }

    public Parametro getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Parametro idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Parametro getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Parametro idProfesion) {
        this.idProfesion = idProfesion;
    }

    public Parametro getIdClaseEmpleado() {
        return idClaseEmpleado;
    }

    public void setIdClaseEmpleado(Parametro idClaseEmpleado) {
        this.idClaseEmpleado = idClaseEmpleado;
    }

    public Parametro getIdNivelAcademico() {
        return idNivelAcademico;
    }

    public void setIdNivelAcademico(Parametro idNivelAcademico) {
        this.idNivelAcademico = idNivelAcademico;
    }

    public Parametro getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Parametro idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Parametro getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(Parametro lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Parametro getSexo() {
        return sexo;
    }

    public void setSexo(Parametro sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.denuncia.entities.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
