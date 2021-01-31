package examen_jee_chanfi_elhadji.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import examen_jee_chanfi_elhadji.models.User;
import examen_jee_chanfi_elhadji.services.UserService;

/**
 * Servlet implementation class UserEditAdminServlet
 */
public class UserEditAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;   
    private List<String> errors;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User session = (User) request.getSession().getAttribute("user");
		if(session != null ) {
			if(session.getRole().equalsIgnoreCase("admin")) {
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
				}
				else {
					request.setAttribute("user", user);
					request.getRequestDispatcher("/user_edit_admin.jsp").forward(request, response);
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
			if(session.getRole().equals("admin")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String lastname = request.getParameter("lastname");
				String firstname = request.getParameter("firstname");
				String phone_number = request.getParameter("phone_number");
				String role = request.getParameter("role");
				Date employed_at = Date.valueOf(request.getParameter("employed_at"));
				String image_link = null;
				
				this.userService = new UserService();
				this.errors = new ArrayList<String>();
				
				if(username.isBlank()) {
					errors.add(" Le nom d'utilisateur est vide");
				}
				
				if(password.isBlank()) {
					errors.add(" Le mot de passe est vide");
				}
				
				if(lastname.isBlank()) {
					errors.add(" Le nom est vide");
				}
				
				if(firstname.isBlank()) {
					errors.add(" Le prénom est vide");
				}
				
				if(employed_at == null) {
					errors.add(" La date d'embauche est vide");
				}
				
				if(phone_number.isBlank()) {
					errors.add(" Le numéro de téléphone est vide");
				}
				
				if(role.isBlank()) {
					errors.add(" Le role est vide");
				}
				
				if(username != null && !username.isBlank() && password != null && !password.isBlank() &&
				   lastname != null && !lastname.isBlank() && firstname != null && !firstname.isBlank() && 
				   phone_number != null && !phone_number.isBlank() && role != null && !role.isBlank() && 
				   employed_at != null) {
					
					try {
						
						Integer id = Integer.parseInt(request.getParameter("id"));
						
						User userToUpdate = this.userService.getById(id);
						User user = this.userService.getByUsername(username);
						if(user != null && !username.equals(userToUpdate.getUsername())) {
								errors.add("Le nom d'utilisateur existe déjà");
								request.setAttribute("errors", errors);
								doGet(request, response);
						}else {
							String applicationPath = request.getServletContext().getRealPath(File.separator);
					        // constructs path of the directory to save uploaded file
					        String uploadFilePath = applicationPath + File.separator + "uploads";
		
		
					        File uploadFolder = new File(uploadFilePath);
					        if (!uploadFolder.exists()) {
					            uploadFolder.mkdirs();
					        }
		
					        String uniqueID = UUID.randomUUID().toString();
					        String filePath = uploadFilePath + File.separator + uniqueID +".jpg";
					        
		
					        // write all files in upload folder
					        for (Part part : request.getParts()) {

					            if (part != null && part.getSize() > 0) {
			            	
					                part.write(filePath);
					                image_link = "/uploads/" + uniqueID + ".jpg";
					                
					            }
					        }
					        phone_number = phone_number.replaceAll(" ", "");
					        user = new User(userToUpdate.getId(), username, password, lastname, firstname, image_link, employed_at, phone_number, role);
					        this.userService.update(user);
					        response.sendRedirect(request.getContextPath() + "/admin/users");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					request.setAttribute("errors", errors);
					doGet(request, response);
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

}
