/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Servlet;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.ContactDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Contact;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christopher
 */
@WebServlet(name = "ContactClient", urlPatterns = {"/Auth/ContactClient"})
public class ContactClient extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ContactDaoJpa contactDao = new ContactDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        
        int ClientId = (int) session.getAttribute("ClientId");
        
        List<Contact> contacts = contactDao.findByClientId(ClientId);
        
        //String testContact = null;
        
        if(contacts != null){
            request.setAttribute("contacts", contacts);
            //this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Contact.jsp").forward(request, response);
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Contact.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        ContactDaoJpa contactDao = new ContactDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        
        //Création de liste des contacts déja existante
        int ClientId = (int) session.getAttribute("ClientId");
        List<Contact> contacts = contactDao.findByClientId(ClientId);
        Client client = clientDao.findByMail(request.getParameter("Email"));
        
        if(contacts != null){
            request.setAttribute("contacts", contacts);
        }        
        
        //Creation des contacts
        if(request.getParameter("ContactId") != null){
            
            
            if(contactDao.findBy2Id((int)(session.getAttribute("ClientId")), clientDao.findById(Integer.parseInt(request.getParameter("ContactId"))))){
                request.setAttribute("MessErrorContact", "La relation existe déjà !");
                this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Contact.jsp").forward(request, response);
            } else {
                Contact contact = new Contact();
                Contact contact2 = new Contact();

                contact.setClientID(clientDao.findById((int)(session.getAttribute("ClientId"))));
                contact.setClientContact(Integer.parseInt(request.getParameter("ContactId")));

                contact2.setClientID(clientDao.findById(Integer.parseInt(request.getParameter("ContactId"))));
                contact2.setClientContact((int)(session.getAttribute("ClientId")));

                contactDao.createContact(contact, contact2);

                doGet(request,response);
            }
        }
        
        //Supprime le contact
        if(request.getParameter("ClientContact") != null){
            //contactDao.supprById(Integer.parseInt(request.getParameter("SupprId")));
            contactDao.suprBy2Id(Integer.parseInt(request.getParameter("ClientContact")), clientDao.findById((int)(session.getAttribute("ClientId"))));
            contactDao.suprBy2Id((int)(session.getAttribute("ClientId")), clientDao.findById(Integer.parseInt(request.getParameter("ClientContact"))));
            doGet(request,response);
        }
        
        //Mauvaise recherche
        if(client == null){
            request.setAttribute("MessErrorContact", "La personne n'existe pas !");
            this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Contact.jsp").forward(request, response);
        } if(client.getClientID() == session.getAttribute("ClientId")){
            request.setAttribute("MessErrorContact", "Evidemment que tu existe !");
            this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Contact.jsp").forward(request, response);
        } else {
            request.setAttribute("Contact", client);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Contact.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
