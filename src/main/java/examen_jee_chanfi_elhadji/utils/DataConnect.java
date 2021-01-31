package examen_jee_chanfi_elhadji.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
	public static Connection getConnexion() throws SQLException, ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/exam_jee_elhadji?serverTimezone=UTC";
		String user = "root";
		String password = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	
	public static void closeConnection(Connection connection) throws SQLException{
		connection.close();
	}
}
