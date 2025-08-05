package com.app.dao.admin;


import com.app.dto.admin.Admin;


public interface AdminDAO {

	public Admin findAdminId(String id);
	public Admin checkAdminLogin(Admin admin);
}
