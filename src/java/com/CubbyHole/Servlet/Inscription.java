/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Servlet;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.PlanDaoJpa;
import com.CubbyHole.DaoJpa.StockageDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Stockage;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    @SuppressWarnings("null")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        PlanDaoJpa planDao = new PlanDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        
        String Email = request.getParameter("Email");
        Client client = clientDao.findByMail(Email);
        
        if(client != null){
            request.setAttribute("MessErrorInscription", "Email deja existant");
            this.getServletContext().getRequestDispatcher("/WEB-INF/ConnexionInscription.jsp").forward(request, response);
        } else {
            String mdpCrypt = null;
            String mdp = request.getParameter("Mdp");
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
            
            HttpSession session = request.getSession();
            
            Client client2 = new Client();
            
            client2.setNom(request.getParameter("Nom"));
            client2.setPrenom(request.getParameter("Prenom"));
            client2.setEmail(Email);
            client2.setMdp(mdpCrypt);
            client2.setDateOffreDebut(new Date());
            client2.setDateOffreFin(new Date());
            client2.setBandePassante(500);
            client2.setQuotas(512);
            client2.setPlanID(planDao.getPlanById(3));

            clientDao.createClient(client2);
            
            session.setAttribute("ClientId", client2.getClientID());
            session.setAttribute("ClientPrenom", client2.getPrenom());
            //session.setAttribute("ClientOffre", client.getPlanID().getTitre());

            request.setAttribute("MessErrorInscription", "Inscription effectuée !");
            this.getServletContext().getRequestDispatcher("/WEB-INF/ConnexionInscription.jsp").forward(request, response);
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
