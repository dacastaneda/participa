/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Periodolectivo;
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
public class PeriodolectivoFacade extends AbstractFacade<Periodolectivo> implements PeriodolectivoFacadeLocal {
    @PersistenceContext(unitName = "participaPU")
    private EntityManager em;
    
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodolectivoFacade() {
        super(Periodolectivo.class);
    }
    
   

    @Override
    public List<SelectItem> listarPeriodoLectivo() {
        List<SelectItem> periodoLectivo = new ArrayList<>();
       List<Periodolectivo> items = em.createNamedQuery("Periodolectivo.findAll", Periodolectivo.class).getResultList();
        periodoLectivo.clear();
        for (Periodolectivo item : items) {
            SelectItem si = new SelectItem(item.getIdPeriodoLectivo());
            periodoLectivo.add(si);
        }
        return periodoLectivo;
    }
}
