<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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

<div class="container col-md-5">
    <h1>User Login</h1>
    <form action="/login" method="post">



        <div class="mb-3">
            <label for="mail" class="form-label">mail</label>
            <input
                    type="text" class="form-control" id="mail"
                    placeholder="entrer votre email" name="mail" required="required">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input
                    type="password" class="form-control" id="password" name="password"
                    placeholder="entrer votre mdp" required="required">
        </div>

        <div>
            <button type="submit" class="btn btn-success">Login</button>

        </div>
        <a href="/create" >Dont have account? create user</a>


    </form>

</div>
</body>
</html>
