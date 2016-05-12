/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denuncia.ejb;

import com.denuncia.entities.DenunciaPersona;
import javax.ejb.Local;

/**
 *
 * @author WIlliam Rubiano
 */
@Local
public interface QuienDenunciaEJBLocal {

    public DenunciaPersona crearDenunciaPersona(DenunciaPersona nueva);
    
    public DenunciaPersona consultarDenunciaPersonaByIdDenuncia(Integer idDenuncia);
}
