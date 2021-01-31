package examen_jee_chanfi_elhadji.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examen_jee_chanfi_elhadji.models.User;
import examen_jee_chanfi_elhadji.services.UserService;

/**
 * Servlet implementation class UserDeleteAdminServlet
 */
public class UserDeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User session = (User) request.getSession().getAttribute("user");
		if(session != null) {
			if(session.getRole().equals("admin")) {
				this.userService = new UserService();
				Integer id = Integer.parseInt(request.getParameter("id"));
				
				try {
					User user = this.userService.getById(id);
					
					if(user == null) {
						response.sendError(HttpServletResponse.SC_NOT_FOUND);
					}
					else {
						this.userService.delete(user);
						response.sendRedirect(request.getContextPath() + "/admin/users");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				response.sendRedirect(request.getContextPath() + "/users");
			}
			
		}
		else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User session = (User) request.getSession().getAttribute("user");
		if(session != null) {
			if(session.getRole().equalsIgnoreCase("admin")) {
				doGet(request, response);
			}
			else {
				response.sendRedirect(request.getContextPath() + "/users");
			}
		}
		else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

}
