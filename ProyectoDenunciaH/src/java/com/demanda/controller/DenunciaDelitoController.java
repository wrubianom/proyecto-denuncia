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
import com.denuncia.singleton.SingletonDenuncia;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
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
    private static double latitud;
    private static double longitud;

    private MapModel model;
    private Marker marker;

    public DenunciaDelitoController() {

    }

    @PostConstruct
    public void init() {
        iniciarDenuncia();
        denunciaCurso = SingletonDenuncia.getinstance().getDenuncia();
        if (denunciaCurso != null && denunciaCurso.getIdDenuncia() != null) {
            DenunciaDelito res = this.denunciaDelitoEJB.findByIDDenuncia(denunciaCurso.getIdDenuncia());
            if (res != null && res.getIdDenunciaDelito() != null) {
                denunciaDelito = res;
            }
        }
        emptyModel = new DefaultMapModel();
        model = new DefaultMapModel();
        this.listaMunicipios = this.parametroEJB.getParametroTipo("Municipios");
        this.listaBarrios = this.parametroEJB.getParametroTipo("Barrio");

    }

    private void iniciarDenuncia() {
        this.denunciaDelito = new DenunciaDelito();
        this.denunciaDelito.setIdMunicipio(new Parametro());
        this.denunciaDelito.setIdBarrio(new Parametro());
    }

    public void crarDenunciaDelito() {
        try {
            this.denunciaDelito.setIdDenuncia(this.denunciaCurso);
            this.denunciaDelito.setLongitud(longitud);
            this.denunciaDelito.setLatitud(latitud);
            this.denunciaDelitoEJB.create(denunciaDelito);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Message", "Se registro correctamente"));
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void onPointSelect(PointSelectEvent event) {
        System.out.println("Add marker title: " + title);
        LatLng latlng = event.getLatLng();
        emptyModel = new DefaultMapModel();
        Marker marker = new Marker(new LatLng(event.getLatLng().getLat(), event.getLatLng().getLng()), title);
        emptyModel.addOverlay(marker);
        System.out.println(":::::::::::::: " + marker.getLatlng().getLat() + " :::::::::::::: " + marker.getLatlng().getLng());
        lat = marker.getLatlng().getLat();
        lng = marker.getLatlng().getLng();
        latitud = marker.getLatlng().getLat();
        longitud = marker.getLatlng().getLng();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));

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

    public MapModel getModel() {
        return model;
    }

    public void setModel(MapModel model) {
        this.model = model;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

}
