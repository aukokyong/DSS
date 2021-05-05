package com.dss.controller;

import com.dss.model.Customer;
import com.dss.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    
    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }
    
    @GetMapping("/customer/{id}")
    public Customer getCustomerByID(@PathVariable(value = "id") int ID){
        Optional<Customer> optionalCustomer = customerRepository.findById(ID);
        Customer customer = optionalCustomer.get();
        return customer;
    }
    
    @PostMapping("/customer")
    public Customer createProduct(@RequestBody Customer customer){
        Customer customerReturned = customerRepository.save(customer);
        return customerReturned;
    }
    
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") int ID, @RequestBody Customer customer){
        Optional<Customer> optionalCustomer = customerRepository.findById(ID);
        Customer customerFromDB = optionalCustomer.get();
        customerFromDB.setCustomerFirstName(customer.getCustomerFirstName());
        customerFromDB.setCustomerLastName(customer.getCustomerLastName());
        customerFromDB.setCustomerAge(customer.getCustomerAge());
        Customer customerReturned = customerRepository.save(customerFromDB);
        return customerReturned;
    }
    
    @DeleteMapping("/customer/{id}")
    public boolean deleteCustomer(@PathVariable(value = "id") int ID){
        customerRepository.deleteById(ID);
        return true;
    }
}
