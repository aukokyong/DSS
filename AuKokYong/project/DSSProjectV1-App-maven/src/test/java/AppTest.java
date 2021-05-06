import com.domain.model.Customer;
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
    
    // @Test
    // public void testInsertCustomer(){
    //     CustomerService customerService = new CustomerServiceImpl();
    //     Customer customer = new Customer(4,"04FIRST", "04LAST", 4);
    //     customerService.createCustomer(customer);
    //     Customer customerDB = customerService.getCustomerByID(4);
    //     assertEquals("04FIRST", customerDB.getCustomerFirstName());
    //     assertEquals("04LAST", customerDB.getCustomerLastName());
    //     assertEquals(4, customerDB.getCustomerAge());
    // }
    
    @Test
    public void testUpdateCustomerByID(){
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer("FIRST-updated", "LAST-updated", 1);
        customerService.updateCustomerByID(2, customer);
        
        Customer customerDB = customerService.getCustomerByID(2);
        assertEquals("FIRST-updated", customerDB.getCustomerFirstName());
        assertEquals("LAST-updated", customerDB.getCustomerLastName());
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
