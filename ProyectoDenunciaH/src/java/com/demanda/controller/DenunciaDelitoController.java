/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demanda.controller;

import com.denuncia.ejb.DenunciaDelitoEJBLocal;
import com.denuncia.ejb.ParametroEJBLocal;
import com.denuncia.entities.Denuncia;
import com.denuncia.entities.DenunciaDelito;
import com.denuncia.entities.Parametro;
import com.denuncia.entities.Persona;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class DenunciaDelitoController {

    @EJB
    private ParametroEJBLocal parametroEJB;

    @EJB
    private DenunciaDelitoEJBLocal denunciaDelitoEJB;

    private Denuncia denunciaNueva = new Denuncia();
    private Denuncia denunciaCurso = null;
    private Persona personaDenuncia;
    private DenunciaDelito denunciaDelito;

    public DenunciaDelitoController() {

    }

    @PostConstruct
    public void init() {
        iniciarDenuncia();
    }

    private void iniciarDenuncia() {
        this.denunciaDelito = new DenunciaDelito();
        this.denunciaNueva = new Denuncia();
        this.denunciaNueva.setArmaEmpleada(new Parametro());
        this.denunciaNueva.setIdDelito(new Parametro());
        this.denunciaNueva.setIdTipoDelito(new Parametro());
        this.denunciaNueva.setModalidad(new Parametro());
        this.denunciaNueva.setMovilAgreado(new Parametro());
        this.denunciaNueva.setMovilVictima(new Parametro());
        this.denunciaNueva.setUnidadInvestigativa(new Parametro());
    }

    public void crarDenunciaDelito() {
        this.denunciaDelito.setIdDenuncia(denunciaCurso);
        this.denunciaDelitoEJB.create(denunciaDelito);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Message", "Se registro correctamente"));
    }

    public DenunciaDelito getDenunciaDelito() {
        return denunciaDelito;
    }

    public void setDenunciaDelito(DenunciaDelito denunciaDelito) {
        this.denunciaDelito = denunciaDelito;
    }

}
