<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="include/stylesheets.jsp" %>
	<title>Fiche d'un utilisateur</title>
</head>
<body>
	<c:set var="admin" value="admin"/>
	<c:set var="user" value="user"/>
	<c:if test="${ sessionScope.user.role == admin  }">
		<%@ include file="include/menu_admin.jsp" %>
	</c:if>
		
	<c:if test="${ sessionScope.user.role == user }">
		<%@ include file="include/menu.jsp" %>
	</c:if>
	
	<main>
		<section class="container-fluid mt-5">
			<div class="row">
				<div class="col-md-8 mx-auto">
					<div class="card mt-3">
						<h2 class="card-header text-center">Fiche de ${ requestScope.user.lastname } ${ requestScope.user.firstname }</h2>
						
						<div class="card-body">
							<div class="row d-flex justify-content-end mt-2">
								<div class="col-md-5">
										<c:if test="${ requestScope.user.image_link != null }">
											<img alt="image profil" style="max-width:100%;" src="<%= request.getContextPath()%>${ requestScope.user.image_link}">
										</c:if>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-6 mx-auto d-flex flex-row justify-content-between">
									<p>
										<span class="fw-bolder"> Nom : </span>
										<span class="text-uppercase"> ${ requestScope.user.lastname }</span>
									</p>
									
									<p>
										<span class="fw-bolder"> Prénom : </span>
										<span class="text-capitalize"> ${ requestScope.user.firstname }</span>
									</p>
								</div>
							 </div>
							 
							 <div class="row">
							 	<div class="col-md-4">
							 		<p>
							 			<span class="fw-bolder"> Date d'embauche : </span>
										<span class="text-uppercase"> 
											<fmt:formatDate pattern="dd/MM/yyyy" value="${ requestScope.user.employed_at }"/>
										</span>
							 		</p>
							 	</div>
							 	
							 	<div class="col-md-4">
							 		<p>
							 			<span class="fw-bolder"> Rôle : </span>
										<span class="text-uppercase"> ${ requestScope.user.role }</span>
							 		</p>
							 	</div>
							 	
							 	<div class="col-md-4">
							 		<p>
							 			<span class="fw-bolder"> Numero de téléphone: </span>
										<span class="text-uppercase"> ${ requestScope.user.phone_number }</span>
							 		</p>
							 	</div>
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