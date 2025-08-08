package com.app.api.dto.detailIntro.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DetailIntroItemCulturalFacility extends DefaultDetailIntroItem{

	 	@JsonProperty("accomcountculture")
	    private String accomCountCulture;
	 	
	    @JsonProperty("chkbabycarriageculture")
	    private String chkBabyCarriageCulture;
	    
	    @JsonProperty("chkcreditcardculture")
	    private String chkCreditCardCulture;
	    
	    @JsonProperty("chkpetculture")
	    private String chkPetCulture;
	    
	    @JsonProperty("discountinfo")
	    private String discountInfo;
	    
	    @JsonProperty("infocenterculture")
	    private String infoCenterCulture;
	    
	    @JsonProperty("parkingculture")
	    private String parkingCulture;
	    
	    @JsonProperty("parkingfee")
	    private String parkingFee;
	    
	    @JsonProperty("restdateculture")
	    private String restDateCulture;
	    
	    @JsonProperty("usefee")
	    private String useFee;
	    
	    @JsonProperty("usetimeculture")
	    private String useTimeCulture;
	    
	    private String scale;
	    
	    @JsonProperty("spendtime")
	    private String spendTime;
	

}
