package main.java.dss.review.repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtil {
	public static Connection getConnection() {
		try {
			// Load the driver
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// getting connected
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dss", "root", "mysql000");
			System.out.println("Connected!!!");
			return connection;
		} catch (ClassNotFoundException | SQLException exception) {
			System.out.println(exception);
			return null;
		}
	}
}
