package com.domain.repository.customer;

import com.domain.model.Customer;
import com.domain.repository.util.MySQLConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {
    
    public CustomerRepositoryImpl(){
        System.out.println("CUSTOMER REPOSITORY LAYER INSTANTIATED");
    }
    
    @Override
    public void createCustomerFromRepository(Customer customer){
        System.out.println(" ADDING NEW CUSTOMER TO DATABASE...");
    
        String sql = "INSERT INTO customer (firstName, lastName, age) VALUES (?, ?, ?)";
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getCustomerFirstName());
            statement.setString(2, customer.getCustomerLastName());
            statement.setInt(3, customer.getCustomerAge());
            System.out.println(statement.executeUpdate());
            connection.close();
        }catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
    @Override
    public void getCustomerByIDFromRepository(int ID){
        System.out.println("GETTING CUSTOMER INFO...");
    }
    
    @Override
    public void updateCustomerByIDFromRepository(){
        System.out.println("UPDATING CUSTOMER INFO...");
    }
    
    @Override
    public void deleteCustomerByIDFromRepository(int ID){
        System.out.println("DELETING CUSTOMER ID FROM DATABASE...");
    }
}
