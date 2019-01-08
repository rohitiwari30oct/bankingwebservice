package com.banking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.dao.CustomerDAO;
import com.banking.entity.Customer;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getCustomersList() {
		return customerDAO.getCustomersList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	public Customer getCustomerByMobileno(String mobleno) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerByMobileno(mobleno);
	}

	
}





