<%-- 
    Document   : ConnexionInscription
    Created on : May 12, 2014, 2:48:20 PM
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
                <a href="/Cubbyhole/ConnexionInscription"><span style="color: #77B5FE">C</span>ubby<span style="color: #77B5FE">H</span>ole</a>
            </li>
        </ul>

        <div class="container">
            <ul class="nav pull-right">
                <ul class="nav">

		</ul>
            </ul>
            </div>
		</div>
        </div>
       
    </head>
    <body>
        <div class="well" >
             <h1>Connexion / Inscription</h1>
        <br/>
        <form action="/Cubbyhole/Connexion" method="post" style="margin-left:50px">
            
            <fieldset>
                <legend>Connexion</legend>
                <p>${MessErrorConnexion}</p>
                <input name=Email type=text placeholder="Email" required><br>
                <input name=Mdp type=password placeholder="Mot de passe" required><br><br/>

                <button type="submit" class="btn btn-primary" value="submit">Connexion</button>
            
            </fieldset>
	</form>
        
        <form action="/Cubbyhole/Inscription" method="post" style="margin-left:50px">
            
            <fieldset>
                <legend>Inscription</legend>
                <p>${MessErrorInscription}</p>
                <input name=Prenom type=text placeholder="Prénom" required><br>
                <input name=Nom type=text placeholder="Nom" required><br>
                <input name=Email type=text placeholder="Email" required><br>
                <input name=Mdp type=password placeholder="Mot de passe" required><br><br/>

                <button type="submit" class="btn btn-primary" value="submit">Inscription</button>
            
            </fieldset>
	</form>
</div>
    </body>
</html>
