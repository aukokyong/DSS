package com.domain.service;

import com.domain.model.Customer;

public interface CustomerService {
    
    public void createCustomer(Customer customer);
    
    public void getCustomerByID(int ID);
    
    public void updateCustomerByID(int ID);
    
    public void deleteCustomerByID(int ID);
}
