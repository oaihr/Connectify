package com.app.api.dto.detailWithTour;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DetailWithTourItem {
	
	@JsonProperty("contentid")
	String contentId;
	
	String parking;
	
	@JsonProperty("publictransport")
	String publicTransport;
	
	String route;
	
	@JsonProperty("ticketoffice")
	String ticketOffice;
	
	String promotion;
	String wheelchair;
	String exit;
	String elevator;
	String restroom;
	String auditorium;
	String room;
	
	@JsonProperty("handicapetc")
	String handicapEtc;
	
	@JsonProperty("braileblock")
	String braileBlock;
	
	@JsonProperty("helpdog")
	String helpDog;
	
	@JsonProperty("guidehuman")
	String guideHuman;
	
	@JsonProperty("audioguide")
	String audioGuide;
	
	@JsonProperty("bigprint")
	String bigPrint;
	
	@JsonProperty("brailepromotion")
	String brailePromotion;
	
	@JsonProperty("guidesystem")
	String guideSystem;
	
	@JsonProperty("blindhandicapetc")
	String blindHandicapEtc;
	
	@JsonProperty("signguide")
	String signGuide;
	
	@JsonProperty("videoguide")
	String videoGuide;
	
	@JsonProperty("hearingroom")
	String hearingRoom;
	
	@JsonProperty("hearinghandicapetc")
	String hearingHandicapEtc;
	
	String stroller;
	
	@JsonProperty("lactationroom")
	String lactationRoom;
	
	@JsonProperty("babysparechair")
	String babySpareChair;
	
	@JsonProperty("infantsfamilyetc")
	String infantsFamilyEtc;
}
