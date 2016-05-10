/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demanda.controller;

import com.denuncia.entities.Denuncia;
import com.denuncia.singleton.SingletonDenuncia;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author WIlliam Rubiano
 */
@ManagedBean
@SessionScoped
public class ModulosSession implements Serializable {

    /**
     * Creates a new instance of ModulosSession
     */
    public ModulosSession() {
    }

    public boolean isPuedeRenderizarBotones() {
        Denuncia denunciaCurso = SingletonDenuncia.getinstance().getDenuncia();

        if (denunciaCurso != null && denunciaCurso.getIdDenuncia() != null) {
            return true;
        }

        return false;
    }
}
