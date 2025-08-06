package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.admin.Admin;
import com.app.dto.admin.AdminUser;
import com.app.dto.admin.AdminUserSearch;
import com.app.service.admin.AdminService;
import com.app.service.admin.AdminUserService;
import com.app.util.LoginManager;

@Controller
public class AdminController {  
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminUserService  adminUserService;
	

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
		
		if(loginAdmin == null) {
			return "admin/adminSignIn";
		} else {
			LoginManager.setSessionLoginUserId(session, loginAdmin.getId());
			return "redirect:/admin/main";
		}
		
		
	}
	
	@GetMapping("/admin/main")
	public String adminMain(Model model, HttpSession session) {
		
		if(LoginManager.isLogin(session)) {
			String loginUserId = LoginManager.getLoginUserId(session);
			
			Admin admin = adminService.findAdminId(loginUserId);
			model.addAttribute("admin", admin);
			
			return "admin/adminMain";
		}
		
		return "redirect:/admin";
		
	}
	
	@GetMapping("/admin/logout")
	public String adminlogout(HttpSession session) {
		LoginManager.logout(session);
		return "redirect:/admin";
	}
	

	//사용자 검색
	@PostMapping("/admin/searchUser")
	public String searchUser(Model model, AdminUserSearch adminUserSearch) {
		
		List<AdminUser> adminUserList = adminUserService.findAdminUserListBySearch(adminUserSearch);
		List<AdminUser> userList = adminUserService.findAdminUserList();
		
		model.addAttribute("adminUserList", adminUserList);
		model.addAttribute("adminUserSearch", adminUserSearch);
		
		model.addAttribute("userList", userList);
		
		model.addAttribute("activeTab", "tab-2");

		return "admin/adminMain";
	}
	
	//사용자 정보
	@PostMapping("/admin/userInfo")
	public String userInfo(Model model) {
		List<AdminUser> userList = adminUserService.findAdminUserList();
		
		model.addAttribute("userList", userList);
		
		model.addAttribute("activeTab", "tab-2");
		
		return "admin/adminMain";
	}
	
}
