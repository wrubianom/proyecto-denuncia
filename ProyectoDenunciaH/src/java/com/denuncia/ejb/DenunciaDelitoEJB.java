/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.DenunciaDelito;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public DenunciaDelito findByIDDenuncia(int ID) {
        try {
            List<DenunciaDelito> list = null;
            list = em.createNamedQuery("DenunciaDelito.findByIdDenuncia").setParameter("ingDenuncia", ID).getResultList();
            if (list != null && !list.isEmpty()) {
                return list.get(0);
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
        return null;
    }

}
