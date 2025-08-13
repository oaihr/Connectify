package com.app.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.admin.AdminIssuesDAO;
import com.app.dto.admin.AdminIssues;
import com.app.service.admin.AdminIssuesService;

@Service
public class AdminIssuesServiceImpl implements AdminIssuesService{
	
	@Autowired
	AdminIssuesDAO adminIssuesDAO;

	@Override
	public List<AdminIssues> findAdminIssuesList() {
		List<AdminIssues> adminIssuesList = adminIssuesDAO.findAdminIssuesList();
		return adminIssuesList;
	}

	@Override
	public int updateAnswer(AdminIssues adminIssues) {
		int result = adminIssuesDAO.updateAnswer(adminIssues);
		return result;
	}

	@Override
	public AdminIssues findAdminIssueId(int id) {
		AdminIssues findId = adminIssuesDAO.findAdminIssueId(id);
		return findId;
	}

	@Override
	public int removeIssue(int id) {
		int result = adminIssuesDAO.removeIssue(id);
		return result;
	}

	@Override
	public int updateStatus(AdminIssues adminIssues) {
		int result = adminIssuesDAO.updateStatus(adminIssues);
		return result;
	}

}
