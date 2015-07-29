/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Componente;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author dacastanedah
 */
@Local
public interface ComponenteFacadeLocal {

    void create(Componente componente);

    void edit(Componente componente);

    void remove(Componente componente);

    Componente find(Object id);

    List<Componente> findAll();

    List<Componente> findRange(int[] range);

    int count();
    
    List<Componente> invocarProcedimiento(EntityManager em, String idGrado, String idAsignatura);
    
    List<Componente> invocarProcedure(String idGrado, String idAsignatura);
    
}
