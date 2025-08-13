package com.app.service.travel.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.dto.areaBasedList.AreaBasedListItem;
import com.app.dao.travel.TravelDAO;
import com.app.service.travel.TravelService;

@Service
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	TravelDAO travelDAO;
	
	@Override
	public List<AreaBasedListItem> getDestinationsListByContentTypeId(Map<String, Integer> params) {
		List<AreaBasedListItem> destinationsList = travelDAO.getDestinationsListByContentTypeId(params);
    	return destinationsList;
	}
	
	public int getDestinationsListCountByContentTypeId(int contentTypeId) {
		return travelDAO.getDestinationsListCountByContentTypeId(contentTypeId);
	}

	@Override
	public int getLodgingListCountByLclsSystm3(String category) {
		return travelDAO.getLodgingListCountByLclsSystm3(category);
	}

	@Override
	public List<AreaBasedListItem> getLodgingListByLcslSystm3(Map<String, Object> params) {		
		return travelDAO.getLodgingListByLcslSystm3(params);
	}

	@Override
	public AreaBasedListItem getDestinationByContentID(String id) {
		return travelDAO.getDestinationByContentID(id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId12(String id) {
		return travelDAO.getDetailIntroByContentId12(id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId14(String id) {
		return travelDAO.getDetailIntroByContentId14(id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId15(String id) {
		return travelDAO.getDetailIntroByContentId15(id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId28(String id) {
		return travelDAO.getDetailIntroByContentId28(id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId38(String id) {
		return travelDAO.getDetailIntroByContentId38(id);
	}

	@Override
	public AreaBasedListItem getDetailIntroByContentId39(String id) {
		return travelDAO.getDetailIntroByContentId39(id);
	}

	@Override
	public List<AreaBasedListItem> getDestinationList() {
		return travelDAO.getDestinationList();
	}

	
}
