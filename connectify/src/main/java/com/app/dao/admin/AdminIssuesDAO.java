package com.app.dao.admin;

import java.util.List;

import com.app.dto.admin.AdminIssues;

public interface AdminIssuesDAO {
	public List<AdminIssues> findAdminIssuesList();
}
