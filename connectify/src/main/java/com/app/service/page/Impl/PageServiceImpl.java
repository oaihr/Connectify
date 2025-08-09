package com.app.service.page.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.page.PageDAO;
import com.app.dto.cs.Cs;
import com.app.service.page.PageService;

@Service
public class PageServiceImpl implements PageService {

	@Autowired
	private PageDAO pageDAO;

    @Override
    public List<Cs> getFaqList(int offset, int limit) {
        return pageDAO.getFaqList(offset, limit);
    }

    @Override
    public int getFaqCount() {
        return pageDAO.getFaqCount();
    }
}

