package com.app.api.dto.areaBasedList;

import com.app.api.dto.ApiResponse;

import lombok.Data;

@Data
public class AreaBasedListResponse {
	private ApiResponse<AreaBasedListBody> response;
}
