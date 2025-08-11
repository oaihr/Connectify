package com.app.api.dto.detailIntro.impl;

import com.app.api.dto.detailIntro.DetailIntroItem;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DefaultDetailIntroItem implements DetailIntroItem{
	
	@JsonProperty("contentid")
	private String contentId;
	
	@JsonProperty("contenttypeid")
    private String contentTypeId;
    
	@Override
	public String getContentId() {
		return contentId;
	}

	@Override
	public String getContenttypeid() {
		return contentTypeId;
	}

}
