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
