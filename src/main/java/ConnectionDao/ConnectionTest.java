package ConnectionDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String qrgs[]) throws ClassNotFoundException, SQLException{
		
		
		String url = "jdbc:mysql://localhost:3306/mydb";
		String username = "root";
		String password = "root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try	(Connection connection = DriverManager.getConnection(url, username, password);) {
			System.out.println("Connection is set!");
		}
		

	}
}
