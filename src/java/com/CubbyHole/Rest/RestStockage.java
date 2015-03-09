/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.StockageDaoJpa;
import com.CubbyHole.Entite.Stockage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import javax.persistence.Persistence;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author 14722_000
 */
@Path("/Stockage")
public class RestStockage {
    
        @GET
 	@Path("/id-{param}")
        public Response getStockageById(@PathParam("param") int id) {
            
            StockageDaoJpa stockageDao = new StockageDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
            Stockage stockage = new Stockage();
            stockage = stockageDao.getStockageById(id);
            Gson gson = new GsonBuilder().setVersion(2.0).create();
                String json = gson.toJson(stockage);
                String output = json;
		return Response.status(200).entity(output).build();
                
        }
        
            @POST
 	@Path("/newStockage")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String postStockage(
            MultivaluedMap<String, String> stockageParams
            ) {
         

        String adresse = stockageParams.getFirst("adresse");
        
         StockageDaoJpa stockageDao = new StockageDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
            Stockage stockage = new Stockage();
            stockage.setAdresse(adresse);
            Date date = new Date();
            stockage.setDate(date);
            
            stockageDao.createStockage(stockage);
            
            return "ok";
            
    }
    
     @GET
 	@Path("/suppid-{param}")
        public String suppStockageById(@PathParam("param") int id) {
         
                StockageDaoJpa stockageDao = new StockageDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		stockageDao.supprById(id);
                return "ok";
}
        
        
    }
        
        
      
         
    

