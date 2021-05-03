package com.domain.ui;

import com.domain.model.Customer;

public class App {
    
    public static void main(String[] args){
        System.out.println("=== Customer Database ===");
        
        Customer customer = new Customer();
        createCustomer();
        getCustomer();
        updateCustomer();
        deleteCustomer();
    }
    
    private static void createCustomer(){
        System.out.println("=== CREATING NEW CUSTOMER ===");
    }
    
    private static void getCustomer(){
        System.out.println("=== RETRIEVING CUSTOMER INFO ===");
    }
    
    private static void updateCustomer(){
        System.out.println("=== UPDATING CUSTOMER INFO");
    }
    
    private static void deleteCustomer(){
        System.out.println("=== DELETING CUSTOMER INFO");
    }
}
