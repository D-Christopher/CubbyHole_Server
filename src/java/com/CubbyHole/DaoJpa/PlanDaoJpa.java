/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.DaoJpa;

import com.CubbyHole.Dao.PlanDao;
import com.CubbyHole.Entite.Plan;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Christopher
 */
public class PlanDaoJpa implements PlanDao{
    private final EntityManagerFactory emf;
    
    public PlanDaoJpa (EntityManagerFactory emf) {
            // TODO Auto-generated constructor stub
            this.emf = emf;
    }

    @Override
    public boolean createPlan(Plan plan) {
        EntityManager em = emf.createEntityManager();
    	EntityTransaction t = em.getTransaction();
    	try {
    		t.begin();
    		em.persist(plan);
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
    public Plan getPlanById(int id) {
        EntityManager em = emf.createEntityManager();
        Plan plan = em.find(Plan.class, id);
        if(plan != null){
                return plan;
        }
        return null;
    }

    @Override
    public List<Plan> getAllPlan() {
        EntityManager em = emf.createEntityManager();
        int result = 0;

        TypedQuery<Plan> query =  em.createNamedQuery("Plan.findAll" , Plan.class);
        result = query.getMaxResults();

        if(result > 0)
        {
                return query.getResultList();
        }
        return null;
    }
    
}
