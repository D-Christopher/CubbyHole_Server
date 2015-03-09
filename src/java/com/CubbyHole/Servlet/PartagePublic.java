/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Servlet;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.StockageClientDaoJpa;
import com.CubbyHole.DaoJpa.StockageDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Stockage;
import com.CubbyHole.Entite.Stockageclient;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
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
@WebServlet(name = "PartagePublic", urlPatterns = {"/PartagePublic"})
public class PartagePublic extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PartagePublic</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PartagePublic at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        StockageClientDaoJpa stockageClientDao = new StockageClientDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        StockageDaoJpa stockageDao = new StockageDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        
        Client client = clientDao.findById(Integer.parseInt(request.getParameter("idClient")));
        Stockage stockage = stockageDao.getStockageById(Integer.parseInt(request.getParameter("idStockage")));
        
        
        
        Stockageclient stockageClient = stockageClientDao.findByPartagePublic(stockage, client);
        
        if(stockageClient != null){
            request.setAttribute("AuteurID", client.getClientID());
            request.setAttribute("stockageNom", stockageClient.getStockageID().getNom());
            request.setAttribute("stockageClient", stockageClient);
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/PartagePublic.jsp").forward(request, response);
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
