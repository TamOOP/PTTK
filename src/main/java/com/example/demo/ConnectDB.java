package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static String url = "jdbc:sqlite:Book.db";
	
	public static Connection getConnection() throws SQLException {
		
		Connection connection = null;
		connection = DriverManager.getConnection(url);
		
		return connection;
	}
}