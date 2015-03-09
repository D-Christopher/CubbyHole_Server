<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/Cubbyhole/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>Paiement Paypal</title>
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
    
<div style="position:absolute; left:40%; top:15%">
	<%
		if (request.getAttribute("redirectURL") != null) {
	%>
        <a class="btn btn-primary" style="color: buttonhighlight" href=<%=(String) request.getAttribute("redirectURL")%>>Effectuer le paiement avec paypal</a>
	<br />
	<%
		}
	%>
	${requestScope.paiement}
    </div>
</body>
</html>