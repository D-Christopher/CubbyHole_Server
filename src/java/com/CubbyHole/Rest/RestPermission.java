/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;


import com.CubbyHole.DaoJpa.PermissionDaoJpa;
import com.CubbyHole.Entite.Permission;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
@Path("/Permission")
public class RestPermission {
    
        @GET
        @Path("/id-{param}")
	public Response getPermissionByID(@PathParam("param") int id) {
            
            
                PermissionDaoJpa permissionDao = new PermissionDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		Permission  permission  = permissionDao.findById(id);
                //parse to Json
		Gson gson = new GsonBuilder().setVersion(2.0).create();
		String json = gson.toJson(permission);
                String output = json;
		return Response.status(200).entity(output).build();
        }
        
        
           @POST
 	@Path("/newPermission")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String postPlan(
            MultivaluedMap<String, String> permissionParams
            ) {
         
        //recupération du json
        String titre = permissionParams.getFirst("titre");
       
        
        
        PermissionDaoJpa permissionDao = new PermissionDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        
        //Création de l'objet Plan
        Permission permission= new Permission();
        permission.setTitre(titre);
        
        //enregistremen du plan en bdd
        permissionDao.createPermission(permission);
        
        return "ok";
    
}
    
}
