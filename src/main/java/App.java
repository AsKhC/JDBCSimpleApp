import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ConnectionDao.ConnectionDao;

public class App {
	final static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		final ConnectionDao connectionDao = new ConnectionDao();
		final Connection connection = connectionDao.getConnection();
		int numberOfOperation = 0;
		
		do {
			numberOfOperation = chooseOperation();
				
			if (numberOfOperation == 1) {
				System.out.println("Number is 1");
			} else if (numberOfOperation == 2) {
				System.out.println("Number is 2");
			} else if (numberOfOperation != 1 || numberOfOperation != 2){
				System.out.println("Error on choosing operation number");
				chooseOperation();
			}
		} while (numberOfOperation != 1 || numberOfOperation != 2);
		
		
//		String id = scanner.next();
//		String email = scanner.next();
//		String first_name = scanner.next();
//		String last_name = scanner.next();
//		
//		Statement statement = connection.createStatement();
//		
//		statement.executeUpdate("INSERT INTO `mydb`.`student` (`id`, `email`, `first_name`, `last_name`)  VALUES ('" + id + "', '" + email + "', '" + first_name + "', '" + last_name + "');");
//		
//		statement.close();
		
		
		
	}
	
	public static int chooseOperation() {
		System.out.println("Hello! What do we do with DB? \n"
				+ "Choose operation:\n"
				+ "1. Add new data\n"
				+ "2. Show data\n");
		
		return scanner.nextInt();
	}
	
}