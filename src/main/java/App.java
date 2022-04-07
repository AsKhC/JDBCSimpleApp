import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ConnectionDao.ConnectionDao;

public class App {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		final ConnectionDao connectionDao = new ConnectionDao();
		final Connection connection = connectionDao.getConnection();
		final Scanner scanner = new Scanner(System.in);
		
		String id = scanner.next();
		String email = scanner.next();
		String first_name = scanner.next();
		String last_name = scanner.next();
		
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("INSERT INTO `mydb`.`student` (`id`, `email`, `first_name`, `last_name`)  VALUES ('" + id + "', '" + email + "', '" + first_name + "', '" + last_name + "');");
		
		statement.close();
		
		
		
	}
}