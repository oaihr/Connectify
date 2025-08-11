package com.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminReportController {
	
	
/* ============ 신고 ================ */
	//신고 페이지
	@GetMapping("/admin/report")
	public String report(Model model) {
		
		/* model.addAttribute("activeTab", "tab-4"); */
		
		return "admin/adminReport/adminReport";
	}
	
}
