package com.domain.ui;

import com.domain.model.Customer;
import com.domain.service.CustomerService;
import com.domain.service.CustomerServiceImpl;

public class App {
    
    public static void main(String[] args){
        System.out.println("=== CUSTOMER DATABASE PORTAL ===");
        
        Customer customer = new Customer();
        
        CustomerService customerService = new CustomerServiceImpl();
        customerService.createCustomer(customer);
        
        // customerService.getCustomerByID();
        // customerService.updateCustomer();
        // customerService.deleteCustomerByID();
    }
}
