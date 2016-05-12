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
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author user
 */
@ManagedBean
@RequestScoped
public class DenunciaDelitoController implements Serializable {

    @EJB
    private ParametroEJBLocal parametroEJB;

    @EJB
    private DenunciaDelitoEJBLocal denunciaDelitoEJB;

    private Denuncia denunciaCurso = null;
    private DenunciaDelito denunciaDelito;
    private List<Parametro> listaMunicipios = new ArrayList<>();
    private List<Parametro> listaBarrios = new ArrayList<>();
    private MapModel emptyModel;
    private String title;
    private double lat;
    private double lng;

    public DenunciaDelitoController() {

    }

    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
        this.listaMunicipios = this.parametroEJB.getParametroTipo("Municipios");
        this.listaBarrios = this.parametroEJB.getParametroTipo("Barrio");
        iniciarDenuncia();
    }

    private void iniciarDenuncia() {
        this.denunciaDelito = new DenunciaDelito();
        this.denunciaDelito.setIdMunicipio(new Parametro());
        this.denunciaDelito.setIdBarrio(new Parametro());
    }

    public void crarDenunciaDelito() {
        try {
            this.denunciaDelito.setIdDenuncia(new Denuncia(1));
            this.denunciaDelitoEJB.create(denunciaDelito);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Message", "Se registro correctamente"));
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void addMarker(ActionEvent actionEvent) {
        Marker marker = new Marker(new LatLng(lat, lng), title);
        emptyModel.addOverlay(marker);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
    }

    public void onPointSelect(PointSelectEvent event) {
        System.out.println("Add marker title: " + title);
       
    }

    public DenunciaDelito getDenunciaDelito() {
        return denunciaDelito;
    }

    public void setDenunciaDelito(DenunciaDelito denunciaDelito) {
        this.denunciaDelito = denunciaDelito;
    }

    public List<Parametro> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(List<Parametro> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public List<Parametro> getListaBarrios() {
        return listaBarrios;
    }

    public void setListaBarrios(List<Parametro> listaBarrios) {
        this.listaBarrios = listaBarrios;
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

}
