package com.domain.service;

import com.domain.model.Customer;

import java.util.List;

public interface CustomerService {
    
    public void createCustomer(Customer customer);
    
    public Customer getCustomerByID(int ID);
    
    public List<Customer> getAllCustomer();
    
    public void updateCustomerByID(int ID);
    
    public void deleteCustomerByID(int ID);
}
