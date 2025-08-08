package com.app.controller.mainscreen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String connectify() {
		
		
		
		return "/mainscreen/mainscreen";
	}
}
