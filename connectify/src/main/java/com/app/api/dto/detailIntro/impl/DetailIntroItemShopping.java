package com.app.api.dto.detailIntro.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DetailIntroItemShopping extends DefaultDetailIntroItem{

	@JsonProperty("chkbabycarriageshopping")
	private String chkBabyCarriageShopping;
	
	@JsonProperty("chkcreditcardshopping")
	private String chkCreditCardShopping;
	
	@JsonProperty("chkpetshopping")
	private String chkPetShopping;
	
	@JsonProperty("culturecenter")
	private String cultureCenter;
	
	@JsonProperty("fairday")
	private String fairDay;
	
	@JsonProperty("infocentershopping")
	private String infoCenterShopping;
	
	@JsonProperty("opendateshopping")
	private String openDateShopping;
	
	@JsonProperty("opentime")
	private String openTime;
	
	@JsonProperty("parkingshopping")
	private String parkingShopping;
	
	@JsonProperty("restdateshopping")
	private String restDateShopping;
	
	@JsonProperty("restroom")
	private String restRoom;
	
	@JsonProperty("saleitem")
	private String saleItem;
	
	@JsonProperty("saleitemcost")
	private String saleItemCost;
	
	@JsonProperty("scaleshopping")
	private String scaleShopping;
	
	@JsonProperty("shopguide")
	private String shopGuide;
}
