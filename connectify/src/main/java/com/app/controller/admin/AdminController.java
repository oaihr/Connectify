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
//package com.app.controller.admin;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import com.app.dto.admin.Admin;
//import com.app.service.admin.AdminService;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private AdminService adminService;
//
//    @GetMapping("/signup")
//    public String showSignupForm() {
//        return "admin/signup";
//    }
//
//    @PostMapping("/signup")
//    public String signup(@RequestParam String id, @RequestParam String pw, @RequestParam String name, Model model) {
//        String pwPattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$";
//        if (!pw.matches(pwPattern)) {
//            model.addAttribute("msg", "비밀번호는 영문, 숫자, 특수문자 8자 이상이어야 합니다.");
//            return "admin/signup";
//        }
//
//        boolean ok = adminService.signup(new Admin(id, pw, name));
//        if (!ok) {
//            model.addAttribute("msg", "회원가입 실패! (아이디 중복 등)");
//            return "admin/signup";
//        }
//
//        model.addAttribute("msg", "관리자 회원가입이 완료되었습니다. 로그인해주세요.");
//        return "admin/login";
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "admin/login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String id, @RequestParam String pw, Model model) {
//        if (adminService.isLocked(id)) {
//            model.addAttribute("msg", "5회 실패. 24시간 잠금");
//            return "admin/login";
//        }
//        if (adminService.login(id, pw)) {
//            return "redirect:/admin/dashboard";
//        }
//        model.addAttribute("msg", "아이디 또는 비밀번호 오류. 5회 실패 시 24시간 잠금");
//        return "admin/login";
//    }
//
//    @GetMapping("/dashboard")
//    public String dashboard() {
//        return "admin/dashboard";
//    }
//}
