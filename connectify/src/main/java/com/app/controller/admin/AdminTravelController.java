package com.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.api.dto.areaBasedList.AreaBasedListItem;
import com.app.service.travel.TravelService;

@Controller
public class AdminTravelController {
	
	@Autowired
	TravelService travelService;
/* ============ 여행지 ================ */
	//여행지 페이지
	@GetMapping("/admin/travel")
	public String tarvel(Model model) {
		List<AreaBasedListItem> travelList = travelService.getDestinationList();
		
		model.addAttribute("travelList", travelList);
		return "admin/adminTravel/adminTravel";
	}
}
