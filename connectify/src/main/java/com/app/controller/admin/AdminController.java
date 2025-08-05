package com.app.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.admin.Admin;
import com.app.service.admin.AdminService;
import com.app.util.LoginManager;

@Controller
public class AdminController {  
	
	@Autowired
	AdminService adminService;
	

	@GetMapping("/admin")
	public String adminSignIn() {
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
	
}
