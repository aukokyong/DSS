import com.domain.model.Customer;
import com.domain.repository.customer.CustomerRepositoryImpl;
import com.domain.service.CustomerService;
import com.domain.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AppTest {
    
    @Test
    public void testGetAllCustomer(){
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> customer = customerService.getAllCustomer();
        assertEquals(customer.size(), customerService.getAllCustomer().size());
    }
    
    @Test
    public void testGetCustomerByID(){
        CustomerService customerService = new CustomerServiceImpl();
        Customer customerDB = customerService.getCustomerByID(1);
        assertEquals("FIRST", customerDB.getCustomerFirstName());
        assertEquals("LAST", customerDB.getCustomerLastName());
        assertEquals(0, customerDB.getCustomerAge());
    }
    
    @Test
    public void testInsertCustomer(){
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer(4,"FIRST_insert", "LAST_insert", 0);
        customerService.createCustomer(customer);
    
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        Customer customerDB = customerRepository.getCustomerByFirstNameFromRepository("FIRST_insert");
        assertEquals("FIRST_insert", customerDB.getCustomerFirstName());
        assertEquals("LAST_insert", customerDB.getCustomerLastName());
        assertEquals(0, customerDB.getCustomerAge());
    }
    
    @Test
    public void testUpdateCustomerByID(){
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer("FIRST_updated", "LAST_updated", 1);
        customerService.updateCustomerByID(2, customer);
        
        Customer customerDB = customerService.getCustomerByID(2);
        assertEquals("FIRST_updated", customerDB.getCustomerFirstName());
        assertEquals("LAST_updated", customerDB.getCustomerLastName());
        assertEquals(1, customerDB.getCustomerAge());
    }
    
    @Test
    public void testDeleteCustomer(){
        CustomerService customerService = new CustomerServiceImpl();
        customerService.deleteCustomerByID(3);
        
        Customer customerDB = customerService.getCustomerByID(3);
        System.out.println("customerDB: " + customerDB);
        assertNull(customerDB);
    }
}
