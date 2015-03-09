/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.DaoJpa;

import com.CubbyHole.Dao.StockageClientDao;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Contact;
import com.CubbyHole.Entite.Stockage;
import com.CubbyHole.Entite.Stockageclient;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Christopher
 */
public class StockageClientDaoJpa implements StockageClientDao{
    private EntityManagerFactory emf;
    
    public StockageClientDaoJpa (EntityManagerFactory emf) {
            // TODO Auto-generated constructor stub
            this.emf = emf;
    }

    @Override
    public List<Stockageclient> findByClient(Client client) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Stockageclient.findByClient");
        query.setParameter("sClient", client);
        List<Stockageclient> stockageclients = query.getResultList();

        return stockageclients;
    }

    @Override
    public boolean createStockageClient(Stockageclient stockageClient) {
        EntityManager em = emf.createEntityManager();
    	EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.persist(stockageClient);
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
    public void suprBy2Id(Stockage stockage, Client client) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query query = em.createNamedQuery("Stockageclient.suprBy2Id");
        query.setParameter("sStockage", stockage);
        query.setParameter("sClient", client);
        
        List<Stockageclient> stockageClient = query.getResultList();
        
        for (Stockageclient elem : stockageClient) {
            t.begin();
            em.remove(elem);
            t.commit();
	}
    }

    @Override
    public List<Stockageclient> findByClientAuteur(Client client) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Stockageclient.findByClientAuteur");
        query.setParameter("sClient", client);
        List<Stockageclient> stockageclients = query.getResultList();

        return stockageclients;
    }

    @Override
    public List<Stockageclient> findByClientNotAuteur(Client client) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Stockageclient.findByClientNotAuteur");
        query.setParameter("sPartage", client);
        List<Stockageclient> stockageclients = query.getResultList();

        return stockageclients;
    }

    @Override
    public Stockageclient findById(int id) {
        EntityManager em = emf.createEntityManager();
        Stockageclient stockageClient = em.find(Stockageclient.class, id);
        if(stockageClient != null){
                return stockageClient;
        }
        return null;
    }

    @Override
    public List<Stockageclient> findByPartage(Stockage fichier, Client client) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Stockageclient.findByPartage");
        query.setParameter("sFichier", fichier);
        query.setParameter("sClient", client);
        
        List<Stockageclient> stockageclients = query.getResultList();
        
        return stockageclients;
    }

    @Override
    public Stockageclient findByPartagePublic(Stockage fichier, Client client) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Stockageclient.findByPartagePublic");
        query.setParameter("sFichier", fichier);
        query.setParameter("sClient", client);
        
        Stockageclient stockageclient = (Stockageclient) query.getSingleResult();
        
        return stockageclient;
    }

    @Override
    public void supprById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
    	Stockageclient stockageclient = em.find(Stockageclient.class, id);
        
        t.begin();
        em.remove(stockageclient);
        t.commit();
    }

    @Override
    public Stockageclient findByVerif(Stockage fichier, Client client, Client partager) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Stockageclient.findByVerif");
        query.setParameter("sFichier", fichier);
        query.setParameter("sClient", client);
        query.setParameter("sPartager", partager);
        
        try{
            Stockageclient stockageclient = (Stockageclient) query.getSingleResult();
            return stockageclient;
        } catch(Exception e){
            return null;
        }
    }
    
}
