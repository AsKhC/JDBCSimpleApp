package ConnectionDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class DBOperations {
	
	final static ConnectionDao connectionDao = new ConnectionDao();
	final static Scanner scanner = new Scanner(System.in);
	final App app = new App();

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
		
		System.out.println("Successfully added new student.\n\n");
	}
	
	public void updateById() throws ClassNotFoundException, SQLException{
		final Connection connection = connectionDao.getConnection();
		
		//Finding Student Entity in DB by ID
		System.out.println("Please enter ID of a student which data you want to update");
		int enteredId = scanner.nextInt();
		boolean isIdFound = false;
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT id FROM mydb.student;");
		while (resultSet.next()) {
			if (resultSet.getInt(1) == enteredId)
				isIdFound = true;
		}
		
		if (isIdFound == true)
			System.out.println("Student's ID is found!");
		else {
			System.out.println("Student's ID is NOT found!"
					+ "\nYou were redirected to the menu.\n");
			app.chooseOperation();
		}
		
		resultSet.close();
		
		//Entering new values to update old data
		System.out.println("Enter new EMAIL");
		String email = scanner.next();
		System.out.println("Enter new FIRST_NAME");
		String first_name = scanner.next();
		System.out.println("Enter new LAST_NAME");
		String last_name = scanner.next();
		
		final String query = "UPDATE `mydb`.`student` SET `email` = '" + email + "', "
				+ "`first_name` = '" + first_name + "', `last_name` = '" + last_name + "' WHERE (`id` = '" + enteredId + "');\r\n";
		
		statement.executeUpdate(query);
		
		System.out.print("Successfully updated student's data\n\n\n");
		
		statement.close();
	}
	
	public void deleteById() throws ClassNotFoundException, SQLException{
		final Connection connection = connectionDao.getConnection();
		Statement statement = connection.createStatement();
		boolean doesIdExist = false;
		//Receiving ID to delete student's data
		System.out.println("Enter student's ID to delete data...");
		int idToDelete = scanner.nextInt();
		
		ResultSet resultSet = statement.executeQuery("SELECT id FROM mydb.student;");
		while(resultSet.next()) {
			if (resultSet.getInt(1) == idToDelete) 
				doesIdExist = true;
		}
		
		if (doesIdExist) {
			final String query = "DELETE FROM `mydb`.`student` WHERE (`id` = '" + idToDelete + "');";
			statement.executeUpdate(query);
		} else {
			System.out.println("Such ID doesn't exist!"
					+ "\nRedirecting to menu.\n\n");
			app.chooseOperation();
		}
		statement.close();
	}
	
	public void showDataById() throws ClassNotFoundException, SQLException{
		final Connection connection = connectionDao.getConnection();
		final Statement statement = connection.createStatement();
		boolean isIdExists = false;
		//Receiving ID to search any entity in DB with such ID
		System.out.println("Enter ID to search...");
		int idToSearch = scanner.nextInt();
		
		final String query = "SELECT * FROM mydb.student where id = " + idToSearch + ";";
		
		ResultSet resultSet = statement.executeQuery("SELECT id FROM mydb.student;");
		while (resultSet.getInt(0) == idToSearch)
			isIdExists = true;
		
		if (isIdExists) {
			statement.executeUpdate(query);
		} else {
			System.out.println("Such ID wasn't found!"
					+ "\nRedirecting to menu.\n\n");
			app.chooseOperation();
		}
		statement.close();
	}
	
	public void showAllData() throws ClassNotFoundException, SQLException{
		final String query = "SELECT * FROM student";
		final Connection connection = connectionDao.getConnection();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {
			System.out.println("_________________________________ \n"
			+ resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4) + "\n"
					+ "_________________________________ \n");
		}
		statement.close();
	}
	
	
	
}