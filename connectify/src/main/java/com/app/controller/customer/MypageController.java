package com.app.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

	@GetMapping("/user/mypage")
	public String mypage() {
		//화면 구상용 주소와  return
		
		return "/mainscreen/userMypage";
	}
	
}
