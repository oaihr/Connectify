package com.app.service.admin;

import java.util.List;

import com.app.dto.admin.AdminUser;
import com.app.dto.admin.AdminUserSearch;

public interface AdminUserService {
	
	public List<AdminUser> findAdminUserList();
	public List<AdminUser> findAdminUserListBySearch(AdminUserSearch adminUserSearch);
	public AdminUser findAdminUserById(String id);
}
