package com.app.api.dto.detailWithTour;

import com.app.api.dto.ApiResponse;
import com.app.api.dto.detailIntro.DetailIntroBody;

import lombok.Data;

@Data
public class DetailWithTourResponse {
	private ApiResponse<DetailWithTourBody> response;
}
