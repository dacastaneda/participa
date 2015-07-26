/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Asignatura;
import java.util.List;
import javax.ejb.Local;
import javax.faces.model.SelectItem;

/**
 *
 * @author dacastanedah
 */
@Local
public interface AsignaturaFacadeLocal {

    void create(Asignatura asignatura);

    void edit(Asignatura asignatura);

    void remove(Asignatura asignatura);

    Asignatura find(Object id);

    List<Asignatura> findAll();

    List<Asignatura> findRange(int[] range);

    int count();
    
    List<SelectItem> listarAsignatura();
    
}
