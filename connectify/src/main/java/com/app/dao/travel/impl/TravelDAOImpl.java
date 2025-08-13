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
	public List<AreaBasedListItem> getDestinationsListByContentTypeId(Map<String, Object> params) {
		List<AreaBasedListItem> destinationsList = sqlSessionTemplate.selectList("TravelMapper.getDestinationsListByContentTypeId", params);
		return destinationsList;
	}

	@Override
	public int getDestinationsListCountByContentTypeId(int contentTypeId) {
//		Map<String, Object> params = new HashMap<>();
//		params.put("contentTypeId", contentTypeId);
//		params.put("keyword", keyword);
		return sqlSessionTemplate.selectOne("TravelMapper.getDestinationsListCountByContentTypeId", contentTypeId);
	}

	@Override
	public int getLodgingListCountByLclsSystm3(String category) {		
		return sqlSessionTemplate.selectOne("TravelMapper.getLodgingListCountByLclsSystm3", category);
	}

	@Override
	public List<AreaBasedListItem> getLodgingListByLcslSystm3(Map<String, Object> params) {
		List<AreaBasedListItem> lodgingList = sqlSessionTemplate.selectList("TravelMapper.getLodgingListByLcslSystm3", params);
		return lodgingList;
	}

	@Override
	public AreaBasedListItem getDestinationByContentID(String id) {
		AreaBasedListItem destination = sqlSessionTemplate.selectOne("TravelMapper.getDestinationByContentID", id);
		return destination;
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId12(String id) {		
		return sqlSessionTemplate.selectOne("TravelMapper.getDetailIntroByContentId12", id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId14(String id) {
		return sqlSessionTemplate.selectOne("TravelMapper.getDetailIntroByContentId14", id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId15(String id) {
		return sqlSessionTemplate.selectOne("TravelMapper.getDetailIntroByContentId15", id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId28(String id) {
		return sqlSessionTemplate.selectOne("TravelMapper.getDetailIntroByContentId28", id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId38(String id) {
		return sqlSessionTemplate.selectOne("TravelMapper.getDetailIntroByContentId38", id);	
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId39(String id) {
		return sqlSessionTemplate.selectOne("TravelMapper.getDetailIntroByContentId39", id);
	}

	

	

}
