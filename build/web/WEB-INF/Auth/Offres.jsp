<%-- 
    Document   : Offres
    Created on : 11 mai 2014, 22:52:43
    Author     : 14722_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="/Cubbyhole/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Offres</title>
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
        <h2>Offres</h2><br/>
    <table class="table table-striped table-bordered" style="width: 1250px">
        <thead>
        <style>
            .hideextra { white-space: nowrap; overflow: hidden; text-overflow:ellipsis; }
        </style>

        <tr>
            <th>Offre</th>                                                                                             <!-- Titre des colonnes -->
            <th>Description</th>
            <th>Prix</th>
            <th>Quotas quotidient</th>
            <th></th>
        </tr>
        </thead>

        <tbody>        
    <c:forEach items="${requestScope.plan}" var="p">
        <tr>
            <td><div class="hideextra" style="width:75px; height : 40px">${p.titre}</div></td>
            <td>${p.description}</td>
            <td>${p.prix} €</td>
            
            <td>${p.quotasQuotidient / 1024} Go ( ${p.quotasQuotidient} mo)</td>
            <td><a href="/Cubbyhole/paymentwithpaypal?id=${p.planID}">Souscrire à l'offre</a></td>
            </tr>
    </c:forEach>
        </tbody>
        </table>
                   
</div>
</body>
</html>
