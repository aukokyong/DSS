package com.domain.ui;

import com.domain.model.Customer;
import com.domain.service.CustomerService;
import com.domain.service.CustomerServiceImpl;

import java.util.List;

public class App {
    
    public static void main(String[] args){
        System.out.println("=== CUSTOMER DATABASE PORTAL ===");
        
        Customer customer = new Customer();
        createCustomer(customer);
        
         getCustomerById(1);
         getAllCustomer();
         updateCustomer(1, "amy", "john", 20);
         deleteCustomerByID(2);
    }
    
    public static void createCustomer(Customer customer){
        CustomerService customerService = new CustomerServiceImpl();
        customerService.createCustomer(customer);
    }
    
    public static void getCustomerById(int ID){
        CustomerService customerService = new CustomerServiceImpl();
        Customer queryResults = customerService.getCustomerByID(ID);
        if(queryResults == null){
            System.out.println("Customer not found...");
        } else {
            System.out.println(queryResults);
        }
    }
    
    public static void getAllCustomer(){
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> queryResults = customerService.getAllCustomer();
        queryResults.forEach(customer -> System.out.println(customer.toString()));
    }
    
    public static void updateCustomer(int ID, String firstName, String lastName, int age){
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer(firstName, lastName, age);
        customerService.updateCustomerByID(ID, customer);
    }
    
    public static void deleteCustomerByID(int ID){
        CustomerService customerService = new CustomerServiceImpl();
        customerService.deleteCustomerByID(ID);
    }
}
