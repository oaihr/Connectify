package com.app.controller.travel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.api.dto.areaBasedList.AreaBasedListItem;
import com.app.service.travel.TravelService;

@Controller
public class TravelController {
	
	private static final Logger logger = LoggerFactory.getLogger(TravelController.class);
	
	@Autowired
	TravelService travelService;
	
	@RequestMapping("/travels")
	public String travel(@RequestParam int category, 
						 @RequestParam(defaultValue="1") int page,
						Model model) {
		
		final int pageSize = 9; // 한 페이지에 9개씩
		int startRow = (page-1) * pageSize + 1; // 시작할 행
		int endRow = page * pageSize;
		
		int count = travelService.getDestinationsListCountByContentTypeId(category);
		logger.info("Category: " + category + ", Total count: " + count);

		// contentTypeId 별 전체 페이지 수 
		int totalPages = (int)Math.ceil((double)count/pageSize);
		logger.info("Total pages: " + totalPages);

		Map<String, Integer> params = new HashMap<>();
		params.put("contentTypeId", category);
		params.put("startRow", startRow);
		params.put("endRow", endRow);
		
		List<AreaBasedListItem> destinations = travelService.getDestinationsListByContentTypeId(params); 
		
		if(destinations != null) {
			model.addAttribute("destinations", destinations);
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("currentCategory", category);
		}else {
			logger.warn("destinations가 비어있음");
		}
		
		return "travel/travel";
	}
	
}
