package com.app.dao.cs;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dto.cs.Cs;

@Repository
public interface CsDAO {

	public List<Cs> getAllFaqs();

	public List<Cs> searchByQuestion(String keyword);

}
