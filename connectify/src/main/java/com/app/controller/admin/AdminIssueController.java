package com.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.admin.AdminIssues;
import com.app.service.admin.AdminIssuesService;

@Controller
public class AdminIssueController {
	
	@Autowired
	AdminIssuesService adminIssuesService;
	
/* ============ 질문 ================ */
	//질문 페이지
	@GetMapping("/admin/issue")
	public String issue(Model model) {
		
		List<AdminIssues> issueList = adminIssuesService.findAdminIssuesList();
		model.addAttribute("issueList", issueList);
		
		
		return "admin/adminIssue/adminIssue";
	}
	
	@PostMapping("/admin/issue")
	public String issueAction(Model model) {
		
		
		
		return "admin/adminIssue/adminIssue";
	}
	
	
	
	
}
