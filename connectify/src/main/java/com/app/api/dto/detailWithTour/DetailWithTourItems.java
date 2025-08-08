package com.app.api.dto.detailWithTour;

import java.util.List;

import com.app.api.dto.detailIntro.DetailIntroItem;

import lombok.Data;

@Data
public class DetailWithTourItems {
	
	List<DetailWithTourItem> item;
}
