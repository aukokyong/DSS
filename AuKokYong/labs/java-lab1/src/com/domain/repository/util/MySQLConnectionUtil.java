package com.domain.repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtil {
    
    // for testing connection only
    // public static void main(String[] args){
    //     getConnection();
    // }
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DSSDB", "root", "");
            System.out.println("CONNECTED TO DATABASE");
            return connection;
        } catch(ClassNotFoundException | SQLException exception){
            System.out.println(exception);
            return null;
        }
    }
}
