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
}
