package com.app.api.dto.detailIntro;

import lombok.Data;

@Data
public class DetailIntroBody {
	private DetailIntroItems items;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
}
