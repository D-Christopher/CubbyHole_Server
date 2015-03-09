<%-- 
    Document   : Accueil
    Created on : May 12, 2014, 7:48:19 PM
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
      <head>
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
        <link href="/Cubbyhole/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Accueil</title>
        
        <div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
            <li class="logo">
                <a href="/Cubbyhole/Auth/Accueil"><span style="color: #77B5FE">C</span>ubby<span style="color: #77B5FE">H</span>ole</a>
            </li>
        </ul>

        <div class="container">
            <ul class="nav pull-right">
                <ul class="nav">
		<li class="button">
		<a href="/Cubbyhole/Auth/Plan">Offres</a>
		</li>
		<li class="button">
		<a href="/Cubbyhole/Auth/ContactClient">Mes contacts</a>
		</li>
		<li class="button">
		<a href="/Cubbyhole/Auth/GestionProfil">Gestion du profil</a>
		</li>
                <li class="divider-vertical"></li>
		<li class="button">		
		<a href="/Cubbyhole/Deconnexion">Deconnexion</a>
		</li>
		</ul>
            </ul>
            </div>
		</div>
        </div>
   
    </head>
    <body>
        <div class="well">
            <h1>Bonjour ${sessionScope.ClientPrenom}</h1>
            Offre : ${sessionScope.ClientOffre}
            <br>Quotas quotidient restant : ${(sessionScope.ClientQuotas)} Mo ${messageQuotas}
            <br>Espace utilisé : ${sessionScope.ClientEspace} Mo - Restant : ${(sessionScope.Plan.espaceStockage - sessionScope.ClientEspace)} Mo
            <br><a href="Accueil">Rafraichir la page</a>
            <div>
                <fieldset>
                    <legend style="color:#77B5FE">Explorateur de fichier - ${requestScope["nbFichier"]}</legend>
                    <form action="" enctype="multipart/form-data" method="post">
                        <input type="file" name="file" />
                        <br><input class="btn btn-primary" type="submit" value="Upload" />
                    </form>
                    <div>
                        <fieldset>
                            <legend style="color:#77B5FE">Mes fichiers</legend>
                            <table class="table table-striped table-bordered" style="width: 1250px">
        <thead>
        <style>
            .hideextra { white-space: nowrap; overflow: hidden; text-overflow:ellipsis; }
        </style>

        <tr>
            <th>Nom du Fichier</th>                                                                                             <!-- Titre des colonnes -->
            <th>Date d'ajout</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>  
            <c:forEach items="${requestScope.stockageClientsAuteur}" var="s">
               <tr>
                    <td><div style="width:75px; height : 40px">${s.stockageID.nom}</div></td>
                    <td>${s.stockageID.date} </td>
                    <td><a href="Partage?idFichier=${s.stockageID.stockageID}">Partager</a> </td>
                    <td><a href="FileDownload?nomFichier=${s.stockageID.nom}&idClient=${sessionScope.ClientId}">Télécharger</a> </td>
                    <td><a href="FileSupr?nom=${s.stockageID.nom}&id=${s.stockageID.stockageID}">Supprimer</a></td>
                    <td><a href="http://192.168.2.110:8080/Cubbyhole/PartagePublic?idStockage=${s.stockageID.stockageID}&idClient=${sessionScope.ClientId}">Générer un lien publique</a></td>
            </tr>
            <!--
           ${s.stockageID.nom} - ${s.stockageID.date} 
           / <a href="Partage?idFichier=${s.stockageID.stockageID}">Partage</a> 
           / <a href="FileDownload?nomFichier=${s.stockageID.nom}&idClient=${sessionScope.ClientId}">Télécharger</a> 
           / <a href="FileSupr?nom=${s.stockageID.nom}&id=${s.stockageID.stockageID}">Supprimer</a> 
           / <a href="http://localhost:8080/Cubbyhole/PartagePublic?idStockage=${s.stockageID.stockageID}&idClient=${sessionScope.ClientId}">Générer un lien public</a><br>
           --> 
            </c:forEach>
                        </fieldset>
                    </div>
                                
                                </tbody>
        </table>
                    <br><br><fieldset >
                        <legend style="color:#77B5FE">Fichiers partagés avec moi</legend>
                        
                        <table class="table table-striped table-bordered" style="width: 1250px">
                            <thead>
        <tr>
            <th>Nom du Fichier</th>                                                                                             <!-- Titre des colonnes -->
            <th>Date d'ajout</th>
            <th>Propriétaire du Fichier</th>
            <th></th>
        </tr>
        </thead>

        <tbody>  
             <c:forEach items="${requestScope.stockageClientsNotAuteur}" var="s">
               <tr>
                  <td><div style="width:75px; height : 40px">${s.stockageID.nom}</div></td>
                  <td>${s.stockageID.date}</td>
                  <td>${s.clientID.prenom} ${s.clientID.nom}</td>
                  <td><a href="FileDownload?nomFichier=${s.stockageID.nom}&idClient=${s.clientID.clientID}">Télécharger</a></td>
                </tr>
            <!--
                            ${s.stockageID.nom} - ${s.stockageID.date} - Appartient à ${s.clientID.prenom} ${s.clientID.nom} / <a href="FileDownload?nomFichier=${s.stockageID.nom}&idClient=${s.clientID.clientID}">Télécharger</a><br>
             -->           
                        </c:forEach>
              </tbody>
        </table>
                    </fieldset>

                </fieldset>
            </div>
        </div>   
    </body>
</html>
