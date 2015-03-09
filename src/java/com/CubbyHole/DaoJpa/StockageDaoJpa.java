/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.DaoJpa;

import com.CubbyHole.Dao.StockageDao;
import com.CubbyHole.Entite.Stockage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Christopher
 */
public class StockageDaoJpa implements StockageDao{
    
    private EntityManagerFactory emf;
	
    public StockageDaoJpa (EntityManagerFactory emf) {
            // TODO Auto-generated constructor stub
            this.emf = emf;
    }

    @Override
    public boolean createStockage(Stockage stockage) {
        EntityManager em = emf.createEntityManager();
    	EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.persist(stockage);
    		t.commit();
    		return true;
    	} catch (Exception e) {
    	// TODO: handle exception
    		return false;
    	} finally {
    		if (t.isActive()) t.rollback();
    		em.close();
    		emf.close();
    	}
    }

    @Override
    public Stockage getStockageById(int id) {
        EntityManager em = emf.createEntityManager();
        Stockage stockage = em.find(Stockage.class, id);
        if(stockage != null){
                return stockage;
        }
        return null;
    }

    @Override
    public void supprById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
    	Stockage stockage = em.find(Stockage.class, id);
        
        t.begin();
        em.remove(stockage);
        t.commit();
    }
}
