package com.dss.model;

public class Customer {
    private int customerID;
    private String customerFirstName;
    private String customerLastName;
    private int customerAge;
    
    public Customer(){
        this("firstName", "lastName", 0);
    }
    
    public Customer(String customerFirstName, String customerLastName, int customerAge){
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerAge = customerAge;
    }
    
    public Customer(int customerID, String customerFirstName, String customerLastName, int customerAge){
        this.customerID = customerID;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerAge = customerAge;
    }
    
    public int getCustomerID(){
        return customerID;
    }
    
    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }
    
    public String getCustomerFirstName(){
        return customerFirstName;
    }
    
    public void setCustomerFirstName(String customerFirstName){
        this.customerFirstName = customerFirstName;
    }
    
    public String getCustomerLastName(){
        return customerLastName;
    }
    
    public void setCustomerLastName(String customerLastName){
        this.customerLastName = customerLastName;
    }
    
    public int getCustomerAge(){
        return customerAge;
    }
    
    public void setCustomerAge(int customerAge){
        this.customerAge = customerAge;
    }
    
    @Override
    public String toString(){
        return "Customer{" +
                "customerID=" + customerID +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerAge=" + customerAge +
                '}';
    }
}
