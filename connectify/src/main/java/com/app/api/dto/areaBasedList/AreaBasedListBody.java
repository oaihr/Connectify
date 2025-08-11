package com.app.api.dto.areaBasedList;

import lombok.Data;

@Data
public class AreaBasedListBody {
	private int numOfRows;
	private int pageNo;
	private int totalCount;
	private AreaBasedListItems items;
}
