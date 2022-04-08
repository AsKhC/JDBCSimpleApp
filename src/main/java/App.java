import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import ConnectionDao.ConnectionDao;
import ConnectionDao.DBOperations;

public class App {
	
	final static Scanner scanner = new Scanner(System.in);
	final static ConnectionDao connectionDao = new ConnectionDao();
	final static DBOperations dbOperations = new DBOperations();
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		final Connection connection = connectionDao.getConnection();
		int numberOfOperation;
		
		
		do {
			numberOfOperation = chooseOperation();
			
			if (numberOfOperation == 1) {
				System.out.println("Number is 1");
				dbOperations.operationExecuteUpdate();
			} else if (numberOfOperation == 2) {
				System.out.println("Number is 2");
			} else {
				System.out.println("Error on choosing operation number!");
			}
		} while (numberOfOperation != 1 & numberOfOperation != 2);
		

		
		
		
	}
	
	public static int chooseOperation() {
		System.out.println("Hello! What do we do with DB? \n"
				+ "Choose operation:\n"
				+ "1. Add new data\n"
				+ "2. Show data by id\n");
		int back = scanner.nextInt();
		return back;
	}
	

}