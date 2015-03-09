/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Dao;

import com.CubbyHole.Entite.Stockage;

/**
 *
 * @author Christopher
 */
public interface StockageDao {
    public boolean createStockage(Stockage stockage);
    public Stockage getStockageById(int id);
    public void supprById (int id);
}
