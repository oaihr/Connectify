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
import com.app.service.qna.QnaService;

@Controller
public class CustomerServiceController {

	@Autowired
	private CsService csService;

	@Autowired
	private QnaService qnaService;

	//자주 묻는 질문 리스트
	@GetMapping("/faq")
	public String showFaqList(Model model) {
		
		System.out.println("faq접속");
		List<Cs> faqList = csService.getAllFaqs();

		model.addAttribute("faqList", faqList);
		return "cs/faq";
	}

	//문의하기
	@GetMapping("/qna")
	public String showQnaPage(Model model, HttpSession session) {
	    System.out.println("qna접속");
	    
	    // 1. 공개 질문 목록 가져오기 (isPublic = 1)
	    List<Qna> qnaList = qnaService.getPublicQna();

	    // 2. 로그인된 사용자의 1:1 질문 목록 가져오기 (isPublic = 0)
	    //String userId = (String) session.getAttribute("loginId");
	    String userId = "testuser";// 임시방편 로그인
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
	    return "cs/private_qna_popup"; // private_qna_popup.jsp 파일로 연결
	}

	@GetMapping("/qna/public_qna_popup")
	public String openPublicPopup() {
	    return "cs/public_qna_popup"; // public_qna_popup.jsp 파일로 연결
	}
	
	//문의하기 메시지 내용전송
	@PostMapping("/qna/popup")
	public String writeQna(Qna qna, HttpSession session) {

//	    임시용하드코딩
	    String userId = "testuser";
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

}
