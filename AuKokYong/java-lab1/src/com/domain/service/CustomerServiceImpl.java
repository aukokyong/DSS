package com.domain.service;

import com.domain.model.Customer;
import com.domain.repository.customer.CustomerRepository;
import com.domain.repository.customer.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    Customer customer;
    
    public CustomerServiceImpl(){
        System.out.println("CUSTOMER SERVICE LAYER INSTANTIATED");
        customerRepository = new CustomerRepositoryImpl();
    }
    
    @Override
    public void createCustomer(Customer customer){
        System.out.println("=== CREATING NEW CUSTOMER ===");
        this.customer = customer;
        customerRepository.createCustomerFromRepository(customer);
        System.out.println("--- CREATED NEW CUSTOMER ---");
    }
    
    @Override
    public void getCustomerByID(int ID){
        System.out.println("=== GETTING CUSTOMER INFO ===");
        customerRepository.getCustomerByIDFromRepository(ID);
    }
    
    @Override
    public void updateCustomerByID(int ID){
        System.out.println("=== UPDATING CUSTOMER INFO ===");
        customerRepository.updateCustomerByIDFromRepository();
        System.out.println("--- UPDATED CUSTOMER INFO ---");
    }
    
    @Override
    public void deleteCustomerByID(int ID){
        System.out.println("=== DELETING CUSTOMER INFO ===");
        customerRepository.deleteCustomerByIDFromRepository(ID);
        System.out.println("--- DELETED CUSTOMER INFO ---");
    }
}
