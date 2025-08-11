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
	
	//자주 묻는 질문 리스트
//	@GetMapping("/faq")
//	public String showFaqList(Model model) {
//		
//		System.out.println("faq접속");
//		List<Cs> faqList = csService.getAllFaqs();
//
//		model.addAttribute("faqList", faqList);
//		return "cs/faq";
//	}

	@GetMapping("/faq")
	public String faqList(@RequestParam(defaultValue = "1") int page, Model model) {

	    int pageSize = 5; // 한 페이지에 보여줄 글 수
	    int offset = (page - 1) * pageSize;
	    System.out.println("page: " + page + ", offset: " + offset + ", pageSize: " + pageSize);
	    System.out.println("faq열림");
	    
	    // 페이징 처리된 FAQ 리스트 가져오기 (PageService와 CsService 중 어떤걸 사용할지 결정)
	    // 아래는 PageService 기반 예시
	    List<Cs> faqList = pageService.getFaqList(offset, pageSize);
	    
	    int totalCount = pageService.getFaqCount();
	    // 만약 CsService에 페이징 지원 메서드가 있다면 아래처럼 쓸 수 있음
	    // List<Cs> faqs = csService.getFaqList(offset, pageSize);
	    // int totalCount = csService.getFaqCount();
	    int totalPages = (int) Math.ceil((double) totalCount / pageSize);

	    model.addAttribute("faqList", faqList);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);

	    return "cs/faq"; // 원래 두 번째 메서드의 뷰 이름 유지
	}
	
	@GetMapping("/search")
	public String searchFaq(@RequestParam("searchValue") String keyword, Model model) {
	    List<Cs> results = csService.searchByQuestion(keyword);
	    model.addAttribute("faqList", results);
	    return "cs/faq"; // jsp 이름
	}


	//문의하기
	@GetMapping("/qna")
	public String showQnaPage(Model model, HttpSession session, @RequestParam(defaultValue = "public") String tab,
            @RequestParam(required = false) String keyword) {
	    System.out.println("qna접속");
	    
	    // 1. 공개 질문 목록 가져오기 (isPublic = 1)
	    List<Qna> qnaList = qnaService.getPublicQna();

	    // 2. 로그인된 사용자의 1:1 질문 목록 가져오기 (isPublic = 0)
	    //String userId = (String) session.getAttribute("loginId");
	    String userId = "user01";// 임시방편 로그인
	    List<Qna> privateList = null;
	    if(userId != null) {
	        privateList = qnaService.getPrivateQnaForUser(userId);
	    }

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
		
		
//	    임시용하드코딩
	    String userId = "user01";
//	    String userId = (String) session.getAttribute("userId");
//
//	    if (userId == null) {
//	        return "redirect:/login"; 
//	    }

	    qna.setUserId(userId);
	    qnaService.insertQna(qna);

	    return "cs/close_popup";
	}
	
	@GetMapping("/qna/delete")
	public String deleteQna(@RequestParam("qnaId") int qnaId) {
	    System.out.println("컨트롤러가 받은 ID 값: " + qnaId); // 이 코드를 추가하세요.
	    qnaService.deleteQna(qnaId);
	    return "redirect:/qna";
	}
	
//	@GetMapping("/faq")
//	public String faqList(@RequestParam(defaultValue = "1") int page, Model model) {
//		int pageSize = 5; // 한 페이지에 보여줄 글 수
//		int offset = (page - 1) * pageSize;
//
//		List<Page> faqs = pageService.getFaqList(offset, pageSize);
//		
//		int totalCount = pageService.getFaqCount();
//		int totalPages = (int) Math.ceil((double) totalCount / pageSize);
//
//		model.addAttribute("faqList", faqs);
//		model.addAttribute("currentPage", page);
//		model.addAttribute("totalPages", totalPages);
//
//		return "faq";
//	}

}
