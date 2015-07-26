/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Asignatura;
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
public class AsignaturaFacade extends AbstractFacade<Asignatura> implements AsignaturaFacadeLocal {
    @PersistenceContext(unitName = "participaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignaturaFacade() {
        super(Asignatura.class);
    }
    
    @Override
    public List<SelectItem> listarAsignatura() {
        List<SelectItem> asignaturas = new ArrayList<>();
       List<Asignatura> items = em.createNamedQuery("Asignatura.findAll", Asignatura.class)
                .getResultList(); 
       asignaturas.clear();
        for (Asignatura item : items) {
            SelectItem si = new SelectItem(item.getNombreAsignatura());
            asignaturas.add(si);
        }
        return asignaturas;
    }
}
