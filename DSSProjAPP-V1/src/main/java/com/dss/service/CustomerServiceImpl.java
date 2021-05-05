package com.dss.service;

import com.dss.model.Customer;
import com.dss.repository.CustomerRepository;
import com.dss.repository.CustomerRepositoryImpl;

import java.util.List;

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
    public Customer getCustomerByID(int ID){
        System.out.println("=== GETTING CUSTOMER INFO ===");
        return customerRepository.getCustomerByIDFromRepository(ID);
    }
    
    @Override
    public List<Customer> getAllCustomer(){
        System.out.println("=== GETTING ALL CUSTOMER INFO===");
        return customerRepository.getAllCustomerFromRepository();
    }
    
    @Override
    public void updateCustomerByID(int ID, Customer customer){
        System.out.println("=== UPDATING CUSTOMER INFO ===");
        customerRepository.updateCustomerByIDFromRepository(ID, customer);
        System.out.println("--- UPDATED CUSTOMER INFO ---");
    }
    
    @Override
    public void deleteCustomerByID(int ID){
        System.out.println("=== DELETING CUSTOMER INFO ===");
        customerRepository.deleteCustomerByIDFromRepository(ID);
        System.out.println("--- DELETED CUSTOMER INFO ---");
    }
}
