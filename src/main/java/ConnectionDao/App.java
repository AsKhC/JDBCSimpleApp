package ConnectionDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
	
	final static Scanner scanner = new Scanner(System.in);
	final static ConnectionDao connectionDao = new ConnectionDao();
	final static DBOperations dbOperations = new DBOperations();
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		final Connection connection = connectionDao.getConnection();
		
		System.out.println("Hello! What do we do with DB? \n");
		chooseOperation();
	}
	
	public static void chooseOperation() throws ClassNotFoundException, SQLException{
		int numberOfOperation;

		do {numberOfOperation = operationVariability();
		if (numberOfOperation == 1) {
			System.out.println("Number is 1");
			dbOperations.operationExecuteUpdate();
		}else if (numberOfOperation == 2) {
			System.out.println("Number is 2");
			dbOperations.updateById();;
		}else if (numberOfOperation == 3) {
			System.out.println("Number is 3");
			dbOperations.deleteById();
		}else if (numberOfOperation == 4) {
			System.out.println("Number is 4");
		}else if (numberOfOperation == 5) {
			System.out.println("Number is 5");
			dbOperations.showAllData();
		}
		else if(numberOfOperation != 0){
			System.out.println("Error on choosing operation!");
		}
	} while(numberOfOperation != 0);
	}
	
	public static int operationVariability() {
		System.out.println("Choose operation:\n"
				+ "1. Add new data\n"
				+ "2. Update data by id\n"
				+ "3. Delete data by id\n"
				+ "4. Show data by id\n"
				+ "5. Show all data\n"
				+ "0. Exit\n");
		int back = scanner.nextInt();
		return back;
	}
	

}