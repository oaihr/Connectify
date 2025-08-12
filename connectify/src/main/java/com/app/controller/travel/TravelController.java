package com.app.controller.travel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String travels(@RequestParam int category, 
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
		
		return "travel/travels";
	}
	
	@GetMapping("/travel/{id}")
	public String travelInfo(@PathVariable("id") String id, Model model) {
		
		AreaBasedListItem destination = travelService.getDetailIntroByContentId12(id);
//		switch(destination.getContenttypeid()) {
//			case 12:
//				destination = travelService.getDetailIntroByContentId12(id);
//				break;
//			case 14:
//				destination = travelService.getDetailIntroByContentId14(id);
//				break;
//			case 15:
//				destination = travelService.getDetailIntroByContentId15(id);
//				break;
//			case 28:
//				destination = travelService.getDetailIntroByContentId28(id);
//				break;
//			case 38:
//				destination = travelService.getDetailIntroByContentId38(id);
//				break;
//			case 39:
//				destination = travelService.getDetailIntroByContentId39(id);
//				break;
//		}
		
		if(destination != null) {
			model.addAttribute("destination", destination);
		}else {
			logger.warn("destination이 비어있음");
		}
		
		return "travel/travel";
	}
	
	@RequestMapping("/lodgings")
	public String lodgings(@RequestParam String category, @RequestParam(defaultValue="1") int page, Model model) {
		
		final int pageSize = 9; // 한 페이지에 9개씩
		int startRow = (page-1) * pageSize + 1; // 시작할 행
		int endRow = page * pageSize;
		
		int count = travelService.getLodgingListCountByLclsSystm3(category);
		logger.info("Category: " + category + ", Total count: " + count);

		// contentTypeId 별 전체 페이지 수 
		int totalPages = (int)Math.ceil((double)count/pageSize);
		logger.info("Total pages: " + totalPages);

		Map<String, Object> params = new HashMap<>();
		params.put("category", category);
		params.put("startRow", startRow);
		params.put("endRow", endRow);
		
		List<AreaBasedListItem> lodgings = travelService.getLodgingListByLcslSystm3(params);
		
		if(lodgings != null) {
			model.addAttribute("lodgings", lodgings);
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("currentCategory", category);
		}else {
			logger.warn("lodgings가 비어있음");
		}
		
		return "travel/lodgings";
	}
	
	@GetMapping("/lodging/{id}")
	public String lodgingInfo(@PathVariable("id") String id, Model model) {
		
		AreaBasedListItem destination = travelService.getDestinationByContentID(id);
		
		if(destination != null) {
			model.addAttribute("destination", destination);
		}else {
			logger.warn("destination이 비어있음");
		}
		
		return "travel/lodging";
	}
}
