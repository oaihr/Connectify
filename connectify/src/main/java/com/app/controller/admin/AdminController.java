package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.admin.Admin;
import com.app.dto.admin.AdminIssues;
import com.app.dto.admin.AdminUser;
import com.app.dto.admin.AdminUserSearch;
import com.app.service.admin.AdminIssuesService;
import com.app.service.admin.AdminService;
import com.app.service.admin.AdminUserService;
import com.app.util.LoginManager;

@Controller
public class AdminController {  
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminUserService  adminUserService;
	
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
			
			//사용자
			List<AdminUser> userList = adminUserService.findAdminUserList();
			model.addAttribute("userList", userList);
			
			//질문
			List<AdminIssues> issueList = adminIssuesService.findAdminIssuesList();
			model.addAttribute("issueList", issueList);
			
			//신고
			
			
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
	
	
/* ============ 여행지 ================ */
	//여행지 페이지
	@GetMapping("/admin/travel")
	public String tarvel(Model model) {
		
		model.addAttribute("activeTab", "tab-1");
		
		return "admin/adminTravel/adminTravel";
	}
	
	
	
	

/* ============ 사용자 ================ */
	//사용자 페이지
	@GetMapping("/admin/user")
	public String user(Model model) {
		
		model.addAttribute("activeTab", "tab-2");
		
		return "admin/adminUser/adminUser";
	}
	

	//사용자 검색
	@PostMapping("/admin/user")
	public String searchUser(Model model, AdminUserSearch adminUserSearch) {
		
		List<AdminUser> userList = adminUserService.findAdminUserListBySearch(adminUserSearch);
		
		model.addAttribute("userList", userList);
		model.addAttribute("adminUserSearch", adminUserSearch);
		
		model.addAttribute("activeTab", "tab-2");
		
		return "admin/adminUser/adminUser";
	}
	
	//사용자 정보
	@GetMapping("/admin/user/{userId}")
	public String userInfo(@PathVariable String userId, Model model) {
		
		AdminUser user = adminUserService.findAdminUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("activeTab", "tab-2");
		
		System.out.println(user);
		
		return "admin/adminUser/adminUserInfo";
	}
	
	
	
/* ============ 질문 ================ */
	//질문 페이지
	@GetMapping("/admin/issue")
	public String issue(Model model) {
		
		model.addAttribute("activeTab", "tab-3");
		
		return "admin/adminIssue/adminIssue";
	}
	

	
/* ============ 신고 ================ */
	//신고 페이지
	@GetMapping("/admin/report")
	public String report(Model model) {
		
		model.addAttribute("activeTab", "tab-4");
		
		return "admin/adminReport/adminReport";
	}
	
}
