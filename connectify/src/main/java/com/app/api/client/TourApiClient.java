package com.app.api.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.api.constants.TourApiConstants;
import com.app.api.dto.ApiResponse;
import com.app.api.dto.TourApiException;
import com.app.api.dto.LclsSystmCode.LclsSystmCodeBody;
import com.app.api.dto.LclsSystmCode.LclsSystmCodeItem;
import com.app.api.dto.LclsSystmCode.LclsSystmCodeResponse;
import com.app.api.dto.LdongCode.LdongCodeBody;
import com.app.api.dto.LdongCode.LdongCodeItem;
import com.app.api.dto.LdongCode.LdongCodeResponse;
import com.app.api.dto.areaBasedList.AreaBasedListBody;
import com.app.api.dto.areaBasedList.AreaBasedListItem;
import com.app.api.dto.areaBasedList.AreaBasedListResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TourApiClient {

	private static final Logger logger = LoggerFactory.getLogger(TourApiClient.class);

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper objectMapper;
	@Value("${tourapi.serviceKey}")
	private String serviceKey;

	public List<LdongCodeItem> getAllLdongCodes() {
		int pageNo = 1;
		int totalCount = Integer.MAX_VALUE;
		List<LdongCodeItem> allLdongCodes = new ArrayList<>();

		while ((pageNo - 1) * TourApiConstants.LDONG_LIST_NUM_OF_ROWS < totalCount) {
			String url = buildLdongCodeUrl(pageNo, TourApiConstants.LDONG_LIST_NUM_OF_ROWS);
			logger.info("Calling TourAPI ldongCode2: {}", url);

			try {
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
				HttpEntity<String> entity = new HttpEntity<>(headers);
				
				// URI 객체로 변환하여 요청
				URI uri = URI.create(url);
				
				ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
				String jsonResponse = responseEntity.getBody();

				logger.info("Raw API Response: {}", jsonResponse);

				LdongCodeResponse apiResponse = objectMapper.readValue(jsonResponse, LdongCodeResponse.class);

				if (apiResponse == null || apiResponse.getResponse() == null || apiResponse.getResponse().getHeader() == null || apiResponse.getResponse().getBody() == null) {
					logger.error("Invalid API response structure or empty response for page {}. URL: {}", pageNo, url);
					break;
				}

				ApiResponse<LdongCodeBody> response = apiResponse.getResponse();

				if (!"0000".equals(response.getHeader().getResultCode())) {
					logger.error("TourAPI returned error code: {} - {}", response.getHeader().getResultCode(), response.getHeader().getResultMsg());
									
					throw new TourApiException(response.getHeader().getResultCode(), response.getHeader().getResultMsg(), jsonResponse);
				}

				if (response.getBody().getItems()!= null && response.getBody().getItems().getItem()!= null) {
					List<LdongCodeItem> items = response.getBody().getItems().getItem();
					allLdongCodes.addAll(items);
					totalCount = response.getBody().getTotalCount();
					logger.info("Fetched {} items for page {}. Total count: {}", items.size(), pageNo, totalCount);
				} else {
					logger.info("No items found for page {}. Total count: {}", pageNo, response.getBody().getTotalCount());
					break;
				}

			} catch (TourApiException e) {
				logger.error("API specific error during ldongCode2 call: {}", e.getMessage());
				return Collections.emptyList();
			} catch (Exception e) {
				logger.error("Error during TourAPI ldongCode2 call for page {}: {}", pageNo, e.getMessage(), e);
				return Collections.emptyList();
			}
			pageNo++;
		}
		logger.info("Successfully fetched a total of {} ldong codes.", allLdongCodes.size());
		return allLdongCodes;
	}
	
	private String buildLdongCodeUrl(int pageNo, int numOfRows) {
		String url = TourApiConstants.BASE_URL + TourApiConstants.LDONG_CODE_OPERATION +
				"?serviceKey=" + serviceKey +
				"&numOfRows=" + numOfRows +
				"&pageNo=" + pageNo +
				"&MobileOS=" + TourApiConstants.MOBILE_OS +
				"&MobileApp=" + TourApiConstants.MOBILE_APP +
				"&_type=" + TourApiConstants.RESPONSE_TYPE_JSON +
				"&lDongListYn=" + TourApiConstants.LDONG_LIST_YN_FULL;

		logger.info("Generated TourAPI URL: {}", url);
		return url;
	}
	
	public List<LclsSystmCodeItem> getAllLclsSystmCodes() {
		int pageNo = 1;
		int totalCount = Integer.MAX_VALUE;
		List<LclsSystmCodeItem> allLclsSystmCode = new ArrayList<>();

		while ((pageNo - 1) * TourApiConstants.LCLS_SYSTEM_CODE_LIST_NUM_OF_ROWS < totalCount) {
			String url = buildLclsSystmCodeUrl(pageNo, TourApiConstants.LCLS_SYSTEM_CODE_LIST_NUM_OF_ROWS);
			logger.info("Calling TourAPI lclsSystmCode2: {}", url);

			try {
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
				HttpEntity<String> entity = new HttpEntity<>(headers);
				
				// URI 객체로 변환하여 요청
				URI uri = URI.create(url);
				
				ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
				String jsonResponse = responseEntity.getBody();

				logger.info("Raw API Response: {}", jsonResponse);
				
				LclsSystmCodeResponse response = objectMapper.readValue(jsonResponse, LclsSystmCodeResponse.class);

				if (response == null || response.getResponse() == null || response.getResponse().getHeader() == null || response.getResponse().getBody() == null) {
					logger.error("Invalid API response structure or empty response for page {}. URL: {}", pageNo, url);
					break;
				}
				if (!"0000".equals(response.getResponse().getHeader().getResultCode())) {
					logger.error("TourAPI returned error code: {} - {}", response.getResponse().getHeader().getResultCode(), response.getResponse().getHeader().getResultMsg());
									
					throw new TourApiException(response.getResponse().getHeader().getResultCode(), response.getResponse().getHeader().getResultMsg(), jsonResponse);
				}

				if (response.getResponse().getBody().getItems()!= null && response.getResponse().getBody().getItems().getItem()!= null) {
					List<LclsSystmCodeItem> items = response.getResponse().getBody().getItems().getItem();
					allLclsSystmCode.addAll(items);
					totalCount = response.getResponse().getBody().getTotalCount();
					logger.info("Fetched {} items for page {}. Total count: {}", items.size(), pageNo, totalCount);
				} else {
					logger.info("No items found for page {}. Total count: {}", pageNo, response.getResponse().getBody().getTotalCount());
					break;
				}

			} catch (TourApiException e) {
				logger.error("API specific error during lclsSystmCode2 call for URL {}: {}", url, e.getMessage());
				return Collections.emptyList();
			} catch (Exception e) {
				logger.error("Error during TourAPI lclsSystmCode2 call for page {}: {}", pageNo, e.getMessage(), e);
				return Collections.emptyList();
			}
			pageNo++;
		}
		logger.info("Successfully fetched a total of {} lclsSystm codes.", allLclsSystmCode.size());
		return allLclsSystmCode;
	}
	
	private String buildLclsSystmCodeUrl(int pageNo, int numOfRows) {
		String url = TourApiConstants.BASE_URL + TourApiConstants.LCLS_SYSTEM_CODE_LIST_OPERATION +
				"?serviceKey=" + serviceKey +
				"&numOfRows=" + numOfRows +
				"&pageNo=" + pageNo +
				"&MobileOS=" + TourApiConstants.MOBILE_OS +
				"&MobileApp=" + TourApiConstants.MOBILE_APP +
				"&_type=" + TourApiConstants.RESPONSE_TYPE_JSON +
				"&lclsSystmListYn=" + TourApiConstants.LCLS_SYSTEM_LIST_YN_FULL;

		logger.info("Generated TourAPI URL: {}", url);
		return url;
	}
	
	public List<AreaBasedListItem> getAllTourDestinationsByLdongCodes() {
	    List<AreaBasedListItem> allTourDestinations = new ArrayList<>();
	    
	    // 1. 모든 법정동 코드를 조회
	    List<LdongCodeItem> allLdongCodes = getAllLdongCodes();
	    
	    if (allLdongCodes.isEmpty()) {
	        logger.warn("No legal administrative district codes were fetched. Cannot proceed with fetching tour destinations.");
	        return Collections.emptyList();
	    }
	    
	    logger.info("Successfully fetched a total of {} ldong codes. Starting to fetch tour destinations for each code...", allLdongCodes.size());
	    
	    // 2. 각 법정동 코드를 이용해 여행지 정보 조회
	    for (LdongCodeItem ldongCode : allLdongCodes) {
	        String ldongRegnCd = ldongCode.getLdongRegnCd();
	        String ldongSignguCd = ldongCode.getLdongSignguCd();
	        
	        if (ldongRegnCd == null || ldongRegnCd.isEmpty()) {
	            logger.warn("Skipping ldongCode with empty lDongRegnCd: {}", ldongCode);
	            continue;
	        }

	        int pageNo = 1;
	        int totalCount = Integer.MAX_VALUE;
	        
	        while ((pageNo - 1) * TourApiConstants.AREA_BASED_LIST_NUM_OF_ROWS < totalCount) {
	            String url = buildAreaBasedListUrl(pageNo, TourApiConstants.AREA_BASED_LIST_NUM_OF_ROWS, ldongRegnCd, ldongSignguCd);
	            logger.info("Calling TourAPI areaBasedList2 for ldongRegnCd: {}, page: {}", ldongRegnCd, pageNo);
	            
	            try {
	                HttpHeaders headers = new HttpHeaders();
	                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	                headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
	                HttpEntity<String> entity = new HttpEntity<>(headers);
	                
	                URI uri = URI.create(url);
	                
	                ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	                String jsonResponse = responseEntity.getBody();

	                //ApiResponse<AreaBasedListBody> response = objectMapper.readValue(jsonResponse, new TypeReference<ApiResponse<AreaBasedListBody>>() {});
					AreaBasedListResponse response = objectMapper.readValue(jsonResponse, AreaBasedListResponse.class);

	                
	                if (response == null || response.getResponse().getHeader() == null || response.getResponse().getBody() == null) {
	                    logger.error("Invalid API response structure or empty response for page {} of ldongRegnCd {}. URL: {}", pageNo, ldongRegnCd, url);
	                    break;
	                }

	                
	                if (!"0000".equals(response.getResponse().getHeader().getResultCode())) {
	                    logger.error("TourAPI returned error code for areaBasedList2: {} - {}", response.getResponse().getHeader().getResultCode(), response.getResponse().getHeader().getResultMsg());
	                    throw new TourApiException(response.getResponse().getHeader().getResultCode(), response.getResponse().getHeader().getResultMsg(), jsonResponse);
	                }

	                if (response.getResponse().getBody() != null
	                        && response.getResponse().getBody().getItems() != null
	                        && response.getResponse().getBody().getItems().getItem() != null) {
	                    
	                    List<AreaBasedListItem> items = response.getResponse().getBody().getItems().getItem();

	                    allTourDestinations.addAll(items);
	                    totalCount = response.getResponse().getBody().getTotalCount();
	                    logger.info(
	                            "Fetched {} tour destinations for ldongRegnCd {} on page {}. Total count for this code: {}",
	                            items.size(), ldongRegnCd, pageNo, totalCount);
	                } else {
	                    logger.info("No tour destinations found for ldongRegnCd {} on page {}. Total count for this code: {}", ldongRegnCd, pageNo, response.getResponse().getBody().getTotalCount());
	                    break;
	                }
	            } catch (TourApiException e) {
	                logger.error("API specific error during areaBasedList2 call for ldongRegnCd {}: {}", ldongRegnCd, e.getMessage());
	                // Continue to the next ldongCode rather than failing the entire process
	            } catch (Exception e) {
	                logger.error("Error during TourAPI areaBasedList2 call for ldongRegnCd {}: {}", ldongRegnCd, e.getMessage(), e);
	                // Continue to the next ldongCode rather than failing the entire process
	            }
	            pageNo++;
	        }
	    }
	    
	    logger.info("Successfully fetched a total of {} tour destinations.", allTourDestinations.size());
	    return allTourDestinations;
	}

	private String buildAreaBasedListUrl(int pageNo, int numOfRows, String ldongRegnCd, String ldongSignguCd) {
		String url = TourApiConstants.BASE_URL + TourApiConstants.AREA_BASED_LIST_OPERATION +
				"?serviceKey=" + serviceKey +
				"&numOfRows=" + numOfRows +
				"&pageNo=" + pageNo +
				"&MobileOS=" + TourApiConstants.MOBILE_OS +
				"&MobileApp=" + TourApiConstants.MOBILE_APP +
				"&_type=" + TourApiConstants.RESPONSE_TYPE_JSON +
				"&lDongRegnCd=" + ldongRegnCd +
				"&lDongSignguCd=" + ldongSignguCd
				;

		logger.info("Generated TourAPI URL: {}", url);
		return url;
	}
	
	
}