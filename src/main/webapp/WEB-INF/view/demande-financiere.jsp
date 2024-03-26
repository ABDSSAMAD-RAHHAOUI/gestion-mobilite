<%--
  Created by IntelliJ IDEA.
  User: 21269
  Date: 3/26/2024
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="navbar.jsp" %>
<div style="margin: 7rem">

    <table class="table table table-dark table-striped" >
        <thead class="thead">
        <tr>
            <th scope="col">nom programme</th>
            <th scope="col">université</th>
            <th scope="col">diplome</th>
            <th scope="col">montant</th>
            <th scope="col">Etat de demande</th>
            <th scope="col">Date depot de demande</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${demandeF}" var="demandeF">
            <tr class="table-light">
                <td>${demandeF.contrat.demandeMobilite.programme.nomProgramme}</td>
                <c:choose>
                    <c:when test="${demandeF.contrat.demandeMobilite.etudiant.diplome.codeDiplome!=demandeF.contrat.demandeMobilite.programme.diplome.codeDiplome}">
                        <td>${demandeF.contrat.demandeMobilite.programme.diplome.universite.nomU}</td>
                        <td>${demandeF.contrat.demandeMobilite.programme.diplome.nomDiplome}</td>
                    </c:when>
                    <c:otherwise>
                        <td>${demandeF.contrat.demandeMobilite.programme.diplome1.universite.nomU}</td>
                        <td>${demandeF.contrat.demandeMobilite.programme.diplome1.nomDiplome}</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${demandeF.montantDemandeF==0}">
                        <td>non specifier</td>
                    </c:when>
                    <c:otherwise>
                        <td>${demandeF.montantDemandeF}</td>
                    </c:otherwise>
                </c:choose>

                <td>${demandeF.etatDemandeF}</td>
                <td>${demandeF.dateDepotDemandeF}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
