package com.app.dao.admin.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.admin.AdminDAO;
import com.app.dto.admin.Admin;


@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Admin findAdminId(String id) {
		Admin admin = sqlSessionTemplate.selectOne("admin_mapper.findAdminId", id);
		return admin;
	}

	@Override
	public Admin checkAdminLogin(Admin admin) {
		Admin loginAdmin = sqlSessionTemplate.selectOne("admin_mapper.checkAdminLogin", admin);
		return loginAdmin;
	}

	/*
	 * @Override public List<AdminUser> findAdminUserListBySearch(AdminUserSearch
	 * adminUserSearch) {
	 * 
	 * List<AdminUser> userList =
	 * sqlSessionTemplate.selectList("admin_mapper.findAdminUserListBySearch",
	 * adminUserSearch);
	 * 
	 * return userList; }
	 */
	
	



}
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
