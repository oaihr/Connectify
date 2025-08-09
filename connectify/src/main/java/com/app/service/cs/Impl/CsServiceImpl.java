package com.app.service.cs.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.cs.CsDAO;
import com.app.dto.cs.Cs;
import com.app.service.cs.CsService;

@Service
public class CsServiceImpl implements CsService {

	@Autowired
	public CsDAO csDAO;

	@Override
	public List<Cs> getAllFaqs() {
		return csDAO.getAllFaqs();
	}
	
	@Override
	public List<Cs> searchByQuestion(String keyword) {
        return csDAO.searchByQuestion(keyword);
    }
}
