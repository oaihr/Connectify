package com.app.dto.qna;

import java.util.Date;

import lombok.Data;

@Data
public class Qna {

	private int id;				 //자동 할당 되는 아이디
	private String userId;         // 사용자_아이디
    private String adminId;        // 답변_관리자_아이디 (답변 후에 들어감)

    private Date askTime;      // 문의시간
    private String title;          // 문의제목
    private String question;        // 문의내용

    private String answer;         // 답변내용
    private String status;         // 처리상태 (예: "대기", "완료")
    
    private int isPublic;   //공개여부, 공개된 문의(게시판)라면 1이고 1:1 비공개 문의는 0으로 한다.


}
