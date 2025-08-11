package com.app.service.cs;

import java.util.List;

import com.app.dto.cs.Cs;

public interface CsService {

	public List<Cs> getAllFaqs();

	public List<Cs> searchByQuestion(String keyword);

	// 검색어에 해당하는 FAQ의 총 개수를 가져오는 메서드
	public int getFaqCountByKeyword(String keyword);

	// 검색어와 페이징을 함께 처리하여 FAQ 리스트를 가져오는 메서드
	public List<Cs> searchByQuestionWithPaging(String keyword, int offset, int pageSize);

}
