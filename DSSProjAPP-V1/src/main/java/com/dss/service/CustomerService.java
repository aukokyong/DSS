package com.dss.service;

import com.dss.model.Customer;

import java.util.List;

public interface CustomerService {
    
    public void createCustomer(Customer customer);
    
    public Customer getCustomerByID(int ID);
    
    public List<Customer> getAllCustomer();
    
    public void updateCustomerByID(int ID, Customer customer);
    
    public void deleteCustomerByID(int ID);
}
