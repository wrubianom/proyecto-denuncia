/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.DenunciaDelito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class DenunciaDelitoEJB extends AbstractFacade<DenunciaDelito> implements DenunciaDelitoEJBLocal {
    @PersistenceContext(unitName = "ProyectoDenunciaHPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DenunciaDelitoEJB() {
        super(DenunciaDelito.class);
    }
    
}
