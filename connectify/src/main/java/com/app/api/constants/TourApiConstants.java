package com.app.api.constants;

public class TourApiConstants {
	public static final String BASE_URL = "http://apis.data.go.kr/B551011/KorWithService2";
	public static final String LDONG_CODE_OPERATION = "/ldongCode2";
	public static final String LCLS_SYSTEM_CODE_LIST_OPERATION = "/lclsSystmCode2";
	public static final String AREA_BASED_LIST_OPERATION = "/areaBasedList2";
	
	public static final String MOBILE_OS = "ETC"; // ETC, IOS, AND, WIN
	public static final String MOBILE_APP = "connectify";
	public static final String RESPONSE_TYPE_JSON = "json";
	
	public static final String LDONG_LIST_YN_FULL = "Y"; // 법정동 전체 목록 조회
	public static final String LDONG_LIST_YN_CODE = "N"; // 법정동 코드 조회
	public static final String LCLS_SYSTEM_LIST_YN_FULL = "Y"; // 분류체계 전체 목록 조회
	public static final String LCLS_SYSTEM_LIST_YN_CODE = "N"; // 분류체계 코드 조회
	
	public static final int LDONG_LIST_NUM_OF_ROWS = 119;
	public static final int LCLS_SYSTEM_CODE_LIST_NUM_OF_ROWS = 245;
	public static final int AREA_BASED_LIST_NUM_OF_ROWS = 10000;

	
	
}
