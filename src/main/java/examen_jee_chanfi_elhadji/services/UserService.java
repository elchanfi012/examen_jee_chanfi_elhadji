package examen_jee_chanfi_elhadji.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen_jee_chanfi_elhadji.models.User;
import examen_jee_chanfi_elhadji.utils.DAOInterface;
import examen_jee_chanfi_elhadji.utils.DataConnect;

public class UserService implements DAOInterface<User, Integer>{
	private Connection connection;
	
	public UserService()  {
		
			try {
				this.connection = DataConnect.getConnexion();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	@Override
	public List<User> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		
		String query = "SELECT * FROM user;";
		PreparedStatement prepareStatement = this.connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();
		
		while(resultSet.next()) {
			
			Integer user_id = resultSet.getInt("id");
			
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			String lastname = resultSet.getString("lastname");
			String firstname = resultSet.getString("firstname");
			String image_link = resultSet.getString("image_link");
			Date employed_at = resultSet.getDate("employed_at");
			String phone_number = resultSet.getString("phone_number");
			String role = resultSet.getString("role");
			
			
			User user = new User(user_id, username, password, lastname, firstname, image_link, employed_at, phone_number, role);
			
			
			users.add(user);
		}
		
		resultSet.close();
		prepareStatement.close();
		return users;
	}

	@Override
	public User getById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM user where id = ?;";
		PreparedStatement prepareStatement = this.connection.prepareStatement(query);
		prepareStatement.setInt(1, id);
		ResultSet resultSet = prepareStatement.executeQuery();
		
		User user = null;
		while(resultSet.next()) {
			
			Integer user_id = resultSet.getInt("id");
			
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			String lastname = resultSet.getString("lastname");
			String firstname = resultSet.getString("firstname");
			String image_link = resultSet.getString("image_link");
			Date employed_at = resultSet.getDate("employed_at");
			String phone_number = resultSet.getString("phone_number");
			String role = resultSet.getString("role");
			
			
			user = new User(user_id, username, password, lastname, firstname, image_link, employed_at, phone_number, role);
			
			
		}
		
		resultSet.close();
		prepareStatement.close();
		return user;
	}
	
	public User getByUsername(String login) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM user where username = ?;";
		PreparedStatement prepareStatement = this.connection.prepareStatement(query);
		prepareStatement.setString(1, login);
		ResultSet resultSet = prepareStatement.executeQuery();
		
		User user = null;
		while(resultSet.next()) {
			
			Integer user_id = resultSet.getInt("id");
			
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			String lastname = resultSet.getString("lastname");
			String firstname = resultSet.getString("firstname");
			String image_link = resultSet.getString("image_link");
			Date employed_at = resultSet.getDate("employed_at");
			String phone_number = resultSet.getString("phone_number");
			String role = resultSet.getString("role");
			
			
			user = new User(user_id, username, password, lastname, firstname, image_link, employed_at, phone_number, role);
			
			
		}
		
		resultSet.close();
		prepareStatement.close();
		return user;
	}
	
	@Override
	public Integer create(User userToAdd) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO user (username, password, lastname, firstname, image_link, employed_at, phone_number, role)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement prepareStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		prepareStatement.setString(1, userToAdd.getUsername());
		prepareStatement.setString(2, userToAdd.getPassword());
		prepareStatement.setString(3, userToAdd.getLastname());
		prepareStatement.setString(4, userToAdd.getFirstname());
		prepareStatement.setString(5, userToAdd.getImage_link());
		prepareStatement.setDate(6, userToAdd.getEmployed_at());
		prepareStatement.setString(7, userToAdd.getPhone_number());
		prepareStatement.setString(8, userToAdd.getRole());
		
		
		prepareStatement.executeUpdate();
		
		ResultSet resultSet = prepareStatement.getGeneratedKeys();
		
		Integer user_id = null;
		
		if(resultSet.next()) {
			user_id = resultSet.getInt(1);
		}
		
		resultSet.close();
		prepareStatement.close();
		return user_id;
	}

	@Override
	public Integer update(User userToUpdate) throws SQLException {
		// TODO Auto-generated method stub
		String query = "UPDATE user SET username = ?, password = ?, lastname = ?, firstname = ?,"
					 + " image_link = ?, employed_at = ?, phone_number = ?, role = ? WHERE id = ?;";
		Integer nbUpdatedRow = 0;
		
		PreparedStatement prepareStatement = this.connection.prepareStatement(query);
		
		prepareStatement.setString(1, userToUpdate.getUsername());
		prepareStatement.setString(2, userToUpdate.getPassword());
		prepareStatement.setString(3, userToUpdate.getLastname());
		prepareStatement.setString(4, userToUpdate.getFirstname());
		prepareStatement.setString(5, userToUpdate.getImage_link());
		prepareStatement.setDate(6, userToUpdate.getEmployed_at());
		prepareStatement.setString(7, userToUpdate.getPhone_number());
		prepareStatement.setString(8, userToUpdate.getRole());
		prepareStatement.setInt(9, userToUpdate.getId());
		
		nbUpdatedRow = prepareStatement.executeUpdate();
		
		prepareStatement.close();
		return nbUpdatedRow;
	}

	@Override
	public void delete(User userToDelete) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM user WHERE id = ?;";
		
		PreparedStatement prepareStatement = this.connection.prepareStatement(query);
		prepareStatement.setInt(1, userToDelete.getId());
		
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

}
