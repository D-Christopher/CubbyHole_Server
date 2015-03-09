/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.StockageClientDaoJpa;
import com.CubbyHole.DaoJpa.StockageDaoJpa;
import com.CubbyHole.Entite.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Christopher
 */
@Path("/suprFile")
public class RestSuprFile {
    
    @GET
    @Path("/id-{idClient}-{idStockage}-{nomFichier}")
    public String suprFile(@PathParam("idClient") int idClient, @PathParam("idStockage") int idStockage, @PathParam("nomFichier") String nomFichier) {
        StockageClientDaoJpa stockageClientDao = new StockageClientDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        StockageDaoJpa stockageDao = new StockageDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        
        String filePath = "\\\\win-dsnq5dd7d85\\CubbyHole" + File.separator + idClient + File.separator + nomFichier;
        
        File myFile = new File(filePath);
        
        stockageClientDao.suprBy2Id(stockageDao.getStockageById(idStockage), clientDao.findById(idClient));
        stockageDao.supprById(idStockage);
        
        myFile.delete();
        
        return "ok";
    }
}
