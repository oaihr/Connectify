package com.app.api.dto.detailIntro.impl;

import com.app.api.dto.detailIntro.DetailIntroItem;

import lombok.Data;

@Data
public class DefaultDetailIntroItem implements DetailIntroItem{
	
	private String contentid;
    private String contenttypeid;
    
	@Override
	public String getContentId() {
		return contentid;
	}

	@Override
	public String getContenttypeid() {
		return contenttypeid;
	}

}
