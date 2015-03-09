/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Dao;

import com.CubbyHole.Entite.Plan;
import java.util.List;

/**
 *
 * @author Christopher
 */
public interface PlanDao {
    public boolean createPlan(Plan plan);
    public Plan getPlanById(int id);
    public List<Plan>getAllPlan();
}
