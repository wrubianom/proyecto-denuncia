/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.DenunciaBienesHurtados;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WIlliam Rubiano
 */
@Stateless
public class BienesHurtadosEJB implements BienesHurtadosEJBLocal {

    @PersistenceContext(unitName = "ProyectoDenunciaHPU")
    private EntityManager em;

    @Override
    public DenunciaBienesHurtados consultarByIdDenuncia(Integer idDenuncia) {
        DenunciaBienesHurtados resultado = null;
        try {
            List<DenunciaBienesHurtados> lista = this.em.createNamedQuery("DenunciaBienesHurtados.findByIdDenuncia").setParameter("IntIdDenuncia", idDenuncia).getResultList();
            if (lista != null && !lista.isEmpty()) {
                resultado = lista.get(0);
            }
        } catch (Exception e) {
            System.out.println("error en consulta id denuncia en bienes hurtados");

        }
        return resultado;
    }

    @Override
    public DenunciaBienesHurtados persistirDatos(DenunciaBienesHurtados nuevo) {
        DenunciaBienesHurtados resultado = null;
        try {
            resultado = this.em.merge(nuevo);
        } catch (Exception e) {
            System.out.println("error en crear bienes hurtados");

        }
        return resultado;
    }

}
