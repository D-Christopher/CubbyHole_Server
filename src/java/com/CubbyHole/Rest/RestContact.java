/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Rest;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.ContactDaoJpa;
import com.CubbyHole.DaoJpa.PlanDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Contact;
import com.CubbyHole.Entite.Plan;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 14722_000
 */
@Path("/Contact")
public class RestContact {
    
        @GET
        @Path("/id-{param}")
	public Response getContactByID(@PathParam("param") int id) {
            
            
                ContactDaoJpa contactDao = new ContactDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		List<Contact> listContact  = contactDao.findByClientId(id);
                //parse to Json
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(listContact);
                String output = json;
		return Response.status(200).entity(output).build();
        }
        
            @GET
        @Path("/cid-{param}")
	public Response getContactByCId(@PathParam("param") int id) {
            
            
                ContactDaoJpa contactDao = new ContactDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
		Contact contact  = contactDao.findById(id);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(contact);
                String output = json;
		return Response.status(200).entity(output).build();
        }
        
        @GET
        @Path("/SuppById-{param}")
	public String suppById(@PathParam("param") int id) {
             ContactDaoJpa contactDao = new ContactDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
             contactDao.supprById(id);
            return "ok";
        }
        
        @GET
        @Path("/id-{idClient}-{mail}")
        public String NewContact(@PathParam("idClient") int idClient, @PathParam("mail") String mail) {
            ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
            ContactDaoJpa contactDao = new ContactDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
            
            Client client = clientDao.findByMail(mail);
            
            if(client != null){
                if(contactDao.findBy2Id(idClient, clientDao.findById(client.getClientID()))){
                    return "Le contact existe déjà !";
                } else {
                    Contact contact = new Contact();
                    Contact contact2 = new Contact();

                    contact.setClientID(clientDao.findById(idClient));
                    contact.setClientContact(client.getClientID());

                    contact2.setClientID(clientDao.findById(client.getClientID()));
                    contact2.setClientContact(idClient);

                    contactDao.createContact(contact, contact2);
                }
                
                return "Ajout effectué !";
            } else {
                return "Le mail n'existe pas  !";
            } 
        }
}
