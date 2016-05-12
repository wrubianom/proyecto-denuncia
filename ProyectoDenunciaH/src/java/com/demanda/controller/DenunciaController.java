/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demanda.controller;

import com.denuncia.ejb.DenunciaEJBLocal;
import com.denuncia.ejb.ParametroEJBLocal;
import com.denuncia.entities.Denuncia;
import com.denuncia.entities.Parametro;
import com.denuncia.entities.Usuario;
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
@Named(value = "denunciaController")
@ViewScoped
public class DenunciaController implements Serializable {

    @EJB
    private ParametroEJBLocal parametroEJB;

    @EJB
    private DenunciaEJBLocal denunciaEJB;

    private Denuncia denunciaCurso = null;
    private Integer idDenunciabuscar;

    private Denuncia denunciaNueva = new Denuncia();
    private List<Parametro> tipoDelitos = new ArrayList<Parametro>();
    private List<Parametro> delitoslist = new ArrayList<Parametro>();
    private List<Parametro> unidadInvestigativa = new ArrayList<Parametro>();
    private List<Parametro> modalidades = new ArrayList<Parametro>();
    private List<Parametro> tiposArmas = new ArrayList<Parametro>();
    private List<Parametro> tiposMoviles = new ArrayList<Parametro>();

    /**
     * Creates a new instance of DenunciaController
     */
    public DenunciaController() {

    }

    @PostConstruct
    private void init() {

        this.tipoDelitos = this.parametroEJB.getParametroTipo("TipoDelito");
        this.delitoslist = this.parametroEJB.getParametroTipo("Delito");
        this.unidadInvestigativa = this.parametroEJB.getParametroTipo("UnidadInvestigativa");
        this.modalidades = this.parametroEJB.getParametroTipo("Modalidad");
        this.tiposArmas = this.parametroEJB.getParametroTipo("TipoArma");
        this.tiposMoviles = this.parametroEJB.getParametroTipo("TipoMovil");

        iniciarDenuncia();

        denunciaCurso = SingletonDenuncia.getinstance().getDenuncia();

        if (denunciaCurso != null && denunciaCurso.getIdDenuncia() != null) {
            this.denunciaNueva = this.denunciaCurso;
        }
        System.out.println("hola");
    }

    private void iniciarDenuncia() {
        this.denunciaNueva = new Denuncia();
        this.denunciaNueva.setArmaEmpleada(new Parametro());
        this.denunciaNueva.setIdDelito(new Parametro());
        this.denunciaNueva.setIdTipoDelito(new Parametro());
        this.denunciaNueva.setModalidad(new Parametro());
        this.denunciaNueva.setMovilAgreado(new Parametro());
        this.denunciaNueva.setMovilVictima(new Parametro());
        this.denunciaNueva.setUnidadInvestigativa(new Parametro());
    }

    public String crearDenuncia() {
        this.denunciaNueva.setIdUsuario(new Usuario(1));
        Denuncia res = this.denunciaEJB.crearDenuncia(denunciaNueva);
        FacesContext context = FacesContext.getCurrentInstance();
        if (res != null && res.getIdDenuncia() != null) {
            context.addMessage(null, new FacesMessage("Message", "Se registro la denuncia # " + res.getIdDenuncia()));
            System.out.println("el id es " + res.getIdDenuncia());
            SingletonDenuncia.getinstance().setDenuncia(res);
            return "QUIEN_DENUNCIAR";
        } else {
            context.addMessage(null, new FacesMessage("Message", "No se pudo registrar la denuncia... Intente nuevamente"));
        }
        return "";
    }

    public String buscarDenuncia() {
        System.out.println("entro a nueva denuncia");
        if (this.idDenunciabuscar != null) {
            Denuncia res = this.denunciaEJB.bucsarDenunciaIdDenuncia(this.idDenunciabuscar);
            if (res != null && res.getIdDenuncia() != null) {
                this.denunciaNueva = res;
                this.denunciaCurso = res;
                SingletonDenuncia.getinstance().setDenuncia(res);
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Message", "No se encontraron resultados "));
            }

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Message", "Ingrese un id de denuncia"));
        }
        return "";
    }

    public String nuevaDenuncia() {
        SingletonDenuncia.getinstance().setDenuncia(null);
        this.denunciaCurso = null;
        this.iniciarDenuncia();
        this.denunciaNueva = new Denuncia();
        this.denunciaNueva.setFechaDelito(null);
        this.denunciaNueva.setOtroDelito("");
        this.denunciaNueva.setArmaEmpleada(new Parametro());
        this.denunciaNueva.setIdDelito(new Parametro());
        this.denunciaNueva.setIdTipoDelito(new Parametro());
        this.denunciaNueva.setModalidad(new Parametro());
        this.denunciaNueva.setMovilAgreado(new Parametro());
        this.denunciaNueva.setMovilVictima(new Parametro());
        this.denunciaNueva.setUnidadInvestigativa(new Parametro());
        return "";
    }

    public Denuncia getDenunciaNueva() {
        return denunciaNueva;
    }

    public void setDenunciaNueva(Denuncia denunciaNueva) {
        this.denunciaNueva = denunciaNueva;
    }

    public List<Parametro> getTipoDelitos() {
        return tipoDelitos;
    }

    public void setTipoDelitos(List<Parametro> tipoDelitos) {
        this.tipoDelitos = tipoDelitos;
    }

    public List<Parametro> getDelitoslist() {
        return delitoslist;
    }

    public void setDelitoslist(List<Parametro> delitoslist) {
        this.delitoslist = delitoslist;
    }

    public List<Parametro> getUnidadInvestigativa() {
        return unidadInvestigativa;
    }

    public void setUnidadInvestigativa(List<Parametro> unidadInvestigativa) {
        this.unidadInvestigativa = unidadInvestigativa;
    }

    public List<Parametro> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<Parametro> modalidades) {
        this.modalidades = modalidades;
    }

    public List<Parametro> getTiposArmas() {
        return tiposArmas;
    }

    public void setTiposArmas(List<Parametro> tiposArmas) {
        this.tiposArmas = tiposArmas;
    }

    public List<Parametro> getTiposMoviles() {
        return tiposMoviles;
    }

    public void setTiposMoviles(List<Parametro> tiposMoviles) {
        this.tiposMoviles = tiposMoviles;
    }

    public Denuncia getDenunciaCurso() {
        return denunciaCurso;
    }

    public void setDenunciaCurso(Denuncia denunciaCurso) {
        this.denunciaCurso = denunciaCurso;
    }

    public boolean isDenunciaCursoNotNull() {
        if (this.denunciaCurso != null && this.denunciaCurso.getIdDenuncia() != null) {
            return true;
        }
        return false;

    }

    public Integer getIdDenunciabuscar() {
        return idDenunciabuscar;
    }

    public void setIdDenunciabuscar(Integer idDenunciabuscar) {
        this.idDenunciabuscar = idDenunciabuscar;
    }

}
