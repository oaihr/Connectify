package com.app.api.dto.detailIntro.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DetailIntroItemLeports extends DefaultDetailIntroItem{

	@JsonProperty("accomcountleports")
	private String accomCountLeports;
	
	@JsonProperty("chkbabycarriageleports")
	private String chkBabyCarriageLeports;
	
	@JsonProperty("chkcreditcardleports")
	private String chkCreditCardLeports;
	
	@JsonProperty("chkpetleports")
	private String chkPetLeports;
	
	@JsonProperty("expagerangeleports")
	private String expAgeRangeLeports;
	
	@JsonProperty("infocenterleports")
	private String infoCenterLeports;
	
	@JsonProperty("openperiod")
	private String openPeriod;
	
	@JsonProperty("parkingfeeleports")
	private String parkingFeeLeports;
	
	@JsonProperty("parkingleports")
	private String parkingLeports;
	
	private String reservation;
	
	@JsonProperty("restdateleports")
	private String restDateLeports;
	
	@JsonProperty("scaleleports")
	private String scaleLeports;
	
	@JsonProperty("usefeeleports")
	private String useFeeLeports;
	
	@JsonProperty("usetimeleports")
	private String useTimeLeports;
	

}
