<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: 21269
  Date: 3/24/2024
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create demande mobilite</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="navbar.jsp" %>


<div class="container col-md-5">
    <h1>Create New Demande de mobilité</h1>
    <form action="/save-DM" method="post">

        <div class="mb-3">
            <label for="mailEtudiant" class="form-label">Programme : </label>
            <input disabled type="text"
                   class="form-control" id="mailEtudiant" placeholder="ecrire votre email" name="mailEtudiant" value="${programme.libelleProgramme}" required="required">
        </div>

        <div class="mb-3">
            <label for="nomEtudiant" class="form-label">Diplome : </label>
            <input disabled type="text"
                   class="form-control" id="nomEtudiant" placeholder="ecrire votre nom" name="nomEtudiant" value="${programme.libelleDiplome}" required="required">
        </div>

        <div class="mb-3">
            <label for="univ" class="form-label">Universite : </label>
            <input disabled type="text"
                   class="form-control" id="univ" placeholder="ecrire votre nom" name="nomEtudiant" value="${programme.universite}" required="required">
        </div>

        <c:forEach items="${programme.cours}" var="cour">
        <div class="form-check">

                <input class="form-check-input" type="checkbox"name="coursIds" value="${cour.codeCours}" id="flexCheckChecked">
                <label class="form-check-label" for="flexCheckChecked">
                        ${cour.libelleCours}
                </label>

        </div>
        </c:forEach>

        <div>
            <button type="submit" class="btn btn-success mt-5">Save</button>

        </div>
    </form>

</div>


</body>
</html>
