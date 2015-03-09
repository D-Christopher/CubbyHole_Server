<%-- 
    Document   : modifierMdp
    Created on : May 14, 2014, 3:19:24 PM
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
        <form action="/Cubbyhole/Auth/ModifierMdp" method="post">
            <br/>
            <fieldset>
                ${MessageConfirm}
                <legend style="color:#77B5FE">Modification du mot de passe</legend>
                <input name=ModifMdp type=password placeholder="Nouveau mot de passe" required><br><br/>

                <button type="submit" class="btn btn-primary" value="submit">Enregistrer</button>
            
            </fieldset>
	</form>
    </body>
</div>
</html>
