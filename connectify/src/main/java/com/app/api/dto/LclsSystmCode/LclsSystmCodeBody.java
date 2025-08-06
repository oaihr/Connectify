package com.app.api.dto.LclsSystmCode;

import lombok.Data;

@Data
public class LclsSystmCodeBody {
	private int numOfRows;
	private int pageNo;
	private int totalCount;
	private LclsSystmCodeItems items;
}
