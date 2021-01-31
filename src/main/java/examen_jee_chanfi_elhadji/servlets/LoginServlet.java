package examen_jee_chanfi_elhadji.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examen_jee_chanfi_elhadji.models.User;
import examen_jee_chanfi_elhadji.services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
    private List<String> errors;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("user") == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/users");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("user") == null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			this.userService = new UserService();
	        this.errors = new ArrayList<String>();
			try {
				
				if(username.isBlank()) {
					errors.add("Le nom d'utilisteur est vide");
				}
				
				if(password.isBlank()) {
					errors.add("Le mot de passe et vide");
				}
				if(username != null && !username.isBlank() && password != null && !password.isBlank()) {

					User userToConnect = this.userService.getByUsername(username);
					
					if(userToConnect != null && userToConnect.getPassword().equals(password)) {
						userToConnect = this.userService.getByUsername(userToConnect.getUsername());
						request.getSession().setAttribute("user", userToConnect);
						
					}
					else {
						errors.add("les identiants sont incorrects");
						
					}
					
				} 
				request.setAttribute("errors", errors);
				this.doGet(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
				
			
		}
		else {
			response.sendRedirect(request.getContextPath() + "/users");
		}
	}

}
