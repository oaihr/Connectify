package com.app.service.travel;

import java.util.List;
import java.util.Map;

import com.app.api.dto.areaBasedList.AreaBasedListItem;

public interface TravelService {
	public List<AreaBasedListItem> getDestinationsListByContentTypeId(Map<String, Integer> params);
	public int getDestinationsListCountByContentTypeId(int contentTypeId);
	public int getLodgingListCountByLclsSystm3(String category);
	public List<AreaBasedListItem> getLodgingListByLcslSystm3(Map<String, Object> params);
	public AreaBasedListItem getDestinationByContentID(String id);
	public AreaBasedListItem getDetailIntroByContentId12(String id);
	public AreaBasedListItem getDetailIntroByContentId14(String id);
	public AreaBasedListItem getDetailIntroByContentId15(String id);
	public AreaBasedListItem getDetailIntroByContentId28(String id);
	public AreaBasedListItem getDetailIntroByContentId38(String id);
	public AreaBasedListItem getDetailIntroByContentId39(String id);
	
	public List<AreaBasedListItem> getDestinationList();
}
