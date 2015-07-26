/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Grado;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dacastanedah
 */
@Stateless
public class GradoFacade extends AbstractFacade<Grado> implements GradoFacadeLocal {
    @PersistenceContext(unitName = "participaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GradoFacade() {
        super(Grado.class);
    }
    
    @Override
    public List<SelectItem> listarGrado() {
        List<SelectItem> grados = new ArrayList<>();
       List<Grado> items = em.createNamedQuery("Grado.findAll", Grado.class)
                .getResultList(); 
       grados.clear();
        for (Grado item : items) {
            SelectItem si = new SelectItem(item.getNombreGrado());
            grados.add(si);
        }
        return grados;
    }
}
