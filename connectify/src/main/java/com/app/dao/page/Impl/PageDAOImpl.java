package com.app.dao.page.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.page.PageDAO;
import com.app.dto.cs.Cs;

@Repository
public class PageDAOImpl implements PageDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.app.dao.page.PageDAO.";

	@Override
	public List<Cs> getFaqList(int offset, int pageSize) {
		// 매퍼의 getFaqList 쿼리 호출 (파라미터를 Map으로 넘기면 편함)
		Map<String, Object> params = new HashMap<>();
		params.put("offset", offset);
		params.put("pageSize", pageSize);

		return sqlSession.selectList(NAMESPACE + "getFaqList", params);
	}

	@Override
	public int getFaqCount() {
		return sqlSession.selectOne(NAMESPACE + "getFaqCount");
	}
}