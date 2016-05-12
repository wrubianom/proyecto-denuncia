/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.Denuncia;
import javax.ejb.Local;

/**
 *
 * @author WIlliam Rubiano
 */
@Local
public interface DenunciaEJBLocal {

    abstract Denuncia crearDenuncia(Denuncia denunciaNueva);

    abstract Denuncia bucsarDenunciaIdDenuncia(Integer idDenunciabuscar);

}
