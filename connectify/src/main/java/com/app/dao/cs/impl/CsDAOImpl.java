package com.app.dao.cs.impl;

import java.util.List;

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
}
