/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.PlanDaoJpa;
import com.CubbyHole.Entite.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.security.Key;
import java.text.DateFormat;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author 14722_000
 */
@Path("/client")
public class RestClient {
	
    @GET
        @Path("/mail-{mail}")
	public Response getClientByMail( @PathParam("mail") String mail) {
        
            ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
            Client client  = clientDao.findByMail(mail);
		
		//parse to Json
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(client);
		return Response.status(200).entity(json).build();
        }
    
	/*@GET
        @Path("/mail-{param}")
	public Response getClientByMail(@PathParam("param") String mail) {
        
		ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		Client client  = clientDao.findByMail(mail);
                
		//parse to Json
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(client);
                String output = json;
		return Response.status(200).entity(output).build();
        }*/
        
        
        @GET
        @Path("/id-{param}")
	public Response getClientById(@PathParam("param") int id) {
        
		ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		Client client  = clientDao.findById(id);

		
		//parse to Json
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").setVersion(2.0).create();
		String json = gson.toJson(client);
                String output = json;
		return Response.status(200).entity(output).build();
        }
        
        @POST
 	@Path("/newClient")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String postClient(
            MultivaluedMap<String, String> ClientParams
            ) {
         

        String nom = ClientParams.getFirst("nom");
        String prenom = ClientParams.getFirst("prenom");
        String email = ClientParams.getFirst("email");
        String mdp = ClientParams.getFirst("password");
        
            String mdpCrypt ="";
                String key = "Bar12345Bar12345";
          
          
          try {
              // Create key and cipher

              Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
              Cipher cipher = Cipher.getInstance("AES");

              // encrypt the text
              cipher.init(Cipher.ENCRYPT_MODE, aesKey);
              byte[] encrypted = cipher.doFinal(mdp.getBytes());
              mdpCrypt = new String(encrypted);
              
              
          }catch(Exception e) {
             e.printStackTrace();
          }
        
        
        
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        PlanDaoJpa planDao = new PlanDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        //Création de l'objet Client
            Client client = new Client();  
            client.setNom(nom);
            client.setPrenom(prenom);
            client.setEmail(email);
            client.setMdp(mdpCrypt);
            client.setDateOffreDebut(new Date());
            client.setDateOffreFin(new Date());
            client.setBandePassante(500);
            client.setQuotas(512);
            client.setPlanID(planDao.getPlanById(3));
            client.setEspace(0);
            
            
            //enregistrement du client
            clientDao.createClient(client);

           return "ok";
    }
       
    @GET
        @Path("/{param}-{param2}")
	public Response getClientByMailMdp(@PathParam("param") String mail, @PathParam("param2") String mdp) {
        
		ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
                
                String mdpCrypt ="";
                String key = "Bar12345Bar12345";
          
          
          try {
              // Create key and cipher

              Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
              Cipher cipher = Cipher.getInstance("AES");

              // encrypt the text
              cipher.init(Cipher.ENCRYPT_MODE, aesKey);
              byte[] encrypted = cipher.doFinal(mdp.getBytes());
              mdpCrypt = new String(encrypted);
              
              
          }catch(Exception e) {
             e.printStackTrace();
          }
                  
		Client client  = clientDao.findByMailMdp(mail, mdpCrypt);
                 String output = "";
                if(client == null)
                   output = null;
                
                else
                {
                    

		System.out.println(client.getPrenom());
		//parse to Json
		Gson gson = new GsonBuilder().setVersion(2.0).setDateFormat("yyyy-MM-dd").create();
               
		String json = gson.toJson(client);
               output = json;
                }
		return Response.status(200).entity(output).build();
        }
        
        @POST
 	@Path("/UpdateMail")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateMailClient(
            MultivaluedMap<String, String> ClientParams
            ) {

        String mail = ClientParams.getFirst("mail");
        int idClient = Integer.parseInt(ClientParams.getFirst("id"));
System.out.println("idClient = "+idClient+" mail  ="+mail);
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
     
            Client client  = clientDao.findById(idClient);
            client.setEmail(mail);

            //Update du client
            clientDao.updatClient(client);

           return "ok";
    }
    
       @POST
 	@Path("/UpdatePassword")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePasswordClient(
            MultivaluedMap<String, String> ClientParams
            ) {

        String password = ClientParams.getFirst("password");
        int idClient = Integer.parseInt(ClientParams.getFirst("id"));
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
     
        
        
            String mdpCrypt ="";
                String key = "Bar12345Bar12345";
          
          
          try {
              // Create key and cipher

              Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
              Cipher cipher = Cipher.getInstance("AES");

              // encrypt the text
              cipher.init(Cipher.ENCRYPT_MODE, aesKey);
              byte[] encrypted = cipher.doFinal(password.getBytes());
              mdpCrypt = new String(encrypted);
              
              
          }catch(Exception e) {
             e.printStackTrace();
          }
        
        
            Client client  = clientDao.findById(idClient);
            client.setMdp(mdpCrypt);

            //Update du client
            clientDao.updatClient(client);

           return "ok";
    }
        
}
