package com.app.dao.admin;

import java.util.List;

import com.app.dto.admin.AdminIssues;
import com.app.dto.admin.AdminUser;
import com.app.dto.admin.AdminUserSearch;

public interface AdminUserDAO {

	public List<AdminUser> findAdminUserList();
	public List<AdminUser> findAdminUserListBySearch(AdminUserSearch adminUserSearch);
	public AdminUser findAdminUserById(String id);
	public List<AdminIssues> findAdminIssuesList();
}
