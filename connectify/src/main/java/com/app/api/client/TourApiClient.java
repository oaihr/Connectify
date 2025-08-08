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
import com.app.api.dto.detailIntro.DetailIntroItem;
import com.app.api.dto.detailIntro.DetailIntroResponse;
import com.app.api.dto.detailWithTour.DetailWithTourItem;
import com.app.api.dto.detailWithTour.DetailWithTourResponse;
import com.fasterxml.jackson.core.JsonParseException;
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
	
	public List<DetailIntroItem> getAllTourDetailIntroByContentIdAndContentTypeID(List<AreaBasedListItem> destinationsList){
		List<DetailIntroItem> allDetailIntroItems = new ArrayList<>();

		if (destinationsList == null || destinationsList.isEmpty()) {
			logger.warn("상세 소개 정보를 조회할 여행지 목록이 제공되지 않았습니다.");
			return allDetailIntroItems;
		}
		
		final String[] API_KEYS = {
		        "5c6IVFOHyKQ%2BMZkQE1g0%2F%2FSDaDAx%2FfLsbvIF7HIOZfzIZ9Myer07ZaX7MgcFdNpE7trxvuluUzepwCRtjyl8Ng%3D%3D",
		        "ZoSnMDJ%2FAq69YitCYXvmR8M0tA3zHBYsW7pvT0MoemXXvj9AWJh9bw3%2FlYY%2F3b6TybD5ytG2zjQdNCMiPRhosQ%3D%3D",
		        "bv8NNvgL2l1rdueDCSIHj6XZI6sEe1cV9YfGyv%2B2NZNZ1sjOHnj%2BcepwLR2zbp8F%2BuDrnHYqqsMzKF1azwOyWA%3D%3D",
		        "TO90wKscUg6u6rP5F%2BGib6c%2BZB23HOQfDM5pnjbHPlrXWlVNUe8JV0mJbe7JpfeuOQQZtupiIlN7w8AQUoo5lw%3D%3D",
		        "dTi49reKFtpHGxGYUh1wLnwd0snUoahFFqMscUix7Cxqe401s6BDlpOwX21MMeIIf%2FyLKFZv6L%2F3oVz1CJfiAw%3D%3D",
		        "B5S3aS93DYD%2BxsLJ9vSNO3Wp%2BOlJ9HkJYglkd9K5%2F0euuUEKsWg5M0iLMlv7j1prwVRuKmAJzZWZyXB%2B8kMHfQ%3D%3D",
		        "ZQZY9RrBcX3e6XvB6VuWBAomzkla9%2B%2BmvyU3%2F9QNZ2E7WJm0lKm0BmAd9DYRhFKlb4cWGC69Otlkj98i3qakSA%3D%3D",
		        "XN5KZcI%2BiRcXz5mqUAsTpN1ePeLi6gDHTgqdNgtepGx2hVMsillVW3nPeWC%2FDL6YUPiSIBnkY%2BY%2F3Djh4Qztmg%3D%3D",
		        "NeHfBKB065psaekMs%2B8nolE4vC60D2Cz516ji45M0QKe6r2%2BLO4mh%2Bq%2BfDFhJp0%2FrTodAaTptL8Q4aIGBtJERQ%3D%3D"
		};
		int keyIndex = 0;
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>(headers);
		    
		for (AreaBasedListItem destination : destinationsList) {
			String contentId = String.valueOf(destination.getContentid());
			String contentTypeId = String.valueOf(destination.getContenttypeid());

			if (contentId == null || contentTypeId == null) {
				logger.warn("contentId 또는 contentTypeId가 누락된 여행지 정보가 있습니다. 건너뜁니다: {}", destination);
				continue;
			}

			try {
				//현재 인덱스 해당 키 가져오기
				String currentApiKey = API_KEYS[keyIndex];
				
				// detailIntro2는 일반적으로 contentId와 contentTypeId당 하나의 상세 정보를 반환하므로,
				// numOfRows와 pageNo는 1로 설정
				String url = buildDetailIntroUrl(1, 1, contentId, contentTypeId, currentApiKey);
                
                URI uri = URI.create(url);
                
                ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
                String jsonResponse = responseEntity.getBody();
                
				
				DetailIntroResponse response = objectMapper.readValue(jsonResponse, DetailIntroResponse.class);
				
				if (response == null || response.getResponse().getHeader() == null || response.getResponse().getBody() == null) {
	                logger.error("유효하지 않은 API 응답 구조 또는 빈 응답입니다. URL: {}", url);
	                continue;
	            }

	            if (!"0000".equals(response.getResponse().getHeader().getResultCode())) {
	                logger.error("TourAPI에서 오류 코드를 반환했습니다. {} - {}", response.getResponse().getHeader().getResultCode(), response.getResponse().getHeader().getResultMsg());
	                throw new TourApiException(response.getResponse().getHeader().getResultCode(), response.getResponse().getHeader().getResultMsg(), jsonResponse);
	            }

	            if (response.getResponse().getBody() != null
	                && response.getResponse().getBody().getItems() != null
	                && response.getResponse().getBody().getItems().getItem() != null) {
	                
	                List<DetailIntroItem> items = response.getResponse().getBody().getItems().getItem();

	                if (!items.isEmpty()) {
	                    allDetailIntroItems.addAll(items);	                    
	                } else {
	                    logger.warn("해당 contentId: {}, contentTypeId: {}에 대한 상세 소개 정보가 없습니다.", contentId, contentTypeId);
	                }
	            } else {
	                logger.warn("API 응답 본문 또는 아이템이 null입니다. contentId: {}, contentTypeId: {}", contentId, contentTypeId);
	            }
	        } catch (TourApiException e) {
	            logger.error("API 특정 오류 발생: contentId {}, contentTypeId {}: {}", contentId, contentTypeId, e.getMessage());
	        } catch (Exception e) {
	            logger.error("상세 소개 정보 조회 중 오류 발생: contentId {}, contentTypeId {}: {}", contentId, contentTypeId, e.getMessage(), e);
	        }
			
			// 다음 호출을 위해, 키 인덱스 갱신
			 keyIndex = (keyIndex + 1) % API_KEYS.length;
	    }
	    
	    return allDetailIntroItems;
	}
	
	private String buildDetailIntroUrl(int pageNo, int numOfRows, String contentId, String contentTypeId, String currentApiKey) {
		String url = TourApiConstants.BASE_URL + TourApiConstants.DETAIL_INTRO_OPERATION +
				"?serviceKey=" + currentApiKey +
				"&numOfRows=" + numOfRows +
				"&pageNo=" + pageNo +
				"&MobileOS=" + TourApiConstants.MOBILE_OS +
				"&MobileApp=" + TourApiConstants.MOBILE_APP +
				"&_type=" + TourApiConstants.RESPONSE_TYPE_JSON +
				"&contentId=" + contentId +
				"&contentTypeId=" + contentTypeId
				;

		return url;
	}
	
	public List<DetailWithTourItem> getAllDetailWithTourByContentId(List<AreaBasedListItem> destinationsList){
		List<DetailWithTourItem> allDetailWithTourItems = new ArrayList<>();

		if (destinationsList == null || destinationsList.isEmpty()) {
			logger.warn("상세 소개 정보를 조회할 여행지 목록이 제공되지 않았습니다.");
			return allDetailWithTourItems;
		}
		
		final String[] API_KEYS = {
		        "5c6IVFOHyKQ%2BMZkQE1g0%2F%2FSDaDAx%2FfLsbvIF7HIOZfzIZ9Myer07ZaX7MgcFdNpE7trxvuluUzepwCRtjyl8Ng%3D%3D",
		        "ZoSnMDJ%2FAq69YitCYXvmR8M0tA3zHBYsW7pvT0MoemXXvj9AWJh9bw3%2FlYY%2F3b6TybD5ytG2zjQdNCMiPRhosQ%3D%3D",
		        "bv8NNvgL2l1rdueDCSIHj6XZI6sEe1cV9YfGyv%2B2NZNZ1sjOHnj%2BcepwLR2zbp8F%2BuDrnHYqqsMzKF1azwOyWA%3D%3D",
		        "TO90wKscUg6u6rP5F%2BGib6c%2BZB23HOQfDM5pnjbHPlrXWlVNUe8JV0mJbe7JpfeuOQQZtupiIlN7w8AQUoo5lw%3D%3D",
		        "dTi49reKFtpHGxGYUh1wLnwd0snUoahFFqMscUix7Cxqe401s6BDlpOwX21MMeIIf%2FyLKFZv6L%2F3oVz1CJfiAw%3D%3D",
		        "B5S3aS93DYD%2BxsLJ9vSNO3Wp%2BOlJ9HkJYglkd9K5%2F0euuUEKsWg5M0iLMlv7j1prwVRuKmAJzZWZyXB%2B8kMHfQ%3D%3D",
		        "ZQZY9RrBcX3e6XvB6VuWBAomzkla9%2B%2BmvyU3%2F9QNZ2E7WJm0lKm0BmAd9DYRhFKlb4cWGC69Otlkj98i3qakSA%3D%3D",
		        "XN5KZcI%2BiRcXz5mqUAsTpN1ePeLi6gDHTgqdNgtepGx2hVMsillVW3nPeWC%2FDL6YUPiSIBnkY%2BY%2F3Djh4Qztmg%3D%3D",
		        "NeHfBKB065psaekMs%2B8nolE4vC60D2Cz516ji45M0QKe6r2%2BLO4mh%2Bq%2BfDFhJp0%2FrTodAaTptL8Q4aIGBtJERQ%3D%3D"
		};
		int keyIndex = 0;
		    
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        
		for (AreaBasedListItem destination : destinationsList) {
			String contentId = String.valueOf(destination.getContentid());

			if (contentId == null ) {
				logger.warn("contentId가 누락된 여행지 정보가 있습니다. 건너뜁니다: {}", destination);
				continue;
			}

			try {
				//현재 인덱스 해당 키 가져오기
				String currentApiKey = API_KEYS[keyIndex];
				
				// detailIntro2는 일반적으로 contentId와 contentTypeId당 하나의 상세 정보를 반환하므로,
				// numOfRows와 pageNo는 1로 설정
				String url = buildDetailWithTourUrl(contentId, currentApiKey);
				
                URI uri = URI.create(url);
                
                ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
                String jsonResponse = responseEntity.getBody();
                
				
                DetailWithTourResponse response = objectMapper.readValue(jsonResponse, DetailWithTourResponse.class);
				
				if (response == null || response.getResponse().getHeader() == null || response.getResponse().getBody() == null) {
	                logger.error("유효하지 않은 API 응답 구조 또는 빈 응답입니다. URL: {}", url);
	                continue;
	            }

	            if (!"0000".equals(response.getResponse().getHeader().getResultCode())) {
	                logger.error("TourAPI에서 오류 코드를 반환했습니다. {} - {}", response.getResponse().getHeader().getResultCode(), response.getResponse().getHeader().getResultMsg());
	                throw new TourApiException(response.getResponse().getHeader().getResultCode(), response.getResponse().getHeader().getResultMsg(), jsonResponse);
	            }

	            if (response.getResponse().getBody() != null
	                && response.getResponse().getBody().getItems() != null
	                && response.getResponse().getBody().getItems().getItem() != null) {
	                
	                List<DetailWithTourItem> items = response.getResponse().getBody().getItems().getItem();

	                if (!items.isEmpty()) {
	                	allDetailWithTourItems.addAll(items);	                    
	                } else {
	                    logger.warn("해당 contentId: {}에 대한 상세 소개 정보가 없습니다.", contentId);
	                }
	            } else {
	                logger.warn("API 응답 본문 또는 아이템이 null입니다. contentId: {}", contentId);
	            }
	        } catch (TourApiException e) {
	            logger.error("API 특정 오류 발생: contentId {}", contentId, e.getMessage());
	        } catch (Exception e) {
	            logger.error("상세 소개 정보 조회 중 오류 발생: contentId {}", contentId, e.getMessage(), e);
	        }
			
			// 다음 호출을 위해, 키 인덱스 갱신
			 keyIndex = (keyIndex + 1) % API_KEYS.length;
	    }
	    
	    return allDetailWithTourItems;
	}
	
	private String buildDetailWithTourUrl(String contentId, String currentApiKey) {
		String url = TourApiConstants.BASE_URL + TourApiConstants.DETAIL_WITH_TOUR_OPERATION +
				"?serviceKey=" + currentApiKey +
				"&MobileOS=" + TourApiConstants.MOBILE_OS +
				"&MobileApp=" + TourApiConstants.MOBILE_APP +
				"&_type=" + TourApiConstants.RESPONSE_TYPE_JSON +
				"&contentId=" + contentId
				;

		return url;
		
		
	}
}