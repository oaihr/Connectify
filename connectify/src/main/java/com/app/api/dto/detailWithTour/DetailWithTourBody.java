package com.app.api.dto.detailWithTour;

import com.app.api.dto.detailIntro.DetailIntroItems;

import lombok.Data;

@Data
public class DetailWithTourBody {
	
	private DetailWithTourItems items;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
}
