/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WIlliam Rubiano
 */
@Stateless
public class DenunciaEJB implements DenunciaEJBLocal {

    @PersistenceContext
    EntityManager em;

}
