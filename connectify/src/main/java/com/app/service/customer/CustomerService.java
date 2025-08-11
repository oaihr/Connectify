package com.app.service.customer;

import com.app.dto.customer.Customer;

public interface CustomerService {
    Customer login(String id, String pw);
    int signup(Customer customer);
}
