package com.domain.repository.customer;

import com.domain.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {
    
    public CustomerRepositoryImpl(){
        System.out.println("CUSTOMER REPOSITORY LAYER INSTANTIATED");
    }
    
    @Override
    public void createCustomerFromRepository(Customer customer){
        System.out.println(" ADDING NEW CUSTOMER TO DATABASE...");
    }
    
    @Override
    public void getCustomerByIDFromRepository(int ID){
        System.out.println("GETTING CUSTOMER INFO...");
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
