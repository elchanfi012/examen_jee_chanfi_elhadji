<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="include/stylesheets.jsp" %>
	<title>Lite des utilisateurs</title>
</head>
<body>
	
		<%@ include file="include/menu_admin.jsp" %>
	
	
	<main>
		<section class="container-fluid mt-5">

			<div class="row">
				<div class="col-md-8 mx-auto">
					<div class="d-flex justify-content-end">
						<a href="<%= request.getContextPath() %>/admin/user/add" class="btn btn-outline-primary btn-sm mb-3">Ajouter</a>
					</div>
				
					<div class="card mt-3">
						<h1 class="card-header text-center">Liste des utilisateurs</h1>
						
						<div class="card-body">
							<div class="row">
								<c:forEach items="${ requestScope.users }" var="user">
									<div class="col-md-4">
										<div class="card my-2">
											<div class="card-body">
												<p class="card-title text-center">${ user.lastname } ${ user.firstname }</p>
												
												<a href="<%= request.getContextPath() %>/user?id=${ user.id }" class="btn btn-outline-secondary btn-sm">
													Consulter
												</a>
												<a href="<%= request.getContextPath() %>/admin/user/edit?id=${ user.id }" class="btn btn-outline-success btn-sm">Modifier</a>
												<a href="<%= request.getContextPath() %>/admin/user/delete?id=${ user.id }" class="btn btn-outline-danger btn-sm">Supprimer</a>
											</div>
										</div>
									</div>
								</c:forEach>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
		

	<%@ include file="include/scripts.jsp" %>	
</body>
</html>