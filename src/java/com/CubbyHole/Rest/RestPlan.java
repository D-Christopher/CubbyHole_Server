/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.PlanDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Plan;
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
@Path("/Plan")
public class RestPlan {
    
       @GET
       @Path("/id-{param}")
	public Response getPlanById(@PathParam("param") int id) {
            
            
                PlanDaoJpa planDao = new PlanDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		Plan plan  = planDao.getPlanById(id);

		
		//parse to Json
		Gson gson = new GsonBuilder().setVersion(2.0).create();
		String json = gson.toJson(plan);
                String output = json;
		return Response.status(200).entity(output).build();
        }
        
        
         @GET
       @Path("/all")
	public Response getAllPlan() {
            
            
                PlanDaoJpa planDao = new PlanDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		List<Plan> listPlan  = planDao.getAllPlan();

		
		//parse to Json
		Gson gson = new GsonBuilder().setVersion(2.0).create();
		String json = gson.toJson(listPlan);
                String output = json;
		return Response.status(200).entity(output).build();
        }
        
        
        
        
           @POST
 	@Path("/newPlan")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String postPlan(
            MultivaluedMap<String, String> planParams
            ) {
         
        //recupération du json
        String titre = planParams.getFirst("titre");
        String description = planParams.getFirst("description");
        String prix = planParams.getFirst("prix");
        String duree = planParams.getFirst("duree");
        String espaceStockage = planParams.getFirst("espaceStockage");
        String quotasQuotidient = planParams.getFirst("quotasQuotidient");
        String bandePassante = planParams.getFirst("bandePassante");
        
        
        PlanDaoJpa planDao = new PlanDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        
        //Création de l'objet Plan
        Plan plan= new Plan();
        plan.setTitre(titre);
        plan.setDescription(description);
        plan.setPrix(Integer.parseInt(prix));
        plan.setDuree(Integer.parseInt(duree));
        plan.setEspaceStockage(Integer.parseInt(espaceStockage));
        plan.setQuotasQuotidient(Integer.parseInt(quotasQuotidient));
        plan.setBandePassante(Integer.parseInt(bandePassante));
        
        //enregistremen du plan en bdd
        planDao.createPlan(plan);
        
        return "ok";
    
}
}
