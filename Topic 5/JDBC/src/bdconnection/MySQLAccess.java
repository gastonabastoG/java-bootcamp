package bdconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLAccess {
	
	private Connection connect = null;
	
	public Connection connectDatabase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/high-school?" + "user=root");
			
			return connect;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void closeDatabase() throws Exception {
		try {
			connect.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
}
