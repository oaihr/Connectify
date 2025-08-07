package com.app.dao.admin.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.admin.AdminUserDAO;
import com.app.dto.admin.AdminUser;
import com.app.dto.admin.AdminUserSearch;

@Repository
public class AdminUserDAOImpl implements AdminUserDAO{

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<AdminUser> findAdminUserList() {
		List<AdminUser> adminUserList = sqlSessionTemplate.selectList("admin_mapper.findAdminUserList");
		return adminUserList;
	}

	@Override
	public List<AdminUser> findAdminUserListBySearch(AdminUserSearch adminUserSearch) {
		List<AdminUser> userList = sqlSessionTemplate.selectList("admin_mapper.findAdminUserListBySearch", adminUserSearch);
		return userList;
	}

	@Override
	public AdminUser findAdminUserById(String id) {
		AdminUser userId = sqlSessionTemplate.selectOne("admin_mapper.findAdminUserById", id);
		return userId;
	}


	
	
}
