package com.app.dao.page;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.dto.cs.Cs;

@Repository
public interface PageDAO {
	List<Cs> getFaqList(@Param("offset") int offset, @Param("pageSize") int pageSize);

	int getFaqCount();
}
