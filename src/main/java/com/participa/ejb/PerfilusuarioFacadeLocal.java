/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Perfilusuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dacastanedah
 */
@Local
public interface PerfilusuarioFacadeLocal {

    void create(Perfilusuario perfilusuario);

    void edit(Perfilusuario perfilusuario);

    void remove(Perfilusuario perfilusuario);

    Perfilusuario find(Object id);

    List<Perfilusuario> findAll();

    List<Perfilusuario> findRange(int[] range);

    int count();
    
}
