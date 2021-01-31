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
 * Servlet implementation class UsersListServlet
 */
public class UsersListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersListServlet() {
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
			List<User> users = new ArrayList<User>();
			try {
				users = this.userService.getAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("users", users);
			request.getRequestDispatcher("/users_list.jsp").forward(request, response);
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
