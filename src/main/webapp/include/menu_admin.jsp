<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand text-capitalize" href="#">Examen JEE</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item px-lg-5">
	          <a href="<%= request.getContextPath() %>/users"> Accueil </a>
	        </li>
	        <li class="nav-item px-lg-5">
	         <a href="<%= request.getContextPath() %>/admin/users"> Gérer les utilisateurs </a>
	        </li>
	        <li class="nav-item px-lg-5">
	          <a href="<%= request.getContextPath() %>/logout"> Déconnexion </a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
</header>
	
	