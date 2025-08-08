package com.app.api.dto.detailIntro;

import com.app.api.dto.ApiResponse;

import lombok.Data;

@Data
public class DetailIntroResponse {
	private ApiResponse<DetailIntroBody> response;
}
