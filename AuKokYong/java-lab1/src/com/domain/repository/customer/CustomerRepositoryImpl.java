package com.domain.repository.customer;

import com.domain.model.Customer;
import com.domain.repository.util.MySQLConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println(statement.executeUpdate() + " new customer data added");
            connection.close();
        } catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    @Override
    public Customer getCustomerByIDFromRepository(int ID){
        System.out.println("GETTING CUSTOMER INFO...");
        
        Customer customer = null;
        String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);
            
            ResultSet results = statement.executeQuery();
            if(results.next()){
                int resultID = results.getInt(1);
                String resultFirstName = results.getString(2);
                String resultLastName = results.getString(3);
                int resultAge = results.getInt(4);
                
                customer = new Customer(resultID, resultFirstName, resultLastName, resultAge);
            }
            connection.close();
            return customer;
        } catch(SQLException err){
            System.out.println(err.getMessage());
        }
        
        return customer;
    }
    
    @Override
    public List<Customer> getAllCustomerFromRepository(){
        System.out.println("GETTING CUSTOMER INFO...");
        
        List<Customer> customer = new ArrayList<Customer>();
        String sql = "SELECT * FROM CUSTOMER";
        
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            if(results.next()){
                int resultID = results.getInt(1);
                String resultFirstName = results.getString(2);
                String resultLastName = results.getString(3);
                int resultAge = results.getInt(4);
                customer.add(new Customer(resultID, resultFirstName, resultLastName, resultAge));
            }
            connection.close();
            return customer;
        } catch(SQLException err){
            System.out.println(err.getMessage());
        }
        return customer;
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
