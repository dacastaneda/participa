/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Perfilusuario;
import com.participa.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

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
    
    @Override
    public void invocarProcedimiento(EntityManager em, int idPersona){
        
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("eliminarPerfilUsuario");
        spq.setParameter("idPersona", idPersona);
        spq.execute();
        
    }
    
    @Override
    public void invocarProcedure(int idPersona){
        
        invocarProcedimiento(em, idPersona);
    }
    
    
}
