package com.app.api.dto.detailIntro.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DetailIntroItemAttraction extends DefaultDetailIntroItem{
	
	@JsonProperty("accomcount")
	private String accomCount; // 수용인원
	
	@JsonProperty("chkbabycarriage")
    private String chkBabyCarriage; // 유모차 대여 여부
	
	@JsonProperty("chkcreditcard")
    private String chkCreditCard; // 신용카드 가능 여부
	
	@JsonProperty("chkpet")
    private String chkPet; // 애완동물 동반 가능 여부
	
	@JsonProperty("expagerange")
    private String expAgeRange; // 체험가능 연령
	
	@JsonProperty("expguide")
    private String expGuide; // 체험안내
	
    private String heritage1; // 세계 문화유산 유무
	
    private String heritage2; // 세계 자연유산 유무
	
    private String heritage3; // 세계 기록유산 유무
	
	@JsonProperty("infocenter")
    private String infoCenter; // 문의 및 안내
	
	@JsonProperty("opendate")
    private String openDate; // 개장일
	
    private String parking; // 주차시설
	
	@JsonProperty("restdate")
    private String restDate; // 쉬는 날
	
	@JsonProperty("useseason")
    private String useSeason; // 이용시기
	
	@JsonProperty("usetime")
    private String useTime; // 이용시간
	

}
