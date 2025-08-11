package com.app.service.customer;

import com.app.dto.customer.Customer;

public interface CustomerService {
	Customer findById(String id);
	int signup(Customer customer);
	
	Customer checkCustomerLogin(Customer customer);
}
