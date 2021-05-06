package com.dss.repository;

import com.dss.model.Customer;
import com.dss.repository.util.MySQLConnectionUtil;

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
        
        String sql = "INSERT INTO customers (firstName, lastName, age) VALUES (?, ?, ?)";
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getCustomerFirstName());
            statement.setString(2, customer.getCustomerLastName());
            statement.setInt(3, customer.getCustomerAge());
            System.out.println(statement.executeUpdate() + " new customer data added");
            connection.close();
            System.out.println("CLOSED DATABASE");
        } catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    @Override
    public Customer getCustomerByIDFromRepository(int ID){
        System.out.println("GETTING CUSTOMER INFO...");
        
        Customer customer = null;
        String sql = "SELECT * FROM CUSTOMERs WHERE ID = ?";
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
            System.out.println("CLOSED DATABASE");
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
        String sql = "SELECT * FROM CUSTOMERs";
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
            System.out.println("CLOSED DATABASE");
            return customer;
        } catch(SQLException err){
            System.out.println(err.getMessage());
        }
        return customer;
    }
    
    @Override
    public void updateCustomerByIDFromRepository(int ID, Customer customer){
        System.out.println("UPDATING CUSTOMER INFO...");
        
        String sql = "UPDATE customers SET firstName = ?, lastName = ?, age = ? where ID = ?";
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getCustomerFirstName());
            statement.setString(2, customer.getCustomerLastName());
            statement.setInt(3, customer.getCustomerAge());
            statement.setInt(4, ID);
            
            System.out.println(statement.executeUpdate() + " customer updated");
            connection.close();
            System.out.println("CLOSED DATABASE");
        } catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    @Override
    public void deleteCustomerByIDFromRepository(int ID){
        System.out.println("DELETING CUSTOMER ID FROM DATABASE...");
        
        String sql = "DELETE FROM customers WHERE ID = ?";
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);
            System.out.println(statement.executeUpdate() + " customer data deleted");
            connection.close();
            System.out.println("CLOSED DATABASE");
        } catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
