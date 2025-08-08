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

}
