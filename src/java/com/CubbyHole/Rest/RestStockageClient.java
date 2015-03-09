/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.PermissionDaoJpa;
import com.CubbyHole.DaoJpa.StockageClientDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Permission;
import com.CubbyHole.Entite.Stockageclient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
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
@Path("/StockageClient")
public class RestStockageClient {
    /*
           @POST
 	@Path("/newStockageClient")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String postClient(
            MultivaluedMap<String, String> stockageClientParams
            ) {
         

        String clientId = stockageClientParams.getFirst("clientId");
        String StockageId = stockageClientParams.getFirst("StockageId");
        String PermissionId = stockageClientParams.getFirst("PermissionId");
        
        
        Stockageclient stockageClient = new Stockageclient();
        
        stockageClient.setStockageClientID(Integer.parseInt(clientId));
        stockageClient.setStockageID(Integer.parseInt(StockageId));
        stockageClient.setPermissionID(Integer.parseInt(StockageId));
}
*/
    
        @GET
 	@Path("/id-{param}")
    public Response getStockageclientById(@PathParam("param") int id) {
         
StockageClientDaoJpa stockageclientDao = new StockageClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		Stockageclient  stockageClient  = stockageclientDao.findById(id);
                //parse to Json
		Gson gson = new GsonBuilder().setVersion(2.0).create();
		String json = gson.toJson(stockageClient);
                String output = json;
		return Response.status(200).entity(output).build();
}
      @GET
        @Path("/ClientAuteur-{param}")

    public Response getStockageclientByClientAuteur(@PathParam("param") int id) {
         
       ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
       
        Client client = new Client();
       client = clientDao.findById(id);
       StockageClientDaoJpa stockageclientDao = new StockageClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
       List<Stockageclient>  listStockageClient  = stockageclientDao.findByClientAuteur(client);
       
        //parse to Json
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	String json = gson.toJson(listStockageClient);
                String output = json;
		return Response.status(200).entity(output).build();
}
    
@GET
@Path("/ClientNotAuteur-{param}")

public Response getStockageclientByClientNotAuteur(@PathParam("param") int id) {

    ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));

    Client client = new Client();
    client = clientDao.findById(id);
    StockageClientDaoJpa stockageclientDao = new StockageClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
    List<Stockageclient>  listStockageClient  = stockageclientDao.findByClientNotAuteur(client);

    //parse to Json
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    String json = gson.toJson(listStockageClient);
    String output = json;
    return Response.status(200).entity(output).build();
}
    
        @GET
 	@Path("/suppid-{param}")
        public String suppStockageclientById(@PathParam("param") int id) {
         
                StockageClientDaoJpa stockageclientDao = new StockageClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		stockageclientDao.supprById(id);
                return "ok";
}
    
}