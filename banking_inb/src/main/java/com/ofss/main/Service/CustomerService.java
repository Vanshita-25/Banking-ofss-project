package com.ofss.main.Service;
import java.util.List;

import com.ofss.main.domain.Customer;

public interface CustomerService {
    //List<Customer> getAllCustomers();
    Customer getCustomerbyCustomerId(int customerId);
    Customer addNewCustomer(Customer customer);
    //boolean deleteCustomerbyCustomerId(int customerId);
    //boolean updateCustomer(Customer customer);

}
