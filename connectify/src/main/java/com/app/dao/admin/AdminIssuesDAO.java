package com.app.dao.admin;

import java.util.List;

import com.app.dto.admin.AdminIssues;

public interface AdminIssuesDAO {
	public List<AdminIssues> findAdminIssuesList();
	public int updateAnswer(AdminIssues adminIssues);
	public AdminIssues findAdminIssueId(int id);
	public int removeIssue(int id);
}
