//package com.app.dao.admin.impl;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.app.dao.admin.AdminDAO;
//import com.app.dto.admin.Admin;
//
//@Repository
//public class AdminDAOImpl implements AdminDAO {
//
//    @Autowired
//    private SqlSession sqlSession;
//
//    private static final String NAMESPACE = "adminMapper.";
//
//    @Override
//    public Admin findById(String id) {
//        return sqlSession.selectOne(NAMESPACE + "findById", id);
//    }
//
//    @Override
//    public int insert(Admin admin) {
//        return sqlSession.insert(NAMESPACE + "insert", admin);
//    }
//}
