<%-- 
    Document   : Souscription
    Created on : May 12, 2014, 7:47:15 PM
    Author     : 14722_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Souscription</title>
    </head>
    <body>
        <a href="/Cubbyhole/Auth/Plan">Retour aux offres</a>
        
         <div id="Offre" style="border: solid 1px black; width: 20%;margin-left: auto; margin-right: auto;">
            Offre ${Plan.titre}
            </br>
            Description : ${Plan.description}
            <br/>
            Prix : ${Plan.prix} €
            <br/>
            Quotas quotidient : ${Plan.quotasQuotidient / 1024} Go( ${Plan.quotasQuotidient} mo)
            <br/>
            </div>
    </body>
</html>