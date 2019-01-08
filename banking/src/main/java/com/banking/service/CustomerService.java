package com.banking.service;

import java.util.List;

import com.banking.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomersList();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	public Customer getCustomerByMobileno(String mobleno);

}
