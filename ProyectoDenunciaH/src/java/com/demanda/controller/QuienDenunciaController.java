/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demanda.controller;

import com.denuncia.ejb.ParametroEJBLocal;
import com.denuncia.ejb.QuienDenunciaEJBLocal;
import com.denuncia.entities.Denuncia;
import com.denuncia.entities.DenunciaPersona;
import com.denuncia.entities.Parametro;
import com.denuncia.entities.Persona;
import com.denuncia.singleton.SingletonDenuncia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author WIlliam Rubiano
 */
@Named(value = "quienDenunciaController")
@ViewScoped
public class QuienDenunciaController implements Serializable {

    @EJB
    private QuienDenunciaEJBLocal quienDenunciaEJB;

    @EJB
    private ParametroEJBLocal parametroEJB;

    private Denuncia denunciaCurso = null;
    private Persona personaDenuncia;
    private DenunciaPersona denunciaPersonaCurso;
    private List<Parametro> relacionAgresor = new ArrayList<Parametro>();
    private List<Parametro> tipoIdentificacionList = new ArrayList<Parametro>();
    private List<Parametro> tipoSexolist = new ArrayList<Parametro>();
    private List<Parametro> lugaresNacimiento = new ArrayList<Parametro>();
    private List<Parametro> estadoCiviles = new ArrayList<Parametro>();
    private List<Parametro> lisNivelAcademico = new ArrayList<Parametro>();
    private List<Parametro> lisClaseEmpleado = new ArrayList<Parametro>();
    private List<Parametro> listProfesion = new ArrayList<Parametro>();

    /**
     * Creates a new instance of QuienDenunciaController
     */
    public QuienDenunciaController() {
    }

    @PostConstruct
    private void init() {
        denunciaCurso = SingletonDenuncia.getinstance().getDenuncia();
        inicializarPersona();
        if (denunciaCurso != null && denunciaCurso.getIdDenuncia() != null) {
            DenunciaPersona resTem = this.quienDenunciaEJB.consultarDenunciaPersonaByIdDenuncia(denunciaCurso.getIdDenuncia());

            if (resTem != null && resTem.getIdDenunciaPersona() != null) {
                denunciaPersonaCurso = resTem;
                this.personaDenuncia = resTem.getIdPersona();
            }
            System.out.println(""
                    + "entro por diferente de null");
        }

        this.relacionAgresor = this.parametroEJB.getParametroTipo("RelacionAgresor");
        this.tipoIdentificacionList = this.parametroEJB.getParametroTipo("TipoDocumento");
        this.tipoSexolist = this.parametroEJB.getParametroTipo("TipoSexo");
        this.lugaresNacimiento = this.parametroEJB.getParametroTipo("LugarNacimiento");
        this.estadoCiviles = this.parametroEJB.getParametroTipo("EstadoCivil");
        this.lisNivelAcademico = this.parametroEJB.getParametroTipo("NivelAcademico");
        this.lisClaseEmpleado = this.parametroEJB.getParametroTipo("ClaseEmpleado");
        this.listProfesion = this.parametroEJB.getParametroTipo("Profesion");
        System.out.println("la denuncia en el controlador quien denuncia es " + denunciaCurso.getIdDenuncia());
    }

    private void inicializarPersona() {
        this.denunciaPersonaCurso = new DenunciaPersona();
        this.denunciaPersonaCurso.setIdRelaccionAgresor(new Parametro());

        this.personaDenuncia = new Persona();
        this.personaDenuncia.setIdTipoDocumento(new Parametro());
        this.personaDenuncia.setIdClaseEmpleado(new Parametro());
        this.personaDenuncia.setIdEstadoCivil(new Parametro());
        this.personaDenuncia.setIdNivelAcademico(new Parametro());
        this.personaDenuncia.setIdProfesion(new Parametro());
        this.personaDenuncia.setLugarNacimiento(new Parametro());
        this.personaDenuncia.setSexo(new Parametro());
    }

    public String crearQuienDenuncia() {
        this.denunciaPersonaCurso.setIdDenuncia(denunciaCurso);
        this.denunciaPersonaCurso.setIdPersona(personaDenuncia);
        System.out.println("la persona ");
        DenunciaPersona res = this.quienDenunciaEJB.crearDenunciaPersona(denunciaPersonaCurso);
        FacesContext context = FacesContext.getCurrentInstance();
        if (res != null && res.getIdDenuncia() != null) {
            System.out.println("el id es " + res.getIdDenuncia());
            return "BIENES_HURTADOS";
        } else {
            context.addMessage(null, new FacesMessage("Message", "No se pudo asociar la persona a la denuncia... Intente nuevamente"));
        }
        return "";
    }

    public Denuncia getDenunciaCurso() {
        return denunciaCurso;
    }

    public void setDenunciaCurso(Denuncia denunciaCurso) {
        this.denunciaCurso = denunciaCurso;
    }

    public Persona getPersonaDenuncia() {
        return personaDenuncia;
    }

    public void setPersonaDenuncia(Persona personaDenuncia) {
        this.personaDenuncia = personaDenuncia;
    }

    public DenunciaPersona getDenunciaPersonaCurso() {
        return denunciaPersonaCurso;
    }

    public void setDenunciaPersonaCurso(DenunciaPersona denunciaPersonaCurso) {
        this.denunciaPersonaCurso = denunciaPersonaCurso;
    }

    public List<Parametro> getRelacionAgresor() {
        return relacionAgresor;
    }

    public void setRelacionAgresor(List<Parametro> relacionAgresor) {
        this.relacionAgresor = relacionAgresor;
    }

    public List<Parametro> getTipoIdentificacionList() {
        return tipoIdentificacionList;
    }

    public void setTipoIdentificacionList(List<Parametro> tipoIdentificacionList) {
        this.tipoIdentificacionList = tipoIdentificacionList;
    }

    public List<Parametro> getTipoSexolist() {
        return tipoSexolist;
    }

    public void setTipoSexolist(List<Parametro> tipoSexolist) {
        this.tipoSexolist = tipoSexolist;
    }

    public List<Parametro> getLugaresNacimiento() {
        return lugaresNacimiento;
    }

    public void setLugaresNacimiento(List<Parametro> lugaresNacimiento) {
        this.lugaresNacimiento = lugaresNacimiento;
    }

    public List<Parametro> getEstadoCiviles() {
        return estadoCiviles;
    }

    public void setEstadoCiviles(List<Parametro> estadoCiviles) {
        this.estadoCiviles = estadoCiviles;
    }

    public List<Parametro> getLisNivelAcademico() {
        return lisNivelAcademico;
    }

    public void setLisNivelAcademico(List<Parametro> lisNivelAcademico) {
        this.lisNivelAcademico = lisNivelAcademico;
    }

    public List<Parametro> getLisClaseEmpleado() {
        return lisClaseEmpleado;
    }

    public void setLisClaseEmpleado(List<Parametro> lisClaseEmpleado) {
        this.lisClaseEmpleado = lisClaseEmpleado;
    }

    public List<Parametro> getListProfesion() {
        return listProfesion;
    }

    public void setListProfesion(List<Parametro> listProfesion) {
        this.listProfesion = listProfesion;
    }

}
