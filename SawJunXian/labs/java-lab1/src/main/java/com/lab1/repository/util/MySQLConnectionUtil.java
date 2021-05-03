package com.lab1.repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtil {
	public static Connection getConnection() {
		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			// getting connected
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSSDB", "root", "qM29pnec");
			return connection;
		} catch (ClassNotFoundException | SQLException exception) {
			System.out.println(exception);
			return null;
		}
	}
}
