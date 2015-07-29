/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.participa.ejb;

import com.participa.model.Asignaturagrado;
import com.participa.model.Componente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author dacastanedah
 */
@Stateless
public class ComponenteFacade extends AbstractFacade<Componente> implements ComponenteFacadeLocal {
    @PersistenceContext(unitName = "participaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComponenteFacade() {
        super(Componente.class);
    }
    
    @Override
    public List<Componente> invocarProcedimiento(EntityManager em, String idGrado, String idAsignatura){
        
        Query query = em.createNativeQuery("call consultarComponente(?1,?2)", Componente.class);
        query.setParameter(1, idGrado);
        query.setParameter(2, idAsignatura);
        
        
        
        
        List<Componente> resultado = query.getResultList();
        
        return resultado;
        
    }
    
    @Override
    public List<Componente> invocarProcedure(String idGrado, String idAsignatura){
        
       return invocarProcedimiento(em, idGrado, idAsignatura);
    }
}
