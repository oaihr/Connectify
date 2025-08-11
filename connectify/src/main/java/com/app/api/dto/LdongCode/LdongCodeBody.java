package com.app.api.dto.LdongCode;

import lombok.Data;

@Data
public class LdongCodeBody {
	
	private LdongCodeItems items;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
}
