package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.admin.AdminIssues;
import com.app.service.admin.AdminIssuesService;
import com.app.service.admin.AdminService;

@Controller
public class AdminIssueController {
	
	@Autowired
	AdminIssuesService adminIssuesService;
	
	@Autowired
	AdminService adminService;
	
/* ============ 질문 ================ */
	//질문 페이지
	@GetMapping("/admin/issue")
	public String issue(Model model) {
		
		List<AdminIssues> issueList = adminIssuesService.findAdminIssuesList();
		model.addAttribute("issueList", issueList);
		
		
		return "admin/adminIssue/adminIssue";
	}

	
	//질문 -> 답변 가능한 info 페이지 넘기기
	@GetMapping("/admin/issue/{id}")
	public String issueInfo(@PathVariable int id, Model model) {
		AdminIssues adminIssues = adminIssuesService.findAdminIssueId(id);
		model.addAttribute("issue", adminIssues);
		
		System.out.println(adminIssues);
		
		return "admin/adminIssue/adminIssueInfo";
	}
	
	@GetMapping("/admin/removeIssue")
	public String removeIssue(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		
		int result = adminIssuesService.removeIssue(Integer.parseInt(id));
		
		return "redirect:/admin/issue";
	}
	
	@PostMapping("/admin/issue/{id}")
	public String updateAnswer(AdminIssues adminIssues) {
		
		int result = adminIssuesService.updateAnswer(adminIssues);
		System.out.println(adminIssues);
		
		if(result > 0) {
			return "redirect:/admin/issue/" + adminIssues.getId();
		} else {
			
			return "redirect:/admin/issue/" + adminIssues.getId();
		}
		
	}
	
	
}
