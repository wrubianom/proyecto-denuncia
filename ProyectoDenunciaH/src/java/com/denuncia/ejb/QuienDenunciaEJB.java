/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.DenunciaPersona;
import com.denuncia.entities.Persona;
import java.util.List;
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
    @Override
    public DenunciaPersona consultarDenunciaPersonaByIdDenuncia(Integer idDenuncia) {
        DenunciaPersona resultado = null;
        try {
            List<DenunciaPersona> resTem = this.em.createNamedQuery("DenunciaPersona.findByIdDenuncia").setParameter("intIdDenuncia", idDenuncia).getResultList();
            if (resTem != null && !resTem.isEmpty()) {
                resultado = resTem.get(0);
//                List<Persona> pList = this.em.createNamedQuery("Persona.findByIdPersona").setParameter("idPersona", resultado.getIdPersona().getIdPersona()).getResultList();
//                if (pList != null && !pList.isEmpty()) {
//                    Persona p = pList.get(0);
//                    resultado.setIdPersona(p);
//                }
            }
        } catch (Exception e) {
            System.out.println("error consultado denuncia persona" + e.toString());
        }
        return resultado;
    }
}
