/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Servlet;

import com.CubbyHole.DaoJpa.ClientDaoJpa;
import com.CubbyHole.DaoJpa.PermissionDaoJpa;
import com.CubbyHole.DaoJpa.StockageClientDaoJpa;
import com.CubbyHole.DaoJpa.StockageDaoJpa;
import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Stockage;
import com.CubbyHole.Entite.Stockageclient;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Christopher
 */
@WebServlet(name = "Accueil", urlPatterns = {"/Auth/Accueil"})
public class Accueil extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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
        StockageClientDaoJpa stockageClientDao = new StockageClientDaoJpa((Persistence.createEntityManagerFactory("cubbyholepu")));
        
        Client client = clientDao.findById((int) session.getAttribute("ClientId"));
        
        session.setAttribute("ClientQuotas", client.getQuotas());
        
        //Recuperation de la liste des fichiers
        List<Stockageclient> stockageClientsAuteur = stockageClientDao.findByClientAuteur(clientDao.findById((int)(session.getAttribute("ClientId"))));
        List<Stockageclient> stockageClientsNotAuteur = stockageClientDao.findByClientNotAuteur(clientDao.findById((int)(session.getAttribute("ClientId"))));
                
        if(stockageClientsAuteur != null){
            request.setAttribute("stockageClientsAuteur", stockageClientsAuteur);
        }
        
        if(stockageClientsNotAuteur != null){
            request.setAttribute("stockageClientsNotAuteur", stockageClientsNotAuteur);
        }
        
        //Verifie si le dossier existe sinon le créer
        File directory = new File("\\\\win-dsnq5dd7d85\\CubbyHole" + File.separator + session.getAttribute("ClientId"));
        
        if(directory.exists()){
            File[] subfiles = directory.listFiles();
            request.setAttribute("nbFichier", subfiles.length+" fichier"+(subfiles.length>1?"s":""));
        } else {
            directory.mkdirs();
        }      
                   
        this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/Accueil.jsp").forward(request, response);
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
        
        String UPLOAD_DIRECTORY = "\\\\win-dsnq5dd7d85\\CubbyHole";
        
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        
                        Stockage stockage = new Stockage();
                        Stockageclient stockageClient = new Stockageclient();
                        Client client = clientDao.findById((int) session.getAttribute("ClientId"));
                        
                        int clientEspace = (int) session.getAttribute("ClientEspace");
                        //int clientQuotas = (int) session.getAttribute("ClientQuotas");
                        
                        stockage.setNom(item.getName());
                        stockage.setAdresse(name);
                        stockage.setDate(new Date());
                        
                        stockageDao.createStockage(stockage);
                        
                        stockageClient.setClientID(client);
                        stockageClient.setPermissionID(permissionDao.findById(4));
                        stockageClient.setStockageID(stockage);
                        stockageClient.setPartagerID(client);
                        stockageClient.setAuteur(true);
                        
                        stockageClientDao.createStockageClient(stockageClient);
                        
                        File file = new File(UPLOAD_DIRECTORY + File.separator + session.getAttribute("ClientId") + File.separator + name);
                        item.write(file);

                        clientEspace += ((file.length()/1024)/1024);
                        //clientQuotas -= ((file.length()/1024)/1024);

                        session.setAttribute("ClientEspace", clientEspace);
                        //session.setAttribute("ClientQuotas", clientQuotas);

                        client.setEspace(clientEspace);
                        //client.setQuotas(clientQuotas);
                        clientDao.updatClient(client);
                    }
                }
           
            } catch (Exception ex) {
            }          
         
        }
        
        doGet(request,response);
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
