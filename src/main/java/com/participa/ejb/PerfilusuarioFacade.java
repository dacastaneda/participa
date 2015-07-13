/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Perfilusuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dacastanedah
 */
@Stateless
public class PerfilusuarioFacade extends AbstractFacade<Perfilusuario> implements PerfilusuarioFacadeLocal {
    @PersistenceContext(unitName = "participaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilusuarioFacade() {
        super(Perfilusuario.class);
    }
    
}
