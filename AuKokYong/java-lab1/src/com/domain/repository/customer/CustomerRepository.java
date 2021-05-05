package com.domain.repository.customer;

import com.domain.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public void createCustomerFromRepository(Customer customer);
    
    public Customer getCustomerByIDFromRepository(int ID);
    
    public List<Customer> getAllCustomerFromRepository();
    
    public void updateCustomerByIDFromRepository();
    
    public void deleteCustomerByIDFromRepository(int ID);
}
