package com.banking.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.banking.entity.Account;
import com.banking.entity.Customer;
import com.banking.model.AccountModel;
import com.banking.model.BalanceResponseModel;
import com.banking.service.AccountService;
import com.banking.service.CustomerService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(@RequestBody AccountModel account)
	{
		try {
		Customer customer  = customerService.getCustomerByMobileno(account.getMobileno());
		if(customer==null) {
			customer = new Customer();
			customer.setName(account.getName());
			customer.setEmail(account.getEmail());
			customer.setCreated_at(new Date());
			customer.setMobileno(account.getMobileno());
			customerService.saveCustomer(customer);
		}
		
		Account acc = new Account();
		acc.setCreated_at(new Date());
		acc.setBalance(account.getBalance());
		acc.setCustomer(customer);
		accountService.saveAccount(acc);
		return "account created successfully";
		}catch(Exception e) {
			return "error occured";
		}
	}
	
	@RequestMapping(value = "/checkbalance/{accountno}", method = RequestMethod.GET)
	public BalanceResponseModel checkBalance(@PathVariable Integer accountno)
	{
		BalanceResponseModel  response = new BalanceResponseModel();
		Account account=accountService.getAccount(accountno);
		if(account==null)
		{
			response.setError("wrong account number");
			return response;
		}
		else {
			response.setError("");
			response.setBalance(account.getBalance());
			return response;
		}
	}

}
