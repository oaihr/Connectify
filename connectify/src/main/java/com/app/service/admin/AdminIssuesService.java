package com.app.service.admin;

import java.util.List;

import com.app.dto.admin.AdminIssues;

public interface AdminIssuesService {
	public List<AdminIssues> findAdminIssuesList();
	public int updateAnswer(AdminIssues adminIssues);
	public AdminIssues findAdminIssueId(int id);
	public int removeIssue(int id);
	public int updateStatus(AdminIssues adminIssues);
}
