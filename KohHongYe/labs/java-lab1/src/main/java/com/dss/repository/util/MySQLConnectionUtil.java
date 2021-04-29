package com.dss.repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MySQLConnectionUtil {


	public static Connection getConnection() {
		try {
			//			Load the driver
			//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// getting connected
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSS", "root", "mysql159!%(");
			System.out.println("Connected!!!");
			return connection;
		}
		catch (ClassNotFoundException | SQLException exception) {
			System.out.println(exception);
			return null;
		}
	}
	

	
}
