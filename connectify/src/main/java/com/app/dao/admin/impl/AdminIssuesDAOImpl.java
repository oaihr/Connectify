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
	
	@Override
	public int updateAnswer(AdminIssues adminIssues) {
		int result = sqlSessionTemplate.update("admin_mapper.updateAnswer", adminIssues);
		return result;
	}

	@Override
	public AdminIssues findAdminIssueId(int id) {
		AdminIssues findId = sqlSessionTemplate.selectOne("admin_mapper.findAdminIssueId", id);
		return findId;
	}

	@Override
	public int removeIssue(int id) {
		int result = sqlSessionTemplate.delete("admin_mapper.removeIssue", id);
		return result;
	}


	
	
}
