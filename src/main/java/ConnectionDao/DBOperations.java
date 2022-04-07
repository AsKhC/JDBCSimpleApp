package ConnectionDao;

import java.sql.Connection;

public class DBOperations {
	
	final ConnectionDao connectionDao = new ConnectionDao();
	final Connection connection = connectionDao.getConnection();
	
	public void databaseExecuteQuery(String id, String email, String first_name, String last_name) {
		
	}
}
