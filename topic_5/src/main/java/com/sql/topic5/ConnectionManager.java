package com.sql.topic5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private final String driverName = "com.mysql.jdbc.Driver";
	private final String serverName = "localhost";
    private final String mydatabase = "";
    private final String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    private final String username = "root";
    private final String password = "";
	
	private Connection connection;
	private static ConnectionManager instance = new ConnectionManager();
	
	private ConnectionManager(){}
	
	public static ConnectionManager getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
	    Class.forName(driverName);
	    connection = DriverManager.getConnection(url, username, password);
	    return connection;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public void loadFile(String path) throws Exception {
		ScriptRunner runner = new ScriptRunner(connection, false, true);
		runner.runScript(new BufferedReader(new FileReader(path)));
	}
}
