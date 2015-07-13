/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Perfilaccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dacastanedah
 */
@Local
public interface PerfilaccionFacadeLocal {

    void create(Perfilaccion perfilaccion);

    void edit(Perfilaccion perfilaccion);

    void remove(Perfilaccion perfilaccion);

    Perfilaccion find(Object id);

    List<Perfilaccion> findAll();

    List<Perfilaccion> findRange(int[] range);

    int count();
    
}
