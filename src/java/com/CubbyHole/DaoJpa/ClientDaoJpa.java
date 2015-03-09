/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.DaoJpa;

import com.CubbyHole.Dao.ClientDao;
import com.CubbyHole.Entite.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Christopher
 */
public class ClientDaoJpa implements ClientDao{
    
    private EntityManagerFactory emf;
	
    public ClientDaoJpa (EntityManagerFactory emf) {
            // TODO Auto-generated constructor stub
            this.emf = emf;
    }

    @Override
    public boolean createClient(Client client) {
        EntityManager em = emf.createEntityManager();
    	EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.persist(client);
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
    public Client findByMailMdp(String mail, String Mdp) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Client.findMailMdp");
        query.setParameter("cMail", mail);
        query.setParameter("cMdp", Mdp);
        
        try {
            if(query.getSingleResult() != null){}
            
            Client client = (Client) query.getSingleResult();
            
            return client;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Client findByMail(String mail) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Client.findMail");
        query.setParameter("cMail", mail);
        
        try {
            if(query.getSingleResult() != null){}
            
            Client client = (Client) query.getSingleResult();
            
            return client;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Client findById(int id) {
        EntityManager em = emf.createEntityManager();
        Client client = em.find(Client.class, id);
        if(client != null){
                return client;
        }
        return null;
    }

    @Override
    public boolean updatClient(Client client) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.merge(client);
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
    public List<Client> findByIds(int id) {
        /*EntityManager em = emf.createEntityManager();

        Query query =  em.createNamedQuery("Plan.findAll" , Plan.class);
        result = query.getMaxResults();

        if(result > 0)
        {
                return query.getResultList();
        }*/
        return null;
    }
    
}
