/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Dao;

import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Contact;
import java.util.List;

/**
 *
 * @author Christopher
 */
public interface ContactDao {
    public boolean createContact(Contact contact, Contact contact2);
    public List<Contact> findByClientId(int id);
    public Contact findById(int id);
    public void supprById (int id);
    public void suprBy2Id(int id, Client idClient);
    public boolean findBy2Id (int id, Client idClient);
}
