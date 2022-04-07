package ConnectionDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
	
	
	
	public Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/mydb";
		String username = "root";
		String password = "root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			connection = DriverManager.getConnection(url, username, password); 
			System.out.println("Connection is set!");
		} catch (SQLException e){
			e.getMessage();
		}
		
		return connection;
	}
}