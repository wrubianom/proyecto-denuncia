/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.Parametro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WIlliam Rubiano
 */
@Stateless
public class ParametroEJB implements ParametroEJBLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Parametro> getParametroTipo(String tipo) {
        return this.em.createNamedQuery("Parametro.findByTipoParametro").setParameter("tipoParametro", tipo).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
