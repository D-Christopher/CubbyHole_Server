/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Dao;

import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Stockage;
import com.CubbyHole.Entite.Stockageclient;
import java.util.List;

/**
 *
 * @author Christopher
 */
public interface StockageClientDao {
    public Stockageclient findById(int id);
    public boolean createStockageClient (Stockageclient stockageClient);
    public List<Stockageclient> findByClient (Client client);
    public List<Stockageclient> findByClientAuteur (Client client);
    public List<Stockageclient> findByClientNotAuteur (Client client);
    public void supprById (int id);
    public void suprBy2Id(Stockage stockage, Client client);
    public List<Stockageclient> findByPartage (Stockage fichier, Client client);
    public Stockageclient findByPartagePublic (Stockage fichier, Client client);
    public Stockageclient findByVerif (Stockage fichier, Client client, Client partager);
}
