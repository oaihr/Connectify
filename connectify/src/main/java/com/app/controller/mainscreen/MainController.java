package com.app.controller.mainscreen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	// 나중에 user 쪽으로 유저 인증 + jsp파일 위치 바꿔서 경로 수정 필요
	@GetMapping("/user/mypage")
	public String mypage() {
		//화면 구상용 주소와  return
		
		return "/mainscreen/userMypage";
	}
	
	@GetMapping("/")
	public String connectify() {
		//user id session 존재하면 로그아웃 버튼 null이면 로그인 코드 필요
		
		
		
		return "/mainscreen/mainscreen";
	}
	
	//검색 form 후 사용자 날짜 데이터 api 숙소? 날짜 데이터랑 겹치는 부분 검색 결과로 보여주기?
	
}
