/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.PermissionDaoJpa;
import com.CubbyHole.DaoJpa.StockageClientDaoJpa;
import com.CubbyHole.DaoJpa.StockageDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Stockage;
import com.CubbyHole.Entite.Stockageclient;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Christopher
 */
@Path("/partageFile")
public class RestPartageFichier {
    
    @GET
    @Path("/{mailContact}-{idStockage}-{idClient}")
    public String suprFile(@PathParam("mailContact") String mailContact, @PathParam("idStockage") int idStockage, @PathParam("idClient") int idClient) {
        
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        StockageDaoJpa stockageDao = new StockageDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        StockageClientDaoJpa stockageClientDao = new StockageClientDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        PermissionDaoJpa permissionDao = new PermissionDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        
        Stockage fichier = stockageDao.getStockageById(idStockage);
        Client clientActuel = clientDao.findById(idClient);
        Client clientPartage = clientDao.findByMail(mailContact);
        Stockageclient verif = stockageClientDao.findByVerif(fichier, clientActuel, clientPartage);
        
        if(verif != null){
            return "Ce fichier est déjà partager avec ce contact !";
        } else {
            Stockageclient stockageClient = new Stockageclient();

            stockageClient.setClientID(clientActuel);
            stockageClient.setPermissionID(permissionDao.findById(4));
            stockageClient.setStockageID(fichier);
            stockageClient.setPartagerID(clientPartage);
            stockageClient.setAuteur(false);

            stockageClientDao.createStockageClient(stockageClient);

            return "Partage effectué !";
        }
        
        
    }
}
