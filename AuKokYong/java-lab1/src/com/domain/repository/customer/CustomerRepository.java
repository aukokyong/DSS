package com.domain.repository.customer;

import com.domain.model.Customer;

public interface CustomerRepository {
    public void createCustomerFromRepository(Customer customer);
    
    public void getCustomerByIDFromRepository(int ID);
    
    public void updateCustomerByIDFromRepository();
    
    public void deleteCustomerByIDFromRepository(int ID);
}
