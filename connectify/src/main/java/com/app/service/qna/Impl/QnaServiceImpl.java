package com.app.service.qna.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.qna.QnaDAO;
import com.app.dto.qna.Qna;
import com.app.service.qna.QnaService;

@Service
public class QnaServiceImpl implements QnaService{

	@Autowired
	public QnaDAO qnaDAO;
	
	@Override
    public List<Qna> getPublicQna() {
        return qnaDAO.getPublicQna();
    }

    @Override
    public List<Qna> getPrivateQnaForUser(String userId) {
        // 로그인된 사용자 ID를 기준으로 조회해야 함
        // 지금은 임시로 userId를 "testUser"로 하드코딩
        // 나중에 실제 로그인 세션에서 가져와야 함
        return qnaDAO.getPrivateQnaForUser(userId);
    }

    @Override
    public void insertQna(Qna qna) {
        qnaDAO.insertQna(qna);
    }

	@Override
	public void deleteQna(int id) {
		qnaDAO.deleteQna(id);
	}
}
