/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.DaoJpa;

import com.CubbyHole.Dao.PermissionDao;
import com.CubbyHole.Entite.Permission;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Christopher
 */
public class PermissionDaoJpa implements PermissionDao{
    private EntityManagerFactory emf;
	
    public PermissionDaoJpa (EntityManagerFactory emf) {
            // TODO Auto-generated constructor stub
            this.emf = emf;
    }

    @Override
    public Permission findById(int id) {
        EntityManager em = emf.createEntityManager();
        Permission permision = em.find(Permission.class, id);
        
        if(permision != null){
                return permision;
        }
        return null;
    }

    @Override
    public boolean createPermission(Permission permission) {
        EntityManager em = emf.createEntityManager();
    	EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.persist(permission);
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
    
}
