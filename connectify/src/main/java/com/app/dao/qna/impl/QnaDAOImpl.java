package com.app.dao.qna.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.qna.QnaDAO;
import com.app.dto.qna.Qna;

@Repository
public class QnaDAOImpl implements QnaDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "qnaMapper.";

	@Override
    public List<Qna> getPublicQna() {
        return sqlSession.selectList(NAMESPACE + "getPublicQna");
    }

    @Override
    public List<Qna> getPrivateQnaForUser(String userId) {
        return sqlSession.selectList(NAMESPACE + "getPrivateQnaForUser", userId);
    }
    
    @Override
    public void insertQna(Qna qna) {
        sqlSession.insert("qnaMapper.insertQna", qna);
    }

	@Override
	public void deleteQna(int id) {
		sqlSession.delete(NAMESPACE + "deleteQna", id);
	}
}
