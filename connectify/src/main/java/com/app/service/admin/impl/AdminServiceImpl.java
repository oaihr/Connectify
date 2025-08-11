package com.app.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.admin.AdminDAO;
import com.app.dto.admin.Admin;
import com.app.service.admin.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDAO adminDAO;
	

	@Override
	public Admin findAdminId(String id) {
		Admin admin = adminDAO.findAdminId(id);
		return admin;
	}

	@Override
	public Admin checkAdminLogin(Admin admin) {
		Admin loginAdmin = adminDAO.checkAdminLogin(admin);
		return loginAdmin;
	}



	
	
}
