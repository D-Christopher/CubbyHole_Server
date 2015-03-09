/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Dao;

import com.CubbyHole.Entite.Client;
import java.util.List;

/**
 *
 * @author Christopher
 */
public interface ClientDao {
    public boolean createClient(Client stockage);
    public Client findByMailMdp(String mail, String Mdp);
    public Client findByMail(String mail);
    public Client findById(int id);
    public List<Client> findByIds(int id);
    public boolean updatClient (Client client);
}
