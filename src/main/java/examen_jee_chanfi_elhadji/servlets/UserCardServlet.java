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
 * Servlet implementation class UserCardServlet
 */
public class UserCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession().getAttribute("user") != null) {
			this.userService = new UserService();
			Integer id = Integer.parseInt(request.getParameter("id"));
			User user = null;
			
			try {
				user = this.userService.getById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}else {
				request.setAttribute("user", user);
				request.getRequestDispatcher("/user_card.jsp").forward(request, response);
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
		if(request.getSession().getAttribute("user") != null) {
			doGet(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

}
