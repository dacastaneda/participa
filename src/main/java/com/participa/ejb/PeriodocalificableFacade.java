/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Periodocalificable;
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
public class PeriodocalificableFacade extends AbstractFacade<Periodocalificable> implements PeriodocalificableFacadeLocal {
    @PersistenceContext(unitName = "participaPU")
    private EntityManager em;
    private Periodocalificable p;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodocalificableFacade() {
        super(Periodocalificable.class);
    }

    public Periodocalificable getP() {
        return p;
    }

    public void setP(Periodocalificable p) {
        this.p = p;
    }
    
    
    
    @Override
    public List<SelectItem> listarPeriodoCalificable() {
        List<SelectItem> periodoCalificable = new ArrayList<>();
       List<Periodocalificable> items = em.createNamedQuery("Periodocalificable.findAll", Periodocalificable.class)
                .getResultList(); 
       periodoCalificable.clear();
        for (Periodocalificable item : items) {
            SelectItem si = new SelectItem(item.getIdPeriodoCalificable());
            periodoCalificable.add(si);
        }
        return periodoCalificable;
    }
}
