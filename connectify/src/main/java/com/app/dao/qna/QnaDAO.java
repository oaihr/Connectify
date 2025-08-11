package com.app.dao.qna;

import java.util.List;

import com.app.dto.qna.Qna;

public interface QnaDAO {

	public List<Qna> getPublicQna();

	public List<Qna> getPrivateQnaForUser(String userId);

	void insertQna(Qna qna);
	
	void deleteQna(int id); //테이블에 부여된 id번호를 기준으로 댓글을 삭제할 수 있는 댓글 삭제 메소드
}