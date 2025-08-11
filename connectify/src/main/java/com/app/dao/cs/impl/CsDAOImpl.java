package com.app.dao.cs.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.cs.CsDAO;
import com.app.dto.cs.Cs;

@Repository
public class CsDAOImpl implements CsDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "faqMapper.";

	@Override
	public List<Cs> getAllFaqs() {
		return sqlSession.selectList(NAMESPACE + "getAllFaqs");
	}

	@Override
	public List<Cs> searchByQuestion(String keyword) {
		return sqlSession.selectList(NAMESPACE + "searchByQuestion", keyword);
	}

	@Override
	public int getFaqCountByKeyword(String keyword) {
		return sqlSession.selectOne(NAMESPACE + "getFaqCountByKeyword", keyword);
	}

	@Override
	public List<Cs> searchByQuestionWithPaging(String keyword, int offset, int pageSize) {
		// 매퍼의 getFaqList 쿼리 호출 (파라미터를 Map으로 넘기면 편함)
				Map<String, Object> params = new HashMap<>();
				params.put("keyword", keyword);
				params.put("offset", offset);
				params.put("pageSize", pageSize);
		return sqlSession.selectList(NAMESPACE + "searchByQuestionWithPaging", params);
	}
}
