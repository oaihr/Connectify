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
//package com.app.service.admin.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.app.dao.admin.AdminDAO;
//import com.app.dto.admin.Admin;
//import com.app.service.admin.AdminService;
//
//@Service
//public class AdminServiceImpl implements AdminService {
//
//    @Autowired
//    private AdminDAO adminDAO;
//
//    @Override
//    public boolean login(String id, String pw) {
//        Admin admin = adminDAO.findById(id);
//        return admin != null && admin.getPw().equals(pw);
//    }
//
//    @Override
//    public boolean signup(String id, String pw, String name) {
//        if (adminDAO.findById(id) != null) return false;
//        Admin admin = new Admin(name, name, name);
//        admin.setId(id);
//        admin.setPw(pw);
//        admin.setName(name);
//        return adminDAO.insert(admin) > 0;
//    }
//
//	@Override
//	public boolean signup(Admin admin) {
//	
//		return false;
//	}
//
//	@Override
//	public boolean isLocked(String id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
