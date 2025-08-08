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

}
