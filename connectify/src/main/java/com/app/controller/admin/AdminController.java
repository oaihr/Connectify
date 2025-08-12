package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.admin.Admin;
import com.app.dto.admin.AdminIssues;
import com.app.dto.admin.AdminUserSearch;
import com.app.service.admin.AdminIssuesService;
import com.app.service.admin.AdminService;
import com.app.util.LoginManager;

@Controller  
public class AdminController { 
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminIssuesService adminIssuesService;

	@GetMapping("/admin")
	public String adminSignIn() {
		//admin001
		//adminpass1
		
		//admin004
		//adminpass4
		return "admin/adminSignIn";
	}
	
	@PostMapping("/admin")
	public String adminSignInAction(Admin admin, HttpSession session) {
		
		Admin loginAdmin = adminService.checkAdminLogin(admin);
		System.out.println(loginAdmin);
		
		if(loginAdmin == null) {
			return "admin/adminSignIn";
		} else {
			LoginManager.setSessionLoginUserId(session, loginAdmin.getId());
			session.setAttribute("admin", loginAdmin);
			return "redirect:/admin/main";
		}
		
		
	}
	
	@GetMapping("/admin/main")
	public String adminMain(Model model, HttpSession session, AdminUserSearch adminUserSearch) {
		
		if(LoginManager.isLogin(session)) {
			String loginUserId = LoginManager.getLoginUserId(session);
			
			Admin admin = adminService.findAdminId(loginUserId);
			model.addAttribute("admin", admin);
			
			List<AdminIssues> issueList = adminIssuesService.findAdminIssuesList();
			model.addAttribute("issueList", issueList);
			
			return "admin/adminMain";
		}
		
		return "redirect:/admin";
		
	}
	
	//로그아웃
	@GetMapping("/admin/logout")
	public String adminlogout(HttpSession session) {
		LoginManager.logout(session);
		return "redirect:/admin";
	}
	
	
}

