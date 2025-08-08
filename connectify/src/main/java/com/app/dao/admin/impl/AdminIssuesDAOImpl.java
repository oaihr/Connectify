package com.app.dao.admin.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.admin.AdminIssuesDAO;
import com.app.dto.admin.AdminIssues;

@Repository
public class AdminIssuesDAOImpl implements AdminIssuesDAO{
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<AdminIssues> findAdminIssuesList() {
		List<AdminIssues> adminIssuesList = sqlSessionTemplate.selectList("admin_mapper.findAdminIssuesList");
		return adminIssuesList;
	}
	
	
}
