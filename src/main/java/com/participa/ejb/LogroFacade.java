/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Logro;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dacastanedah
 */
@Stateless
public class LogroFacade extends AbstractFacade<Logro> implements LogroFacadeLocal {
    @PersistenceContext(unitName = "participaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogroFacade() {
        super(Logro.class);
    }
    
    @Override
    public List<SelectItem> listarLogro() {
        List<SelectItem> logros = new ArrayList<>();
       List<Logro> items = em.createNamedQuery("Logro.findAll", Logro.class)
                .getResultList(); 
       logros.clear();
        for (Logro item : items) {
            SelectItem si = new SelectItem(item.getIdLogro());
            logros.add(si);
        }
        return logros;
    }
}
