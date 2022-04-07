package ConnectionDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	
	final ConnectionDao connectionDao = new ConnectionDao();
	
	public void databaseExecuteQuery(String id, String email, String first_name, String last_name) throws ClassNotFoundException, SQLException {
		
		final Connection connection = connectionDao.getConnection();

		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO `mydb`.`student` (`id`, `email`, `first_name`, `last_name`)  VALUES "
				+ "('" + id + "', '" + email + "', '" + first_name + "', '" + last_name + "');");
		statement.close();
	}
	
	public void databaseExecuteQuery() throws ClassNotFoundException, SQLException{
		
		final Connection connection = connectionDao.getConnection();
		
		Statement statement = connection.createStatement();
		
		

	}
}
