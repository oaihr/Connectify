package com.app.dao.customer;

import com.app.dto.customer.Customer;

public interface CustomerDAO {
    Customer findById(String id);
    int signup(Customer customer);
    
    Customer checkCustomerLogin(Customer customer);
}
