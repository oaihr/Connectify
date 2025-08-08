package com.app.dao.travel.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.api.dto.areaBasedList.AreaBasedListItem;
import com.app.dao.travel.TravelDAO;

@Repository
public class TravelDAOImpl implements TravelDAO{
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<AreaBasedListItem> getDestinationsListByContentTypeId(Map<String, Integer> params) {
		List<AreaBasedListItem> destinationsList = sqlSessionTemplate.selectList("TravelMapper.getDestinationsListByContentTypeId", params);
		return destinationsList;
	}

	@Override
	public int getDestinationsListCountByContentTypeId(int contentTypeId) {		
		return sqlSessionTemplate.selectOne("TravelMapper.getDestinationsListCountByContentTypeId", contentTypeId);
	}

	

}
