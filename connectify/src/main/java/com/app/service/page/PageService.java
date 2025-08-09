package com.app.service.page;

import java.util.List;

import com.app.dto.cs.Cs;

public interface PageService {

	List<Cs> getFaqList(int offset, int pageSize);

	int getFaqCount();

}
