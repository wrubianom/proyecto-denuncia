/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.Denuncia;
import com.denuncia.entities.DenunciaPersona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WIlliam Rubiano
 */
@Stateless
public class QuienDenunciaEJB implements QuienDenunciaEJBLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public DenunciaPersona crearDenunciaPersona(DenunciaPersona nueva) {
        DenunciaPersona resultado = null;
        try {
            resultado = this.em.merge(nueva);
        } catch (Exception e) {
            System.out.println("Error el crear denuncia");
        }
        return resultado;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
