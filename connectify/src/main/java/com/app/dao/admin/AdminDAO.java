package com.app.dao.admin;


import java.util.List;

import com.app.dto.admin.Admin;
import com.app.dto.admin.AdminUser;
import com.app.dto.admin.AdminUserSearch;


public interface AdminDAO {

	public Admin findAdminId(String id);
	public Admin checkAdminLogin(Admin admin);
	
	//public List<AdminUser> findAdminUserListBySearch(AdminUserSearch adminUserSearch);
}
