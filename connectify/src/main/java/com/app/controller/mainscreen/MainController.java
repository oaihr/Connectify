package com.app.controller.mainscreen;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.customer.Customer;
import com.app.service.customer.CustomerService;
import com.app.util.LoginManager;


@Controller
public class MainController {
	
    @Autowired
    CustomerService customerService;
	
	@GetMapping("/")
	public String connectify(Model model, HttpSession session) {
		
			String loginCusId = LoginManager.getLoginUserId(session);
			Customer customer = customerService.findById(loginCusId);
			model.addAttribute("customer", customer);

		return "/mainscreen/mainscreen";
	}
	
	//검색 form 후 사용자 날짜 데이터 api 숙소? 날짜 데이터랑 겹치는 부분 검색 결과로 보여주기?
	
}
