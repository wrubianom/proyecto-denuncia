/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.singleton;

import com.denuncia.entities.Denuncia;

/**
 *
 * @author WIlliam Rubiano
 */
public class SingletonDenuncia {

    public static SingletonDenuncia instancia = null;
    private Denuncia denuncia = new Denuncia();

    private SingletonDenuncia() {
    }

    public static SingletonDenuncia getinstance() {
        if (instancia == null) {
            instancia = new SingletonDenuncia();
            return instancia;
        }
        return instancia;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

}
