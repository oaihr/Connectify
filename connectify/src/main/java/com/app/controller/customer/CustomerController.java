package com.app.controller.customer;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.customer.Customer;
import com.app.service.customer.CustomerService;
import com.app.util.LoginManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

  //로그인
    @GetMapping("/customer/login")
    public String loginForm() {
        return "customer/login";
    }

    @PostMapping("/customer/login")
    public String login(Customer customer, HttpSession session) {

        Customer loginCus = customerService.checkCustomerLogin(customer);
        System.out.println(loginCus);
        
        if (loginCus == null) {
            return "redirect:/customer/login";
        } else {
        	// 인터셉터가 체크하는 "loginId" 키로 세션에 사용자 ID를 직접 저장
            session.setAttribute("loginId", loginCus.getId());
            
        	LoginManager.setSessionLoginUserId(session, loginCus.getId());
        	session.setAttribute("customer", loginCus);
        	return "redirect:/";
        }
    }
    
    
//회원가입
    @GetMapping("/customer/signup")
    public String signupForm(Model model) {
    	 model.addAttribute("customer", new Customer());
        return "customer/signup";
    }

    @PostMapping("/customer/signup")
    public String signup(@Valid Customer customer, BindingResult bindingResult, Model model) {
        
        // 1. 유효성 검증 실패 시
        if (bindingResult.hasErrors()) {
            // 회원가입 페이지로 돌아가 오류 메시지 출력
            return "customer/signup";
        }

        // 2. 유효성 검증 성공 시
        int result = customerService.signup(customer);
        
        if (result > 0) {
        	// DB 저장 실패 시 에러 메시지를 모델에 담아 회원가입 페이지로 이동
        	 model.addAttribute("error");
            return "customer/signup";
        } else {
        	// DB 저장 성공 시 로그인 페이지로 리다이렉트
            return "redirect:/";
        }
    }

   //로그인 성공 임시 페이지
    @GetMapping("/customer/main")
    public String main() {
        return "customer/main";
    }
    
    //로그아웃
	@GetMapping("/customer/logout")
	public String customerlogout(HttpSession session) {
		LoginManager.logout(session);
		return "redirect:/";
	}
}
