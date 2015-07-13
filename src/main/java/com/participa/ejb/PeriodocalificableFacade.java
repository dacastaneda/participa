/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Periodocalificable;
import javax.ejb.Stateless;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodocalificableFacade() {
        super(Periodocalificable.class);
    }
    
}
