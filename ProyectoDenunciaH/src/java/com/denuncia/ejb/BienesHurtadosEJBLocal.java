/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.DenunciaBienesHurtados;
import javax.ejb.Local;

/**
 *
 * @author WIlliam Rubiano
 */
@Local
public interface BienesHurtadosEJBLocal {

    public DenunciaBienesHurtados consultarByIdDenuncia(Integer idDenuncia);
    public DenunciaBienesHurtados persistirDatos(DenunciaBienesHurtados nuevo);
}
