/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Menunivel3;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dacastanedah
 */
@Local
public interface Menunivel3FacadeLocal {

    void create(Menunivel3 menunivel3);

    void edit(Menunivel3 menunivel3);

    void remove(Menunivel3 menunivel3);

    Menunivel3 find(Object id);

    List<Menunivel3> findAll();

    List<Menunivel3> findRange(int[] range);

    int count();
    
}
