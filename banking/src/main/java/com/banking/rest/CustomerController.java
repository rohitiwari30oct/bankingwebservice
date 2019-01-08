package com.banking.rest;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.banking.entity.Customer;

@RestController
public class CustomerController {
	@RequestMapping(value = "/createcustomer", method = RequestMethod.GET)
	@ResponseBody public List<Customer> createCustomer()
	{
		return null;
	}

}
