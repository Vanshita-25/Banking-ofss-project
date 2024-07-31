package com.ofss.main.repository;
import com.ofss.main.domain.Customer;
import java.util.List;

public interface CustomerRepository {
    //List<Customer> getAllCustomers();
    Customer getCustomerbyCustomerId(int customerId);
    int addNewCustomer(Customer customer);
    //boolean deleteCustomerbyCustomerId(int customerId);
    //boolean updateCustomer(Customer customer);
}
