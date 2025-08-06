package com.app.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.admin.AdminUserDAO;
import com.app.dto.admin.AdminUser;
import com.app.dto.admin.AdminUserSearch;
import com.app.service.admin.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired
	AdminUserDAO adminUserDAO;

	@Override
	public List<AdminUser> findAdminUserList() {
		List<AdminUser> adminUserList = adminUserDAO.findAdminUserList();
		return adminUserList;
	}

	@Override
	public List<AdminUser> findAdminUserListBySearch(AdminUserSearch adminUserSearch) {
		List<AdminUser> userList = adminUserDAO.findAdminUserListBySearch(adminUserSearch);
		return userList;
	}

}
