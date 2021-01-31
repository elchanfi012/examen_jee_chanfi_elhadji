<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Modification d'un utilisateur</title>
	<%@ include file="include/stylesheets.jsp" %>
</head>
<body>
	<%@ include file="include/menu_admin.jsp" %>
	
	<main>
		<section class="container-fluid">
			<div class="row h100vh">
				<div class="col-md-6 mx-auto my-auto">
					<div class="card mt-4">
						<h1 class="card-header text-center">Modifier un utilisateur</h1>
						
						<form class="card-body" method="post" enctype="multipart/form-data">
							<div class="mb-4 form-group">
								<label class="form-label" for="username"> Nom d'utilisateur :</label>
								<input type="text" class="form-control" id="username" name="username" value="${ requestScope.user.username }">
							</div>
							<div class="mb-4 form-group">
								<label class="form-label" for="password">Mot de passe :</label>
								<input type="password" class="form-control" id="passwword" name="password" value="${ requestScope.user.password }">
							</div>
							<div class="mb-4 form-group">
								<label class="form-label" for="lastname"> Nom :</label>
								<input type="text" class="form-control" id="lastname" name="lastname" value="${ requestScope.user.lastname }">
							</div>
							<div class="mb-4 form-group">
								<label class="form-label" for="firstname"> Prénom :</label>
								<input type="text" class="form-control" id="firstname" name="firstname" value="${ requestScope.user.firstname }">
							</div>
							<div class="mb-4 form-group">
								<label for="image">Image</label>
        						<input type="file" accept="image/jpeg" class="form-control" id="image" name="image">
							</div>
							<div class="mb-4 form-group">
								<label class="form-label" for="employed_at"> Date :</label>
								<input type="date" class="form-control" id="employed_at" name="employed_at" value="${ requestScope.user.employed_at }">
							</div>
							<div class="form-group mb-4">
							 	<label class="form-label" for="phone_number"> Numéro de téléphone :</label>
							 		<div class="input-group">
							 			<span class="input-group-text">+33 1 23 45 67 89</span>
										<input type="text" class="form-control" id="phone_number" name="phone_number" value="${ requestScope.user.phone_number }">
							 		</div>  
							</div>
							<div class="mb-3">
								 <c:set var="admin" value="admin"/>
								 <c:set var="user" value="user"/>
							     <label for="role" class="form-label">Rôle</label>
							     <c:if test="${ requestScope.user.role == admin }">
							     		<select id="role" class="form-select" name="role">
									       	<option value="admin" selected>admin</option>
									       	<option value="user">user</option>
									     </select>
							     </c:if>
							     
							     <c:if test="${ requestScope.user.role == user }">
							     		<select id="role" class="form-select" name="role">
									       	<option value="admin">admin</option>
									       	<option value="user" selected>user</option>
									     </select>
							     </c:if>
							     
						   </div>							
						   <div class="d-flex justify-content-end">
								<button type="submit" class="btn btn-primary">Modifier</button>
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