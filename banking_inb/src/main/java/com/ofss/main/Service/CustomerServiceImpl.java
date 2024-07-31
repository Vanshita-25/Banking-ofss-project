package com.ofss.main.Service;

import java.util.List;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repository.CustomerRepository;
import com.ofss.main.repository.CustomerRepositoryImpl;
import com.ofss.main.repository.LoginRepository;
import com.ofss.main.repository.LoginRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository = new CustomerRepositoryImpl();
	private LoginRepository loginRepository = new LoginRepositoryImpl();
	
	// @Override
	// public List<Customer> getAllCustomers() {
	// return customerRepository.getAllCustomers();
	// }

	@Override
	public Customer getCustomerbyCustomerId(int customerId) {
		return customerRepository.getCustomerbyCustomerId(customerId);
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		Login login = customer.getLogin();
		int loginId = loginRepository.addNewLogin(login);
		customer.getLogin().setLoginId(loginId);
		System.out.println("in service");
		System.out.println(customer);
		int customerId = customerRepository.addNewCustomer(customer);
		if (customerId != 0) {
			customer.setCustomerId(customerId);
			return customer;
		}

		return null;
	}

	// @Override
	// public boolean deleteCustomerbyCustomerId(int customerId) {
	// return customerRepository.deleteCustomerbyCustomerId(customerId); }

	// @Override
	// public boolean updateCustomer(Customer customer) {
	// return customerRepository.updateCustomer(customer);
	// }

}
