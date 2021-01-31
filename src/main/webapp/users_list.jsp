<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="include/stylesheets.jsp" %>
	<title>Liste des utilisateurs</title>
</head>
<body>
	<c:set var="admin" value="admin"/>
	<c:set var="user" value="user"/>
	<c:if test="${ sessionScope.user.role == admin  }">
		<%@ include file="include/menu_admin.jsp" %>
	</c:if>
		
	<c:if test="${ sessionScope.user.role == user  }">
		<%@ include file="include/menu.jsp" %>
	</c:if>
	
	<main>
		<section class="container-fluid mt-5">
			<h1 class="text-center"> Bienvenue ${ sessionScope.user.lastname } ${ sessionScope.user.firstname  }</h1>
			<div class="row">
				<div class="col-md-8 mx-auto">
					<div class="card mt-3">
						<h2 class="card-header text-center">Liste des utilisateurs</h2>
						
						<div class="card-body">
							<div class="row">
								<c:forEach items="${ requestScope.users }" var="user">
									<div class="col-md-4">
										<div class="card my-2">
											<div class="card-body">
												<p class="card-title text-center">${ user.lastname } ${ user.firstname }</p>
												
												
												
												<div class="d-flex justify-content-center">
													<a href="<%= request.getContextPath() %>/user?id=${ user.id }" class="btn btn-outline-secondary btn-sm">
														Consulter
													</a>
												</div>
												
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