/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.DenunciaDelito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface DenunciaDelitoEJBLocal {

    void create(DenunciaDelito denunciaDelito);

    void edit(DenunciaDelito denunciaDelito);

    void remove(DenunciaDelito denunciaDelito);

    DenunciaDelito find(Object id);

    List<DenunciaDelito> findAll();

    List<DenunciaDelito> findRange(int[] range);

    int count();

}
