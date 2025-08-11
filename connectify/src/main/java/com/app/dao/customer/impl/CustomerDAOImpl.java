package com.app.dao.customer.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.customer.CustomerDAO;
import com.app.dto.customer.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public Customer findById(String id) {
        return sqlSession.selectOne("customerMapper.findById", id);
    }

    @Override
    public int insert(Customer customer) {
        return sqlSession.insert("customerMapper.insert", customer);
    }
}
