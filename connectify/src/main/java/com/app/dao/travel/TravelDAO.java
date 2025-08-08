package com.app.dao.travel;

import java.util.List;
import java.util.Map;

import com.app.api.dto.areaBasedList.AreaBasedListItem;

public interface TravelDAO {
	public List<AreaBasedListItem> getDestinationsListByContentTypeId(Map<String, Integer> params);
	public int getDestinationsListCountByContentTypeId(int contentTypeId);
}
