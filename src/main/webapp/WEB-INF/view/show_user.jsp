
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	
	<div class="row">
	<a href="/create" >Create new User</a>
				<div class="col-md-8">
					
				</div>
				<div class="col-md-4">
					<form action="/user_search" method="get">
						<div class="input-group mb-3">
							<input type="text" class="form-control" name="searchText"
								placeholder="Search Users" aria-label="Search Users"
								aria-describedby="basic-addon2"> 
								<button id="basic-addon2" class="input-group-text" type="submit">Search</button>								
						</div>
					</form>
				</div>
			</div>
			
			
	<div class="container">
		<h1>User List</h1>
		<table class="table table-responsive table-striped" >
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">username</th>
					<th scope="col">password</th>
					<th scope="col">Gender</th>
					<th scope="col">Skill</th>
					<th scope="col">Location</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="us" items="${data.users}">
					<tr>
						<td>${us.id}</td>
						<td>${us.name}</td>
						<td>${us.username}</td>
						<td>${us.password}</td>
						<td>${us.gender}</td>
						<td>${us.skill}</td>
						<td>${us.location}</td>
						<td><a href="">Edit</a> | <a
							href="">Delete</a></td>
					</tr>


				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>