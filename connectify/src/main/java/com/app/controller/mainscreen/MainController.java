package com.app.controller.mainscreen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String connectify() {
		
		
		
		return "/mainscreen/mainscreen";
	}
	
	//검색 form 후 사용자 날짜 데이터 api 숙소? 날짜 데이터랑 겹치는 부분 검색 결과로 보여주기?
	
}
