<%-- 
    Document   : ModifierMail
    Created on : May 14, 2014, 4:36:19 PM
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/Cubbyhole/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Modification du mail</title>
        
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
        <form action="/Cubbyhole/Auth/ModifierMail" method="post">
            <legend style="color:#77B5FE">Modification de l'adresse email</legend>
            <fieldset>
                ${MessageConfirm}
                
                <input name=ModifEmail  placeholder="Nouvelle adresse" required><br>
<br/>
                <button type="submit" value="submit" class="btn btn-primary">Enregistrer</button>
            
            </fieldset>
	</form>
</div>
    </body>
</html>
