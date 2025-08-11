package com.app.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.customer.CustomerDAO;
import com.app.dto.customer.Customer;
import com.app.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer login(String id, String pw) {
        Customer customer = customerDAO.findById(id);
        if (customer != null && customer.getPw().equals(pw)) {
            return customer;
        }
        return null;
    }

    @Override
    public int signup(Customer customer) {
        return customerDAO.insert(customer);
    }
}
