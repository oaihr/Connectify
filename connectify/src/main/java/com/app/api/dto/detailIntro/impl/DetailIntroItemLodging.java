package com.app.api.dto.detailIntro.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DetailIntroItemLodging extends DefaultDetailIntroItem{

	@JsonProperty("accomcountlodging")
	private String accomCountLodging;
	
	@JsonProperty("checkintime")
	private String checkinTime;
	
	@JsonProperty("checkouttime")
	private String checkoutTime;
	
	@JsonProperty("chkcooking")
	private String chkCooking;
	
	@JsonProperty("foodplace")
	private String foodPlace;
	
	@JsonProperty("infocenterlodging")
	private String infoCenterLodging;
	
	@JsonProperty("parkinglodging")
	private String parkingLodging;
	
	private String pickup;
	
	@JsonProperty("roomcount")
	private String roomCount;
	
	@JsonProperty("reservationlodging")
	private String reservationLodging;
	
	@JsonProperty("reservationurl")
	private String reservationUrl;
	
	@JsonProperty("roomtype")
	private String roomType;
	
	@JsonProperty("scalelodging")
	private String scaleLodging;
	
	@JsonProperty("subfacility")
	private String subFacility;
	
	
	private String barbecue;
	private String beauty;
	private String beverage;
	private String bicycle;
	private String campfire;
	private String fitness;
	private String karaoke;
	
	@JsonProperty("publicbath")
	private String publicBath;
	
	@JsonProperty("publicpc")
	private String publicPc;
	
	private String sauna;
	private String seminar;
	private String sports;
	
	@JsonProperty("refundregulation")
	private String refundRegulation;

}
