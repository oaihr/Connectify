package com.app.api.dto.detailIntro.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DetailIntroItemFestival extends DefaultDetailIntroItem{
	
	@JsonProperty("agelimit")
	private String ageLimit;
	
	@JsonProperty("bookingplace")
	private String bookingPlace;
	
	@JsonProperty("discountinfofestival")
	private String discountInfoFestival;
	
	@JsonProperty("eventenddate")
	private String eventEndDate;
	
	@JsonProperty("eventhomepage")
	private String eventHomepage;
	
	@JsonProperty("eventplace")
	private String eventPlace;
	
	@JsonProperty("eventstartdate")
	private String eventStartDate;
	
	@JsonProperty("festivalgrade")
	private String festivalGrade;
	
	@JsonProperty("placeinfo")
	private String placeInfo;
	
	@JsonProperty("playtime")
	private String playTime;
	
	private String program;
	
	@JsonProperty("spendtimefestival")
	private String spendTimeFestival;
	
	private String sponsor1;
	
	@JsonProperty("sponsor1tel")
	private String sponsor1Tel;
	
	private String sponsor2;
	
	@JsonProperty("sponsor2tel")
	private String sponsor2Tel;
	
	@JsonProperty("subevent")
	private String subEvent;
	
	@JsonProperty("usetimefestival")
	private String useTimeFestival;
	
}
