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
import com.CubbyHole.Entite.Stockageclient;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "FileSupr", urlPatterns = {"/Auth/FileSupr"})
public class FileSupr extends HttpServlet {

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
            out.println("<title>Servlet FileSupr</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileSupr at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        StockageClientDaoJpa stockageClientDao = new StockageClientDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        StockageDaoJpa stockageDao = new StockageDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        
        String NomFichier = request.getParameter("nom");
        int idStockage = Integer.parseInt(request.getParameter("id"));
        int clientEspace = (int) session.getAttribute("ClientEspace");
        
        String filePath = "\\\\win-dsnq5dd7d85\\CubbyHole" + File.separator + session.getAttribute("ClientId") + File.separator + NomFichier;
        
        Client client = clientDao.findById((int) session.getAttribute("ClientId"));
        
        File myFile = new File(filePath);
        
        clientEspace -= ((myFile.length()/1024)/1024);
        
        session.setAttribute("ClientEspace", clientEspace);
        
        stockageClientDao.suprBy2Id(stockageDao.getStockageById(idStockage), clientDao.findById((int)(session.getAttribute("ClientId"))));
        stockageDao.supprById(idStockage);
        
        client.setEspace(clientEspace);
        clientDao.updatClient(client);
        
        myFile.delete();
        
        response.sendRedirect("/Cubbyhole/Auth/Accueil");
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
