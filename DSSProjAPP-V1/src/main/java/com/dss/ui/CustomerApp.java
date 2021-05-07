package com.dss.ui;

import com.dss.model.Customer;
import com.dss.service.CustomerService;
import com.dss.service.CustomerServiceImpl;

import java.util.List;

public class CustomerApp {

	public static void main(String[] args){
		System.out.println("=== CUSTOMER DATABASE PORTAL ===");

		Customer customer = new Customer(5, "amy", "john", 20);
		getAllCustomer();
		createCustomer(customer);
		getCustomerById(1);

		updateCustomer(1, "amy", "john", 20);
		deleteCustomerByID(2);
		getAllCustomer();
	}

	public static void createCustomer(Customer customer){
		CustomerService customerService = new CustomerServiceImpl();
		customerService.createCustomer(customer);
	}

	public static void getCustomerById(int ID){
		CustomerService customerService = new CustomerServiceImpl();
		Customer queryResults = customerService.getCustomerByID(ID);
		if(queryResults == null){
			System.out.println("Customer not found...");
		} else {
			System.out.println(queryResults);
		}
	}

	public static void getAllCustomer(){
		CustomerService customerService = new CustomerServiceImpl();
		List<Customer> queryResults = customerService.getAllCustomer();
		queryResults.forEach(customer -> System.out.println(customer.toString()));
	}

	public static void updateCustomer(int ID, String firstName, String lastName, int age){
		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = new Customer(firstName, lastName, age);
		customerService.updateCustomerByID(ID, customer);
	}

	public static void deleteCustomerByID(int ID){
		CustomerService customerService = new CustomerServiceImpl();
		customerService.deleteCustomerByID(ID);
	}
}
