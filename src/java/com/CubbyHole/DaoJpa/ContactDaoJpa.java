/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.DaoJpa;

import com.CubbyHole.Dao.ContactDao;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Contact;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Christopher
 */
public class ContactDaoJpa implements ContactDao{
    private EntityManagerFactory emf;
	
    public ContactDaoJpa (EntityManagerFactory emf) {
            // TODO Auto-generated constructor stub
            this.emf = emf;
    }

    @Override
    public boolean createContact(Contact contact, Contact contact2) {
        EntityManager em = emf.createEntityManager();
    	EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.persist(contact);
                em.persist(contact2);
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
    public List<Contact> findByClientId(int id) {
        EntityManager em = emf.createEntityManager();

        Query query =  em.createNamedQuery("Contact.findByClientId");
        query.setParameter("cId", id);
        List<Contact> contacts = query.getResultList();

        return contacts;
    }

    @Override
    public void supprById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
    	Contact contact = em.find(Contact.class, id);
        
        t.begin();
        em.remove(contact);
        t.commit();
    }

    @Override
    public Contact findById(int id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Contact.findByClientId");
        query.setParameter("cId", id);
        try {
            if(query.getSingleResult() != null){}
            
            Contact contact = (Contact) query.getSingleResult();
            
            return contact;
        } catch (Exception e) {
            return null;
        }
        
        
        
    }

    @Override
    public void suprBy2Id(int id, Client Client) {
        ContactDaoJpa contactDao = new ContactDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Contact.findBy2Id");
        query.setParameter("clientContact", id);
        query.setParameter("clientID", Client);
        
        Contact contact = (Contact) query.getSingleResult();
            
        contactDao.supprById(contact.getContactID());
    }

    @Override
    public boolean findBy2Id(int id, Client Client) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Contact.findBy2Id");
        query.setParameter("clientContact", id);
        query.setParameter("clientID", Client);
        
        try {
            if(query.getSingleResult() != null){}
            
            return true;
        } catch (Exception e) {
            return false;
        }
    
}
}