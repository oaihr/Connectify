package com.app.service.qna;

import java.util.List;

import com.app.dto.qna.Qna;

public interface QnaService {
	
	List<Qna> getPublicQna();
	
	List<Qna> getPrivateQnaForUser(String userId);
	
	void insertQna(Qna qna);

	void deleteQna(int id);
}
