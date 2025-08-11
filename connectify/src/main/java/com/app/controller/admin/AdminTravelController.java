package com.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminTravelController {
	
/* ============ 여행지 ================ */
	//여행지 페이지
	@GetMapping("/admin/travel")
	public String tarvel(Model model) {
		
		return "admin/adminTravel/adminTravel";
	}
}
