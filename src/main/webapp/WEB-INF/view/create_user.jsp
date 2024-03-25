<%@ page import="java.time.Year" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container col-md-5">
		<h1>Create New User</h1>
		<form action="/save" method="post">

			<div class="mb-3">
				<label for="mailEtudiant" class="form-label">email : </label>
				<input type="text"
					class="form-control" id="mailEtudiant" placeholder="ecrire votre email" name="mailEtudiant" required="required">
			</div>

			<div class="mb-3">
				<label for="prenomEtudiant" class="form-label">prenom</label>
				<input type="text"
					   class="form-control" id="prenomEtudiant" placeholder="ecrire votre prenom" name="prenomEtudiant" required="required">
			</div>

			<div class="mb-3">
				<label for="nomEtudiant" class="form-label">nom</label>
				<input type="text"
					   class="form-control" id="nomEtudiant" placeholder="ecrire votre nom" name="nomEtudiant" required="required">
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Password</label> 
				<input
					type="password" class="form-control" id="password"
					placeholder="Type user password" name="password">
			</div>
			<div>
				<label>Select Your Diplome</label>
				<select class="form-control" name="diplome">
					<option value="">-- Select Your Diplome --</option>
					<c:forEach items="${diplomes}" var="diplome">
						<option value="${diplome.codeDiplome}">${diplome.nomDiplome} - ${diplome.niveauDiplome}</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<select class="form-control" name="annee">
					<label>choisi votre anee</label>
					<option>-- Sélectionner une année --</option>
					<%
						int currentYear = Year.now().getValue();
						for (int year = currentYear-5; year <= currentYear + 5; year++) {
					%>
					<option value="<%= year %>"><%= year %></option>
					<% } %>
				</select>
			</div>









			<div>
				<button type="submit" class="btn btn-success mt-5">Save</button>

			</div>
		</form>

	</div>

</body>
</html>