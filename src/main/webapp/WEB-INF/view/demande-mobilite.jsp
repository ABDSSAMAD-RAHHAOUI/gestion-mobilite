<%--
  Created by IntelliJ IDEA.
  User: 21269
  Date: 3/25/2024
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="navbar.jsp" %>

<div style="margin: 10rem">

    <table class="table table table-dark table-striped" >
        <thead class="thead">
        <tr>
            <th scope="col">nom programme</th>
            <th scope="col">université</th>
            <th scope="col">diplome</th>
            <th scope="col">etat demande</th>
            <th scope="col">cours</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${demandeM}" var="demandeM">
            <tr class="table-light">
                <td>${demandeM.demandeMobilite.programme.nomProgramme}</td>

                <c:choose>
                    <c:when test="${demandeM.demandeMobilite.etudiant.diplome.codeDiplome!=demandeM.demandeMobilite.programme.diplome.codeDiplome}">
                        <td>${demandeM.demandeMobilite.programme.diplome.universite.nomU}</td>
                        <td>${demandeM.demandeMobilite.programme.diplome.nomDiplome}</td>
                    </c:when>
                    <c:otherwise>
                        <td>${demandeM.demandeMobilite.programme.diplome1.universite.nomU}</td>
                        <td>${demandeM.demandeMobilite.programme.diplome1.nomDiplome}</td>
                    </c:otherwise>
                </c:choose>
                <td>${demandeM.demandeMobilite.etatDemandeM}</td>
                <td>
                    <c:forEach items="${demandeM.cours}" var="cours">
                        ${cours.libelleCours}
                        <br>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
