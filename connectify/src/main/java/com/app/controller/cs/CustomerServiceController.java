package com.app.controller.cs;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.cs.Cs;
import com.app.dto.qna.Qna;
import com.app.service.cs.CsService;
import com.app.service.page.PageService;
import com.app.service.qna.QnaService;

@Controller
public class CustomerServiceController {

	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private CsService csService;

	@GetMapping("/faq")
	public String faqList(@RequestParam(defaultValue = "1") int page, Model model) {

		int pageSize = 5; // 한 페이지에 보여줄 글 수
		int offset = (page - 1) * pageSize;
		System.out.println("page: " + page + ", offset: " + offset + ", pageSize: " + pageSize);
		System.out.println("faq열림");

		List<Cs> faqList = pageService.getFaqList(offset, pageSize);

		int totalCount = pageService.getFaqCount();

		int totalPages = (int) Math.ceil((double) totalCount / pageSize);

		model.addAttribute("faqList", faqList);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);

		return "cs/faq";
	}
	
	@GetMapping("/search")
	public String searchFaq(@RequestParam("searchValue") String keyword, 
	                        @RequestParam(defaultValue = "1") int page, 
	                        Model model) {

	    int pageSize = 5;
	    int offset = (page - 1) * pageSize;
	    
	    int totalCount = csService.getFaqCountByKeyword(keyword); 

	    List<Cs> results = csService.searchByQuestionWithPaging(keyword, offset, pageSize);
	    
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);

	    model.addAttribute("faqList", results);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("searchValue", keyword);

	    return "cs/faq"; 
	}


	//문의하기
	@GetMapping("/qna")
	public String showQnaPage(Model model, HttpSession session, @RequestParam(defaultValue = "public") String tab,
            @RequestParam(required = false) String keyword) {
	    System.out.println("qna접속");
	    
	    // 1. 공개 질문 목록 가져오기 (isPublic = 1) 1은 전체가 볼 수 있는 공개내용
	    List<Qna> qnaList = qnaService.getPublicQna();

	    // 2. 로그인된 사용자의 1:1 질문 목록 가져오기 (isPublic = 0) 0은 1:1만 볼 수 있는 비공개
	    String userId = (String) session.getAttribute("loginId");
	    List<Qna> privateList = qnaService.getPrivateQnaForUser(userId);
	    

	    model.addAttribute("qnaList", qnaList);
	    model.addAttribute("privateList", privateList);
	    
	    return "cs/qna";
	}
	
	//문의하기 메시지 팝업창
	@GetMapping("/qna/private_qna_popup")
	public String openOneToOnePopup() {
		System.out.println("1:1문의 팝업창열림");
		
	    return "cs/private_qna_popup"; // private_qna_popup.jsp 파일로 연결
	}

	@GetMapping("/qna/public_qna_popup")
	public String openPublicPopup() {
		System.out.println("게시판문의 팝업창열림");
	    return "cs/public_qna_popup"; // public_qna_popup.jsp 파일로 연결
	}
	
	//문의하기 메시지 내용전송
	@PostMapping("/qna/popup")
	public String writeQna(Qna qna, HttpSession session) {
		
	    String userId = (String) session.getAttribute("loginId");

	    if (userId == null) {
	        return "redirect:/login"; 
	    }

	    qna.setUserId(userId);
	    qnaService.insertQna(qna);

	    return "cs/close_popup";
	}
	
	@GetMapping("/qna/delete")
	public String deleteQna(@RequestParam("qnaId") int qnaId) {
	    System.out.println("컨트롤러가 받은 ID 값: " + qnaId);
	    qnaService.deleteQna(qnaId);
	    return "redirect:/qna";
	}

}
