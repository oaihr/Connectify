package com.app.service.admin;

import com.app.dto.admin.Admin;

public interface AdminService {
	
	public Admin findAdminId(String id);
	public Admin checkAdminLogin(Admin admin);
}
