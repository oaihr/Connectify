package com.app.api.dto.detailIntro.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DetailIntroItemFood extends DefaultDetailIntroItem{

	@JsonProperty("chkcreditcardfood")
	private String chkCreditCardFood;
	
	@JsonProperty("discountinfofood")
	private String discountInfoFood;
	
	@JsonProperty("firstmenu")
	private String firstMenu;
	
	@JsonProperty("infocenterfood")
	private String infoCenterFood;
	
	@JsonProperty("kidsfacility")
	private String kidsFacility;
	
	@JsonProperty("opendatefood")
	private String openDateFood;
	
	@JsonProperty("opentimefood")
	private String openTimeFood;
	
	private String packing;
	
	@JsonProperty("parkingfood")
	private String parkingFood;
	
	@JsonProperty("reservationfood")
	private String reservationFood;
	
	@JsonProperty("restdatefood")
	private String restDateFood;
	
	@JsonProperty("scalefood")
	private String scaleFood;
	
	private String seat;
	private String smoking;
	
	@JsonProperty("treatmenu")
	private String treatMenu;
	
	@JsonProperty("lcnsno")
	private String lcnsNo;
}
