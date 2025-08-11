package com.app.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.customer.CustomerDAO;
import com.app.dto.customer.Customer;
import com.app.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public Customer findById(String id) {
        Customer customer = customerDAO.findById(id);

        return customer;
    }

    @Override
    public int signup(Customer customer) {
    	int result = customerDAO.signup(customer);
    	
        return result;
    }

	@Override
	public Customer checkCustomerLogin(Customer customer) {
		Customer loginCus = customerDAO.checkCustomerLogin(customer);
		return loginCus;
	}


}
