package com.app.api.dto.areaBasedList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AreaBasedListItem {
	private Integer contentid;
	private Integer contenttypeid;
	private String title;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String areacode;
	private String sigungucode;
	private String cat1;
	private String cat2;
	private String cat3;
	private String mapx;
	private String mapy;
	private String mlevel;
	private String tel;
	private String firstimage;
	private String firstimage2;
	private String cpyrhtDivCd;
	@JsonProperty("lDongRegnCd")
	private String lDongRegnCd; // 법정동 시도 코드
	@JsonProperty("lDongSignguCd")
	private String lDongSignguCd; // 법정동 시군구 코드
	private String lclsSystm1; // 분류체계 대분류
	private String lclsSystm2; // 분류체계 중분류
	private String lclsSystm3; // 분류체계 소분류
	private String createdtime; // YYYYMMDDHHMMSS
	private String modifiedtime; // YYYYMMDDHHMMSS
	
	//12
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
	
	
	//withtour
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
