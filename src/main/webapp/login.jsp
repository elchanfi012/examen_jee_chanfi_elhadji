<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Connexion</title>
	<%@ include file="include/stylesheets.jsp" %>
</head>
<body>
	<main>
		<section class="container-fluid">
			<div class="row h100vh">
				<div class="col-md-4 mx-auto my-auto">
					<div class="card">
						<h1 class="card-header text-center">Connexion</h1>
						
						<form class="card-body" method="post">
							<div class="mb-4">
								<label class="form-label" for="username"> Nom d'utilisateur :</label>
								<input type="text" class="form-control" id="username" name="username">
							</div>
							<div class="mb-4">
								<label class="form-label" for="password">Mot de passe :</label>
								<input type="password" class="form-control" id="passwword" name="password">
							</div>
							<div class="d-flex justify-content-end">
								<button type="submit" class="btn btn-primary">Se connecter</button>
							</div>
						</form>
						<c:forEach items="${ requestScope.errors }" var="error">
							<p class="text-danger text-center">Erreur : ${ error }</p>
						</c:forEach>										
					</div>
				</div>
			</div>
		</section>
	</main>
	
	<%@ include file="include/scripts.jsp" %>
</body>
</html>