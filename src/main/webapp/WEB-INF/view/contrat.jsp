<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: 21269
  Date: 3/26/2024
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="navbar.jsp" %>

<c:if test="${not empty valide }">
    <div class= "alert alert-success">
        <c:out value="${valide }"></c:out>
    </div>
</c:if>

<c:if test="${not empty error }">
    <div class= "alert alert-danger">
        <c:out value="${error }"></c:out>
    </div>
</c:if>

<div style="margin: 10rem">

    <table class="table table table-dark table-striped" >
        <thead class="thead">
        <tr>
            <th scope="col">nom programme</th>
            <th scope="col">université</th>
            <th scope="col">diplome</th>
            <th scope="col">duree contrat</th>
            <th scope="col">etat Contrat</th>
            <th scope="col">Demande Financement</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${contrat}" var="contrat">
            <tr class="table-light">
                <td>${contrat.demandeMobilite.programme.nomProgramme}</td>
                <c:choose>
                    <c:when test="${contrat.demandeMobilite.etudiant.diplome.codeDiplome!=contrat.demandeMobilite.programme.diplome.codeDiplome}">
                        <td>${contrat.demandeMobilite.programme.diplome.universite.nomU}</td>
                        <td>${contrat.demandeMobilite.programme.diplome.nomDiplome}</td>
                    </c:when>
                    <c:otherwise>
                        <td>${contrat.demandeMobilite.programme.diplome1.universite.nomU}</td>
                        <td>${contrat.demandeMobilite.programme.diplome1.nomDiplome}</td>
                    </c:otherwise>
                </c:choose>

                <td>${contrat.dureeContrat}</td>
                <td>${contrat.etatContrat}</td>

                <td>
                    <form action="/contrat/${contrat.codeContrat}/demande-financement" method="post">
                        <button type="submit" class="btn btn-link">Demander</button>
                    </form>
                </td>




            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
