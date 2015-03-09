<%-- 
    Document   : Contact
    Created on : May 14, 2014, 5:03:31 PM
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/Cubbyhole/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
        <!-- Navbar -->
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
        <h1>Contact</h1><br/>
       
        
        <form action="/Cubbyhole/Auth/ContactClient" method="post" style="margin-left:70px">
            <fieldset>
                <legend>Rechercher un contact</legend>
                <p>${MessErrorContact}</p>
                <input name=Email type=text placeholder="Adresse email du contact" required><br/><br/>

                <button type="submit" value="submit" class="btn btn-primary" style="width:100px">Rechercher</button>
            </fieldset>
	</form>
                
        <c:if test="${!empty Contact}" >
            <form action="/Cubbyhole/Auth/ContactClient" method="post">
                <fieldset style="margin-left:70px">
                    <legend >Contact trouvé</legend>
                    <span style="color:#77B5FE">${Contact.prenom} ${Contact.nom}</span>
                    <br><br/>Compte : ${Contact.planID.titre}
                    <input type="hidden"  name="ContactId"  value="${Contact.clientID}">
                    <br/><br/><button type="submit" value="submit" class="btn  btn-primary">Ajouter</button>
                </fieldset>
            </form>
        </c:if>
                
        <c:forEach items="${requestScope.contacts}" var="p">
            <form action="/Cubbyhole/Auth/ContactClient" method="post">
                <fieldset style="margin-left:70px">
                    <legend style="color:#77B5FE">${p.clientID.prenom} ${p.clientID.nom}</legend>
                    <input type="hidden"  name="SupprId"  value="${p.contactID}">
                    <input type="hidden"  name="ClientContact"  value="${p.clientID.clientID}">
                    Email : ${p.clientID.email}
                    <br>offre : ${p.clientID.planID.titre}
                    <br><button type="submit" value="submit" class="btn btn-danger">Supprimer le contact</button>
                </fieldset>
            </form>
        </c:forEach>
</div>
    </body>
</html>
