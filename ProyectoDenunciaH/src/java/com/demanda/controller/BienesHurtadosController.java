/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demanda.controller;

import com.denuncia.ejb.BienesHurtadosEJBLocal;
import com.denuncia.ejb.ParametroEJBLocal;
import com.denuncia.entities.Denuncia;
import com.denuncia.entities.DenunciaBienesHurtados;
import com.denuncia.entities.Parametro;
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
@Named(value = "bienesHurtadosController")
@ViewScoped
public class BienesHurtadosController implements Serializable {

    @EJB
    private BienesHurtadosEJBLocal bienesHurtadosEJB;

    @EJB
    private ParametroEJBLocal parametroEJB;

    private Denuncia denunciaCurso = null;

    private DenunciaBienesHurtados denunciaBienesHurtados;

    private List<Parametro> listClasebien = new ArrayList<Parametro>();
    private List<Parametro> listTipoBien = new ArrayList<Parametro>();
    private List<Parametro> listInstituciones = new ArrayList<Parametro>();
    private List<Parametro> listDestino = new ArrayList<Parametro>();
    private List<Parametro> listAutoridad = new ArrayList<Parametro>();
    private List<Parametro> listCiudadAutoridad = new ArrayList<Parametro>();
    private List<Parametro> listTipoNovedad = new ArrayList<Parametro>();

    /**
     * Creates a new instance of BienesHurtadosController
     */
    public BienesHurtadosController() {

    }

    @PostConstruct
    private void init() {
        denunciaCurso = SingletonDenuncia.getinstance().getDenuncia();
        iniciarDenunciahurto();
        listClasebien = this.parametroEJB.getParametroTipo("ClaseBien");
        listTipoBien = this.parametroEJB.getParametroTipo("TipoBien");
        listInstituciones = this.parametroEJB.getParametroTipo("Institucion");
        listDestino = this.parametroEJB.getParametroTipo("Destino");
        listAutoridad = this.parametroEJB.getParametroTipo("Autoridad");
        listCiudadAutoridad = this.parametroEJB.getParametroTipo("CiudadAutoriza");
        listTipoNovedad = this.parametroEJB.getParametroTipo("TipoNovedad");

        if (denunciaCurso
                != null && denunciaCurso.getIdDenuncia()
                != null) {
            DenunciaBienesHurtados res = this.bienesHurtadosEJB.consultarByIdDenuncia(denunciaCurso.getIdDenuncia());
            if (res != null && res.getIdDenunciaBienesHurtados() != null) {
                this.denunciaBienesHurtados = res;
            }
        }

    }

    private void iniciarDenunciahurto() {
        this.denunciaBienesHurtados = new DenunciaBienesHurtados();
        this.denunciaBienesHurtados.setIdAutoridad(new Parametro());
        this.denunciaBienesHurtados.setIdCiudadAutoridad(new Parametro());
        this.denunciaBienesHurtados.setIdClaseBien(new Parametro());
        this.denunciaBienesHurtados.setIdDenuncia(denunciaCurso);
        this.denunciaBienesHurtados.setIdDestino(new Parametro());
        this.denunciaBienesHurtados.setIdInstitucion(new Parametro());
        this.denunciaBienesHurtados.setIdTipoBien(new Parametro());
        this.denunciaBienesHurtados.setIdTipoNovedad(new Parametro());

    }

    public String persistirInformacion() {
        DenunciaBienesHurtados res = this.bienesHurtadosEJB.persistirDatos(denunciaBienesHurtados);
        FacesContext context = FacesContext.getCurrentInstance();

        if (res != null && res.getIdDenunciaBienesHurtados() != null) {
//            context.addMessage(null, new FacesMessage("Message", "Se registro la denuncia # " + res.getIdDenuncia()));
            System.out.println("el id es " + res.getIdDenuncia());
            return "LUGAR_DELITO";
        }
        return "";
    }

    public DenunciaBienesHurtados getDenunciaBienesHurtados() {
        return denunciaBienesHurtados;
    }

    public void setDenunciaBienesHurtados(DenunciaBienesHurtados denunciaBienesHurtados) {
        this.denunciaBienesHurtados = denunciaBienesHurtados;
    }

    public Denuncia getDenunciaCurso() {
        return denunciaCurso;
    }

    public void setDenunciaCurso(Denuncia denunciaCurso) {
        this.denunciaCurso = denunciaCurso;
    }

    public List<Parametro> getListClasebien() {
        return listClasebien;
    }

    public void setListClasebien(List<Parametro> listClasebien) {
        this.listClasebien = listClasebien;
    }

    public List<Parametro> getListTipoBien() {
        return listTipoBien;
    }

    public void setListTipoBien(List<Parametro> listTipoBien) {
        this.listTipoBien = listTipoBien;
    }

    public List<Parametro> getListInstituciones() {
        return listInstituciones;
    }

    public void setListInstituciones(List<Parametro> listInstituciones) {
        this.listInstituciones = listInstituciones;
    }

    public List<Parametro> getListDestino() {
        return listDestino;
    }

    public void setListDestino(List<Parametro> listDestino) {
        this.listDestino = listDestino;
    }

    public List<Parametro> getListAutoridad() {
        return listAutoridad;
    }

    public void setListAutoridad(List<Parametro> listAutoridad) {
        this.listAutoridad = listAutoridad;
    }

    public List<Parametro> getListCiudadAutoridad() {
        return listCiudadAutoridad;
    }

    public void setListCiudadAutoridad(List<Parametro> listCiudadAutoridad) {
        this.listCiudadAutoridad = listCiudadAutoridad;
    }

    public List<Parametro> getListTipoNovedad() {
        return listTipoNovedad;
    }

    public void setListTipoNovedad(List<Parametro> listTipoNovedad) {
        this.listTipoNovedad = listTipoNovedad;
    }

}
