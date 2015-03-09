<%-- 
    Document   : Partage
    Created on : 29 mai 2014, 10:55:36
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="/Cubbyhole/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partage de fichier</title>
        
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
        <h1>Partager ${requestScope.Fichier.nom}</h1>
    
    
    
    <br><a href="/Cubbyhole/Auth/ContactClient">Ajouter un contact</a><br>
    
    <br>${MessageError}
    
    <fieldset>
        <legend>Choisir le ou les utilisateur(s) pour le partage</legend>

        <form action="/Cubbyhole/Auth/Partage" method="post">
            
            <c:forEach items="${requestScope.contacts}" var="p">
                <br><input type="radio" name="contact" value="${p.clientID.clientID}"> ${p.clientID.prenom} ${p.clientID.nom} - ${p.clientID.email} 
                <input type="hidden"  name="fichier"  value="${p.clientID.clientID}">
                <input type="hidden" name="nameFichier" value="${requestScope.Fichier.nom}">
                <input type="hidden" name="idStockage" value="${requestScope.Fichier.stockageID}">
            </c:forEach>
            <br><br><input type="submit" class="btn btn-primary" value="Partager" />
        </form>
    </fieldset>
    
    <fieldset>
        <legend>Utilisateur disposant du fichier</legend>
        <c:forEach items="${requestScope.StockagePartager}" var="c">
            <br>${c.partagerID.prenom} ${c.partagerID.nom} - ${c.partagerID.email} / <a href="SuprPartage?idPartage=${c.stockageClientID}">Supprimer le partage</a><br>
        </c:forEach>
    </fieldset>
    </div>
    </body>
</html>
