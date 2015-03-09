/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Servlet;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Plan;
import java.io.IOException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
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
@WebServlet(name = "Connexion", urlPatterns = {"/Connexion"})
public class Connexion extends HttpServlet {

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
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        
        String mdp = request.getParameter("Mdp");
        String mail = request.getParameter("Email");
        String key = "Bar12345Bar12345";
        
        try {
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(mdp.getBytes());
            mdp = new String(encrypted);
        }catch(Exception e) {
           e.printStackTrace();
        }
        
        Client client = clientDao.findByMailMdp(mail, mdp);
        
        
        if(client == null){
            request.setAttribute("MessErrorConnexion", "Email ou mot de passe non valide !");
            this.getServletContext().getRequestDispatcher("/WEB-INF/ConnexionInscription.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            Plan plan = client.getPlanID();
            session.setAttribute("Plan", plan);
            session.setAttribute("ClientId", client.getClientID());
            session.setAttribute("ClientPrenom", client.getPrenom());
            session.setAttribute("ClientOffre", client.getPlanID().getTitre());
            session.setAttribute("ClientQuotas", client.getQuotas());
            session.setAttribute("ClientEspace", client.getEspace());

            response.sendRedirect("/Cubbyhole/Auth/Accueil");
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
