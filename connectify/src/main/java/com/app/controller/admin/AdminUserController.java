package com.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.admin.AdminUser;
import com.app.dto.admin.AdminUserSearch;
import com.app.service.admin.AdminUserService;


@Controller
public class AdminUserController {
	@Autowired
	AdminUserService  adminUserService;
	

/* ============ 사용자 ================ */
	//사용자 페이지
	@GetMapping("/admin/user")
	public String searchUser(Model model) {
		List<AdminUser> userList = adminUserService.findAdminUserList();
		
		model.addAttribute("userList", userList);
		
		return "admin/adminUser/adminUser";
	}
	

	//사용자 검색
	@PostMapping("/admin/user")
	public String searchUserAction(Model model, AdminUserSearch adminUserSearch) {
		
		List<AdminUser> userList = adminUserService.findAdminUserListBySearch(adminUserSearch);
		
		model.addAttribute("userList", userList);
		model.addAttribute("adminUserSearch", adminUserSearch);
		
		return "admin/adminUser/adminUser";
	}
	
	
	//사용자 정보
	@GetMapping("/admin/user/{userId}")
	public String userInfo(@PathVariable String userId, Model model) {
		
		AdminUser user = adminUserService.findAdminUserById(userId);
		model.addAttribute("user", user);
		
		System.out.println(user);
		
		return "admin/adminUser/adminUserInfo";
	}
	

	

}
