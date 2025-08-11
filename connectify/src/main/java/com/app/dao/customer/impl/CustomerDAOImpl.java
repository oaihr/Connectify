package com.app.dao.customer.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.customer.CustomerDAO;
import com.app.dto.customer.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Customer findById(String id) {
    	
    	Customer customer = sqlSessionTemplate.selectOne("customer_mapper.findById", id);
    	
        return customer;
    }

    @Override
    public int signup(Customer customer) {
    	
    	int result = sqlSessionTemplate.insert("customer_mapper.signup", customer);
        return result;
    }

	@Override
	public Customer checkCustomerLogin(Customer customer) {
		Customer loginCus = sqlSessionTemplate.selectOne("customer_mapper.checkCustomerLogin", customer);
		return loginCus;
	}


}
