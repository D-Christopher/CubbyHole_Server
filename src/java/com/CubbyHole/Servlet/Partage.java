/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Servlet;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.ContactDaoJpa;
import com.CubbyHole.DaoJpa.PermissionDaoJpa;
import com.CubbyHole.DaoJpa.StockageClientDaoJpa;
import com.CubbyHole.DaoJpa.StockageDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Contact;
import com.CubbyHole.Entite.Stockage;
import com.CubbyHole.Entite.Stockageclient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "Partage", urlPatterns = {"/Auth/Partage"})
public class Partage extends HttpServlet {

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
            out.println("<title>Servlet Partage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Partage at " + request.getContextPath() + "</h1>");
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
        ClientDaoJpa clientDao = new ClientDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        ContactDaoJpa contactDao = new ContactDaoJpa(Persistence.createEntityManagerFactory("cubbyholepu"));
        StockageDaoJpa stockageDao = new StockageDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        StockageClientDaoJpa stockageClientDao = new StockageClientDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        
        Stockage fichier = stockageDao.getStockageById(Integer.parseInt(request.getParameter("idFichier")));
        Client client = clientDao.findById((int) session.getAttribute("ClientId"));
        
        List<Contact> contacts = contactDao.findByClientId((int) session.getAttribute("ClientId"));
        List<Stockageclient> StockagePartager = stockageClientDao.findByPartage(fichier, client);
        
        if(StockagePartager != null && contacts != null){
            request.setAttribute("StockagePartager", StockagePartager);
            request.setAttribute("contacts", contacts);
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Accueil.jsp").forward(request, response);
        }
        
        request.setAttribute("Fichier", fichier);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Partage.jsp").forward(request, response);
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
        StockageDaoJpa stockageDao = new StockageDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        StockageClientDaoJpa stockageClientDao = new StockageClientDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        PermissionDaoJpa permissionDao = new PermissionDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        
        String[] valeurs = request.getParameterValues("contact");
        String idStockage = request.getParameter("idStockage");
        Stockage fichier = stockageDao.getStockageById(Integer.parseInt(idStockage));
        Client clientActuel = clientDao.findById((int) session.getAttribute("ClientId"));
                
        for (int i=0; i < valeurs.length ; i++) {
            Client clientPartage = clientDao.findById(Integer.parseInt(valeurs[i]));
            Stockageclient stockageClient = new Stockageclient();

            stockageClient.setClientID(clientActuel);
            stockageClient.setPermissionID(permissionDao.findById(4));
            stockageClient.setStockageID(fichier);
            stockageClient.setPartagerID(clientPartage);
            stockageClient.setAuteur(false);

            stockageClientDao.createStockageClient(stockageClient);
            
        }
        
        response.sendRedirect("/Cubbyhole/Auth/Accueil");
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
