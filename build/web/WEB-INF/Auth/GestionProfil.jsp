<%-- 
    Document   : GestionProfil
    Created on : May 13, 2014, 6:17:43 PM
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        
        <link href="/Cubbyhole/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
       
        <h2>Gestion du Profil</h2>
        
        <fieldset>
            <legend>Client</legend>
            <u>Prenom :</u> <i>${Client.prenom}</i>
            <br/><u>Nom :</u> <i>${Client.nom}</i>
                <br/><u>Email :</u> <i>${Client.email}</i>
            <br/><br/><a href="/Cubbyhole/Auth/ModifierMdp">Modifier le mot de passe</a> / <a href="/Cubbyhole/Auth/ModifierMail">Modifier l'adresse email</a>
        </fieldset>
        </div>
            <div class="well">
        <fieldset>
            <legend>Offre</legend>
            <u>Titre :</u> <i>${Plan.titre}</i>
            <br/><u>Durée :</u><i> ${Plan.duree}</i>  ->  <u>Restant :</u> <i>${Plan.duree}</i>
            <br/><u>Espace de stockage :</u><i> ${Plan.espaceStockage}</i> Mo  ->  <u>Restant :</u> <i>${Plan.espaceStockage}</i> Mo
            <br/><u>Quotas quotidient :</u><i> ${Plan.quotasQuotidient}</i> Mo - <u>Restant :</u> <i>${Client.quotas}</i> Mo
            <br/><u>Bande passante :</u> <i>${Plan.bandePassante}</i> Kb/s - <u>Restant :</u> <i>${Client.bandePassante}</i> Kb/s
            <br/><u>Date de souscription :</u> <i>${Client.dateOffreDebut}</i> - <u>Date de fin :</u> <i>${Client.dateOffreFin}</i>
            <br/><br/><a href="/Cubbyhole/Auth/Plan">Souscrire à une nouvelle offre</a>
        </fieldset>
</div>
</body>
</html>
