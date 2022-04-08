package ConnectionDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBOperations {
	
	final static ConnectionDao connectionDao = new ConnectionDao();
	final static Scanner scanner = new Scanner(System.in);
	
	public static void operationExecuteUpdate() throws ClassNotFoundException, SQLException{
		
		final Connection connection = connectionDao.getConnection();

		//Entering data to add new student to DB
		System.out.println("Enter student's ID");
		String id = scanner.next();
		System.out.println("Enter student's EMAIL");
		String email = scanner.next();
		System.out.println("Enter student's FIRST_NAME");
		String first_name = scanner.next();
		System.out.println("Enter student's LAST_NAME");
		String last_name = scanner.next();
		
		//Creating a Statement to execute SQL query to add new student
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO `mydb`.`student` (`id`, `email`, `first_name`, `last_name`)  "
				+ "VALUES ('" + id + "', '" + email + "', '" + first_name + "', '" + last_name + "');");
		
		//Closing the Statement to free used recources
		statement.close();
		
		System.out.println("Successfully added new student.");
		
	}
	
	public void databaseExecuteQuery() throws ClassNotFoundException, SQLException{
		
		final Connection connection = connectionDao.getConnection();
		
		Statement statement = connection.createStatement();
		
		

	}
}
