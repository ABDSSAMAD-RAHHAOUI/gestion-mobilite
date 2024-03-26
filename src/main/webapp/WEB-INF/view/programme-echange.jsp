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
    <title>programme-echange</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="navbar.jsp" %>
<table class="table" align="center">
    <thead class="thead">
    <tr>
        <th scope="col">nom programme</th>
        <th scope="col">université</th>
        <th scope="col">diplome</th>
        <th scope="col">cours</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${programmes}" var="programme">
        <tr>
            <td>${programme.libelleProgramme}</td>
            <td>${programme.universite}</td>
            <td>${programme.libelleDiplome}</td>
            <td>
                <c:forEach items="${programme.cours}" var="cour">
                    ${cour.libelleCours}<br>
                </c:forEach>
            </td>
            <td><a href="/create-DM?programId=${programme.codeProgramme}">Demande mobilité</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
