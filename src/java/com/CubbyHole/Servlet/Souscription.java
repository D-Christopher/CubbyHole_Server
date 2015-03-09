/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Servlet;

import com.CubbyHole.DaoJpa.PlanDaoJpa;
import com.CubbyHole.Entite.Plan;
import java.io.IOException;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Christopher
 */
@WebServlet(name = "Souscription", urlPatterns = {"/Auth/Souscription"})
public class Souscription extends HttpServlet {

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
        //Recherche de l'offre par l'id passé dans l'url
        int idPlan = Integer.parseInt(request.getParameter("id"));
        PlanDaoJpa planDao = new PlanDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        Plan plan = planDao.getPlanById(idPlan);
        
        //Si Id plan n'existe pas, retour page Offre
        if (plan == null)
        response.sendRedirect("/Cubbyhole/Auth/Plan");
        
        //Sinon redirection sur l'offre sélectionné
        else{
            request.setAttribute("Plan", plan);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Souscription.jsp").forward(request, response);
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
