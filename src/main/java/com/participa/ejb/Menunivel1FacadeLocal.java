/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Menunivel1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dacastanedah
 */
@Local
public interface Menunivel1FacadeLocal {

    void create(Menunivel1 menunivel1);

    void edit(Menunivel1 menunivel1);

    void remove(Menunivel1 menunivel1);

    Menunivel1 find(Object id);

    List<Menunivel1> findAll();

    List<Menunivel1> findRange(int[] range);

    int count();
    
}
