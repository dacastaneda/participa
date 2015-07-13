/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Notas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dacastanedah
 */
@Local
public interface NotasFacadeLocal {

    void create(Notas notas);

    void edit(Notas notas);

    void remove(Notas notas);

    Notas find(Object id);

    List<Notas> findAll();

    List<Notas> findRange(int[] range);

    int count();
    
}
